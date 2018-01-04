package cn.hibernate.day07ManyToManyZhuJie;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yu  fan on 2018/1/2.
 */
@Entity
@Table(name = "TEACHERTWO")
public class TeacherTwo {
    @Id
   @GenericGenerator(name="teaid",strategy = "native")
    @GeneratedValue(generator = "teaid")
    private Integer tid;

    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "RStuTea",joinColumns = {@JoinColumn(name = "Teaid")},inverseJoinColumns = {@JoinColumn(name = "stuid")})

    private Set<StudentTwo> studentTwos=new HashSet<StudentTwo>();

    public Set<StudentTwo> getStudentTwos() {
        return studentTwos;
    }

    public void setStudentTwos(Set<StudentTwo> studentTwos) {
        this.studentTwos = studentTwos;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
@Column
    private String tname;

}