package com.qwm.ssh_crm.web.intercreptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.qwm.ssh_crm.domain.User;

import java.util.Map;

/**
 * @author：qiwenming
 * @date：2017/12/3 0003
 * @description：
 * 登录的验证
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

    //不校验登陆和注册方法
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        //1 获取session
        //2 获取登录标识
        //3 判断标识是否存在
        Map<String,Object> session = ActionContext.getContext().getSession();
        User user = (User)session.get("user");
        if(user!=null){
            //存在-->放行
            return invocation.invoke();
        }else {
            //不存在---> 重定向到登陆页面
            return "toLogin";
        }
    }
}
