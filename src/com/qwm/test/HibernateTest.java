package com.qwm.test;

import com.qwm.ssh_crm.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author：qiwenming
 * @date：2017/11/2 0002   23:06
 * @description： Hiberante单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
    @Test
    public void test1() {
        // 1. 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        //3. 获取session
        Session session = sessionFactory.openSession();
        //4 开启事务
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUser_code("wm");
        user.setUser_name("wiming");
        user.setUser_password("123456");

        //5 数据持久化
        session.save(user);

        //6 提交事务
        transaction.commit();

        //7 关闭session
        session.close();

    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Test
    public void test2(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUser_code("qwm");
        user.setUser_name("qiwenming");
        user.setUser_password("11111");

        session.save(user);

        transaction.commit();
        session.close();
    }

    @Test
    public void test3(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUser_code("xm");
        user.setUser_name("xiaoming");
        user.setUser_password("66666");

        session.save(user);

        transaction.commit();
        session.close();
    }
}
