package com.qwm.ssh_crm.service;

import com.qwm.ssh_crm.domain.BaseDict;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   17:04
 * @description：
 */
public interface BaseDictService {
    List<BaseDict> getListByTypeCode(String dict_type_code);
}
