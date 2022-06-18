package com.gymSQL.SQservice;

import com.gymSQL.DAO.impl.userDao;
import com.gymSQL.pojo.User;
import com.gymSQL.pojo.cardholder;

import java.util.Date;
import java.util.List;
public class Vipuser<T> {
    //查询整个vip_user表以集合的形式返回
    userDao userDao = new userDao();
    cardholder cardholder = new cardholder();

    public List<T> viplist(Integer pageno, String keyword) {//查询所有用户
        String sql = "select * from vip_user where id like ? or username like ? or vip_type like ? or login_limit like ? limit 9 offset ?";
        return userDao.queryMulti(sql, User.class, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", (pageno-1)*9);
    }

    public Object getAllVipUserCount(String keyword) {//查询总记录条数
        String sql = "select count(*) from vip_user where id like ? or username like ? or vip_type like ? or login_limit like ?";
        return userDao.queryScalar(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    public void Deluser(int user_id) {//删除用户
        String sql = "delete from vip_user where id=?";
        userDao.update(sql, user_id);
    }

    public User getVipUserById(Integer id) {//通过Id查询用户
        String sql = "select * from vip_user where id=?";
        return userDao.querySingleUser(sql, User.class, id);
    }

    //修改用户信息
    public void editVip_user(String username, String password, String email, Date reg_date, String vip_type, String login_limit, Integer id) {
        String sql = "update vip_user set username=?,password=?,email=?,reg_date=?,vip_type=?,login_limit=? where id=?";
        userDao.update(sql, username, password, email, reg_date, vip_type, login_limit, id);
    }

    public void addVipUser(String username, String password, String email, String login_limit) {//添加用户
        String sql = "insert into vip_user values(null,?,?,?,now(),'未办卡',?)";
        userDao.update(sql, username, password, email, login_limit);
    }

    public Object getAllCardholderCount(String keyword) {//查询总记录条数cardholder表
        String sql = "select count(*) from cardholder where card_id like ? or card_user like ? or phone like ? or card_state like ? or sex like ? ";
        return userDao.queryScalar(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    public List<cardholder> cardholderList(Integer pagenocard, String keyword1) {//查询cardholder表所有持卡用户
        String sql = "select * from cardholder where card_id like ? or card_user like ? or phone like ? or card_state like ? or sex like ?limit 9 offset ?";
        return userDao.queryMulti(sql, cardholder.class, "%" + keyword1 + "%", "%" + keyword1 + "%", "%" + keyword1 + "%", "%" + keyword1 + "%", "%" + keyword1 + "%",(pagenocard-1)*9);
    }

    //用来充值会员卡通过card_id查找用户
    public Object getCardholderById(Integer card_id) {
        String sql = "select * from cardholder where card_id=?";
        return userDao.querySingle(sql, cardholder.class, card_id);
    }

    public void addBalance(Integer card_id, Double balance) {
        String sql = "UPDATE cardholder SET balance=balance+? where card_id=?";
        userDao.update(sql, balance, card_id);
    }

    public void addExpire_date(Integer card_id, Integer expire_date) {
        String sql = "UPDATE cardholder SET expire_date=expire_date+? where card_id=?";
        userDao.update(sql, expire_date, card_id);
    }

    public cardholder getCardholderBalance(Integer card_id) {
        String sql = "select * from cardholder where card_id=?";
        return userDao.querySingleCardholder(sql, cardholder.class, card_id);
    }

    public void removeBalance(Integer card_id, Double balance) {
        String sql = "UPDATE cardholder SET balance=balance-? where card_id=?";
        userDao.update(sql, balance, card_id);
    }
    public User getVipUserByUsername(String username) {//通过Id查询用户
        String sql = "select * from vip_user where username=?";
        return userDao.querySingleUser(sql, User.class, username);
    }
    public cardholder  getCardholderByUsername(String card_user) {//通过会员名查询用户
        String sql = "select * from cardholder where card_user=?";
        return userDao.querySingleCardholder(sql, User.class, card_user);
    }
    public boolean queryUser(String username){//查询用户是否存在
        Object user_exist=userDao.queryScalar("SELECT * FROM vip_user WHERE username=?",username);
        return user_exist==null;
    }
    public Object getCardholderByName(String card_user) {//通过会员名查询用户
        String sql = "select * from cardholder where card_User=?";
        return userDao.querySingle(sql, cardholder.class,card_user);
    }
    public void addCardholder(
            String card_user,
            String sex,
            Integer age,
            String phone,
            Date birthday) {//添加办卡用户
        String sql = "insert into cardholder values(null,?,?,?,?,?,0,now(),0,'已过期')";
        userDao.update(sql,card_user,sex,age,phone,birthday);
    }
    public void setVip_user(String username) {//更改用户办卡状态
        String sql = "UPDATE vip_user SET vip_type='已办卡' where username=?";
        userDao.update(sql,username);
    }
    public Object getAllExpireCardCount() {//查询已过期持总记录条数cardholder表
        String sql = "select count(*) from cardholder where card_state='已过期'";
        return userDao.queryScalar(sql);
    }

    public List<cardholder> ExpireCardList(Integer pagenocard) {//查询cardholder表所有已过期持卡用户
            String sql = "select * from cardholder where card_state='已过期' limit 9 offset ?";
        return userDao.queryMulti(sql, cardholder.class, (pagenocard - 1) * 10);
    }
    public List<cardholder> ExpireCardList1() {//查询cardholder表所有持卡用户
        String sql = "select * from cardholder";
        return userDao.queryMulti(sql, cardholder.class);
    }
    public Integer ExpireCardList2() {//查询cardholder表所有持卡用户数量
        String sql = "select count(*) from cardholder";
        return userDao.querySingle(sql, cardholder.class);
    }
    public void setCard_state(String card_user) {//更改状态
        String sql = "UPDATE cardholder SET card_state='已过期' where card_user=?";
        userDao.update(sql, card_user);
    }
    public void setExpire_date(String card_user) {//更改剩余天数
        String sql = "UPDATE cardholder SET expire_date=0 where card_user=?";
        userDao.update(sql, card_user);
    }
    public void setExpire_date2(String card_user,Integer expire_date) {//更改剩余天数
        String sql = "UPDATE cardholder SET expire_date=? where card_user=?";
        userDao.update(sql, expire_date,card_user);
    }
    public void setExpireCard_state(Integer card_id) {//更改状态
        String sql = "UPDATE cardholder SET card_state='正常使用',card_date=now() where card_id=?";
        userDao.update(sql,card_id);
    }
    public List<cardholder> ExpireCardList() {//查询cardholder表所有持卡用户
        String sql = "select * from cardholder";
        return userDao.queryMulti(sql, cardholder.class);
    }

}