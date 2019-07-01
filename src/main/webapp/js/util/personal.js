layui.use("layer",function () {
$(document).ready(function () {
    var stu_id = null;
    var flag = false; //记录是否有账号登录
    $.ajax({
        url:"getLoginInfo.action",
        method:"GET",
        async:false,
        success:function (data) {
            if(data === null || data.data === "未登录"){
               layer.open({
                   content:'<br><center>请进行登录</center>',
                   btn1:function () {
                       location.href = "index.html";
                   }
               })
            }else {
                flag = true;
                $("#loginUser").text(data.name);
                $("#stu_idLabel").text(data.sid);
                stu_id = data.sid;
            }
        }
    })
    //如果为真，说明已经登录，正常显示页面
    if(flag) {
        $.ajax({
            url: "FindUser.action",
            method: "GET",
            async: false,
            data: {
                condition: "学号",
                context: stu_id,
                currPage: 1,
                pageSize: 1
            },
            success: function (data1) {
                    if (data1 != "null") {
                        var sex = data1.sex;
                        $("#stu_id").val(data1.sid);
                        if(sex == "男") {
                            $('input[name="sex"][value="男"]').attr("checked", "checked");
                            $("#img").attr("src","images/manager.png")
                        }
                        if(sex == "女"){
                            $('input[name="sex"][value="女"]').attr("checked", "checked");
                            $("#img").attr("src","images/me.png")
                        }
                        if (data1.phone != "") {
                            $("#phone").val(data1.phone);
                        }
                        if (data1.email != null) {
                            $("#email").val(data1.email);
                        }
                        $("#Id_number").val(data1.idcard);
                        $("#department").val(data1.department);
                        $("#grade").val(data1.major + data1.grade + "-" + data1.classnumber);
                        $("#stu_name").val(data1.name);
                    }
            }
        })
    }
    //修改密码的提交按钮功能
    $("#submit_but").click(function () {
        newpwd1 = $("#new_pwd").val();
        newpwd2 = $("#new_pwd2").val();
        if(newpwd1 == newpwd2) {
            oldpwd = $("#old_pwd").val();
            newpwd = $("#new_pwd").val();
            $.ajax({
                url: "resetPwd.action",
                method: "GET",
                async: false,
                data: {
                    sid: stu_id,
                    oldPwd:oldpwd,
                    newpwd: newpwd
                },
                success: function (data) {
                    if (data.data == "1") {
                        $.ajax({
                            url:"exitLogin.action",
                            method:"POST",
                            async:false,
                            success:function (data) {
                                layer.open({
                                    content:'<br>修改成功，请重新登录',
                                    btn1:function () {
                                        location.href = "login.html";
                                    }
                                });
                            },
                            error:function (data) {
                                layer.alert("退出失败");
                            }
                        })
                    } else {
                        layer.alert("修改失败!");
                    }
                },
                error: function (data) {
                    layer.alert("修改失败");
                }
            })
        }else{
            layer.alert("密码不匹配！")
        }
    })
})

})
function check() {
    userid = document.getElementById("stu_idLabel").innerText;
    password = document.getElementById("old_pwd").value;
    $.ajax({
        url:"stulogin2.action",
        method:"get",
        async:true,
        data:{
            sid:userid,
            password:password
        },
        success:function (data) {
            if(data == true){
                document.getElementById("msg1").style.display = 'inline';
                document.getElementById("msg2").style.display = 'none';
            }else {
                document.getElementById("msg1").style.display = 'none';
                document.getElementById("msg2").style.display = 'inline';
            }
        }
    });
}
function check2() {
    newpwd1 = document.getElementById("new_pwd").value;
    newpwd2 = document.getElementById("new_pwd2").value;
    if(newpwd1 == newpwd2){
        document.getElementById("msg3").style.display = 'inline';
        document.getElementById("msg4").style.display = 'none';
    }else{
        document.getElementById("msg3").style.display = 'none';
        document.getElementById("msg4").style.display = 'inline';
    }
}
