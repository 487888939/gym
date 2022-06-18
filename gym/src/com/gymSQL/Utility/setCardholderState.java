package com.gymSQL.Utility;

import com.gymSQL.SQservice.Vipuser;
import com.gymSQL.pojo.cardholder;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class setCardholderState {
    Vipuser vipuser = new Vipuser();
    @Test
    public void setCardState() throws ParseException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String TimeStr = sdf.format(now);//得到当前时间的字符串
        Date Time = sdf.parse(TimeStr);//将字符串转为日期
        List<cardholder> list = vipuser.ExpireCardList();
        for (int i = 0; i < list.size(); i++) {
            cardholder cardholder = list.get(i);//得到第I个集合对象
            Date card_date = cardholder.getCard_date();//得到办卡日期
            Integer expire_date = cardholder.getExpire_date();//得到卡上天数
            long l = Time.getTime() - card_date.getTime();//得到两个时间差(毫秒)
            long l2 = l / (1000 * 60 * 60 * 24);//毫秒转为天数,超过三年的毫秒会损失一位
            Integer l3 = (int) l2;//将long类型转为int类型
            int l4=expire_date-l3;//得到新的剩余时间
            String card_user = cardholder.getCard_user();//得到用户名
            if (l4<=0) {//如果时间差小于等于0,就将cardholder表中的剩余天数改为0,并且将card_state改为已过期
                vipuser.setCard_state(card_user);//更改card_state为已过期
                vipuser.setExpire_date(card_user);//跟该天数为0
            } else {//如果时间差不小于等于0,就将剩余天数改为该天数
                vipuser.setExpire_date2(card_user,l4);
            }
        }

    }
}
