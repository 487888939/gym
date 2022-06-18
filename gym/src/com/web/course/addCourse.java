package com.web.course;

import com.gymSQL.SQservice.courseSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addCourse")
public class addCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_name = req.getParameter("course_name");
        String course_price = req.getParameter("course_price");
        String taught = req.getParameter("taught");
        String teach_time = req.getParameter("teach_time");
        String teach_space = req.getParameter("teach_space");
        String course_state = req.getParameter("course_state");
        courseSQ courseSQ=new courseSQ();
        courseSQ.addCourse(course_name,course_price,taught,teach_time,teach_space,course_state);
        req.getRequestDispatcher("getCourseList").forward(req,resp);
    }
}
