package com.itheima;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class DeleteTest {

    @Autowired
    private UserMapper userMapper;


    /**
     * 条件删除
     */
    @Test
    public void deleteByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //eq = , p1:列名,p2:值
        //wrapper.eq("id",7);
        //column 必须是数据库表的列名
        wrapper.eq("user_name","ycy");
        userMapper.delete(wrapper);
    }

    /**
     * 根据id删除
     */
    @Test
    public void deleteById(){

        userMapper.deleteById(11);
    }


    /**
     * 根据columnMap删除
     */
    @Test
    public void deleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",12);
        map.put("user_name","ycy");
        userMapper.deleteByMap(map);
    }

    /**
     * 批量删除,使用in,要注意sql语句的长度
     * 每种数据库的服务器都会限制sql语句的长度
     */
    @Test
    public void deleteByBatchId(){
        List<Integer> ids = new ArrayList<>();
        for (int i = 13; i <= 14;i++){
            ids.add(i);
        }
        userMapper.deleteBatchIds(ids);
    }
}
