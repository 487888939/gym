package com.web.notice;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.noticeSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doUpdate")
public class doUpdate extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String upType = req.getParameter("upType");
        String idStr = req.getParameter("notice_id");
        int id = Integer.parseInt(idStr);
        noticeSQ noticeSQ=new noticeSQ();
        if (upType.equals("delete")){
            noticeSQ.delNotice(id);
            req.getRequestDispatcher("getNoticeList").forward(req,resp);
        }else if (upType.equals("alter")){
            req.getRequestDispatcher("updateNotice").forward(req,resp);
        }else if (upType.equals("release")){
            boolean b = noticeSQ.setNoticeState();//将所有正在公示的改为未公示
            if (b){
                noticeSQ.setNoticeState1(id);//将state改为正在公示
                req.getRequestDispatcher("getNoticeList").forward(req,resp);
            }
        }
    }
}
