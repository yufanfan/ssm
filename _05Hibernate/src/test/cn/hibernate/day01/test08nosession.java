package cn.hibernate.day01;

import cn.hibernate.day04OneToMany.Service.HibernateBiz;


import cn.hibernate.day04OneToMany.oneToMany.Emp;
import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test08nosession {

    //1类级别查询策略
    @Test
    public void test1() {
        HibernateBiz service=new HibernateBiz();
        //1获取单个员工
    Emp emp=(Emp) service.get(Emp.class,29) ;
    //2.获取员工实体中员工姓名
         System.out.println(emp.getEname());
    }















}
