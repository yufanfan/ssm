package cn.hibernate.day05duoduiduofencheng两个.chaifen;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Project {
    private Integer pid;
    private String pname;
private Set<PE> employee=new HashSet<PE>();

    public Set<PE> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<PE> employee) {
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
