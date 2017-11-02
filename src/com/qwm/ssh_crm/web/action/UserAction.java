package com.qwm.ssh_crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qwm.ssh_crm.service.UserService;

/**
 * @author：qiwenming
 * @date：2017/11/1 0001   23:37
 * @description：
 */
public class UserAction extends ActionSupport{
    private UserService userService;

    public String login() throws Exception{
        System.out.println(userService);
        return super.execute();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}