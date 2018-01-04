package cn.hibernate.day01.entity.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by annan on 2017/12/21.
 */

public class Student {
    private Integer stuid;

    private  String stuname;

    private Integer stuage;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }
}
