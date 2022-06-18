package com.web.lost;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.goodsSQ;
import com.gymSQL.SQservice.lostSQ;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.goods;
import com.gymSQL.pojo.lost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/lostList")
public class lostList extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pagenolost=1;
        req.setCharacterEncoding("UTF-8");
        lostSQ lostSQ=new lostSQ();
        HttpSession session = req.getSession();
        String pagenoStr=req.getParameter("pagenolost");

        if(utils.isNotEmpty(pagenoStr)){//判断pagenogoods是否为空,若不是就转为inter类型
            pagenolost=Integer.parseInt(pagenoStr);
        }
        session.setAttribute("pagenolost",pagenolost);
        String operStrReq=req.getParameter("oper1");
        //如果oper不等于null 说明通过表单的查询按钮点击过来的
        //如果oper是空,说明不是通过表单的查询按钮点击过来的
        String keyword1=null;
        if (utils.isNotEmpty(operStrReq)&&"search".equals(operStrReq)){
            //经入if说明是点击查询进来的
            //此时,pageno应该还原为1,keyword应该从请求参数中获取
            pagenolost=1;
            keyword1=req.getParameter("keyword1");
            if (utils.isEmpty(keyword1)){
                keyword1="";
            }
            session.setAttribute("keyword1",keyword1);
        }else{
            if(utils.isNotEmpty(pagenoStr)){//说明不是点击搜寻进来的判断pagenoStr是否位空
                pagenolost=Integer.parseInt(pagenoStr);
            }
            Object keywordC = session.getAttribute("keyword1");
            if (keywordC!=null){
                keyword1=(String)keywordC;
            }else{
                keyword1="";
            }
        }
        Object lostCountObj =lostSQ.getLostCount(keyword1);
        int lostCountAll= Integer.parseInt(lostCountObj.toString());//将Object类型转为int类型
        int lostCount=(lostCountAll+6-1)/6;//计算当前页每十条一页,总页数为
        session.setAttribute("lostCount",lostCount);//将总页数保存到session作用域
        List<lost> lostList = lostSQ.getLostList(pagenolost, keyword1);

        //将查询到的结果保存到会话作用域
        session.setAttribute("lostList",lostList);
        super.processTemplate("lost/lostList",req,resp);
    }
}
