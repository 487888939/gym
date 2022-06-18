$(function () {
    $("#vip_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='vipList' target='work_window'>查看会员信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='cardholderList' target='work_window'>持卡用户信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='static/queryCustomer.html' target='work_window'>会员卡充值</a></button>\n" +
            "                    </ul>\n"+
            "                    <ul>\n" +
            "                        <button><a href='static/applyCard.html' target='work_window'>会员卡办理</a></button>\n" +
            "                    </ul>\n"+
            "                    <ul>\n" +
            "                        <button><a href='setCard' target='work_window'>会员卡管理</a></button>\n" +
            "                    </ul>\n"+
            "                </td>")
    });
    $("#coach_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='coachList' target='work_window'>查看教练信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='getCoachLogin' target='work_window'>修改登录信息</a></button>\n"+
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='static/coach/addCoachLogin.html' target='work_window'>增加登录账号</a></button>\n"+
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='static/coach/addCoach.html' target='work_window'>增加教练</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#fitness_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='getCourseList' target='work_window'>查看课程信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='static/course/addCourse.html' target='work_window'>增加课程</a></button>\n"+
            "                    </ul>\n" +
            "                </td>")
    });
    $("#kit_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                   <button><a href='equtList' target='work_window'>查看健身器材</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='static/equipment/addEqut.html' target='work_window'>增加健身器材</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#goods_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='goodsList'  target='work_window'>查看商品信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='static/goods/addGoods.html' target='work_window'>增加商品</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#statistic_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a>收入统计</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>会员注册统计</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>商品销售统计</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#lose_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='lostList' target='work_window'>失物登记信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n"+
            "                        <button><a href='static/lost/addLost.html' target='work_window'>失物登记</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
        "                        <button><a href='static/notice/addNotice.html'  target='work_window'>发布失物公示</a></button>\n" +
        "                    </ul>\n" +
            "                </td>")
    });
});
function setNotice(notice_id){
    window.location.href="updateNotice?id="+notice_id;
}


