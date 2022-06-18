package com.gymSQL.DAO;

import com.gymSQL.Utility.JdbcUtils;
import com.gymSQL.pojo.User;
import com.gymSQL.pojo.card_type;
import com.gymSQL.pojo.cardholder;
import com.gymSQL.pojo.notice;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao<T> {
    private QueryRunner qr=new QueryRunner();
    public int update(String sql,Object... parameters){
        Connection connection=null;
        try {
            connection = JdbcUtils.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
        //返回多个对象
    }
    //返回多行
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameter){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanListHandler<>(clazz),parameter);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    //返回单行
    public T querySingle(String sql, Class<T> clazz, Object... parameter){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameter);//单行
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    //查询单行单列的方法,即返回单值的方法
    public Object queryScalar(String sql,Object... paratmeter){
        Connection connection=null;
        try {
            connection = JdbcUtils.getConnection();
            return qr.query(connection,sql,new ScalarHandler(),paratmeter);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    public User querySingleUser(String sql, Class<User> clazz, Object... parameter){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanHandler<User>(clazz),parameter);//单行
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    public card_type querySinglecard_type(String sql, Class<card_type> clazz, Object... parameter){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanHandler<card_type>(clazz),parameter);//单行
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    public cardholder querySingleCardholder(String sql, Class<cardholder> clazz, Object... parameter){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanHandler<cardholder>(clazz),parameter);//单行
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    public List<T> queryMultiCardholder(String sql, Class<T> clazz){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanListHandler<>(clazz));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    public Integer querySingle(String sql, Class<Integer> clazz){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanHandler<Integer>(clazz));//单行
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
    public notice getNoticeSingle(String sql, Class<notice> clazz, Object... parameter){
        Connection connection=null;
        try {
            connection =JdbcUtils.getConnection();
            return qr.query(connection,sql,new BeanHandler<notice>(clazz),parameter);//单行
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JdbcUtils.close(null,null,connection);
        }
    }
}
