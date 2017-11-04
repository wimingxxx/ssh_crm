package com.qwm.ssh_crm.dao.impl;

import com.qwm.ssh_crm.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   4:07
 * @description：
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

    protected Class clazz;//用于接收运行期泛型类型

    public BaseDaoImpl() {
        //获得当前类型的带有泛型类型的父类
        ParameterizedType ptClass = (ParameterizedType)this.getClass().getGenericSuperclass();
        //获得运行期的泛型类型
        clazz = (Class)ptClass.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    @Override
    public void delete(Serializable id) {
        //先取，再删
        T t = this.getById(id);
        getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    @Override
    public T getById(Serializable id) {
        return (T)getHibernateTemplate().get(clazz,id);
    }

    @Override
    public Integer getTotalCount(DetachedCriteria dc) {
        //1.设置查询条件
        //2.查询
        //3.清空设置的聚合函数
        //4.判断返回
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>)getHibernateTemplate().findByCriteria(dc);
        dc.setProjection(null);
        if(list!=null && list.size()>0){
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
        List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc,start,pageSize);
        return list;
    }
}