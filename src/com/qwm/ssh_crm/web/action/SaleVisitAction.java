package com.qwm.ssh_crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qwm.ssh_crm.domain.SaleVisit;
import com.qwm.ssh_crm.domain.User;
import com.qwm.ssh_crm.service.SaleVisitService;
import com.qwm.ssh_crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author：qiwenming
 * @date：2017/12/3 0003
 * @description：
 * 客户拜访
 */
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
    private SaleVisit saleVisit = new SaleVisit();
    private SaleVisitService svs ;

    /**
     * 添加客户拜访记录
     * @return
     * @throws Exception
     */
    public String add() throws Exception{
        //1.取出登录用户，放入SaleVisit实体表达关系
        User u = (User) ActionContext.getContext().getSession().get("user");
        saleVisit.setUser(u);
        //2.调用Service保存客户拜访记录
        //加上这个if的原因是这样的，因为我们的SaleVisit的id默认是 "" 在添加记录的时候，回去执行
        //update语句，把id设置为null,那么它就回去执行 save了
        if(saleVisit.getVisit_id()==null || saleVisit.getVisit_id().trim().equals("")) {
            saleVisit.setVisit_id(null);
        }
        svs.save(saleVisit);
        //3.重定向到拜访记录列表Action
        return "toList";
    }

    private Integer currentPage;
    private Integer pageSize;
    public String list() throws Exception {
        //封装离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
        //判断并封装参数
        if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=null){
            dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
        }
        if(saleVisit.getUser()!=null &&saleVisit.getUser().getUser_id()!=null){
            dc.add(Restrictions.eq("user.user_id",saleVisit.getUser().getUser_id()));
        }

        //1 调用Service查询分页数据(PageBean)
        PageBean pb = svs.getPageBean(dc,currentPage,pageSize);
        //2 将PageBean放入request域,转发到列表页面显示
        ActionContext.getContext().put("pageBean", pb);
        return "list";
    }

    /**
     * 编辑
     */
    public String toEdit() throws Exception {
        //1 调用Service根据id查询客户拜访对象
        SaleVisit sv = svs.getById(saleVisit.getVisit_id());
        //2 将对象放入request域
        ActionContext.getContext().put("saleVisit", sv);
        //3 转发到add.jsp
        return "add";
    }

    /**
     * 编辑
     */
    public String delete() throws Exception {
        svs.delete(saleVisit);
        return "toList";
    }

    @Override
    public SaleVisit getModel() {
        return saleVisit;
    }

    public SaleVisitService getSvs() {
        return svs;
    }

    public void setSvs(SaleVisitService svs) {
        this.svs = svs;
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
