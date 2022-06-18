package com.web.equipment;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.courseSQ;
import com.gymSQL.SQservice.equipmentSQ;
import com.gymSQL.pojo.course;
import com.gymSQL.pojo.equipment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdEqut")
public class UpdEqut extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("equt_id");
        int id = Integer.parseInt(idStr);
        String updType = req.getParameter("updType");
        equipmentSQ equipmentSQ=new equipmentSQ();
        if ("delete".equals(updType)){
            equipmentSQ.delEqut(id);
            req.getRequestDispatcher("equtList").forward(req,resp);
        }else if ("alter".equals(updType)){
            List<equipment> equtById = equipmentSQ.getEqutById(id);
            equipment equipment = equtById.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("equipment",equipment);
            super.processTemplate("equipment/alterEqut",req,resp);
        }
    }
}
