layui.use("layer",function () {
$(document).ready(function(){
    //前台登录
    $("#login-button").on('click',function () {
        var userid = $("#login-student-id").val();
        var password = $("#login-pasw").val();
        if(userid == "" || userid == null){
            alert("请输入用户名")
        }else {
            if (password == "" || password == null) {
                alert("请输入密码")
            }else{
                $.ajax({
                    url:"stulogin.action",
                    method:"get",
                    async:false,
                    data:{
                        sid:userid,
                        password:password
                    },
                    success:function (data) {
                        if(data!="null"){
                            window.location.href = "index.html";
                        }else {
                            layer.alert("用户名或密码错误")
                        }
                    }
                })
            }
        }
    })
    //后台登录
    $("#admin-login").on('click',function () {
        var admin = $("#backmanlogin-student-id").val();
        var password = $("#backmanlogin-pasw").val();
        if(admin == "" || admin == null){
            alert("请输入用户名")
        }else {
            if (password == "" || password == null) {
                alert("请输入密码")
            }else{
                $.ajax({
                    url:"adminlogin.action",
                    method:"get",
                    async:false,
                    data:{
                        admin:admin,
                        adminpwd:password
                    },
                    success:function (data) {
                        if(data!="null"){
                            window.location.href = "manage-false.html";
                        }else {
                            layer.alert("用户名或密码错误")
                        }
                    }
                })
            }
        }
    })
});
});