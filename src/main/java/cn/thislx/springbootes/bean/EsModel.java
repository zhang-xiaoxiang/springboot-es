package cn.thislx.springbootes.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * EsModel:ES模型实体
 * @author zhangxiaoxiang
 * @date 2019/7/16
 */

@Data
@ToString
@NoArgsConstructor
public class EsModel {

    private String id;

    private String name;

    private int age;

    private Date date;
}
