package com.qwm.ssh_crm.service;

import com.qwm.ssh_crm.dao.UserDao;
import com.qwm.ssh_crm.domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：qiwenming
 * @date：2017/11/2 0002   21:48
 * @description：
 */
@Transactional(isolation = Isolation.REPEATABLE_READ , propagation = Propagation.REQUIRED , readOnly = true)
public class UserServiceImpl implements UserService{

    private UserDao ud;

    @Override
    public User getUserByCodePassword(User u) {
        return null;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ , propagation = Propagation.REQUIRED , readOnly = false)
    @Override
    public void saveUser(User u) {
        ud.save(u);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
