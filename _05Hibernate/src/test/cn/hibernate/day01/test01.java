package cn.hibernate.day01;

import cn.hibernate.day01.entity.Student6;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yu  fan on 2017/12/21.
 */

public class test01 {
    @Test
    //1.查询get()
    public void tes1(){
        //Configuration
        Configuration cfg=new Configuration().configure();
        //SessionFactory
        SessionFactory factory= cfg.buildSessionFactory();
        //Session
        Session session=factory.openSession();//从连接池中随机取出连接
        //1.查询数据 get 永远返回的是原始对象本身,如果load/get 加载的记录数据不存在,返回null
        Student6 o = (Student6) session.get(Student6.class, 1);
        System.out.println(o.getSname()+"==============");
        //4.关闭Session
        session.close();
    }



    @Test
//2.查询 load()
    public void tes2() {
        //Configuration
        Configuration cfg = new Configuration().configure();
        //SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        //Session
        Session session = factory.openSession();//从连接池中随机取出连接
        //2.查询数据load  代理对象$$  如果load/get 加载的记录数据不存在,抛出异常
        Student6 o = (Student6) session.load(Student6.class, 1);
        System.out.println(o.getSname() + "==============");
        session.close();
    }





    @Test
    //3.添加数据
    public void tes3(){
        //Configuration
        Configuration cfg=new Configuration().configure();
        //SessionFactory
        SessionFactory factory= cfg.buildSessionFactory();
        //Session
        Session session=factory.openSession();//从连接池中随机取出连接

        //添加数据
        Transaction tx=session.beginTransaction();
        Student6 student=new Student6();
        student.setSid(105);
        student.setSname("呵呵呵");
        student.setSage(100);
        session.save(student);
        tx.commit();
        System.out.print("添加成功");
        //4.关闭Session
        session.close();
    }




    Configuration cfg;
    SessionFactory factory;
    Session session;
    Transaction tx;
    @Before
    public void MyBefore(){
        //Configuration
         cfg=new Configuration().configure();
        //SessionFactory
        factory= cfg.buildSessionFactory();
        //Session
        session=factory.openSession();//从连接池中随机取出连接
        //修改数据
        tx=session.beginTransaction();
    }

    @Test
    //4.修改数据方法一
    public void tes4Method1(){
     Student6 student=(Student6) session.get(Student6.class,3);
     student.setSname("湖广会馆");
    }

    @Test
    //4.修改数据方法二
    public void tes4Method2(){
        Student6 student=new Student6();
        student.setSid(3);
        student.setSname("大");
        session.update(student);
    }

    @Test
    //4.修改数据方法    merge()   and    saveoruodate()
    public void tes4Mtttttt(){
        Student6 student=new Student6();
        student.setSid(2);
        student.setSname("77777777777777777777777");
   /*     session.merge(student);*/
   session.saveOrUpdate(student);
    }

    @After
    public void myAfter(){
        tx.commit();
        //4.关闭Session
        session.close();
    }






    @Test
    //5.删除数据
    public void tes5(){
        //Configuration
        Configuration cfg=new Configuration().configure();
        //SessionFactory
        SessionFactory factory= cfg.buildSessionFactory();
        //Session
        Session session=factory.openSession();//从连接池中随机取出连接

       //删除数据
        Transaction tx=session.beginTransaction();
        Student6 student=new Student6();
        student.setSid(50
        );
        session.delete(student);
        tx.commit();
        System.out.print("删除成功");
        //4.关闭Session
        session.close();
    }


}
