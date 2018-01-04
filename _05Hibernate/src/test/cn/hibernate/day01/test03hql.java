package cn.hibernate.day01;


import cn.hibernate.day01.entity.Dept;
import cn.hibernate.day01.entity.DeptMode;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by yu  fan on 2017/12/21.
 * hql
 */

public class test03hql {
    Session session;
    Transaction tx;
    @Before
    public void mybefore(){
        //1.构建配置对象  读取配置文件  默认读取 hibernate.cfg.xml
        Configuration cfg=new Configuration().configure("hibernatehql1.cfg.xml");
        //2. 构建SessionFactory对象
        SessionFactory factory= cfg.buildSessionFactory();
        //3.构建Session
        session=factory.getCurrentSession();//从连接池中随机取出连接
        //千万注意：在Hibernate改变数据的时候，一定要让我们的操作运行在事务当中强烈建议
        //大家select操作也要运行在事务环境中  》jta（Java  Transaction API事务处理的API）  jpa (Java Persisistence API 持久化的标准API)
        //4.开始事务
        tx=session.beginTransaction();
    }
    @After
    public void myafter(){
        tx.commit();
        //session.close();
    }




    //HQL检索所有部门集合
    @Test
    public void tesgetMultColumns(){
String hql="from Dept";
        Query query=session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept dept:list){
            System.out.println(dept.getDeptno());
        }

    }

//获取销售部信息
    @Test
    public void tesgetMultColumns2(){
        String hql="from Dept d where d.dname='SALES'";
        Query query=session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept dept:list){
            System.out.println(dept.getDeptno());
        }

    }


    /*获取部分列 多列 List<强类型>*/
@Test
public void testgetColumns(){
    String hql="select new Dept(d.deptno,d.dname,d.loc) from Dept d";
    Query query=session.createQuery(hql);
    List<Dept> list=query.list();
    for (Dept dept:list){
        System.out.println(dept.getDeptno());
    }
}




    /*参数查询 匿名占位符 ?*/
    @Test
    public void testByConditionNiMing(){
        String hql="from Dept d where d.dname=? and d.loc=?";
        Query query=session.createQuery(hql);
        query.setParameter(0,"SALES");
        query.setParameter(1,"CHICAGO");
        List<Dept> list=query.list();
        for (Dept dept:list){
            System.out.println(dept.getDeptno());
        }
    }


    /*参数查询 name 参数名称绑定*/
    @Test
    public void testByConditionParamtername(){
        String hql="from Dept d where d.dname=:dname and d.loc=:loc";
        Query query=session.createQuery(hql);
        query.setParameter("dname","SALES");
        query.setParameter("loc","CHICAGO");
        List<Dept> list=query.list();
        for (Dept dept:list){
            System.out.println(dept.getDeptno());
        }
    }



    /*参数查询 参数名称绑定+对象属性*/
    @Test
    public void testByConditionParamternameAndObjectAttribute(){
        String hql="from Dept d where d.dname=:dname and d.loc=:loc";
        Query query=session.createQuery(hql);
        //视图Model ViewModel  UI层
        DeptMode dept=new DeptMode();
        dept.setDname("SALES");
        dept.setLoc("CHICAGO");
        query.setProperties(dept);
        List<Dept> list=query.list();
        for (Dept dept1:list){
            System.out.println(dept1.getDeptno());
        }
    }


}
