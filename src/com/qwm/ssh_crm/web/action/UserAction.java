package com.qwm.ssh_crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qwm.ssh_crm.domain.User;
import com.qwm.ssh_crm.service.UserService;

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

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
    }
}