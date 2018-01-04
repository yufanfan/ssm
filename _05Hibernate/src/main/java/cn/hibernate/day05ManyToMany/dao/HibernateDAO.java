package cn.hibernate.day05ManyToMany.dao;



import cn.hibernate.day05ManyToMany.util.HibernateUtil;


import java.io.Serializable;


/**
 * Created by yu  fan on 2017/12/29.
 */
public class HibernateDAO {
    public Object get(Class clazz, Serializable id){
Object result= HibernateUtil.getSession().load(clazz,id);
return result;
    }





}
