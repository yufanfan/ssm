package cn.hibernate.day05ManyToMany.ManyToMany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Employee {
    private Integer empid;
    private String empname;


    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

}
