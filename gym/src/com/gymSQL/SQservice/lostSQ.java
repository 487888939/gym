package com.gymSQL.SQservice;
import com.gymSQL.DAO.impl.lostDAO;
import com.gymSQL.pojo.goods;
import com.gymSQL.pojo.lost;

import java.util.Date;
import java.util.List;

public class lostSQ {
    lostDAO lostDAO=new lostDAO();
    public List<lost> getLostList(Integer pageno, String keyword){
        String sql="select * from lost where id like ? or l_name like ? or l_type like ?  or phone like ? or state like ? limit 6 offset ?";
        List<lost> list = lostDAO.queryMulti(sql,lost.class,"%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%",(pageno-1)*6);
        return list;
    }
    public Object getLostCount(String keyword){
        String sql="select count(*) from lost where id like ? or l_name like ? or l_type like ?  or phone like ? or state like ? ";
        Object o = lostDAO.queryScalar(sql, "%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%");
        return o;
    }
    public void delLost(Integer id){
        String sql="delete from lost where id=? ";
        lostDAO.update(sql,id);
    }
    public List<lost> getLostById(Integer id){
        String sql="select * from lost where id=?";
        List<lost> list =lostDAO.queryMulti(sql,lost.class, id);
        return list;
    }
    public void setLost(Integer id, String l_name, String l_describe, String l_type,
                        String phone, Date pick_date,Date get_date,String state){
        String sql="update lost set l_name=?,l_describe=?,l_type=?,phone=?, pick_date=? ,get_date=?,state=? where id=?";
        lostDAO.update(sql,l_name,l_describe,l_type,phone,pick_date,get_date,state,id);
    }
    public void addLost(String l_name, String l_describe, String l_type,
                        String phone, Date pick_date,Date get_date,String state){
        String sql="insert into lost values(null,?,?,?,?,?,?,?)";
        lostDAO.update(sql,l_name,l_describe,l_type,phone,pick_date,get_date,state);
    }
}
