package cn.hibernate.day01;


import cn.hibernate.day04OneToMany.oneToMany.Dept;
import cn.hibernate.day04OneToMany.oneToMany.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Happy on 2017-12-24.
 */
public class test06MappingOneToMany {


    //01  关联查询:一对多双向关联  通过部门 获取该部门下的所有员工
    @Test
    public void selectOneToMany(){
        List<Dept> list=session.createQuery("from Dept").list();
        for (Dept dept : list){
            System.out.println(dept.getDname());
            System.out.println("===============");
              for (Emp emp:dept.getEmp()){
                  System.out.println(emp.getEname());
              }
        }
    }

    @Test
    public void test(){
        //可以通过某个员工获取该员工所在的部门
        Emp emp=(Emp) session.load(Emp.class,7369);
        System.out.println(emp.getDept().getDname());
    }




    //级联 添加部门的同时自动添加员工
    @Test
    public void insertEmpDept(){
  //准备一个Dept对象
        Dept dept1=new Dept();
        dept1.setDname("软件部");
        //准备一个Emp对象
        Emp emp1=new Emp();
        emp1.setEname("张二");
        emp1.setDept(dept1);
        dept1.getEmp().add(emp1);
        session.save(dept1);
    }

    //order by 排序
    @Test
    public void OrderByEmpDept(){
        List<Dept> list=session.createQuery("from Dept").list();
        for (Dept dept:list){
            for (Emp emp:dept.getEmp()){
                System.out.println(emp.getEmpno()+"\t"+emp.getEname());
            }
        }
          }



    Session session;
    Transaction tx;
    @Before
    public void mybefore(){
        //1.构建配置对象  读取配置文件  默认读取 hibernate.cfg.xml
        Configuration cfg=new Configuration().configure("hibernateMappingOneToMany.cfg.xml");
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
