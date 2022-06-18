package com.web.notice;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.noticeSQ;
import com.gymSQL.pojo.notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/getNoticeList")
public class getNoticeList extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        noticeSQ noticeSQ=new noticeSQ();
        List<notice> noticeCon = noticeSQ.getNoticeCon();
        req.getSession().setAttribute("noticeList",noticeCon);
        super.processTemplate("notice/noticeList",req,resp);
    }
}
