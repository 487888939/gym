package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.noticeDAO;
import com.gymSQL.pojo.coach_login;
import com.gymSQL.pojo.notice;
import org.omg.CORBA.StringHolder;

import java.util.Date;
import java.util.List;


public class noticeSQ {
    noticeDAO noticeDAO=new noticeDAO();
    public notice getNotice(){
        String sql="select * from notice where state='正在公示'";
        notice notice= noticeDAO.getNoticeSingle(sql, notice.class);
        return  notice;
    }
    public List<notice> getNoticeCon(){
        String sql="select * from notice";
        List noticeList = noticeDAO.queryMulti(sql, notice.class);
        return noticeList;
    }
    public void setNoticeContent(Integer id,String content){
        String sql="update notice set content=? where id=?";
        noticeDAO.update(sql,id,content);
    }
    public void doSetNotice(Integer id,String release_name, Date release_date,String type,String content){
        String sql="update notice set release_name=?,release_date=?,type=?,release_content=? ,change_date=now() where id=?";
        noticeDAO.update(sql,release_name,release_date,type,content,id);
    }
    public void delNotice(Integer id){
        String sql="delete from notice where id=? ";
        noticeDAO.update(sql,id);
    }
    public notice getNotice(Integer id){
        String sql="select * from notice where id=?";
        notice notice= noticeDAO.getNoticeSingle(sql, notice.class,id);
        return  notice;
    }
    public boolean setNoticeState(){
        String sql="update notice set state='未公示' where state='正在公示'";
        int update = noticeDAO.update(sql);
        return update>=1;
    }
    public void setNoticeState1(Integer id){
        String sql1="update notice set state='正在公示' where id=?";
        noticeDAO.update(sql1,id);
    }
    public void addNotice(String release_name,String state,String type,Date release_date,String release_content){
        String sql="insert into notice values(null,?,?,?,?,?,null)";
        noticeDAO.update(sql, state, type, release_date, release_name, release_content);
    }

}
