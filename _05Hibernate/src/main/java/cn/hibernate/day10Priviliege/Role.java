package cn.hibernate.day10Priviliege;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2018/1/4.
 */
@Entity
@Table(name = "ROLE2")
public class Role {
    @Id
    @GeneratedValue
private Integer rid;
    @Column
private String rname;


    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "USER_ROLE2",joinColumns = {@JoinColumn(name = "rid")},inverseJoinColumns = {@JoinColumn(name = "userid")})
    private Set<User> users=new HashSet<User>();

    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "ROLE_PRIVILEGE2",joinColumns = {@JoinColumn(name = "rid")},inverseJoinColumns = {@JoinColumn(name = "pid")})
    private Set<Privilege> privileges=new HashSet<Privilege>();

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
