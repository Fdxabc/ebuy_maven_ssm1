package com.lcvc.ebuy_maven_ssm.web.backstage.admin;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

@Controller
public class AdminController {
   // private  AdminDao adminDao=new AdminDao();
   private AdminService adminService=new AdminService();
    //跳转到密码修改页面
    @RequestMapping(value ="/backstage/admin/toUpdatePassword")
    public String toUpdatePassword(){
        return "/jsp/backstage/admin/passwordupdate.jsp";
    }
    //执行密码修改操作
    @RequestMapping(value ="/backstage/admin/doUpdatePassword")
    public  String doUpdatePassword(String oldPass, String newPass, String confirmPass, HttpSession session ){
       //执行密码修改
        //关键点：获取登录账的ID

        Admin admin=(Admin)session.getAttribute("admin");
        //方法一，重新登陆的方式
        if( adminService.login(admin.getUsername(),oldPass)!=null){   //先对旧密码是否正确进行判断
            if (newPass.equals(confirmPass)){                         //对新密码和确认密码是否一致判断
                //保存密码
                adminService.updatePassword(newPass,admin.getId());
            }
        }

        return "/jsp/backstage/admin/passwordupdate.jsp";
    }
}
