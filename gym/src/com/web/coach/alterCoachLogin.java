package com.web.coach;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.coachSQ;
import com.gymSQL.pojo.coach_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/alterCoachLogin")
public class alterCoachLogin extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login_idStr=req.getParameter("login_id");
        int id = Integer.parseInt(login_idStr);
        String alterType = req.getParameter("alterType");
        coachSQ coachSQ=new coachSQ();
        if (alterType.equals("delete")){
            coachSQ.delCoachLogin(id);
            req.getRequestDispatcher("getCoachLogin").forward(req,resp);
        }else if (alterType.equals("alter")){
            List<coach_login> coachLoginByID = coachSQ.getCoachLoginByID(id);
            coach_login coach_login = coachLoginByID.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("coachLoginByID",coach_login);
            super.processTemplate("coach/alterCoachLogin",req,resp);
        }
    }
}
