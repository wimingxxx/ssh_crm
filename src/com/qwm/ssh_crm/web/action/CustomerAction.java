package com.qwm.ssh_crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qwm.ssh_crm.domain.Customer;
import com.qwm.ssh_crm.service.CustomerService;
import com.qwm.ssh_crm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   0:34
 * @description：
 * 用户相关Action
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    private Customer customer = new Customer();

    private CustomerService cs;

    private Integer currentPage;
    private Integer pageSize;

    public String list() throws Exception{
        //1.封装离线查询对象
        //2.判断并添加参数
        //3.调用Service的查询分页数据（PageBean）
        //4.把PageBean方法request域中，转发到客户列表界面
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if(StringUtils.isNotBlank(customer.getCust_name())){
            dc.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }
        PageBean pb = cs.getPageBean(dc,currentPage,pageSize);
        ActionContext.getContext().put("pageBean",pb);
        return "list";
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    public CustomerService getCs() { return cs; }

    public void setCs(CustomerService cs) { this.cs = cs; }

    public Integer getCurrentPage() { return currentPage; }

    public void setCurrentPage(Integer currentPage) { this.currentPage = currentPage; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
