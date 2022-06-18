function coursePage(pagenocourse){
    window.location.href="getCourseList?pagenocourse="+pagenocourse;
}
function del_course(course_id) {
    if (confirm("是否确认删除?")) {
        window.location.href = "UpdCourse?course_id=" + course_id+"&updType=delete";
    }
}
function alter_course(course_id){
    window.location.href="UpdCourse?course_id="+course_id+"&updType=alter";
}

