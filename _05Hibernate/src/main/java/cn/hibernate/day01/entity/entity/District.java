package cn.hibernate.day01.entity.entity;

/**
 * Created by Administrator on 2017/12/23.
 * 区县表
 */
public class District {
    private Integer id;  //曲线编号
    private String name;  //区县名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
