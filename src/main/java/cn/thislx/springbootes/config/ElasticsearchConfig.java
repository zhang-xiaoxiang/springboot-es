package cn.thislx.springbootes.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * ElasticsearchConfig:用于定义配置类，可替换xml配置文件
 * @author zhangxiaoxiang
 * @date 2019/7/16
 */
@Configuration
@Slf4j
public class ElasticsearchConfig {

    /**
     * elk集群地址
     */
    @Value("${elasticsearch.ip}")
    private String hostName;

    /**
     * 端口
     */
    @Value("${elasticsearch.port}")
    private String port;

    /**
     * 集群名称
     */
    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    /**
     * 连接池
     */
    @Value("${elasticsearch.pool}")
    private String poolSize;

    /**
     * Bean name default  函数名字
     *
     * @return
     */
    @Bean(name = "transportClient")
    public TransportClient transportClient() {
        log.warn("Elasticsearch初始化开始......");
        TransportClient transportClient = null;
        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    //集群名字
                    .put("cluster.name", clusterName)
                    //增加嗅探机制，找到ES集群
                    .put("client.transport.sniff", true)
                    //增加线程池个数，暂时设为5
                    .put("thread_pool.search.size", Integer.parseInt(poolSize))
                    .build();
            //配置信息Settings自定义
            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port));
            transportClient.addTransportAddresses(transportAddress);
        } catch (Exception e) {
            log.error("elasticsearch TransportClient create error!!", e);
        }
        return transportClient;
    }

}