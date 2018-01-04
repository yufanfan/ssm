package cn.hibernate.day07ManyToManyZhuJie;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2018/1/2.
 */
@Entity
@Table(name = "STUDENTTWO")
public class StudentTwo {
    @Id
    @GenericGenerator(name = "stuid",strategy = "native")
    @GeneratedValue(generator = "stuid")
    private Integer sid;

    @ManyToMany
    @Cascade(value = CascadeType.SAVE_UPDATE)
    @JoinTable(name = "RStuTea",joinColumns = {@JoinColumn(name = "stuid")},inverseJoinColumns = {@JoinColumn(name = "Teaid")})
    private Set<TeacherTwo> teacherTwos=new HashSet<TeacherTwo>();

    public Set<TeacherTwo> getTeacherTwos() {
        return teacherTwos;
    }

    public void setTeacherTwos(Set<TeacherTwo> teacherTwos) {
        this.teacherTwos = teacherTwos;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
@Column
    private String sname;

}
