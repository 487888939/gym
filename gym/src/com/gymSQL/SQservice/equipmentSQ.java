package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.equipmentDAO;
import com.gymSQL.pojo.course;
import com.gymSQL.pojo.equipment;

import java.util.Date;
import java.util.List;

public class equipmentSQ {
    equipmentDAO equipmentDAO=new equipmentDAO();
    public List<equipment> getEqutList(Integer pageno, String keyword){
        String sql="select * from equipment where id like ? or equ_name like ? or account like ? or equ_state like ? limit 6 offset ?";
        List<equipment> list = equipmentDAO.queryMulti(sql, equipment.class,"%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%",(pageno-1)*6);
        return list;
    }
    public Object getEqutCount(String keyword){
        String sql="select count(*) from equipment where id like ? or equ_name like ? or account like ? or equ_state like ? ";
        Object o = equipmentDAO.queryScalar(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%","%" + keyword + "%");
        return o;
    }
    public void delEqut(Integer id){
        String sql="delete from equipment where id=? ";
        equipmentDAO.update(sql,id);
    }
    public List<equipment> getEqutById(Integer id){
        String sql="select * from equipment where id=?";
        List<equipment> list = equipmentDAO.queryMulti(sql, equipment.class, id);
        return list;
    }
    public void setEqut(Integer id, String equ_name,Integer account, Double purchase, String merchant,
                        Date buy_time, String equ_state){
        String sql="update equipment set equ_name=?,account=?,purchase=?,merchant=?,buy_time=?,equ_state=? where id=?";
        equipmentDAO.update(sql,equ_name,account,purchase,merchant,buy_time,equ_state,id);
    }
    public void addEqut(String equ_name,Integer account, Double purchase, String merchant,
                        Date buy_time, String equ_state){
        String sql="insert into equipment values(null,?,?,?,?,?,?)";
        equipmentDAO.update(sql,equ_name,account,purchase,merchant,buy_time,equ_state);
    }
}
