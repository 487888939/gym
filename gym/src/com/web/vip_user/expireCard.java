package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.cardholder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/expireCard")
public class expireCard extends ViewBaseServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pagenocard2=1;
        req.setCharacterEncoding("UTF-8");
        Vipuser vipuser = new Vipuser();
        HttpSession session = req.getSession();
        String pagenoStr=req.getParameter("pagenocard2");
        if(utils.isNotEmpty(pagenoStr)){//判断pagenocard是否为空,若不是就转为inter类型
            pagenocard2=Integer.parseInt(pagenoStr);
        }
        session.setAttribute("pagenocard2",pagenocard2);
        Object countObj = vipuser.getAllExpireCardCount();
        int count= Integer.parseInt(countObj.toString());//将Object类型转为int类型
        int cardcountPag2=(count+9-1)/9;//计算当前页每十条一页,总页数为
        session.setAttribute("cardcountPag2",cardcountPag2);//将总页数保存到session作用域
        List<cardholder> expireCardList= vipuser.ExpireCardList(pagenocard2);
        //将查询到的结果保存到会话作用域
        session.setAttribute("expireCardList",expireCardList);
        super.processTemplate("vip_user/expireCard",req,resp);
    }
}
