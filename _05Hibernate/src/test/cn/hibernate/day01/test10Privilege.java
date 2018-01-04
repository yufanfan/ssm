package cn.hibernate.day01;
import cn.hibernate.day10Priviliege.Privilege;
import cn.hibernate.day10Priviliege.Role;
import cn.hibernate.day10Priviliege.User;
import cn.hibernate.day10Priviliege.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Happy on 2017-12-24.
 */
public class test10Privilege {
    //01
    @Test
    public void t1(){
    Session session= HibernateUtil.getSession();
    Transaction tx=session.beginTransaction();
        User user1=new User();
        user1.setUsername("张三");

        Role role1=new Role();
        role1.setRname("教员");
        Role role2=new Role();
        role2.setRname("学员");

        Privilege privilege1=new Privilege();
        privilege1.setPname("修改密码");

        user1.getRoles().add(role1);
        role1.getUsers().add(user1);
        user1.getRoles().add(role2);
      role2.getUsers().add(user1);

        privilege1.getRoles().add(role1);
        role1.getPrivileges().add(privilege1);
        privilege1.getRoles().add(role2);
  role2.getPrivileges().add(privilege1);

        session.save(user1);
        session.save(role1);
        session.save(role2);
        session.save(privilege1);

        tx.commit();
        System.out.println("=================");
    }




}
