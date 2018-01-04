package cn.hibernate.day01;

import cn.hibernate.day01.entity.Dept;
import cn.hibernate.day01.entity.DeptMode;
import cn.hibernate.day02.entity.Emp;
import cn.hibernate.day02.entity.EmpCondition;
import cn.hibernate.day02.util.Tool;
import javafx.beans.binding.StringBinding;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Happy on 2017-12-24.
 */
public class test04limitandselectsome {


    //04.分页 案例：分页
    @Test
    public void selectPageData(){
        String hql="from Emp";
        Query query = session.createQuery(hql);
        int pageSize=3;
        int pageIndex=1;
        query.setFirstResult((pageIndex-1)*pageSize); //6
        query.setMaxResults(pageSize);
        List<Emp> list = query.list();
        for (Emp item:list) {
            System.out.println(item.getEname());
        }
    }



    //03.动态查询
    @Test
    public void selectByDynamic() throws ParseException {
        EmpCondition emp=new EmpCondition();
        //伪造界面的Condition
        //.视图model
        emp.setJob("CLERK");
        emp.setSal(1000.0);
        emp.setFromDate(Tool.strToDate("1980-04-01"));
        emp.setEndDate(new Date());

        //根据条件拼接SQL
        StringBuilder sb=new StringBuilder("from Emp e where 1=1 ");
        if (emp.getJob()!=null){
            sb.append("and e.job=:job ");
        }
        if (emp.getSal()!=null){
            sb.append("and e.sal>:sal ");
        }
        if (emp.getFromDate()!=null){
            sb.append("and e.hiredate>=:fromDate ");
        }
        if (emp.getEndDate()!=null){
            sb.append("and e.hiredate<=:endDate ");
        }
        Query query = session.createQuery(sb.toString());
        query.setProperties(emp);

        List<Emp> list = query.list();
        for (Emp item:list) {
            System.out.println(item.getEname());
        }
    }






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
}
