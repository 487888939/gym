function coachPage(pagenocoach){
    window.location.href="coachList?pagenocoach="+pagenocoach;
}
function del_coach(coach_id) {
    if (confirm("是否确认删除?")) {
        window.location.href = "delCoach?coach_id=" + coach_id;
    }
}
function alter_coach(coach_id){
    window.location.href="alterCoach?coach_id="+coach_id;
}
function del_coachLogin(login_id) {
    if (confirm("是否确认删除?")) {
        window.location.href = "alterCoachLogin?login_id=" + login_id+"&alterType=delete";
    }
}
function alter_coachLogin(login_id){
    window.location.href="alterCoachLogin?login_id="+login_id+"&alterType=alter";
}

