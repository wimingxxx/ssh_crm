package com.qwm.ssh_crm.dao.impl;

import com.qwm.ssh_crm.dao.UserDao;
import com.qwm.ssh_crm.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/4 0004   17:25
 * @description：
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    @Override
    public User getByUserCode(String usercode) {
        //Criteria 方式查询
        //是一个离线 Criteria
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("user_code",usercode));
        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
        if(list!=null && list.size()>0)
            return list.get(0);
        return null;
    }
}