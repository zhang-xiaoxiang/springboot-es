package cn.thislx.springbootes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
/**
 * SpringbootEsApplication:启动类
 * @author zhangxiaoxiang
 * @date 2019/7/16
 */
public class SpringbootEsApplication {



	public static void main(String[] args)  {

		SpringApplication.run(SpringbootEsApplication.class, args);
		log.warn("Springboot启动成功!");
	}
}
