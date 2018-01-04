package cn.hibernate.day03manyoroneMapping.manyOrOne;

/**
 * Created by yu  fan on 2017/12/27.
 */
public class Dept {
    private Integer deptno;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    private String dname;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

public void  f(){
        System.out.println("hello");
}
}
