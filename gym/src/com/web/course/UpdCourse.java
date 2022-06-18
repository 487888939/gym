package com.web.course;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.courseSQ;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdCourse")
public class UpdCourse extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("course_id");
        int id = Integer.parseInt(idStr);
        String updType = req.getParameter("updType");
        courseSQ courseSQ=new courseSQ();
        if ("delete".equals(updType)){
            courseSQ.delCourse(id);
            req.getRequestDispatcher("getCourseList").forward(req,resp);
        }else if ("alter".equals(updType)){
            List<course> courseById = courseSQ.getCourseById(id);
            course course = courseById.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("course",course);
            super.processTemplate("course/alterCourse",req,resp);
        }
    }
}
