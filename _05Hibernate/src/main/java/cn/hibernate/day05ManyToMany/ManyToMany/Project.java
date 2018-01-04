package cn.hibernate.day05ManyToMany.ManyToMany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Project {
    private Integer pid;
    private String pname;
private Set<Employee> employee=new HashSet<Employee>();

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


}
