package com.qwm.ssh_crm.service.impl;

import com.qwm.ssh_crm.dao.CustomerDao;
import com.qwm.ssh_crm.domain.Customer;
import com.qwm.ssh_crm.service.CustomerService;
import com.qwm.ssh_crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   0:47
 * @description：
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao cd;
    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //1 调用Dao查询总记录数
        //2 创建PageBean对象
        //3 调用Dao查询分页数
        //4 列表数据放入到PageBean中，并返回
        Integer totalCount = cd.getTotalCount(dc);
        PageBean pb = new PageBean(currentPage,totalCount,pageSize);
        List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
        pb.setList(list);
        return pb;
    }

    @Override
    public void save(Customer customer) {
        //1 维护Customer与数据字典对象的关系,由于struts2参数封装,会将参数封装到数据字典的id属性.
        //那么我们无需手动维护关系
        //2 调用Dao保存客户
        cd.saveOrUpdate(customer);
    }

    @Override
    public Customer getById(Long cust_id) {
        return cd.getById(cust_id);
    }

    @Override
    public void delete(Long cust_id) {
        cd.delete(cust_id);
    }

    public CustomerDao getCd() { return cd; }

    public void setCd(CustomerDao cd) { this.cd = cd; }
}