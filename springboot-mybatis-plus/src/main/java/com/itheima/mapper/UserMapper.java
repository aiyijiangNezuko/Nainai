package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pojo.User;
//BaseMapper 封装了crud,分页
//UserMapper 操作那张表tb_user BaseMpper引入pojo的泛型,pojo类上有@TableName注解
public interface UserMapper extends BaseMapper<User> {
}
