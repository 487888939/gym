package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.coachDAO;
import com.gymSQL.pojo.coach;
import com.gymSQL.pojo.coach_login;

import java.util.Date;
import java.util.List;

public class coachSQ {
    coachDAO coachDAO=new coachDAO();
    public List<coach> getCoachList(Integer pageno, String keyword){
        String sql="select * from coach where id like ? or coach_name like ? or coach_phone like ? or coach_sex like ? limit 9 offset ?";
        List<coach> list = coachDAO.queryMulti(sql, coach.class,"%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%",(pageno-1)*9);
        return list;
    }
    public Object getCoachCount(String keyword){
        String sql="select count(*) from coach where id like ? or coach_name like ? or coach_phone like ? or coach_sex like ?";
        Object o = coachDAO.queryScalar(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
        return o;
    }
    public void delCoach(Integer id){
        String sql="delete from coach where id=?";
        coachDAO.update(sql, id);
    }
    public List<coach> getCoachById(Integer id){
        String sql="select * from coach where id=?";
        List<coach> list = coachDAO.queryMulti(sql, coach.class, id);
        return list;
    }
    public void setCoachById(Integer id, String coach_name, String coach_sex, Integer coach_age,
                             String coach_phone, String pre_address, Date hire_date,String coach_state,Integer teaching_age,Double salary){
        String sql="update coach set coach_name=?,coach_sex=?,coach_age=?,coach_phone=?," +
                "pre_address=?,hire_date=?,coach_state=?,teaching_age=?,salary=? where id=?";
        coachDAO.update(sql,coach_name,coach_sex,coach_age,coach_phone,pre_address,hire_date,coach_state,teaching_age,salary,id);
    }
    public void addCoach(String coach_name, String coach_sex, Integer coach_age,
                         String coach_phone, String pre_address, Date hire_date,String coach_state,Integer teaching_age,Double salary){
        String sql="insert into coach values(null,?,?,?,?,?,?,?,?,?)";
        coachDAO.update(sql,coach_name,coach_sex,coach_age,coach_phone,pre_address,hire_date,coach_state,teaching_age,salary);
    }
    public List<coach_login> getCoachLogin(){
        String sql="select * from coach_login";
        List<coach_login> list = coachDAO.queryMulti(sql, coach_login.class);
        return list;
    }
    public void delCoachLogin(Integer id){
        String sql="delete from coach_login where id=?";
        coachDAO.update(sql, id);
    }
    public List<coach_login> getCoachLoginByID(Integer id){
        String sql="select * from coach_login where id=?";
        List<coach_login> list = coachDAO.queryMulti(sql, coach_login.class,id);
        return list;
    }
}
