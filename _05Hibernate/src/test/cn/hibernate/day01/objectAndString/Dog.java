package cn.hibernate.day01.objectAndString;

/**
 * Created by Happy on 2017-12-28.
 */
public class Dog {
    private String name;
    private Integer age;

//重写hashCode  是一个算法，另外一个维度标识一个对象的信息
    //如果两个对象相同，hashCode 值必定相同
    //如果两个hashCode值相同的对象，不一定是同一个对象


    @Override
    public int hashCode() {
        int result=17;
        result=result*31+name.hashCode();
        result=result*31+age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Dog dog=(Dog)obj;
        if (this.name.equals(dog.getName())){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
