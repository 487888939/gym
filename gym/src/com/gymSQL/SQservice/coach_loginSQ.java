package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.coach_loginDAO;

public class coach_loginSQ<T> {
    com.gymSQL.DAO.impl.coach_loginDAO coach_loginDAO= new coach_loginDAO();
    public boolean coach_login(String coa_name,String password){
        String sql="select * from coach_login where coa_name=? and password=? and state='正常'";
        Object o = coach_loginDAO.queryScalar(sql, coa_name, password);
        return o!=null;
    }
    public void alterCoach_login(Integer id,String coa_name,String password,String state){
        String sql="update coach_login set coa_name=?,password=?,state=? where id=?";
        coach_loginDAO.update(sql,coa_name,password,state,id);
    }
    public void addCoachLogin(String coa_name,String pssword,String state){
        String sql="insert into coach_login values(null,?,?,?)";
        coach_loginDAO.update(sql,coa_name,pssword,state);
    }
}
