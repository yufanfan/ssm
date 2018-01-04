package cn.hibernate.day01.entity.entity;

/**
 * Created by Administrator on 2017/12/23.
 * 街道表
 */
public class Street {
    private Integer id;  //街道编号
    private String name;  //街道名称
    private Integer district_id;  //所属区县编号

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

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }
}
