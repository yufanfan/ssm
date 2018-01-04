package cn.hibernate.day04OneToMany.oneToMany;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Emp {
    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    private Integer empno;
    private String ename;
    private Dept dept=new Dept();


    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

}
