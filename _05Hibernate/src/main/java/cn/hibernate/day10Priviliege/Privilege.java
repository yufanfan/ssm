package cn.hibernate.day10Priviliege;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2018/1/4.
 */
@Entity
@Table(name = "PRIVILEGE2")
public class Privilege {
    @Id
    @GeneratedValue
    private Integer pid;
    @Column
    private String pname;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles=new HashSet<Role>();


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


}
