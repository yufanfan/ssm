package cn.hibernate.day01;




import cn.hibernate.day05duoduiduofencheng两个.chaifen.Employee;
import cn.hibernate.day05duoduiduofencheng两个.chaifen.PE;
import cn.hibernate.day05duoduiduofencheng两个.chaifen.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test06Mappingtwo {
    @Test
    public void addTest(){
            //创建EMP对象
            Employee emp=new Employee();
            emp.setEmpname("李小龙");

            //创建Pro对象
            Project pro=new Project();
            pro.setPname("海淀花园");

            //创建PE对象
            PE proemp=new PE();
            proemp.setEid(emp);
            proemp.setPid(pro);;

            session.save(emp);
            session.save(pro);
            session.save(proemp);
            System.out.println("成功");

    }
    Session session;
    Transaction tx;
    @Before
    public void mybefore(){
        //1.构建配置对象  读取配置文件  默认读取 hibernate.cfg.xml
        Configuration cfg=new Configuration().configure("hibernateMappingliangge.cfg.xml");
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
      //  session.close();
    }





}