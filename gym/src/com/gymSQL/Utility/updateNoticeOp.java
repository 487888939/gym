package com.gymSQL.Utility;

import com.gymSQL.SQservice.noticeSQ;
import com.gymSQL.pojo.notice;

public class updateNoticeOp {
    public notice getNoticeCot(){
        com.gymSQL.SQservice.noticeSQ noticeSQ=new noticeSQ();
        notice noticeCot = noticeSQ.getNotice();//拿到公告栏内容
        return noticeCot;
 }
}
