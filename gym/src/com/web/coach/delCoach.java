package com.web.coach;

import com.gymSQL.SQservice.coachSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delCoach")
public class delCoach extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("coach_id");
        int id= Integer.parseInt(idStr);
         coachSQ coachSQ=new coachSQ();
         coachSQ.delCoach(id);
         req.getRequestDispatcher("coachList").forward(req,resp);
    }
}
