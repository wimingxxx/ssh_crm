package com.qwm.ssh_crm.dao;

import com.qwm.ssh_crm.domain.BaseDict;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   17:06
 * @description：
 */
public interface BaseDictDao extends BaseDao<BaseDict>{
    List<BaseDict> getListByTypeCode(String dict_type_code);
}
