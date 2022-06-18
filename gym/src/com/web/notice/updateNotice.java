package com.web.notice;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.noticeSQ;
import com.gymSQL.Utility.updateNoticeOp;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/updateNotice")
public class updateNotice extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String upType = req.getParameter("upType");
        HttpSession session = req.getSession();
        if (utils.isEmpty(upType)){
            updateNoticeOp updateNoticeOp=new updateNoticeOp();
            notice noticeCot = updateNoticeOp.getNoticeCot();
            session.setAttribute("noticeSet",noticeCot);
            super.processTemplate("notice/setNotice",req,resp);
        }else{
            noticeSQ noticeSQ=new noticeSQ();
            String idStr = req.getParameter("notice_id");
            int id = Integer.parseInt(idStr);
            notice noticeCot = noticeSQ.getNotice(id);
            session.setAttribute("noticeSet",noticeCot);
            super.processTemplate("notice/setNotice",req,resp);
        }
    }
}
