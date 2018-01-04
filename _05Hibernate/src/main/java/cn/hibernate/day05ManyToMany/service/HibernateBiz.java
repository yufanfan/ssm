package cn.hibernate.day05ManyToMany.service;


import cn.hibernate.day05ManyToMany.ManyToMany.Employee;
import cn.hibernate.day05ManyToMany.dao.HibernateDAO;

import cn.hibernate.day05ManyToMany.util.HibernateUtil;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by yu  fan on 2017/12/29.
 */
public class HibernateBiz {
    HibernateDAO dao=new HibernateDAO();
    public  Object get (Class clazz, Serializable id){
     /*   Transaction tx = HibernateUtil.getSession().beginTransaction();
      */  Object obj=dao.get(clazz,id);
/*        tx.commit();*/
        Employee employee=(Employee) obj;
        employee.getEmpname();
        HibernateUtil.getSession();
        return  obj;
    }


}
