$(function () {
    $("#vip_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='vipList' target='work_window'>查看个人信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='cardholderList' target='work_window'>修改个人信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='static/queryCustomer.html' target='work_window'>会员卡办理</a></button>\n" +
            "                    </ul>\n"+
            "                    <ul>\n" +
            "                        <button><a href='static/applyCard.html' target='work_window'>我的预约</a></button>\n" +
            "                    </ul>\n"+
            "                    <ul>\n" +
            "                        <button><a href='setCard' target='work_window'>修改登录信息</a></button>\n" +
            "                    </ul>\n"+
            "                </td>")
    });
    $("#coach_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='coachList' target='work_window'>查看教练信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a href='getCoachLogin' target='work_window'>教练预约</a></button>\n"+
            "                </td>")
    });
    $("#fitness_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='getCourseList' target='work_window'>查看课程信息</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#kit_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                   <button><a href='equtList' target='work_window'>查看健身器材</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#goods_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='goodsList'  target='work_window'>查看商品信息</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#lose_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='lostList' target='work_window'>查看登记信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n"+
            "                        <button><a href='static/lost/addLost.html' target='work_window'>失物登记</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n"+
            "                        <button><a href='static/lost/addLost.html' target='work_window'>我的登记</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
});
function setNotice(notice_id){
    window.location.href="updateNotice?id="+notice_id;
}


