package cn.happy.controller;


import cn.happy.entity.UserInfo;
import cn.happy.service.IUserInfoService;
import cn.happy.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Happy on 2017-11-09.
 */
@Controller
public class UserInfoController {
    @Resource(name = "userService")
    IUserInfoService userInfoService;

    //删除用户
    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteUserInfo(String allId,HttpSession session){
        String[] split = allId.split(",");// 拆解逗号
        int count=0;
        for (int i=0;i<split.length;i++){
            count = userInfoService.deleteUserInfo(Integer.parseInt(split[i])); //在遍历数组时删除批量数据
        }
        boolean flag=false;
        if (count>0)
            flag=true;
        return flag;
    }



    //添加用户
    @RequestMapping("/insert")
    @ResponseBody
    public Object insertUserInfo(UserInfo info,HttpSession session){
        int i = userInfoService.addUserInfo(info);
        boolean flag=false;
        if (i>0)
            flag=true;
        else
            flag=false;

        return flag;
    }


    //修改用户信息
    @RequestMapping("/update")
    @ResponseBody
    public String userUpdate(UserInfo user){
        int count = userInfoService.userUpdate(user);
        return "/jsp/userListEasyUIAdd.jsp";
    }
    //按id查询用户信息
    @RequestMapping("/getinfo")
    public String getinfo(int id,HttpSession session){
        UserInfo info = userInfoService.getInfo(id);
        session.setAttribute("info",info);
        return "/jsp/userUpdate.jsp";
    }




  /*  //查询单页用户记录的方法
    @RequestMapping("/userList")
    @ResponseBody
    public Object userList(@RequestParam(defaultValue = "1",required = false*//*,value = "page"*//*) int pageindex, @RequestParam(defaultValue = "2",required = false*//*,value = "rows"*//*)int pagesize,UserInfo info){
  *//*      Map<String ,Object> map=new HashMap<String,Object>();*//*
        PageUtil<UserInfo> page = userInfoService.findOnePageData(pageindex, pagesize,info);
 *//*       map.put("total",page.getTotalRecords());
        map.put("rows",page.getList());*//*
        return page;
    }*/

    //查询单页用户记录的方法
    @RequestMapping("/userList")
    @ResponseBody
    public Object userList(@RequestParam(defaultValue = "1",required = false,value = "page") int pageindex,
                           @RequestParam(defaultValue = "2",required = false,value = "rows")int pagesize,
                           UserInfo info){
        Map<String ,Object> map=new HashMap<String,Object>();
       PageUtil<UserInfo> page = userInfoService.findOnePageData(pageindex, pagesize,info);
     map.put("total",page.getTotalRecords());
     map.put("rows",page.getList());
        return map;
    }

   //登录
   @RequestMapping("/login")
  public String isLogin(UserInfo info, HttpSession session){
        UserInfo user = userInfoService.login(info);
        if(user!=null){
            //登录成功
            session.setAttribute("userinfo",user);
            return "/jsp/welcome.jsp";
        }else{
            //登录失败，跳回login
            return "/jsp/login.jsp";
        }
    }
}
