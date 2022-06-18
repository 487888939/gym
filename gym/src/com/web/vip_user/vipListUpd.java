package com.web.vip_user;

import com.gymSQL.SQservice.Vipuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/vipListUpd")
public class vipListUpd extends HttpServlet {
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int user_id= Integer.parseInt(idStr);
        vipuser.Deluser(user_id);
        resp.sendRedirect("vipList");
    }
}
