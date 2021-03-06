package com.qwm.ssh_crm.service;

import com.qwm.ssh_crm.domain.Customer;
import com.qwm.ssh_crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   0:45
 * @description：
 * 客户
 */
public interface CustomerService {
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) ;
    void save(Customer customer);
    Customer getById(Long cust_id);
    void delete(Long cust_id);
}