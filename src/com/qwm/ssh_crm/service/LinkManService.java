package com.qwm.ssh_crm.service;

import com.qwm.ssh_crm.domain.LinkMan;
import com.qwm.ssh_crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
/**
 * @author：qiwenming
 * @date：2017/12/2 0002
 * @description：
 * 联系人的Service
 */
public interface LinkManService {
    void save(LinkMan linkMan);
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    LinkMan getById(Long lkm_id);
    void delete(Long lkm_id);
}
