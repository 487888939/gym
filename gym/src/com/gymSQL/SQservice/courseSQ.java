package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.courseDAO;
import com.gymSQL.pojo.coach;
import com.gymSQL.pojo.course;
import com.gymSQL.pojo.notice;

import java.util.Date;
import java.util.List;

public class courseSQ {
    courseDAO courseDAO=new courseDAO();
    public List<course> getCourseList(Integer pageno, String keyword){
        String sql="select * from course where id like ? or course_name like ? or taught like ? or teach_time like ? or teach_space like ?limit 9 offset ?";
        List<course> list = courseDAO.queryMulti(sql, course.class,"%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%","%" + keyword + "%",(pageno-1)*9);
        return list;
    }
    public Object getCourseCount(String keyword){
        String sql="select count(*) from course where id like ? or course_name like ? or taught like ? or teach_time like ? or teach_space like ?";
        Object o = courseDAO.queryScalar(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%","%" + keyword + "%");
        return o;
    }
    public void delCourse(Integer id){
        String sql="delete from course where id=? ";
        courseDAO.update(sql,id);
    }
    public List<course> getCourseById(Integer id){
        String sql="select * from course where id=?";
        List<course> list = courseDAO.queryMulti(sql, course.class, id);
        return list;
    }
    public void setCourse(Integer id,String course_name,String course_price,String taught,
                          String teach_time,String teach_space,String course_state){
        String sql="update course set course_name=?,course_price=?,taught=?,teach_time=?,teach_space=?,course_state=? where id=?";
        courseDAO.update(sql,course_name,course_price,taught,teach_time,teach_space,course_state,id);
    }
    public void addCourse(String course_name,String course_price,String taught,
                          String teach_time,String teach_space,String course_state){
        String sql="insert into course values(null,?,?,?,?,?,?)";
        courseDAO.update(sql,course_name,course_price,taught,teach_time,teach_space,course_state);
    }
}
