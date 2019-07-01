layui.use("layer",function () {
$(document).ready(function () {
    $("#register").on('click',function () {
        var stuid = $("#student-id").val();
        var stuname = $("#yourname").val();
        var password = $("#paws").val();
        var department = $("#department").val();
        var major = $("#major").val();
        var grade = $("#grade").val();
        var stu_class = $("#class").val();
        var idCard = $("#idCard").val();
        var sex = $('input[name="sex"]:checked').val();
        alert(stuid+stuname+password+department+major+grade+stu_class+idCard+sex)
        $.ajax({
            url:"register.action",
            method:"get",
            async:false,
            dataType:'json',
            data:{
                sid:stuid,
                password:password,
                name:stuname,
                sex:sex,
                department:department,
                major:major,
                grade:grade,
                idcard:idCard,
                classnumber:stu_class
            },
            success:function (data) {
                if(data === 1){
                    layer.alert("激活成功！");
                }else{
                    layer.alert("激活失败！")
                }
            }
        })
    })

    $("#reset").on('click',function () {
        window.location.href="register-one.html";
    })
})

})