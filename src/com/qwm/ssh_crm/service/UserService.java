package com.qwm.ssh_crm.service;

import com.qwm.ssh_crm.domain.User;
import com.qwm.ssh_crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author：qiwenming
 * @date：2017/11/2 0002   21:48
 * @description：
 */
public interface UserService {
    //登陆方法
    User getUserByCodePassword(User u);
    //注册用户
    void saveUser(User u);
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
