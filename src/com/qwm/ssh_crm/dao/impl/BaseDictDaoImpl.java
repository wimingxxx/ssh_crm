package com.qwm.ssh_crm.dao.impl;

import com.qwm.ssh_crm.dao.BaseDictDao;
import com.qwm.ssh_crm.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   17:07
 * @description：
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao{
    @Override
    public List<BaseDict> getListByTypeCode(String dict_type_code) {
        //1.创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
        //2.封装条件
        dc.add(Restrictions.eq("dict_type_code",dict_type_code));
        //3.执行查询
        List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
        return list;
    }
}
