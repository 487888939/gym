package com.web.vip_user;

import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.Utility.setCardholderState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
@WebServlet("/addCardBalance")
public class addCardBalance extends HttpServlet {
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        setCardholderState setCardholderState=new setCardholderState();
        try {
            setCardholderState.setCardState();//得到数据库列表之前的更新操作
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String card_idStr = req.getParameter("card_id");
        int card_id = Integer.parseInt(card_idStr);
        String addBalanceStr = req.getParameter("addBalance");
        double addBalance= Double.valueOf(addBalanceStr.toString());//将String转为double类型
        vipuser.addBalance(card_id,addBalance);
        req.getRequestDispatcher("cardholderList").forward(req,resp);
    }
}
