package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.card_typeSQ;
import com.gymSQL.pojo.card_type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/doSetCard")
public class doSetCard extends ViewBaseServlet {
    card_typeSQ card_typeSQ=new card_typeSQ();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String card_idStr = req.getParameter("card_id");
        int card_id= Integer.parseInt(card_idStr);
        card_type card_type= card_typeSQ.getCard_typeById(card_id);
        session.setAttribute("card_type",card_type);
        super.processTemplate("vip_user/editSetCard",req,resp);
    }
}
