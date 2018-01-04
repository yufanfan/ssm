package cn.hibernate.day01;

import cn.hibernate.day07ManyToManyZhuJie.StudentTwo;
import cn.hibernate.day07ManyToManyZhuJie.TeacherTwo;
import cn.hibernate.day07ManyToManyZhuJie.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test05ManyToManyZhuJie {


    //01
    @Test
    public void t1(){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        TeacherTwo teacherTwo1=new TeacherTwo();
        teacherTwo1.setTname("付老师");
        TeacherTwo teacherTwo2=new TeacherTwo();
        teacherTwo2.setTname("付老师2");
        TeacherTwo teacherTwo3=new TeacherTwo();
        teacherTwo3.setTname("付老师3");

        StudentTwo studentTwo1=new StudentTwo();
        studentTwo1.setSname("张三");
        StudentTwo studentTwo2=new StudentTwo();
        studentTwo2.setSname("李四");
        StudentTwo studentTwo3=new StudentTwo();
        studentTwo3.setSname("王五");

      studentTwo1.getTeacherTwos().add(teacherTwo1);
      studentTwo1.getTeacherTwos().add(teacherTwo2);
        studentTwo2.getTeacherTwos().add(teacherTwo1);
        studentTwo2.getTeacherTwos().add(teacherTwo2);
        studentTwo3.getTeacherTwos().add(teacherTwo1);
        studentTwo3.getTeacherTwos().add(teacherTwo3);


        session.save(studentTwo1);
        session.save(studentTwo2);
        session.save(studentTwo3);
        session.save(teacherTwo1);
        session.save(teacherTwo2);
        session.save(teacherTwo3);

        tx.commit();
        HibernateUtil.getSession();
    }




}
