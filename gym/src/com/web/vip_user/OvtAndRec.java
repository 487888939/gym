package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/OvtAndRec")
public class OvtAndRec extends ViewBaseServlet {
    //用来加载要充值的用户信息
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String card_idStr= req.getParameter("card_id");
        int  card_id= Integer.parseInt(card_idStr);
        Object cardholder= vipuser.getCardholderById(card_id);
        req.getSession().setAttribute("cardholder",cardholder);
        String addType = req.getParameter("addType");
        if ("recharge".equals(addType)){
            super.processTemplate("vip_user/addBalance",req,resp);
        }else if ("overtime".equals(addType)){
            super.processTemplate("vip_user/addOvertime",req,resp);
        }

    }
}
