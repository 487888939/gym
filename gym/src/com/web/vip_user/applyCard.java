package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/applyCard")
public class applyCard extends ViewBaseServlet {
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name= req.getParameter("username");
        HttpSession session = req.getSession();
        if(utils.isEmpty(name)){
            String prompt="输入不能为空";
            session.setAttribute("prompt",prompt);//提示客户端输入不能为空
            super.processTemplate("vip_user/applyCard",req,resp);
            return;
        }else{
            boolean b = vipuser.queryUser(name);//查询用户是否存在true为用户不存在
            if (!b) {//用户存在
                User vipUserByUser = vipuser.getVipUserByUsername(name);
                String vip_type = vipUserByUser.getVip_type();//得到当前用户办卡状态
                if (!("已办卡".equals(vip_type))){//当用户存在时 判断有没有办卡
                    User vipUserByUsername = vipuser.getVipUserByUsername(name);
                    session.setAttribute("vip_user",vipUserByUsername);
                    super.processTemplate("vip_user/addCardholder",req,resp);
                }else if (("已办卡".equals(vip_type))){//如果以办卡提示客户端
                    String prompt="您已办卡请勿重复办卡";
                    session.setAttribute("prompt",prompt);//提示客户端还未注册
                    super.processTemplate("vip_user/applyCard",req,resp);
                }
            }
            if (b) {
                String prompt = "您还未注册,请先注册!";
                session.setAttribute("prompt", prompt);//提示客户端还未注册
                super.processTemplate("vip_user/applyCard", req, resp);
            }
        }
    }
}
