package com.web.coach;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.coachSQ;
import com.gymSQL.pojo.coach_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/getCoachLogin")
public class getCoachLogin extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        coachSQ coachSQ=new coachSQ();
        List<coach_login> coachLogin = coachSQ.getCoachLogin();
        HttpSession session = req.getSession();
        session.setAttribute("coach_login",coachLogin);
        super.processTemplate("coach/coachLogin",req,resp);
    }
}
