package cn.happy.service;

import cn.happy.entity.UserInfo;
import cn.happy.util.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-11-09.
 */
public interface IUserInfoService {
    //登录
    public UserInfo login(UserInfo info);
    //获取总记录数
    public int getTotalCount();
    //查询单页用户数据
    public PageUtil<UserInfo> findOnePageData(int pageindex, int pagesize,UserInfo info);
    //添加用户
    public int addUserInfo(UserInfo info);
    //删除用户
    public int deleteUserInfo(int id);
    //修改用户
    public int userUpdate(UserInfo info);
    //按id查询用户信息
    public UserInfo getInfo(int id);
}
