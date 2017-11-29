package com.qwm.ssh_crm.web.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.qwm.ssh_crm.domain.BaseDict;
import com.qwm.ssh_crm.service.BaseDictService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/1 0001   23:37
 * @description：
 */
public class BaseDictAction extends ActionSupport{
    private String dict_type_code;
    private BaseDictService baseDictService;

    @Override
    public String execute() throws Exception {
        //1.调用Service根据typecode获取数据字典对象list
        List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
        //2.将list转为json
        Gson gson = new Gson();
        String jsonStr  = gson.toJson(list);
        //3.将json发送给浏览器
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(jsonStr);
        return null;//告诉struts2不需要进行结果处理
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }
}