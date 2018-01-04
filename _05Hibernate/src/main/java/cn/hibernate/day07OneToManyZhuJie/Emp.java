package cn.hibernate.day07OneToManyZhuJie;


import javax.persistence.*;

/**
 * Created by yu  fan on 2017/12/27.
 */
@Entity
@Table(name = "EMP3")
public class Emp {
    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

@Id
@GeneratedValue
    private Integer empno;
    @Column
    private String ename;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "deptno")
    private Dept dept=new Dept();

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

}
