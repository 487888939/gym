package com.web.equipment;

import com.gymSQL.SQservice.equipmentSQ;
import com.gymSQL.Utility.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/doUpdEqut")
public class doUpdEqut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        equipmentSQ equipmentSQ=new equipmentSQ();
        String doUpdType = req.getParameter("doUpdType");
        String equ_name = req.getParameter("equ_name");
        String accountStr = req.getParameter("account");
        int account= Integer.parseInt(accountStr);
        String purchaseStr = req.getParameter("purchase");
        Double purchase = Double.valueOf(purchaseStr.toString());
        String merchant = req.getParameter("merchant");
        String equ_state = req.getParameter("equ_state");
        String buy_timeStr = req.getParameter("buy_time");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date buy_time= sdf.parse(buy_timeStr);
            if (doUpdType.equals("add")){
                equipmentSQ.addEqut(equ_name,account,purchase,merchant,buy_time,equ_state);
                req.getRequestDispatcher("equtList").forward(req,resp);
            }else if(doUpdType.equals("alter")){
                String idStr = req.getParameter("eupt_id");
                int id = Integer.parseInt(idStr);
                equipmentSQ.setEqut(id,equ_name,account,purchase,merchant,buy_time,equ_state);
                req.getRequestDispatcher("equtList").forward(req,resp);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }
}
