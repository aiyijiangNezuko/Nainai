package com.itheima;


import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 封装service测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testService(){
        User user = userService.getById(1);
        System.out.println("user = " + user);
    }

    @Test
    public void testService2(){
        User user = userService.findById(1);
        System.out.println("user = " + user);
    }
    @Test
    public void testService3(){
        User user = userService.findByName("鞠婧祎");
        System.out.println("user = " + user);
    }

    @Test
    public void testService4(){
        User user = userService.findByName2("李居丽");
        System.out.println("user = " + user);
    }
}
