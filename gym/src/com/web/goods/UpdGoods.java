package com.web.goods;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.equipmentSQ;
import com.gymSQL.SQservice.goodsSQ;
import com.gymSQL.pojo.equipment;
import com.gymSQL.pojo.goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdGoods")
public class UpdGoods extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("goods_id");
        int id = Integer.parseInt(idStr);
        String updType = req.getParameter("updType");
        goodsSQ goodsSQ=new goodsSQ();
        if ("delete".equals(updType)){
            goodsSQ.delGoods(id);
            req.getRequestDispatcher("goodsList").forward(req,resp);
        }else if ("alter".equals(updType)){
            List<goods> goodsById = goodsSQ.getGoodsById(id);
            goods goods = goodsById.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("goods",goods);
            super.processTemplate("goods/alterGoods",req,resp);
        }
    }
}
