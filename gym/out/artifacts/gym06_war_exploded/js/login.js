function f1() {
    //验证用户名是否合法
    //验证密码是否合法
    var username = document.getElementsByName("username")[0].value;
    var span_username = document.getElementById("test_username");
    var patt_username=/[a-zA-Z0-9_\u4e00-\u9fa5]{3,6}/;
    if (!patt_username.test(username)){
        span_username.innerHTML="用户名不合法";
        return false;
    }else{
        span_username.innerHTML="";
        return true;
    }
}
function f2() {
    var password = document.getElementsByName("password")[0].value;
    var span_password = document.getElementById("test_password");
    var patt_password = /^[a-zA-Z]\w{4,10}$/;
    if (!patt_password.test(password)) {
        span_password.innerHTML = "密码不合法"
        return false;
    } else {
        span_password.innerHTML = ""
        return true;
    }
}