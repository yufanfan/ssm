package cn.hibernate.day01;



import cn.hibernate.day05ManyToMany.ManyToMany.Employee;
import cn.hibernate.day05ManyToMany.service.HibernateBiz;
import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test08nosessionmanytomany {

    //1类级别查询策略
    @Test
    public void test1() {
        HibernateBiz service=new HibernateBiz();
        //1获取单个员工
  Employee emp=(Employee) service.get(Employee.class,9) ;
    //2.获取员工实体中员工姓名
         System.out.println(emp.getEmpname());
    }















}
