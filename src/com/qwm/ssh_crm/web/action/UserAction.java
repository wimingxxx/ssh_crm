package com.qwm.ssh_crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qwm.ssh_crm.domain.SaleVisit;
import com.qwm.ssh_crm.domain.User;
import com.qwm.ssh_crm.service.UserService;
import com.qwm.ssh_crm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author：qiwenming
 * @date：2017/11/1 0001   23:37
 * @description：
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();

    private UserService userService;

    public String login() throws Exception{
        //1.调用Service执行登录逻辑
        User u = userService.getUserByCodePassword(user);
        //2.将返回的user对象放入到session域
        ActionContext.getContext().getSession().put("user",u);
        //3.重定向到项目首页
        return "toHome";
    }

    public String regist() throws Exception{
        //1.调用Service保存注册用户
        try{
            userService.saveUser(user);
        }catch (Exception e) {
            e.printStackTrace();
            ActionContext.getContext().put("error", e.getMessage());
            return "regist";
        }
        return "toLogin";
    }

    private Integer currentPage;
    private Integer pageSize;
    public String list() throws Exception {
        //封装离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        //判断并封装参数
        if(StringUtils.isNotBlank(user.getUser_name())){
            dc.add(Restrictions.like("user_name", "%"+user.getUser_name()+"%"));
        }

        //1 调用Service查询分页数据(PageBean)
        PageBean pb = userService.getPageBean(dc,currentPage,pageSize);
        //2 将PageBean放入request域,转发到列表页面显示
        ActionContext.getContext().put("pageBean", pb);
        return "list";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
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