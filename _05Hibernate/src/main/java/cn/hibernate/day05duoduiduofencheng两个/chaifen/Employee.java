package cn.hibernate.day05duoduiduofencheng两个.chaifen;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Employee {
    private Integer empid;
    private String empname;
private Set<PE> project=new HashSet<PE>();

    public Set<PE> getProject() {
        return project;
    }

    public void setProject(Set<PE> project) {
        this.project = project;
    }

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
