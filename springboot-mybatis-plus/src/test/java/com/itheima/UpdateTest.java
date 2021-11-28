package com.itheima;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testUpdateById(){
        User user = new User();
        //想改那个字段就必须给这个对应的属性设置值, 如果值为null则不更新
        user.setUserName("jujingyi");
        user.setId(6L);
        user.setName("鞠婧祎");

        userMapper.updateById(user);
    }

    @Test
    public void testUpdateById2(){
        User user = new User();
        //想改那个字段就必须给这个对应的属性设置值, 如果值为null则不更新
        user.setUserName("liuyifei");

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",7);
        userMapper.update(user,queryWrapper);
    }

    /**
     * 值为null则不更新
     */
    @Test
    public void testUpdateNullById(){
        User user = new User();
        //想改那个字段就必须给这个对应的属性设置值, 如果值为null则不更新
        user.setUserName("liuyifei");
        user.setName(null);

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",7);
        updateWrapper.set("email",null);
        //updateWrapper.set("password",null);

        userMapper.update(user,updateWrapper);
        //密码设置为空
        //userMapper.update(null,updateWrapper);
    }
}
