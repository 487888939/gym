package com.web.lost;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.goodsSQ;
import com.gymSQL.SQservice.lostSQ;
import com.gymSQL.pojo.goods;
import com.gymSQL.pojo.lost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdLost")
public class UpdLost extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("lost_id");
        int id = Integer.parseInt(idStr);
        String updType = req.getParameter("updType");
        lostSQ lostSQ=new lostSQ();
        if ("delete".equals(updType)){
           lostSQ.delLost(id);
            req.getRequestDispatcher("lostList").forward(req,resp);
        }else if ("alter".equals(updType)){
            List<lost> lostById = lostSQ.getLostById(id);
            lost lost = lostById.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("lost",lost);
            super.processTemplate("lost/alterLost",req,resp);
        }
    }
}
