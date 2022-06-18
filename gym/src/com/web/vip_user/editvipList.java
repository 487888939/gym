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
@WebServlet("/editvipList")
public class editvipList extends HttpServlet {
    Vipuser vipuser=new Vipuser();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        int  id= Integer.parseInt(idStr);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String reg_dateStr = req.getParameter("reg_date");
        String vip_type = req.getParameter("vip_type");
        String login_limit = req.getParameter("login_limit");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
            try {
                Date reg_date= sdf.parse(reg_dateStr);//将string类型转为date类型
                vipuser.editVip_user(username,password,email,reg_date,vip_type,login_limit,id);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        resp.sendRedirect("vipList");
    }
}
