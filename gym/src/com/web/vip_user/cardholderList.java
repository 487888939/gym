package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.Utility.setCardholderState;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.cardholder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
@WebServlet("/cardholderList")
public class cardholderList extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pagenocard=1;
        req.setCharacterEncoding("UTF-8");
        Vipuser vipuser = new Vipuser();
        setCardholderState setCardholderState=new setCardholderState();
        try {
            setCardholderState.setCardState();//得到数据库列表之前的更新操作
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        String pagenoStr=req.getParameter("pagenocard");

        if(utils.isNotEmpty(pagenoStr)){//判断pagenocard是否为空,若不是就转为inter类型
            pagenocard=Integer.parseInt(pagenoStr);
        }
        session.setAttribute("pagenocard",pagenocard);
        String operStrReq=req.getParameter("oper1");
        //如果oper不等于null 说明通过表单的查询按钮点击过来的
        //如果oper是空,说明不是通过表单的查询按钮点击过来的
        String keyword1=null;
        if (utils.isNotEmpty(operStrReq)&&"search".equals(operStrReq)){
            //经入if说明是点击查询进来的
            //此时,pageno应该还原为1,keyword应该从请求参数中获取
            pagenocard=1;
            keyword1=req.getParameter("keyword1");
            if (utils.isEmpty(keyword1)){
                keyword1="";
            }
            session.setAttribute("keyword1",keyword1);
        }else{
            if(utils.isNotEmpty(pagenoStr)){
                pagenocard=Integer.parseInt(pagenoStr);
            }
            Object keywordC = session.getAttribute("keyword1");
            if (keywordC!=null){
                keyword1=(String)keywordC;
            }else{
                keyword1="";
            }
        }
        Object countObj = vipuser.getAllCardholderCount(keyword1);
        int count= Integer.parseInt(countObj.toString());//将Object类型转为int类型
        int cardcountPag=(count+9-1)/9;//计算当前页每十条一页,总页数为
        session.setAttribute("cardcountPag",cardcountPag);//将总页数保存到session作用域
        List<cardholder> cardholderList= vipuser.cardholderList(pagenocard,keyword1);
        //将查询到的结果保存到会话作用域
        session.setAttribute("cardholderList",cardholderList);
        super.processTemplate("vip_user/cardholderList",req,resp);
    }
}
