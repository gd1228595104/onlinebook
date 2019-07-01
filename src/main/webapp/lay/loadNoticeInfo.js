layui.use('table',function () {
    var table = layui.table;
    table.render({
        elem:'#noticeInfo',
        size:"sm",
        skin:'none',
        loading:true,
        url:'AnnoList.action',
        toolbar:"default",
        height:550,
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
            {field:'nid',title:"序号",width:80},
            {field:'annotime',title:'时间',width:150,templet : "<div>{{layui.util.toDateString(d.ordertime, 'yyyy年MM月dd日 HH:mm:ss')}}</div>"},
            {field:'announcement',title:'内容',width:200},
            {field:'control',title:'操作',width:100,toolbar:'#control'}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    });
    table.on('tool(test)',function (obj) {
        if(obj.event==="delete"){
            layer.open({
                type:1,
                title:false,
                content:'<br><center><div>确认删除?</div></center>',
                btn:['确认','取消'],
                btn1:function () {
                    layer.closeAll();
                    var param = obj.data;
                    $.ajax({
                        url:"DeleteAnnouncement.action",
                        method:"get",
                        async:false,
                        data:{
                            nid:param.nid
                        },
                        dataType:'json',
                        success:function (data) {
                            var res = data.data;
                            layer.alert(res);
                            table.reload('noticeInfo',{
                                url:'AnnoList.action'
                            })
                        }
                    })
                },
                btn2:function () {
                    layer.closeAll();
                }
            })

        }
    })
})