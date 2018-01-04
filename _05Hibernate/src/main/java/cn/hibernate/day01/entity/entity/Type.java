package cn.hibernate.day01.entity.entity;

/**
 * Created by Administrator on 2017/12/23.
 *房屋类型
 */
public class Type {
    private Integer id;  //类型编号
    private String name;  //类型名称

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
