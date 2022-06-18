package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.card_typeDao;
import com.gymSQL.pojo.card_type;

import java.util.List;

public class card_typeSQ<T>{
    card_typeDao card_typeDao=new card_typeDao();
    public card_type getCard_type(String card_name){
        String sql="select * from card_type where card_name=?";
        return card_typeDao.querySinglecard_type(sql,card_type.class,card_name);
    }
    public void setCard_type(String card_name,Double card_price,Integer indate,Double discount,Integer card_id){//更改卡的价格
        String sql="UPDATE card_type SET card_name=?,card_price=?,indate=?,discount=? where card_id=?";
        card_typeDao.update(sql,card_name,card_price,indate,discount,card_id);
    }
    public List<card_type> getAllCard_type(){
        String sql="select * from card_type";
        return card_typeDao.queryMulti(sql,card_type.class);
    }
    public card_type getCard_typeById(Integer card_id){
        String sql="select * from card_type where card_id=?";
       return card_typeDao.querySinglecard_type(sql,card_type.class,card_id);
    }
    public void addCard_type(String card_name,Double card_price,Integer indate,Double discount ){
        String sql="insert into card_type values(null,?,?,?,?)";
        card_typeDao.update(sql,card_name,card_price,indate,discount);
    }
}
