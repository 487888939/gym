package com.web.vip_user;

import com.gymSQL.SQservice.Vipuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addCardholder")
public class addCardholder extends HttpServlet {
     Vipuser vipuser=new Vipuser();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String card_user= req.getParameter("card_user");
        String sex = req.getParameter("sex");
        String ageStr = req.getParameter("age");
        String phone = req.getParameter("phone");
        String birthdayStr = req.getParameter("birthday");
        int age= Integer.parseInt(ageStr);//转为int类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday= sdf.parse(birthdayStr);//将string类型转为date类型
            vipuser.addCardholder(card_user,sex,age,phone,birthday);
            vipuser.setVip_user(card_user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("cardholderList").forward(req,resp);
    }
}
