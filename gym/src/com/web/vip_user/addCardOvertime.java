package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.SQservice.card_typeSQ;
import com.gymSQL.Utility.setCardholderState;
import com.gymSQL.pojo.card_type;
import com.gymSQL.pojo.cardholder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
@WebServlet("/addCardOvertime")
public class addCardOvertime extends ViewBaseServlet {
    Vipuser vipuser=new Vipuser();
    card_typeSQ card_typeSQ=new card_typeSQ();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        setCardholderState setCardholderState=new setCardholderState();
        try {
            setCardholderState.setCardState();//得到数据库列表之前的更新操作
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
            String estimate = req.getParameter("estimate");
            String card_idStr = req.getParameter("card_id");
            int card_id = Integer.parseInt(card_idStr);
            String addBalanceStr = req.getParameter("addOvertime");//得到选择充值的卡类型
            card_type card_type = card_typeSQ.getCard_type(addBalanceStr);
            Double card_price = card_type.getCard_price();//拿到充值卡类型的价格
            cardholder cardholderBalance = vipuser.getCardholderBalance(card_id);
            Double balance = cardholderBalance.getBalance();//得到当前账户的余额
            Integer indate = card_type.getIndate();//拿到年卡有效天数
        String card_state = cardholderBalance.getCard_state();//得到当前卡的状态信息
        if (balance>=card_price){//判断余额是否大于卡类型价格
            if ("已过期".equals(card_state)){//判断该卡是否是已过期的卡,如果是
                vipuser.removeBalance(card_id,card_price);//减去卡上年卡金额
                vipuser.addExpire_date(card_id,indate);//给该卡加上当前卡类型的时长
                vipuser.setExpireCard_state(card_id);//更改当前卡的状态,并且更新充值时间(为当前时间)
                req.getRequestDispatcher("cardholderList").forward(req,resp);//充值成功跳转到之前也页面
            }else{//若该卡是正常使用的卡
                vipuser.removeBalance(card_id,card_price);//减去卡上年卡金额
                vipuser.addExpire_date(card_id,indate);//给该卡加上当前卡类型的时长
                req.getRequestDispatcher("cardholderList").forward(req,resp);//充值成功跳转到之前也页面
            }
        }else if (estimate==null){//判断请求是那个页面发送的
            String prompt="卡上余额不足,请先充值!";
            session.setAttribute("prompt",prompt);
            super.processTemplate("vip_user/addOvertime",req,resp);
        }else if ("B".equals(estimate)){
            String prompt="卡上余额不足,请先充值!";
            session.setAttribute("prompt",prompt);
            super.processTemplate("vip_user/CardAndRecharge",req,resp);
        }
    }
}
