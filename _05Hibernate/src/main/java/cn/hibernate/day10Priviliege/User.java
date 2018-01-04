package cn.hibernate.day10Priviliege;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2018/1/4.
 */
@Entity
@Table(name = "USER2")
public class User {
    @Id
    @GeneratedValue
    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column
    private String username;


    @ManyToMany(mappedBy = "users")
 private Set<Role> roles=new HashSet<Role>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}
