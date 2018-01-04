package cn.hibernate.day01;



import cn.hibernate.day09.Book.Book;
import cn.hibernate.day09.Book.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * Created by Happy on 2017-12-24.
 */
public class test05Book {


    //01
    @Test
    public void t1(){
    Session session= HibernateUtil.getSession();
    Transaction tx=session.beginTransaction();
        Book book=new Book();
        book.setBname("红楼梦");
        book.setBprice(50);
        book.setBtype(1);

        Book book1=new Book();
        book1.setBname("西游记");
        book1.setBprice(20);
        book1.setBtype(1);

        Book book2=new Book();
        book2.setBname("哈哈");
        book2.setBprice(100);
        book2.setBtype(2);

        Book book3=new Book();
        book1.setBname("呵呵");
        book1.setBprice(80);
        book1.setBtype(2);


        session.save(book);
        session.save(book1);
        session.save(book2);
        session.save(book3);

        tx.commit();
        System.out.println("=================");
    }







    //02 --查询Books表中大于该类图书价格平均值的图书信息
    @Test
    public void t2(){
        Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Query query=session.createQuery(" from Book a where bprice>(select avg(bprice)from book b where a.btype=b.btype)");
        List<Book> list = query.list();
        for (Book book:list){
            System.out.println(book.getBname());
        }
        tx.commit();
        System.out.println("=================");
    }




}