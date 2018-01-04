package cn.hibernate.day04OneToMany.dao;

import cn.hibernate.day04OneToMany.util.hibernateUtil;

import java.io.Serializable;



/**
 * Created by yu  fan on 2017/12/29.
 */
public class HibernateDAO {
    public Object get(Class clazz, Serializable id){
Object result= hibernateUtil.getSession().load(clazz,id);
return result;
    }





}
