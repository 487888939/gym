package com.web.vip_user;

import com.gymSQL.SQservice.Vipuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addVipUser")
public class addVipUser extends HttpServlet {
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String login_limit = req.getParameter("login_limit");
        vipuser.addVipUser(username,password,email,login_limit);
        req.getRequestDispatcher("/static/vip_user/addVipUser.html").forward(req,resp);
    }
}
