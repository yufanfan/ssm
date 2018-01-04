package cn.hibernate.day05ManyToManyTwo.ManyToManyTwo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Employee {
    private Integer empid;
    private String empname;
    private Set<Project> project=new HashSet<Project>();

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

    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }
}
