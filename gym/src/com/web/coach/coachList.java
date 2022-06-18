package com.web.coach;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.SQservice.coachSQ;
import com.gymSQL.Utility.setCardholderState;
import com.gymSQL.Utility.utils;
import com.gymSQL.pojo.cardholder;
import com.gymSQL.pojo.coach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
@WebServlet("/coachList")
public class coachList extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer pagenocoach=1;
            req.setCharacterEncoding("UTF-8");
            coachSQ coachSQ=new coachSQ();
            HttpSession session = req.getSession();
            String pagenoStr=req.getParameter("pagenocoach");

            if(utils.isNotEmpty(pagenoStr)){//判断pagenocoach是否为空,若不是就转为inter类型
                pagenocoach=Integer.parseInt(pagenoStr);
            }
            session.setAttribute("pagenocoach",pagenocoach);
            String operStrReq=req.getParameter("oper1");
            //如果oper不等于null 说明通过表单的查询按钮点击过来的
            //如果oper是空,说明不是通过表单的查询按钮点击过来的
            String keyword1=null;
            if (utils.isNotEmpty(operStrReq)&&"search".equals(operStrReq)){
                //经入if说明是点击查询进来的
                //此时,pageno应该还原为1,keyword应该从请求参数中获取
                pagenocoach=1;
                keyword1=req.getParameter("keyword1");
                if (utils.isEmpty(keyword1)){
                    keyword1="";
                }
                session.setAttribute("keyword1",keyword1);
            }else{
                if(utils.isNotEmpty(pagenoStr)){//说明不是点击搜寻进来的判断pagenoStr是否位空
                    pagenocoach=Integer.parseInt(pagenoStr);
                }
                Object keywordC = session.getAttribute("keyword1");
                if (keywordC!=null){
                    keyword1=(String)keywordC;
                }else{
                    keyword1="";
                }
            }
        Object coachCountStr = coachSQ.getCoachCount(keyword1);
        int coachCount= Integer.parseInt(coachCountStr.toString());//将Object类型转为int类型
            int coachCountPag=(coachCount+10-1)/10;//计算当前页每十条一页,总页数为
            session.setAttribute("coachCountPag",coachCountPag);//将总页数保存到session作用域
            List<coach> coachList = coachSQ.getCoachList(pagenocoach, keyword1);
            //将查询到的结果保存到会话作用域
            session.setAttribute("coachList",coachList);
            super.processTemplate("coach/coachList",req,resp);
        }
    }

