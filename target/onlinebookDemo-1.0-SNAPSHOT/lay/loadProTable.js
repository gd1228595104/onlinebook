layui.use('table',function () {
    var table = layui.table;
    table.render({
        elem:'#problemTable',
        size:"sm",
        skin:'none',
        loading:true,
        height:550,
        url:'ProblemList.action',
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
            // {field:'aid',title:'序号',width:100,sort:true},
            {field:'sid',title:'投诉人学号',width:150,sort:true},
            {field:'asid',title:'被投诉人学号',width:150,sort:true},
            {field:'content',title:'投诉内容',width:100},
            {field:'astatus',title:'状态',width:100},
            {field:'message',title:'审核',width:100,toolbar:'#control'}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    });
    table.on('tool(test)',function (obj) {
        if(obj.event==="update"){
            layer.open({
                type:1,
                title:false,
                content:'<br><center><div>确认通过审核?</div></center>',
                btn:['确认','取消'],
                btn1:function () {
                    layer.closeAll();
                    var param = obj.data;
                    if(param.astatus==="已审核"){
                        layer.alert("已通过审核，无需再次审核！")
                    }else {
                        $.ajax({
                            url: "CheckProblem.action",
                            method: "get",
                            async: false,
                            data: {
                                aid: param.aid
                            },
                            dataType: 'json',
                            success: function (data) {
                                var res = data.data;
                                layer.alert(res);
                                table.reload('problemTable', {
                                    url: 'ProblemList.action'
                                })
                            }
                        })
                    }
                },
                btn2:function () {
                    layer.closeAll();
                }
            })

        }
    })

})