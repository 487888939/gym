package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.coach_loginDAO;
import com.gymSQL.DAO.impl.managerDAO;
import com.gymSQL.pojo.manager;

import java.net.InetAddress;

public class managerSQ<T>{
    managerDAO managerDAO=new managerDAO();
    public boolean man_login(String m_name,String password){
        String sql="select * from manager where m_name=? and password=? and state='正常'";
        Object o =managerDAO.queryScalar(sql,m_name, password);
        return o!=null;
    }
}
