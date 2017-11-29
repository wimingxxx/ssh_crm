package com.qwm.ssh_crm.dao.impl;

import com.qwm.ssh_crm.dao.CustomerDao;
import com.qwm.ssh_crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   0:55
 * @description：
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
    public Customer getByUserCode(String usercode) {
        //Criteria 方式查询
        //是一个离线 Criteria
//        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
//        dc.add(Restrictions.eq("cust_name",usercode));
//        List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc);
        List<Customer> list = (List<Customer>)getHibernateTemplate().find("from Customer where cust_id = 15");
        if(list!=null && list.size()>0)
            return list.get(0);
        return null;
    }
}