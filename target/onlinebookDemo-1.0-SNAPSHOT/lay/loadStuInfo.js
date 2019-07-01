layui.use('table',function () {
    var table = layui.table;
    table.render({
        elem:'#loadStuInfo',
        size:"sm",
        skin:'none',
        loading:true,
        height:600,
        url:'getAll.action',
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
            limit:20,
            limits:[20],
            group:1
        },
        parseData:function(res){
            return{
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.count, //解析数据长度
                "data": res.data //解析数据列表
            }
        },
        cols:[[
            {field:'sid',title:'学号',align:'center',edit:'text',width:150,sort:true},
            {field:'name',title:'姓名',align:'center',edit:'text',width:100},
            {field:'sex',title:'性别',align:'center',edit:'text',width:100},
            {field:'department',title:'学院',align:'center',edit:'text',width:100},
            {field:'major',title:'专业',align:'center',edit:'text',width:150},
            {field:'classnumber',title:'班级',align:'center',edit:'text',width:100},
            {field:'grade',title:'年级',align:'center',edit:'text',width:100},
            {field:'points',title:'积分',align:'center',width:100},
            {field:'credit',title:'信誉分',align:'center',width:100},
            {field:'control',title:'操作',align:'center',width:200,toolbar:"#control"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    //操作按钮的功能
    table.on('tool(test)',function (obj) {
        if(obj.event === 'update'){ //保存修改信息
            var row = obj.data;
            layer.alert("该功能后端人员没有写。￣へ￣")
        }
    })

    //Jquery,搜索功能
    $(function () {
        $("#Searchbtn").click(function () {
            paramType = $("#selectParam").val();
            context = $("#Search").val();
            table.reload("loadStuInfo",{
                url:"FindUser.action",
                where:{
                    condition:paramType,
                    context:context
                }
            })
        })
    })
})