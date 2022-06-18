package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/vipList")
public class vipList extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);//接受查询的内容调用doGet方法
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageno=1;
        req.setCharacterEncoding("UTF-8");
        Vipuser vipuser = new Vipuser();
        HttpSession session = req.getSession();
        String pagenoStr=req.getParameter("pageno");
        if(utils.isNotEmpty(pagenoStr)){//判断pageno是否为空,若不是就转为inter类型
            pageno=Integer.parseInt(pagenoStr);
        }
        session.setAttribute("pageno",pageno);
        String operStrReq=req.getParameter("oper");
        //如果oper不等于null 说明通过表单的查询按钮点击过来的
        //如果oper是空,说明不是通过表单的查询按钮点击过来的
        String keyword=null;
        if (utils.isNotEmpty(operStrReq)&&"search".equals(operStrReq)){
            //经入if说明是点击查询进来的
            //此时,pageno应该还原为1,keyword应该从请求参数中获取
            pageno=1;
            keyword=req.getParameter("keyword");
            if (utils.isEmpty(keyword)){
                keyword="";
            }
            session.setAttribute("keyword",keyword);
        }else{
            if(utils.isNotEmpty(pagenoStr)){
                pageno=Integer.parseInt(pagenoStr);
            }
            Object keyword1 = session.getAttribute("keyword");
            if (keyword1!=null){
                keyword=(String)keyword1;
            }else{
                keyword="";
            }
        }
        Object countObj = vipuser.getAllVipUserCount(keyword);
        int count= Integer.parseInt(countObj.toString());//将Object类型转为int类型
        int countPag=(count+9-1)/9;//计算当前页每十条一页,总页数为
        session.setAttribute("countPag",countPag);//将总页数保存到session作用域
        List<User> viplist= vipuser.viplist(pageno,keyword);
        //将查询到的结果保存到会话作用域
        session.setAttribute("viplist",viplist);
        super.processTemplate("vip_user/vipList",req,resp);
    }
}
