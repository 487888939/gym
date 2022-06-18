package com.web.notice;

import com.gymSQL.SQservice.noticeSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/addNotice")
public class addNotice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String release_name = req.getParameter("release_name");
        String state = req.getParameter("state");
        String release_content = req.getParameter("release_content");
        String release_dateStr = req.getParameter("release_date");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String type = req.getParameter("type");
        noticeSQ noticeSQ=new noticeSQ();
        try {
            Date release_date= sdf.parse(release_dateStr);
            noticeSQ.addNotice(release_name,state,type,release_date,release_content);
            req.getRequestDispatcher("getNoticeList").forward(req,resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
