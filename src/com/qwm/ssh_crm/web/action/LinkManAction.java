package com.qwm.ssh_crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qwm.ssh_crm.domain.LinkMan;
import com.qwm.ssh_crm.service.LinkManService;
import com.qwm.ssh_crm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author：qiwenming
 * @date：2017/12/2 0002
 * @description：
 *   联系人的Action
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    private LinkMan linkMan =new LinkMan();

    private LinkManService lms;

    private Integer currentPage;
    private Integer pageSize;

    public String list() throws Exception{
        //封装离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
        //判断并封装参数
        if(StringUtils.isNotBlank(linkMan.getLkm_name())){
            dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
        }
        if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
            dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
        }

        //1 调用Service查询分页数据(PageBean)
        PageBean pb = lms.getPageBean(dc,currentPage,pageSize);
        //2 将PageBean放入request域,转发到列表页面显示
        ActionContext.getContext().put("pageBean", pb);
        return "list";
    }

    public String add() throws Exception {
        //1 调用Service
        lms.save(linkMan);
        //2 重定向到联系人列表(404)
        return "toList";
    }

    public String toEdit() throws Exception {
        //1 调用Service,查询LinkMan
        LinkMan lm = lms.getById(linkMan.getLkm_id());
        //2 将查询的Linkman对象放入request域,转发到添加页面
        ActionContext.getContext().put("linkMan", lm);
        return "add";
    }

    public String delete() throws Exception {
        //1 调用Service
        lms.delete(linkMan.getLkm_id());
        //2 重定向到联系人列表(404)
        return "toList";
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }


    public LinkManService getLms() {
        return lms;
    }

    public void setLms(LinkManService lms) {
        this.lms = lms;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
