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
import java.util.List;
@WebServlet("/setCard")
public class setCard extends ViewBaseServlet {
    card_typeSQ card_typeSQ=new card_typeSQ();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<card_type> allCard_type = card_typeSQ.getAllCard_type();
        HttpSession session = req.getSession();
        session.setAttribute("card_typeList",allCard_type);
        super.processTemplate("vip_user/setCard",req,resp);
    }
}
