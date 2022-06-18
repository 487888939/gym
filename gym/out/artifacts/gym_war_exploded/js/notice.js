
function del_notice(notice_id){
    if (confirm("是否确认删除?")){
        window.location.href="doUpdate?notice_id="+notice_id+"&upType=delete";
    }

}
function upd_notice(notice_id) {
    window.location.href = "doUpdate?notice_id=" +notice_id + "&upType=alter";
}
    function rel_notice(notice_id){
        window.location.href="doUpdate?notice_id="+notice_id+"&upType=release";
    }