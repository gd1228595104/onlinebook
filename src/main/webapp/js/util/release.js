$(function () {
    var table1;//记录希望书籍表的信息
    var table2;//记录闲置书籍表的信息
        //加载各个下拉框
    $.ajax({
        url: "getAllBookClass.action",
        method: "GET",
        async: false,
        data: {
            param: 0
        },
        success: function (data) {
            var obj = data.data;
            for (i = 0; i < obj.length; i++) {
                $("#bookClass1").append("<option value='" + obj[i].cid + "'>" + obj[i].classname + "</option>");
                $("#bookClass2").append("<option value='" + obj[i].cid + "'>" + obj[i].classname + "</option>");
            }
        }
    })
    $("#bookClass1").change(function () {
        var param = $("#bookClass1").val();
        $.ajax({
            url: "getAllBookClass.action",
            method: "GET",
            async: false,
            data: {
                param: param
            },
            success: function (data) {
                var obj = data.data;
                var select = $("#book1");
                select.empty();
                for (i = 0; i < obj.length; i++) {
                    select.append("<option value='" + obj[i].cid + "'>" + obj[i].classname + "</option>");
                }
            }
        })
    })
    $("#bookClass2").change(function () {
        var param = $("#bookClass2").val();
        $.ajax({
            url: "getAllBookClass.action",
            method: "GET",
            async: false,
            data: {
                param: param
            },
            success: function (data) {
                var obj = data.data;
                var select = $("#book2");
                select.empty();
                for (i = 0; i < obj.length; i++) {
                    select.append("<option value='" + obj[i].cid + "'>" + obj[i].classname + "</option>");
                }
            }
        })
    })

    //加载两个书籍表
    $("#book1").change(function () {
        layui.use('table', function () {
            var param = $("#book1").val();
            var table = layui.table;
            table.render({
                elem: '#HopeBooTable',
                size: "sm",
                skin: 'none',
                loading: true,
                url: 'getBook.action?cid=' + param,
                height: 400,
                toolbar: false,
                request: {
                    pageName: 'currPage',
                    limitName: 'pageSize'
                },
                response: {
                    statusCode: 200
                },
                page: {
                    theme: '#5C9EFF',
                    limit: 10,
                    limits: [10, 20, 50, 100],
                }, group: 4,
                parseData: function (res) {
                    return {
                        "code": res.code, //解析接口状态
                        "msg": res.msg, //解析提示文本
                        "count": res.count, //解析数据长度
                        "data": res.data //解析数据列表
                    }
                },
                cols: [[
                    {field:'cid',title:"序号",width:100,sort:true},
                    {field: 'bookname', title: "书名", width: 100},
                    {field: 'author', title: '作者', width: 150},
                    {field: 'message', title: '选中', width: 100, type:"checkbox"},
                ]],
                //重新加载设置表格背景颜色
                done: function (res, curr, count) {
                    tableList = res.data;
                    $('th').css({'background-color': '#5C9EFF', 'color': '#fff', 'font-weight': 'bold'})
                }
            })
            table.on("checkbox(test)",function (obj) {
                table1 = table.checkStatus("HopeBooTable").data;
            })
        })
    })
    $("#book2").change(function () {
        layui.use('table', function () {
            var param = $("#book2").val();
            var table = layui.table;
            table2 = table.render({
                elem: '#HopeBooTable2',
                size: "sm",
                skin: 'none',
                loading: true,
                url: 'getBook.action?cid=' + param,
                height: 400,
                toolbar: false,
                request: {
                    pageName: 'currPage',
                    limitName: 'pageSize'
                },
                response: {
                    statusCode: 200
                },
                page: {
                    theme: '#5C9EFF',
                    limit: 10,
                    limits: [10, 20, 50, 100],
                }, group: 4,
                parseData: function (res) {
                    return {
                        "code": res.code, //解析接口状态
                        "msg": res.msg, //解析提示文本
                        "count": res.count, //解析数据长度
                        "data": res.data //解析数据列表
                    }
                },
                cols: [[
                    {field:'cid',title:"序号",width:100,sort:true},
                    {field: 'bookname', title: "书名", width: 100},
                    {field: 'author', title: '作者', width: 150},
                    {field: 'message', title: '选中', width: 100, type: 'radio'},
                ]],
                //重新加载设置表格背景颜色
                done: function (res, curr, count) {
                    tableList = res.data;
                    $('th').css({'background-color': '#5C9EFF', 'color': '#fff', 'font-weight': 'bold'})
                }
            })
            table.on("radio(test2)",function (obj) {
                row = obj.data
                $("#cid").val(row.cid);
                $("#bookName1").val(row.bookname);
            })
        })
    })
    //搜索书籍
    $("#Search").click(function () {
        var author = $("#author").val();
        var bookname = $("#bookname").val();
        var publishPlace = $("#publishPlace").val();
        layui.use("layer",function () {

         $.ajax({
            url:"PromptBookClass.action",
            method:"GET",
            async:false,
            data:{
                bookname:bookname,
                author:author,
                publishinghouse:publishPlace
            },
            success:function (data) {
                obj = data.data;
                var msg = "";
                for(i = 0; i < obj.length; i++){
                    msg = msg + "<br>类别1："+obj[i].c1+" 类别2:"+obj[i].c2;
                }
                layer.alert(msg);
            },error:function () {
                layer.alert("填写信息不正确");
            }
        })

        })
    })
    //发布希望书籍
    $("#publishHopebook").click(function () {
        var param = JSON.stringify(table1);//将数组json化用于传参
        $.ajax({
            url:"PublishHopeBook.action",
            method:"GET",
            async:false,
            traditional: true,
            data:{
                booklist:param
            },
            success:function (data) {
                layui.use('layer',function () {
                    layer.alert(data.data)
                })
            }
        })
    })
    // $("#publishButton").click(function () {
    //     $.ajax({
    //         url:"PublishInaBook.action",
    //         method:"POST",
    //         async:false,
    //         traditional: true,
    //         data:$("#bookForm2").serialize(),
    //         success:function (data) {
    //             layui.use('layer',function () {
    //                 layer.alert(data.data)
    //             })
    //         }
    //     })
    // })
})