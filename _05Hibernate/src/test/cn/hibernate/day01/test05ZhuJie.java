package cn.hibernate.day01;



import cn.hibernate.day07ZhuJie.Dept;
import cn.hibernate.day07ZhuJie.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test05ZhuJie {


    //01
    @Test
    public void t1(){
    Session session= HibernateUtil.getSession();
    Transaction tx=session.beginTransaction();
        Dept dept=new Dept();
        dept.setDname("测试哈哈哈部");
        session.save(dept);
        tx.commit();
        System.out.println("=================");
    }




}
