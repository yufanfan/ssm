package cn.hibernate.day07ZhuJie;

import javax.persistence.*;

/**
 * Created by yu  fan on 2017/12/27.
 */
@Entity
@Table(name="DEPT2")
public class Dept {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_gen")
    @SequenceGenerator(name="seq_gen",sequenceName="SEQ_NUM",allocationSize = 1)
    private Integer deptno;
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
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
