package cn.hibernate.day05duoduiduofencheng两个.chaifen;

/**
 * Created by yu  fan on 2017/12/30.
 */
public class PE {
    private Integer id;
    private Project pid;
    private Employee eid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getPid() {
        return pid;
    }

    public void setPid(Project pid) {
        this.pid = pid;
    }

    public Employee getEid() {
        return eid;
    }

    public void setEid(Employee eid) {
        this.eid = eid;
    }
}
