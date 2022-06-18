package com.web.notice;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.noticeSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/doSetNotice")
public class doSetNotice extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        String release_name = req.getParameter("release_name");
        String release_dateStr = req.getParameter("release_date");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String type = req.getParameter("type");
        String content = req.getParameter("content");
        noticeSQ noticeSQ=new noticeSQ();
        try {
            Date release_date= sdf.parse(release_dateStr);
            noticeSQ.doSetNotice(id,release_name,release_date,type,content);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("getNoticeList").forward(req,resp);
    }
}
