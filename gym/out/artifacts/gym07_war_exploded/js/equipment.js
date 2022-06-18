function equtPage(pagenoequt){
    window.location.href="equtList?pagenoequt="+pagenoequt;
}
function del_equt(equ_id) {
    if (confirm("是否确认删除?")){
        window.location.href = "UpdEqut?equt_id=" +equ_id+"&updType=delete";
    }
}
function alter_equt(equ_id){
    window.location.href="UpdEqut?equt_id="+equ_id+"&updType=alter";
}
function goodsPage(pagenogoods){
    window.location.href="goodsList?pagenogoods="+pagenogoods;
}
function del_goods(goods_id) {
    if (confirm("是否确认删除?")){
        window.location.href = "UpdGoods?goods_id=" +goods_id+"&updType=delete";
    }
}
function alter_goods(goods_id){
    window.location.href="UpdGoods?goods_id="+goods_id+"&updType=alter";
}
function lostPage(pagenolost){
    window.location.href="lostList?pagenolost="+pagenolost;
}
function del_lost(lost_id) {
    if (confirm("是否确认删除?")){
        window.location.href = "UpdLost?lost_id=" +lost_id+"&updType=delete";
    }
}
function alter_lost(lost_id){
    window.location.href="UpdLost?lost_id="+lost_id+"&updType=alter";
}
