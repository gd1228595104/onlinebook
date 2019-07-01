layui.use('table',function () {
    var table = layui.table;
    table.render({
        elem:'#stuInfo',
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
            // {field:'name',title:'申请时间',width:80,sort:true},
            {field:'cStatus',title:'审核状态',width:100},
            {field:'message',title:'详情',width:100,toolbar:'#xiangqing'}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    });
});