package cn.happy.dao;


import cn.happy.entity.UserInfo;


import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-11-09.
 */
public interface IUserInfoDAO {
    //登录
    public UserInfo login(UserInfo info);
    //获取总记录数
    public int getTotalCount();
    //获取单页数据
    public List<UserInfo> findOnePageData(Map<String,Object> map);
    //带条件查询数据
    public int getTotalRecordsByCondition(String userName);
    //添加用户
    public int addUserInfo(UserInfo info);
    //删除用户
    public int deleteUserInfo(int id);
    //修改用户
    public int userUpdate(UserInfo info);
    //按id查询用户信息
    public UserInfo getInfo(int id);
}
