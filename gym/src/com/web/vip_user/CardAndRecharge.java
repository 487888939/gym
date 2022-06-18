package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/CardAndRecharge")
public class CardAndRecharge extends ViewBaseServlet {
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name= req.getParameter("username");
        HttpSession session = req.getSession();
        boolean b = vipuser.queryUser(name);//true为用户不存在
        if (b){
            String prompt="您还未注册,请先注册!";
            session.setAttribute("prompt",prompt);//提示客户端还未注册
            super.processTemplate("vip_user/queryCustomer",req,resp);
        }else{//当用户存在时
            User vipUserByUsername = vipuser.getVipUserByUsername(name);
            String vip_type = vipUserByUsername.getVip_type();//判断用户是否办卡
            if ("未办卡".equals(vip_type)){//判断用户是否办卡
                String prompt="您还未办卡请先办卡!";
                session.setAttribute("prompt",prompt);//提示客户端还未注册
                super.processTemplate("vip_user/queryCustomer",req,resp);
            }else{//如果已办卡
                Object cardholderByName = vipuser.getCardholderByName(name);
                session.setAttribute("cardholder",cardholderByName);
                super.processTemplate("vip_user/CardAndRecharge",req,resp);
            }
        }
    }
}
