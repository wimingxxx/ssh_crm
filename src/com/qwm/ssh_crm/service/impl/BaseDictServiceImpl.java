package com.qwm.ssh_crm.service.impl;

import com.qwm.ssh_crm.dao.BaseDictDao;
import com.qwm.ssh_crm.domain.BaseDict;
import com.qwm.ssh_crm.service.BaseDictService;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   17:04
 * @description：
 */
public class BaseDictServiceImpl implements BaseDictService{
    private BaseDictDao bdd;
    @Override
    public List<BaseDict> getListByTypeCode(String dict_type_code) {
        return bdd.getListByTypeCode(dict_type_code);
    }

    public void setBdd(BaseDictDao bdd) {
        this.bdd = bdd;
    }
}
