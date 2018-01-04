package cn.hibernate.day07OneToOneZhuJie;

import javax.persistence.*;


/**
 * Created by yu  fan on 2017/12/27.
 */
@Entity
@Table(name = "DEPT2")
public class Dept {

    @Id
    @GeneratedValue
    private Integer deptno;
        /*    @OneToOne(mappedBy = "dept" ,targetEntity = Emp.class,cascade = CascadeType.ALL)*/
    private String dname;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
    @OneToOne(mappedBy = "dept" ,cascade = CascadeType.ALL)
    private Emp emp;


}
