package cn.hibernate.day02.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Happy on 2017-12-26.
 */
//检索条件的实体
public class EmpCondition {
    //和UI紧耦合  雇佣日期 ：范围
    //job
    private String job;


    //salary
    private Double sal;

    //入职开始时间
    private Date fromDate;

    //入职结束时间
    private Date endDate;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
