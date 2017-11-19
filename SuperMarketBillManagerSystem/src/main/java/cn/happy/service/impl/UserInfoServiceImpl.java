package cn.happy.service.impl;

import cn.happy.dao.IUserInfoDAO;
import cn.happy.entity.UserInfo;
import cn.happy.service.IUserInfoService;
import cn.happy.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-11-09.
 */
@Service("userService")
public class UserInfoServiceImpl implements IUserInfoService {
    @Resource(name = "IUserInfoDAO")
    private IUserInfoDAO userInfoDAO;

    //登录
    public UserInfo login(UserInfo info) {
        return userInfoDAO.login(info);
    }
    //查询总记录数
    public int getTotalCount() {
        return userInfoDAO.getTotalCount();
    }
    //分页查询
    public PageUtil<UserInfo> findOnePageData(int pageindex, int pagesize, UserInfo info) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageindex",(pageindex-1)*pagesize);
        map.put("pagesize",pagesize);
        if(info!=null&&!info.getUserName().equals(null)){//模糊查询框有输入条件
            map.put("userName",info.getUserName());;
        }
        PageUtil<UserInfo> page=new PageUtil<UserInfo>();
        page.setPageIndex(pageindex);
        page.setPageSize(pagesize);
        int totalRecords=0;
        if (info!=null&&!info.getUserName().equals(null)){//用户填写了查询体条件
            totalRecords= userInfoDAO.getTotalRecordsByCondition(info.getUserName());
        }else{
            totalRecords = userInfoDAO.getTotalCount();
        }
        page.setTotalRecords(totalRecords);
        page.setTotalPages(page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize()
                :page.getTotalRecords()/page.getPageSize()+1);
        page.setList(userInfoDAO.findOnePageData(map));
        return page;
    }
    //添加用户
    public int addUserInfo(UserInfo info) {
        return userInfoDAO.addUserInfo(info);
    }
    //删除用户
    public int deleteUserInfo(int id) {
        return userInfoDAO.deleteUserInfo(id);
    }

    public int userUpdate(UserInfo info) {
        return userInfoDAO.userUpdate(info);
    }

    public UserInfo getInfo(int id) {
        return userInfoDAO.getInfo(id);
    }

}

