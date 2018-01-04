package cn.hibernate.day03manyoroneMapping.manyOrOne;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Emp {
    private Integer empno;
    private String ename;
    private Dept dept=new Dept();


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



    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
