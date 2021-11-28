package com.itheima;


import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFindById(){
        //baseMapper, 查询:select ,添加:insert,修改:update,删除:delete

        User user = userMapper.selectById(5);

        System.out.println(user);
    }
    @Test
    public void testFindAll(){
        //baseMapper, 查询:select ,添加:insert,修改:update,删除:delete

        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        //baseMapper, 查询:select ,添加:insert,修改:update,删除:delete
        User user = new User();
        user.setUserName("ycy");
        user.setName("杨超越");
        user.setPassword("ycy");
        user.setAge(18);
        user.setEmail("1234455655");
        //count sql语句执行后影响的行数 > 0
        int count = userMapper.insert(user);
        System.out.println("count = " + count);
    }

}
