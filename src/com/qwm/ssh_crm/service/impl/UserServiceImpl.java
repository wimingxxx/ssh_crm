package com.qwm.ssh_crm.service.impl;

import com.qwm.ssh_crm.dao.UserDao;
import com.qwm.ssh_crm.domain.User;
import com.qwm.ssh_crm.service.UserService;
import com.qwm.ssh_crm.utils.Md5Utils;
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
        u.setUser_password(Md5Utils.md5Encode(u.getUser_password()));
        if(!existU.getUser_password().equals(u.getUser_password())){
            throw new RuntimeException("密码错误");
        }
        return existU;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void saveUser(User u) {
        //1 调用Dao根据注册的登陆名获得用户对象
        //2 如果获得到user对象,用户名已经存在,抛出异常
        //3 使用MD5对密码进行加密
        //4 调用Dao执行保存
        User existU = ud.getByUserCode(u.getUser_code());
        if(existU!=null){
            throw new RuntimeException("用户名已经存在了");
        }
        u.setUser_password(Md5Utils.md5Encode(u.getUser_password()));
        ud.save(u);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
