package com.qwm.test;

import com.qwm.ssh_crm.dao.UserDao;
import com.qwm.ssh_crm.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author：qiwenming
 * @date：2017/11/4 0004   17:38
 * @description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml.2")
public class DaoTest {

    @Resource(name = "userDao")
    private UserDao ud;

    /**
     * UserDao中 get测试
     */
    @Test
    public void test1(){
        User user = ud.getByUserCode("wm");
        System.out.println(user);
    }
}
