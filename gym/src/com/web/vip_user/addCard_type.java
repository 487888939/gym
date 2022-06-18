package com.web.vip_user;

import com.gymSQL.SQservice.card_typeSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addCard_type")
public class addCard_type extends HttpServlet {
    com.gymSQL.SQservice.card_typeSQ card_typeSQ=new card_typeSQ();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String card_name = req.getParameter("card_name");
        String card_priceStr = req.getParameter("card_price");
        Double card_price = Double.valueOf(card_priceStr.toString());//将String转为double类型
        String indateStr = req.getParameter("indate");
        int indate = Integer.parseInt(indateStr);
        String discountStr = req.getParameter("discount");
        Double  discount=Double.valueOf(discountStr.toString());//将String转为double类型
        card_typeSQ.addCard_type(card_name,card_price,indate,discount);
        req.getRequestDispatcher("setCard").forward(req,resp);
    }
}
