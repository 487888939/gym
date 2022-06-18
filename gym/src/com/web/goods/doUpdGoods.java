package com.web.goods;


import com.gymSQL.SQservice.goodsSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doUpdGoods")
public class doUpdGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        goodsSQ goodsSQ = new goodsSQ();
        String doUpdType = req.getParameter("doUpdType");
        String g_name = req.getParameter("g_name");
        String g_accountStr = req.getParameter("g_account");
        int g_account = Integer.parseInt(g_accountStr);
        String g_priceStr = req.getParameter("g_price");
        Double g_price = Double.valueOf(g_priceStr.toString());
        String g_brand = req.getParameter("g_brand");
        if (doUpdType.equals("add")) {
            goodsSQ.addGoods(g_name, g_account, g_price, g_brand);
            req.getRequestDispatcher("goodsList").forward(req, resp);
        } else if (doUpdType.equals("alter")) {
            String idStr = req.getParameter("goods_id");
            int id = Integer.parseInt(idStr);
            goodsSQ.setGoods(id, g_name, g_account, g_price, g_brand);
            req.getRequestDispatcher("goodsList").forward(req, resp);
        }
    }
}
