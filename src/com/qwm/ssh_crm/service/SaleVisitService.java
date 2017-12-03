package com.qwm.ssh_crm.service;

import com.qwm.ssh_crm.domain.SaleVisit;
import com.qwm.ssh_crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
/**
 * @author：qiwenming
 * @date：2017/12/3 0003
 * @description：
 * 客户拜访
 */
public interface SaleVisitService {
    //保存客户拜访记录
    void save(SaleVisit saleVisit);
    //客户拜访记录的分页列表
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    //根据id获得客户对象
    SaleVisit getById(String visit_id);
    void delete(SaleVisit saleVisit);
}
