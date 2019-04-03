package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;

public class AdminService {
    private AdminDao adminDao=new AdminDao();
    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return null表示
     *
     * */
    public Admin login(String username, String password) {
        //对密码加密
        password = SHA.getResult(password);
        Admin admin=adminDao.login(username,password);
        return admin;
    }

    /**
     *
     * @param newPass
     * @param id
     * @return
     */
    public boolean updatePassword(String newPass,Integer id){
        boolean result=false;
        newPass=SHA.getResult(newPass);
        if(adminDao.updatePassword(newPass,id)>0){//如果能够从数据库找到记录
            result=true;
        }
        return  result;
    }
}
