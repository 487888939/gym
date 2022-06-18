package com.web.equipment;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.SQservice.courseSQ;
import com.gymSQL.SQservice.equipmentSQ;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.User;
import com.gymSQL.pojo.course;
import com.gymSQL.pojo.equipment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/equtList")
public class equtList extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pagenoequt=1;
        req.setCharacterEncoding("UTF-8");
        equipmentSQ equipmentSQ=new equipmentSQ();
        HttpSession session = req.getSession();
        String pagenoStr=req.getParameter("pagenoequt");

        if(utils.isNotEmpty(pagenoStr)){//判断pagenocoach是否为空,若不是就转为inter类型
            pagenoequt=Integer.parseInt(pagenoStr);
        }
        session.setAttribute("pagenoequt",pagenoequt);
        String operStrReq=req.getParameter("oper1");
        //如果oper不等于null 说明通过表单的查询按钮点击过来的
        //如果oper是空,说明不是通过表单的查询按钮点击过来的
        String keyword1=null;
        if (utils.isNotEmpty(operStrReq)&&"search".equals(operStrReq)){
            //经入if说明是点击查询进来的
            //此时,pageno应该还原为1,keyword应该从请求参数中获取
            pagenoequt=1;
            keyword1=req.getParameter("keyword1");
            if (utils.isEmpty(keyword1)){
                keyword1="";
            }
            session.setAttribute("keyword1",keyword1);
        }else{
            if(utils.isNotEmpty(pagenoStr)){//说明不是点击搜寻进来的判断pagenoStr是否位空
                pagenoequt=Integer.parseInt(pagenoStr);
            }
            Object keywordC = session.getAttribute("keyword1");
            if (keywordC!=null){
                keyword1=(String)keywordC;
            }else{
                keyword1="";
            }
        }
        Object equtCountStr= equipmentSQ.getEqutCount(keyword1);
        int equtCountAll= Integer.parseInt(equtCountStr.toString());//将Object类型转为int类型
        int equtCount=(equtCountAll+6-1)/6;//计算当前页每十条一页,总页数为
        session.setAttribute("equtCount",equtCount);//将总页数保存到session作用域
        List<equipment> equtList = equipmentSQ.getEqutList(pagenoequt, keyword1);
        //将查询到的结果保存到会话作用域
        session.setAttribute("equtList",equtList);
        super.processTemplate("equipment/equtList",req,resp);
    }
}
