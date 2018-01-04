package cn.hibernate.day01;


import cn.hibernate.day07OneToManyZhuJie.Dept;
import cn.hibernate.day07OneToManyZhuJie.Emp;


import cn.hibernate.day07OneToManyZhuJie.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test05OneToManyZhuJie {


    //01一对多注解  保存员工的同时保存部门
    @Test
    public void t1(){
    Session session= HibernateUtil.getSession();
    Transaction tx=session.beginTransaction();
            Emp emp1=new Emp();
        emp1.setEname("张");
        Emp emp2=new Emp();
        emp2.setEname("里");

        Dept dept=new Dept();
        dept.setDname("啦啦部门");


        emp1.setDept(dept);
        emp2.setDept(dept);
        session.saveOrUpdate(emp1);
        session.saveOrUpdate(emp2);
        tx.commit();
        System.out.println("=================");
    }




}
