package cn.hibernate.day04OneToMany.oneToMany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Dept {
    private Integer deptno;  private String dname;
    private Set<Emp> emp=new HashSet<Emp>();

    public Set<Emp> getEmp() {
        return emp;
    }

    public void setEmp(Set<Emp> emp) {
        this.emp = emp;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }



    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }


}
