package cn.hibernate.day01;


import cn.hibernate.day08joinselect.Dept;
import cn.hibernate.day08joinselect.Emp;
import cn.hibernate.day08joinselect.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * Created by Happy on 2017-12-24.
 */
public class test05JoinSelect {


    //01内连接,查询部门和员工
    @Test
    public void t1(){
    Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
  Query query=session.createQuery(" from Emp e inner join e.dept");
        List<Object[]> list = query.list();
        for (Object[] dept:list){
            System.out.println(dept[0]);
          /*  for (Emp emp:dept.getEmp()){
                System.out.println(emp.getEname());
            }*/
        }
      tx.commit();
    }


    //02根据deptname查询整个员工对象
    @Test
    public void t2(){
        Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Query query=session.createQuery(" from Emp e where e.dept.deptname='啦啦部门'");
        List<Emp> list = query.list();
        for (Emp emp:list){
            System.out.println(emp.getEname());
        }
        tx.commit();
    }

    //03迫切内连接
    @Test
    public void t3(){
        Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Query query=session.createQuery("  from Emp e inner join fetch e.dept");
        List<Emp> list = query.list();
        for (Emp emp:list){
            System.out.println(emp.getEname());
        }
        tx.commit();
    }



    //04子查询 查员工编号小于5000的部门名称
    @Test
    public void t4(){
        Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Query query=session.createQuery("  from Dept d where 5000>all(select e.empno from d.emps.e)");
        List<Dept> list = query.list();
        for (Dept dept:list){
            System.out.println(dept.getDname());
        }
        tx.commit();
    }

}
