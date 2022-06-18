package com.web.coach;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.coachSQ;
import com.gymSQL.pojo.coach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/alterCoach")
public class alterCoach extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("coach_id");
        int id= Integer.parseInt(idStr);
        coachSQ coachSQ=new coachSQ();
        List<coach> coachById = coachSQ.getCoachById(id);
        coach coach = coachById.get(0);
        HttpSession session = req.getSession();
        session.setAttribute("coachObj",coach);
        super.processTemplate("coach/alterCoach.html",req,resp);
    }
}
