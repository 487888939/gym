package com.web.lost;


import com.gymSQL.SQservice.goodsSQ;
import com.gymSQL.SQservice.lostSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/doUpdLost")
public class doUpdLost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lostSQ lostSQ=new lostSQ();
        String doUpdType = req.getParameter("doUpdType");
        String l_name = req.getParameter("l_name");
        String l_describe = req.getParameter("l_describe");
        String l_type = req.getParameter("l_type");
        String phone = req.getParameter("phone");
        String pick_dateStr = req.getParameter("pick_date");
        String get_dateStr = req.getParameter("get_date");
        String state = req.getParameter("state");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-hh");
        try {
            Date pick_date = sdf.parse(pick_dateStr);
            Date get_date= sdf.parse(get_dateStr);
            if (doUpdType.equals("add")) {
                lostSQ.addLost(l_name,l_describe,l_type,phone,pick_date,get_date,state);
                req.getRequestDispatcher("lostList").forward(req, resp);
            } else if (doUpdType.equals("alter")) {
                String idStr = req.getParameter("lost_id");
                int id = Integer.parseInt(idStr);
                lostSQ.setLost(id,l_name,l_describe,l_type,phone,pick_date,get_date,state);
                req.getRequestDispatcher("lostList").forward(req, resp);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
