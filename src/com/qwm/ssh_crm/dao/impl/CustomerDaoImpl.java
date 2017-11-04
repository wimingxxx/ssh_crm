package com.qwm.ssh_crm.dao.impl;

import com.qwm.ssh_crm.dao.CustomerDao;
import com.qwm.ssh_crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   0:55
 * @description：
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public Integer getTotalCount(DetachedCriteria dc) {
        //1.设置查询条件
        //2.查询
        //3.清空设置的聚合函数
        //4.判断返回
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>)getHibernateTemplate().findByCriteria(dc);
        dc.setProjection(null);
        if(list!=null && list.size()>0){
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
        List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc,start,pageSize);
        return list;
    }
}
