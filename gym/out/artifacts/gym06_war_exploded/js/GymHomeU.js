$(function () {
    $("#vip_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a href='vipList' target='work_window'>查看信息</a></button>\n" +
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
            "                        <button><a>查看教练信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>修改教练信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>删除教练</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>增加教练</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#fitness_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a>查看课程信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>修改课程信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>删除课程</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>增加课程</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#kit_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                   <button><a>查看健身器材</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>修改器材信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>删除健身器材</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>增加健身器材</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
    $("#goods_tit").click(function () {
        $("#list_tab").replaceWith("<td id=\"list_tab\">\n" +
            "                    <ul>\n" +
            "                        <button><a>查看商品信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>修改商品信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>删除商品</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>增加商品</a></button>\n" +
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
            "                        <button><a>失物登记</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>遗留物品登记</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>删除登记信息</a></button>\n" +
            "                    </ul>\n" +
            "                    <ul>\n" +
            "                        <button><a>修改登记信息</a></button>\n" +
            "                    </ul>\n" +
            "                </td>")
    });
});