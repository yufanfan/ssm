package cn.hibernate.day01;


import cn.hibernate.day01.entity.entity.SessionUtil;
import cn.hibernate.day01.entity.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by yu  fan on 2017/12/21.
 */

public class test02 {
    Configuration cfg;
    SessionFactory factory;
    Session session;
    Transaction tx;
    public void MyBefore(){
        //Configuration
        cfg=new Configuration().configure();
        //SessionFactory
        factory= cfg.buildSessionFactory();
      /*  factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());*/
        //Session
        session=factory.openSession();//从连接池中随机取出连接
        //修改数据
        tx=session.beginTransaction();
    }
    @Test
    public void tesTable(){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Users users=new Users();
        users.setName("刘志威");
        users.setPassword("1");
        users.setIsadmin("是");
        users.setTelephone("18779971057");
        session.save(users);
        transaction.commit();


    }

    public void myAfter(){
        tx.commit();
        //4.关闭Session
        session.close();
    }

}
