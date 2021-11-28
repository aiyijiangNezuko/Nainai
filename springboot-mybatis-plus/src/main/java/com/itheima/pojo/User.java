package com.itheima.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//@TableName("tb_user") // 指定表名
@Data
public class User {
    /**
     * TableId 做主键与属性名映射,如果属性名于id相同,则可省略
     * type:主键生成的策略
     */
    //@TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    //@TableField(exist = false) 忽略某个字段的查询,默认为true
    private String email;
}