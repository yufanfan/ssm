package cn.hibernate.day02.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by yu  fan on 2017/12/26.
 */
public class hibernateUtil {

  private static ThreadLocal<Session> tlSession;
  private static SessionFactory factory;
 private  static Configuration cfg=null;
  static{
      tlSession=new ThreadLocal<Session>();
      cfg=new Configuration().configure("");
      factory=cfg.buildSessionFactory();
  }

//获取和当前线程绑定的session
  public static Session getSession(){
      //尝试从线程中看看有没有线程变量
      Session session=tlSession.get();
      if (session==null){
          //线程中没有session,创建一个
          session=factory.openSession();
      }
      return session; //没有和当前线程绑定
  }


  public static void closeSession(){
      Session session=tlSession.get();
      if (session!=null){
          tlSession.set(null);
          session.close();
      }
  }
}
