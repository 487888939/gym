package com.web.vip_user;

import com.gymSQL.SQservice.UserRegist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/registGym")
public class registGym extends HttpServlet {
    UserRegist userRegist=new UserRegist();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        boolean b = userRegist.registUser(username, password, email);
        if (b){
            req.getRequestDispatcher("/static/vip_user/login.html").forward(req,resp);
        }else{
            req.getRequestDispatcher("/static/vip_user/regist.html").forward(req,resp);
        }
    }
}
