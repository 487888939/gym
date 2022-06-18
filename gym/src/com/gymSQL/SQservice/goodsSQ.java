package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.goodsDAO;
import com.gymSQL.pojo.equipment;
import com.gymSQL.pojo.goods;

import java.util.Date;
import java.util.List;

public class goodsSQ {
    goodsDAO goodsDAO=new goodsDAO();
    public List<goods> getGoodsList(Integer pageno, String keyword){
        String sql="select * from goods where id like ? or g_name like ? or g_brand like ? limit 6 offset ?";
        List<goods> list =goodsDAO.queryMulti(sql,goods.class,"%" + keyword + "%","%" + keyword + "%","%" + keyword + "%",(pageno-1)*6);
        return list;
    }
    public Object getGoodsCount(String keyword){
        String sql="select count(*) from goods where id like ? or g_name like ? or g_brand like ?";
        Object o = goodsDAO.queryScalar(sql, "%" + keyword + "%",  "%" + keyword + "%","%" + keyword + "%");
        return o;
    }
    public void delGoods(Integer id){
        String sql="delete from goods where id=? ";
        goodsDAO.update(sql,id);
    }
    public List<goods> getGoodsById(Integer id){
        String sql="select * from goods where id=?";
        List<goods> list =goodsDAO.queryMulti(sql, goods.class, id);
        return list;
    }
    public void setGoods(Integer id, String g_name, Integer g_account, Double g_price, String g_brand){
        String sql="update goods set g_name=?,g_account=?,g_price=?,g_brand=? where id=?";
        goodsDAO.update(sql,g_name,g_account,g_price,g_brand,id);
    }
    public void addGoods(String g_name, Integer g_account, Double g_price, String g_brand){
        String sql="insert into goods values(null,?,?,?,?)";
        goodsDAO.update(sql,g_name,g_account,g_price,g_brand);
    }
}
