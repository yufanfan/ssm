package cn.hibernate.day01.objectAndString;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Happy on 2017-12-28.
 */
public class ObjectTest {
    @Test
    public void t2(){
        Set<Dog> set=new HashSet<Dog>();
        Dog d1=new Dog();
        d1.setName("张三");
        d1.setAge(2);

        Dog d2=new Dog();
        d2.setName("张三");
        d2.setAge(2);
        set.add(d1);
        set.add(d2);
        System.out.println(set.size());
    }
    @Test
    public void t1(){


        Dog d1=new Dog();
        d1.setName("张三");
        d1.setAge(2);

        Dog d2=new Dog();
        d2.setName("张三");
        d2.setAge(20);
        if (d1==d2){
            System.out.println("==");
        }
        if (d1.equals(d2)){
            System.out.println("equals===========");
        }

   /*    Object obj=null;
        obj.hashCode();
        obj.equals("");

        String str=null;
        str.equals("");*/
    }
}
