package cn.hibernate.day01;

/*
import cn.hibernate.day04OneToMany.oneToMany.Dept;
import cn.hibernate.day04OneToMany.oneToMany.Emp;*/
import cn.hibernate.day03manyoroneMapping.manyOrOne.Emp;
import cn.hibernate.day06LazyLoading.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Happy on 2017-12-24.
 */
public class test07LazyLoading {

    //1类级别查询策略
    @Test
    public void test1() {
        //load()没有sql  get()有sql
        Student student=(Student) session.load(Student.class,1);
      /*  System.out.println(student.getStuname());*/
    }


/*

    //2一对多关联查询策略
    @Test
            public void test2(){
        Dept dept=(Dept) session.get(Dept.class,1);
        Set<Emp> emps=dept.getEmp();
        emps.size();
       */
/* for (Emp emp:emps){
            System.out.println(emp.getEname());
        }*//*

    }
*/


    //2多对一
    @Test
    public void test3(){
        Emp emp=(Emp) session.get(Emp.class,25);
     /*   emp.getDept().f();*/
     /*   System.out.println(emp.getDept().getDeptno());*/
    }





















    Session session;
    Transaction tx;
    @Before
    public void mybefore(){
        //1.构建配置对象  读取配置文件  默认读取 hibernate.cfg.xml
        Configuration cfg=new Configuration().configure("hibernateLazyLoding.cfg.xml");
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
