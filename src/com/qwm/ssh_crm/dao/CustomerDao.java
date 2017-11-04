package com.qwm.ssh_crm.dao;

import com.qwm.ssh_crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   0:53
 * @description：
 */
public interface CustomerDao {
    //查询总记录数
    Integer getTotalCount(DetachedCriteria dc);
    //查询分页数据
    List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);
}