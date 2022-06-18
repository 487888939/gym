package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.userDao;

public class Userlogin<T> {
    userDao userDao = new userDao();
    public boolean queryUser(String username,String password){

        Object userlogin=userDao.queryScalar("SELECT * FROM vip_user WHERE username=? AND PASSWORD=? AND login_limit='允许登录'", username, password);
        return userlogin!=null;
    }
}
