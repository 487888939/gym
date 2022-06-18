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
@WebServlet("/getEditVipList")
public class getEditVipList extends ViewBaseServlet {
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int  id= Integer.parseInt(idStr);
        User vipUserById = vipuser.getVipUserById(id);
        HttpSession session = req.getSession();
        session.setAttribute("vipUserById",vipUserById);
        System.out.println(vipUserById.getUsername());
        super.processTemplate("vip_user/editvipList",req,resp);
    }
}
