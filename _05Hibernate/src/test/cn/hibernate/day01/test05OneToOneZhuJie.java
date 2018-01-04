package cn.hibernate.day01;


import cn.hibernate.day07OneToOneZhuJie.Dept;
import cn.hibernate.day07OneToOneZhuJie.Emp;
import cn.hibernate.day07OneToOneZhuJie.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test05OneToOneZhuJie {


    //01
    @Test
    public void t1(){
    Session session= HibernateUtil.getSession();
    Transaction tx=session.beginTransaction();
        Dept dept=new Dept();
        dept.setDname("测试啦啦啦部");
        Emp emp=new Emp();
        emp.setEname("111");

        dept.setEmp(emp);
        emp.setDept(dept);

        session.save(dept);
        tx.commit();
        System.out.println("=================");
    }




}
