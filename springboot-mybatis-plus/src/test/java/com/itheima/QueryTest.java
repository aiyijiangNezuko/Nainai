package com.itheima;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class QueryTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 没有条件的分页查询
     */
   @Test
    public void testPage(){
       IPage page = new Page(2,2);

       IPage page1 = userMapper.selectPage(page, null);

       System.out.println("总数 :" + page1.getTotal());
       System.out.println("分页结果集 : " + page1.getRecords());

       System.out.println("page = page1 " + (page1==page));
   }

    /**
     * 有条件的分页查询
     */
   @Test
    public void testQueryWrapper(){
       QueryWrapper<User> queryWrapper = new QueryWrapper<>();

       queryWrapper.lt("age",25);
       queryWrapper.in("name","全宝蓝","杨超越");
       List<User> users = userMapper.selectList(queryWrapper);
       users.forEach(System.out::println);
   }
    /**
     * 有条件的分页查询
     */
    @Test
    public void testQueryOrWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("user_name","lijuli").or().lt("age",25)
        .in("name","全宝蓝","杨超越");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * like   %% 【索引失效】  数量大时
     * notLike <> 【索引失效】
     * likeLeft %s  LIKE '%值' 【坚决不写,让索引失效】,以什么结尾
     * likeRight s%  LIKE '值%' 【可写】,以什么开头  推荐
     */
    @Test
    public void testLikeQueryOrWrapper(){
       //创建查询条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //设置条件
        //查询名字以an结尾的人的信息
        queryWrapper.likeLeft("user_name","an");
        /**
         * select id,user_name,password,name,age,email from tb_user where user_name like ? %zhang
         */
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 按排序条件的分页
     */
    @Test
    public void testQueryWrapperOrderBy(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age",20);
        //按年龄降序
        queryWrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testQueryWrapperColumn(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age",20);
        //按年龄降序
        queryWrapper.orderByDesc("age");
        //指定要查询的列
        queryWrapper.select("name","age");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testPageCondition(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age",25);
        IPage page = new Page(1,3);

        IPage page1 = userMapper.selectPage(page, queryWrapper);

        System.out.println("总数 :" + page1.getTotal());
        System.out.println("分页结果集 : " + page1.getRecords());
    }
}
