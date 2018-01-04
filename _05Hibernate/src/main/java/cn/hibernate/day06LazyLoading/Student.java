package cn.hibernate.day06LazyLoading;

import java.util.Date;

/**
 * Created by yu  fan on 2017/12/29.
 */
public class Student {
    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    private Integer stuid;
    private String stuname;
    private Integer stuage;
    private Date studate;



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

    public Date getStudate() {
        return studate;
    }

    public void setStudate(Date studate) {
        this.studate = studate;
    }
}
