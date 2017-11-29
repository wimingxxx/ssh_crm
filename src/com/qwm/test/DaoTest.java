package com.qwm.test;

import com.qwm.ssh_crm.dao.CustomerDao;
import com.qwm.ssh_crm.dao.UserDao;
import com.qwm.ssh_crm.dao.impl.CustomerDaoImpl;
import com.qwm.ssh_crm.domain.Customer;
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
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTest {

    @Resource(name = "userDao")
    private UserDao ud;

    @Resource(name = "customerDao")
    private CustomerDao cd;

    /**
     * UserDao中 get测试
     */
    @Test
    public void test1(){
        User user = ud.getByUserCode("wm");
        System.out.println(user);
    }


    @Test
    public void test2(){
        Customer customer = cd.getByUserCode("小明公司");
        System.out.println(customer);
    }
}
