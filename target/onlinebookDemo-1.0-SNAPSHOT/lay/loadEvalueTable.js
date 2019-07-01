layui.use('table',function () {
    var table = layui.table;//他人评价表
    var table2 = layui.table;//评价他人表
    var table3 = layui.table;//闲置书籍表
    var table4 = layui.table;//希望书籍表
    var table5 = layui.table;//已借出书籍
    var table6 = layui.table;//待借出的表
    var table7 = layui.table;//加载借入的书籍
    var table8 = layui.table;//待借入的书籍
    table.render({
        elem:'#evaTable',
        size:"sm",
        skin:'none',
        loading:true,
        url:'FindBeEvaluation.action',
        height:450,
        toolbar:false,
        response:{
            statusCode:200
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
            {field:'evaluatorId',title:'学号',width:200},
            {field:'evaluatorName',title:'姓名',width:200},
            {field:'evaluation',title:'评价内容',width:200},
            {field:'evaluatescore',title:'分数',width:200}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    });
    //加载评价他人表
    var t2 = table2.render({
        elem:'#evaTable2',
        size:"sm",
        skin:'none',
        loading:true,
        url:'FindEvaluation.action',
        height:450,
        toolbar:false,
        response:{
            statusCode:200
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
            {field:'beevaluatorId',title:'学号',align:"center",width:"150"},
            {field:'beevaluatorName',title:'姓名',align:"center",width:"150"},
            {field:'evaluation',title:'评价内容',align:"center",edit:"text",width:"250"},
            {field:'evaluatescore',title:'分数',align:"center",edit:"text",width:"150"},
            {field:'message',title:'操作',align:"center",width:"150",toolbar:"#control"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    table2.on('tool(test2)',function (obj) {
        if(obj.event === "update"){
            var row = obj.data;
            $.ajax({
                url:"ChangeEvaluation.action",
                method:"GET",
                async:false,
                ContentType:"application/json;charset=UTF-8",
                data:{
                    evaid:row.evaid,
                    evaluation:row.evaluation,
                    evaluatescore:row.evaluatescore
                },
                success:function (data) {
                    layer.open({
                        type:0,
                        content:data.data,
                        btn:["确定"],
                        btn1:function () {
                            layer.closeAll();
                            t2.reload({
                                url:"FindEvaluation.action"
                            })
                        }
                    })
                },
                error:function (data) {
                    layer.alert("修改失败。<br>“分数只能为整数”")
                }
            })
        }
        if(obj.event === "delete") {
            var row = obj.data;
            $.ajax({
                url:"DeleteEvaluation.action",
                metod:"get",
                async:false,
                ContentType:"application/json;charset=UTF-8",
                data:{
                    evaid:row.evaid
                },
                dataType:'json',
                success:function (data) {
                    layer.open({
                        type:0,
                        title:false,
                        content:data.data,
                        btn:["确定"],
                        btn1:function () {
                            layer.closeAll();
                            t2.reload({
                                url:"FindEvaluation.action",
                            })
                        }
                    });
                }
            })
        }
    })

    //加载闲置书籍表
    table3.render({
        elem:"#time",
        size:"sm",
        skin:"none",
        loading:true,
        url:"FindPublishedInaBook.action",
        height:450,
        toolbar:false,
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
            {field:'inactivebookname',title:'书籍名称',align:"left",width:"300"},
            {field:'status',title:'书籍状态',align:"left",width:"250"},
            {field:'message',title:'操作',align:"left",width:"250",toolbar:"#delete"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    table3.on('tool(Invfilter)',function (obj) {
        if(obj.event === "delete"){
            var row = obj.data;
            layer.alert("后端人员偷懒不做，o(︶︿︶)o ")
        }
    })
    //加载希望书籍表
    table4.render({
        elem:"#hope1",
        size:"sm",
        skin:"none",
        loading:true,
        url:"FindPublishedHopeBook.action",
        height:450,
        toolbar:false,
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
            {field:'hopebookname',title:'书籍名称',align:"left",width:"200"},
            {field:'author',title:'作者',align:"left",width:"200"},
            {field:'hopeid',title:'单号',align:"left",width:"250"},
            {field:'message',title:'操作',align:"left",width:"200",toolbar:"#delete2"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    table4.on('tool(hope1filter)',function (obj) {
        if(obj.event === "delete"){
            layer.alert("后端人员还是没做，前端整合心也是很累的o(︶︿︶)o ");
        }
    })

    //加载已借出书籍
    table5.render({
        elem:"#lended",
        size:"sm",
        skin:"none",
        loading:true,
        url:"LendedBook.action",
        height:450,
        toolbar:false,
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
            {field:"bookid",title:'书籍编号',align:"left",width:"100",
                templet:function (row) {
                    return row.tInactivebook.bookid;
                }
            },
            {title:'书籍名称',align:"left",width:"100",
                templet:function (row) {
                    return row.tInactivebook.inactivebookname;
                }
            },
            {field:'borrowerId',title:'学号',align:"left",width:"150"},
            {field:'stoptime',title:'归还时间',edit:"text",align:"left",width:"150"},
            {title:'状态',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.status;
                }
            },
            {field:'message',title:'操作',align:"left",width:"200",toolbar:"#update"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    table5.on("tool(lendedFilter)",function (obj) {
        if(obj.event === "update"){
            var row = obj.data;
            layer.open({
                title:false,
                content:"确认修改？",
                btn:["确认","取消"],
                btn1:function () {
                    layer.closeAll();
                    if(row.status === "未还"){
                        $.ajax({
                            url:"LengthenTime.action",
                            method:"GET",
                            async:false,
                            data:{
                                bookid:row.bookid,
                                stoptime:row.stoptime
                            },
                            success:function (data) {
                                layer.alert(data.data);
                            }
                        })
                    }else{
                        layer.alert("书籍已归还");
                    }
                }
            })

        }
        if(obj.event === "update1"){
            var row = obj.data;
            layer.open({
                title:false,
                content:"确认还书？",
                btn:["确认","取消"],
                btn1:function () {
                    layer.closeAll();
                    if(row.status === "已还"){
                        $.ajax({
                            url:"ReturnInaBook.action",
                            method:"GET",
                            async:false,
                            data:{
                                bookid:row.tInactivebook.bookid,
                            },
                            success:function (data) {
                                layer.alert(data.data);
                            }
                        })
                    }else{
                        layer.alert("书籍已归还");
                    }
                }
            })
        }
    })
    //加载待接出的书籍
    table6.render({
        elem:"#lend",
        size:"sm",
        skin:"none",
        loading:true,
        url:"FindLendBook.action",
        height:450,
        toolbar:false,
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
            {field:'borrowerId',title:'学号',align:"center",width:"150"},
            {field:'borrowerName',title:'姓名',align:"center",width:"150"},
            {field:"bookid",title:'书籍编号',align:"center",width:"150",
                templet:function (row) {
                    return row.tInactivebook.bookid;
                }
            },
            {title:'书籍名称',align:"center",width:"200",
                templet:function (row) {
                    return row.tInactivebook.inactivebookname;
                }
            },
            {field:'message',title:'操作',align:"left",width:"150",toolbar:"#lendUpdate"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    table6.on("tool(lendFilter)",function (obj) {
        if(obj.event === "agree"){
            var row = obj.data;
            var content = "归还日期：<input type='date' id='stopDate' class=layui-input>"
            layer.open({
                title:false,
                content:"确认同意？",
                btn:["确认","取消"],
                btn1:function () {
                    layer.open({
                        type:1,
                        content:content,
                        btn:["确定"],
                        btn1:function () {
                            var stopDate = $("#stopDate").val();
                            layer.closeAll();
                            $.ajax({
                                url:"SureLend.action",
                                method:"GET",
                                async:false,
                                data:{
                                    bookid:row.bookid,
                                    stoptime:stopDate
                                },
                                success:function (data) {
                                    layer.alert(data.data);
                                }
                            })
                        }
                    })

                }
            })

        }
        if(obj.event === "disagree"){
            var row = obj.data;
            layer.open({
                title:false,
                content:"确认不同意？",
                btn:["确认","取消"],
                btn1:function () {
                    layer.closeAll();
                    $.ajax({
                        url:"DisagreedLend.action",
                        method:"GET",
                        async:false,
                        data:{
                            eid:row.eid,
                            sid:row.borrowerId
                        },
                        success:function (data) {
                            layer.alert(data.data);
                        }
                    })


                }
            })

        }
    })
    //加载借入的书籍
    table7.render({
        elem:"#borrowed",
        size:"sm",
        skin:"none",
        loading:true,
        url:"BorrowedBook.action",
        height:450,
        toolbar:false,
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
            {field:"loanerId",title:'学号',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.loanerId;
                }
            },
            {field:"bookid",title:'书号',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.bookid;
                }
            },
            {title:'书名',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.inactivebookname;
                }
            },
            {field:"stoptime",title:'期限',align:"left",width:"130"},
            {field:"status",title:'状态',align:"left",width:"130"},
            {field:'message',title:'操作',align:"left",width:"140",toolbar:"#updateH"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    table7.on("tool(borrowFilter)",function (obj) {
        if(obj.event === "update"){
            var row = obj.data;
            layer.open({
                title:false,
                content:"确认还书？",
                btn:["确认","取消"],
                btn1:function (){
                    $.ajax({
                        url:"ReturnExcBook.action",
                        method:"GET",
                        async:false,
                        data:{
                           eid:row.eid
                        },
                        success:function (data) {
                            layer.alert(data.data);
                        }
                    })
                }

            })

        }
    })

    //加载待接入书籍
    table8.render({
        elem:"#borrow",
        size:"sm",
        skin:"none",
        loading:true,
        url:"FindBorrowBook.action",
        height:450,
        toolbar:false,
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
            {field:"loanerId",title:'学号',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.loanerId;
                }
            },
            {title:'姓名',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.loanerName;
                }
            },
            {title:'书籍ID',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.bookid;
                }
            },
            {title:'书名',align:"left",width:"150",
                templet:function (row) {
                    return row.tInactivebook.inactivebookname;
                }
            },
            {field:'stoptime',title:'还书时间',align:'left',width:"200"},
            {field:'message',title:'操作',align:"left",width:"150",toolbar:"#updateB"}
        ]],
        //重新加载设置表格背景颜色
        done:function (res,curr,count) {
            tableList = res.data;
            $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
        }
    })
    table8.on("tool(borrowFilter2)",function (obj) {
        if(obj.event === "update"){
            var row = obj.data;
            console.info(row)
            layer.open({
                title:false,
                content:"确认已经借入？",
                btn:["确认","取消"],
                btn1:function (){
                    $.ajax({
                        url:"SureBorrow.action",
                        method:"GET",
                        async:false,
                        data:{
                            bookid:row.tInactivebook.bookid,
                            sid:row.tInactivebook.loanerId
                        },
                        success:function (data) {
                            layer.alert(data.data);
                        }
                    })
                }

            })

        }
    })

})
