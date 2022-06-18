package com.web.coach;

import com.gymSQL.SQservice.coachSQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/doAlterCoach")
public class doAlterCoach extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("coach_id");
        int id = Integer.parseInt(idStr);
        String coach_name = req.getParameter("coach_name");
        String sex = req.getParameter("sex");
        String coach_ageStr = req.getParameter("coach_age");
        int coach_age=Integer.parseInt(coach_ageStr);
        String coach_phone = req.getParameter("coach_phone");
        String pre_address = req.getParameter("pre_address");
        String coach_state = req.getParameter("coach_state");
        String teaching_ageStr = req.getParameter("teaching_age");
        int teaching_age= Integer.parseInt(teaching_ageStr);
        String salaryStr = req.getParameter("salary");
        Double salary= Double.valueOf(salaryStr.toString());
        String hire_dateStr = req.getParameter("hire_date");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date hire_date = sdf.parse(hire_dateStr);
            coachSQ coachSQ=new coachSQ();
            coachSQ.setCoachById(id,coach_name,sex,coach_age,coach_phone,pre_address,hire_date,coach_state,teaching_age,salary);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("coachList").forward(req,resp);
    }
}
