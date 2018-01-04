package cn.hibernate.day09.Book;

import javax.persistence.*;

/**
 * Created by yu  fan on 2018/1/4.
 */
@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue
    private Integer bid;

    @Column
    private String bname;
    private Integer btype;
    private Integer bprice;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getBtype() {
        return btype;
    }

    public void setBtype(Integer btype) {
        this.btype = btype;
    }

    public Integer getBprice() {
        return bprice;
    }

    public void setBprice(Integer bprice) {
        this.bprice = bprice;
    }
}
