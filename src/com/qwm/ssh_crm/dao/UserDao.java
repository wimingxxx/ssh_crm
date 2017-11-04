package com.qwm.ssh_crm.dao;

import com.qwm.ssh_crm.domain.User;

/**
 * @author：qiwenming
 * @date：2017/11/4 0004   17:24
 * @description：
 */
public interface UserDao extends BaseDao<User> {
    //根据登陆名称查询user对象
    User getByUserCode(String usercode);
}
