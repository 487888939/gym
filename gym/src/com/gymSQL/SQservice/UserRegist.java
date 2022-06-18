package com.gymSQL.SQservice;
import com.gymSQL.DAO.impl.userDao;

public class UserRegist<T>{
    com.gymSQL.DAO.impl.userDao userDao=new userDao();
    public boolean registUser(String username,String password,String email){
        int update = userDao.update("insert into vip_user values(null,?,?,?,now(),'未办卡','允许登录')", username, password, email);//加入失败返回-1,成功返回1
        return update>=1;
    }
}
