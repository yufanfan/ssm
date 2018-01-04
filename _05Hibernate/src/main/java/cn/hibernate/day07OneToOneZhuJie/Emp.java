package cn.hibernate.day07OneToOneZhuJie;

import javax.persistence.*;

/**
 * Created by yu  fan on 2017/12/27.
 */
@Entity
@Table(name = "EMP2")
public class Emp {

@Id
@GeneratedValue
    private Integer empno;
    private String ename;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @OneToOne
      /*  @OneToOne(optional = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)*/
    @JoinColumn(name = "did")
private Dept dept;


}
