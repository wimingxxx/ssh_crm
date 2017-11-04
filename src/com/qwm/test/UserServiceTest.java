package com.qwm.test;

import com.qwm.ssh_crm.domain.User;
import com.qwm.ssh_crm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author：qiwenming
 * @date：2017/11/4 0004   19:03
 * @description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Resource(name = "userService")
    private UserService us;

    /**
     * 测试保存用户的方法
     */
    @Test
    public void test1(){
        User user = new User();
        user.setUser_code("yxr");
        user.setUser_name("yangxiaorong");
        user.setUser_password("123456");
        us.saveUser(user);
    }

    /**
     * 测试保存用户的方法
     */
    @Test
    public void test2(){
        User user = new User();
        user.setUser_code("yxr222");
        user.setUser_name("yangxiaorong222");
        user.setUser_password("123456");
        us.saveUser(user);
    }
}
