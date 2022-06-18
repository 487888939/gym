function delVip_user(id){
    if (confirm("是否确认删除?")){
        window.location.href="vipListUpd?id="+id;
    }
}
function page(pageno){
    window.location.href="vipList?pageno="+pageno;
}
function getEditVip_user(id){
    window.location.href="getEditVipList?id="+id;
}
function cardPage(pagenocard){
    window.location.href="cardholderList?pagenocard="+pagenocard;
}
function recharge_card(card_id){
    window.location.href="OvtAndRec?card_id="+card_id+"&addType=recharge";
}
function overtime_card(card_id){
    window.location.href="OvtAndRec?card_id="+card_id+"&addType=overtime";
}
function expireCard(pagenocard2){
    window.location.href="expireCard?pagenocard2="+pagenocard2;
}
function doSetCard(card_id){
    window.location.href="doSetCard?card_id="+card_id;
}