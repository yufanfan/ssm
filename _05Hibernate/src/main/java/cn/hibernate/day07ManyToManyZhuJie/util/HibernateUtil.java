package cn.hibernate.day07ManyToManyZhuJie.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2017/12/23.
 */
public class HibernateUtil {
    private static Configuration conf=null;
    private static SessionFactory factory=null;
    private static Session session=null;
    static {
        conf=new Configuration().configure("hibernateManyToManyZhuJie.cfg.xml");
        factory=conf.buildSessionFactory();
    }
    public static Session getSession(){
        Session currentSession = factory.getCurrentSession();
        return currentSession;
    }
}
