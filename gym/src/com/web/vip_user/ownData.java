package com.web.vip_user;

import com.MySpringmvc.ViewBaseServlet;
import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.pojo.User;
import com.gymSQL.pojo.cardholder;

import java.util.List;

public class ownData extends ViewBaseServlet {

    public void getOwnData(int id){
        Vipuser Vipuser=new Vipuser();
        User vipUserById = Vipuser.getVipUserById(id);

    }
}
