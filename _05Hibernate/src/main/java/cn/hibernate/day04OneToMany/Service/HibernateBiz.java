package cn.hibernate.day04OneToMany.Service;

import cn.hibernate.day04OneToMany.dao.HibernateDAO;
import cn.hibernate.day04OneToMany.util.hibernateUtil;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by yu  fan on 2017/12/29.
 */
public class HibernateBiz {
    HibernateDAO dao=new HibernateDAO();
    public  Object get (Class clazz, Serializable id){
        Transaction tx = hibernateUtil.getSession().beginTransaction();
        Object obj=dao.get(clazz,id);
        tx.commit();
        hibernateUtil.closeSession();
        return  obj;
    }


}
