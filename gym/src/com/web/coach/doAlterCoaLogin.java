package com.web.coach;

import com.gymSQL.SQservice.coach_loginSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doAlterCoaLogin")
public class doAlterCoaLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("login_id");
        int id = Integer.parseInt(idStr);
        String coa_name = req.getParameter("coa_name");
        String password = req.getParameter("password");
        String state = req.getParameter("state");
        coach_loginSQ coach_loginSQ=new coach_loginSQ();
        coach_loginSQ.alterCoach_login(id,coa_name,password,state);
        req.getRequestDispatcher("getCoachLogin").forward(req,resp);
    }
}
