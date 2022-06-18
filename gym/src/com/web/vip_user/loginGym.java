package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Userlogin;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.SQservice.coach_loginSQ;
import com.gymSQL.SQservice.managerSQ;
import com.gymSQL.Utility.updateNoticeOp;
import com.gymSQL.pojo.User;
import com.gymSQL.pojo.notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginGym")
public class loginGym extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String login_type = req.getParameter("login_type");
        updateNoticeOp updateNoticeOp=new updateNoticeOp();
        notice noticeCot = updateNoticeOp.getNoticeCot();
        managerSQ managerSQ = new managerSQ();
        boolean b = managerSQ.man_login(username, password);//管理员登录
        if (b) {
            session.setAttribute("login_name", username);
            session.setAttribute("notice",noticeCot);
            super.processTemplate("vip_user/GymHome", req, resp);
        } else {
            String prompt = "登录失败密码或账户名有误!";
            session.setAttribute("prompt1", prompt);
            super.processTemplate("vip_user/login", req, resp);
        }
    }
}
