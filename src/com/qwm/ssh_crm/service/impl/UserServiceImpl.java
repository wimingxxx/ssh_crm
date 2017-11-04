package com.qwm.ssh_crm.service.impl;

import com.qwm.ssh_crm.dao.UserDao;
import com.qwm.ssh_crm.domain.User;
import com.qwm.ssh_crm.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：qiwenming
 * @date：2017/11/2 0002   21:48
 * @description：
 */

public class UserServiceImpl implements UserService {

    private UserDao ud;

    @Override
    public User getUserByCodePassword(User u) {
        //1.根据登录名称查询登录用户
        //2.判断用户是否存在。不存在，抛出异常，提示：用户名不存在
        //3.判断用户登录密码是否正确。不正确，抛出异常，提示：密码错误
        //4.返回查询到的用户对象
        User existU = ud.getByUserCode(u.getUser_code());
        if(existU==null){
            throw new RuntimeException("用户名不存在");
        }
        if(!existU.getUser_password().equals(u.getUser_password())){
            throw new RuntimeException("密码错误");
        }
        return existU;
    }

    @Override
    public void saveUser(User u) {
        ud.save(u);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
