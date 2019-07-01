//检测是否已经登录
$(document).ready(function () {
     $.ajax({
        url:"checkLogin.action",
        method:"GET",
        async:false,
        success:function (data) {
            if(data.data == "???"){
                location.href = "backman-login.html";
            }else{
                $("#useradmin").text=data;
            }
        }
    })
})

layui.use('table',function () {
    var table = layui.table;
    table.render({
        elem:'#faileInfo',
        size:"sm",
        skin:'none',
        loading:true,
        url:'AcvationFailList.action',
        height:550,
        toolbar:"default",
        request:{
            pageName:'currPage',
            limitName:'pageSize'
        },
        response:{
            statusCode:200
        },
        page:{
            theme:'#5C9EFF',
            limit:10,
            limits:[10,20,50,100],
        },  group:4,
        parseData:function(res){
          return{
              "code": res.code, //解析接口状态
              "msg": res.msg, //解析提示文本
              "count": res.count, //解析数据长度
              "data": res.data //解析数据列表
          }
        },
        cols:[[
            {field:'cId',title:"序号",width:100,sort:true},
            {field:'cIdcard',title:'学号',width:150,sort:true},
            {field:'cName',title:'姓名',width:100},
            {field:'cSex',title:'性别',width:100},
            {field:'cStatus',title:'审核状态',width:100},
            {field:'message',title:'详情',width:100,toolbar:'#xiangqing'}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
        tableList = res.data;
        $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    });
    table.on('tool(test)',function (obj) {
        if(obj.event==="detail") {
            var row = obj.data;
            $.ajax({
                url:"AcvationFailInfo.action",
                metod:"get",
                async:false,
                ContentType:"application/json;charset=UTF-8",
                data:{
                    checkId:row.cId
                },
                dataType:'json',
                success:function (data) {
                    var obj = data.data;
                    var str = "<center>详情</center><br>学号："+obj.cSid+"<br>姓名："+obj.cName+
                        "<br>性别："+obj.cSex+"<br>院系："+obj.cDepartment+"<br>专业："+obj.cMajor+
                        "<br>年级："+obj.cGrade+"<br>班级："+obj.cClass+"<br>申请状态："+obj.cStatus+
                        "<br>原因："+obj.cReason+"<br><img src='"+obj.cPhoto+"'>";
                    // layer.alert(str);
                    layer.open({
                        type:1,
                        title:false,
                        content:str,
                        btn:["通过","不通过","关闭"],
                        btn1:function () {
                            $.ajax({
                                url:"PassAcvationFailInfo.action",
                                method:"GET",
                                async:false,
                                data:{
                                    cId:row.cId,
                                    sid:obj.cSid,
                                    name:obj.cName,
                                    sex:obj.cSex,
                                    department:obj.cDepartment,
                                    major:obj.cMajor,
                                    grade:obj.cGrade,
                                    classnumber:obj.cClass,
                                    idcard:obj.cIdcard,
                                    msg:"",
                                    id:1
                                },
                                success:function (data) {
                                    layer.open({
                                        type:1,
                                        content:data.data,
                                        btn:["确认"],
                                        btn1:function () {
                                            layer.closeAll();
                                        }
                                    })
                                }
                            })
                        },
                        btn2:function () {
                            layer.open({
                                type:0,
                                content:"<input type=\"text\" id=\"shenhe\" autocomplete=\"off\" class=\"layui-input\">",
                                btn:["确认"],
                                btn1:function () {
                                    var id = row.cId;
                                    var s = $("#shenhe").val();
                                    $.ajax({
                                        url:"RefuseAcvationFailInfo.action",
                                        method:"GET",
                                        async:false,
                                        data:{
                                            cId:id,
                                            cReason:s
                                        },
                                        success:function (data) {
                                            layer.open({
                                                type:0,
                                                content:data.data,
                                                btn:["确定"],
                                                btn1:function () {
                                                   layer.closeAll();
                                                   location.href = "manage-false.html";
                                                }
                                            })
                                        }
                                    })
                                }
                            })
                        }
                    })
                }
            })
        }
    })
})


