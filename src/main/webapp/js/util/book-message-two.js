layui.use("table",function () {

        $(function () {
        /**
         * 获取地址栏参数
         */
        $.extend({
            getUrlParam(name){
                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]); return null;
            }
        })
        var bookid = $.getUrlParam("bookid");
        var stuId = null;
        $.ajax({
        url:"FindInaBookInfo.action",
        method:"GET",
        async:false,
        data:{
            bookid:bookid
        },
        success:function (data) {
            var obj = data.data;
            if(obj === "未登录"){
               layer.open({
                   content:obj,
                   btn:["确认"],
                   btn1:function () {
                       window.location.href = "login.html";
                   }
               })
            }
            stuId = obj[0].loanerId;
            $("#bookname").text(obj[0].inactivebookname);
            $("#booktype").text("类型："+obj[0].classname);
            $("#author").text("作者："+obj[0].author);
            $("#publishPlace").text(obj[0].publisher);
            $("#status").text("状态："+obj[0].status);
            $("#loanerName").text("用户名："+obj[0].loanerName);
            $("#stuId").text("学号："+obj[0].loanerId);
            $("#major").text("专业："+obj[0].major+"-"+obj[0].classnumber);
            $("#department").text("学院："+obj[0].department);
            $("#status2").text("状态："+obj[0].status);
        }
    })

        //加载借阅信息
        var table = layui.table;
        table.render({
                elem:'#borrowInfo',
                size:"sm",
                skin:'none',
                loading:true,
                url:'FindHaveBorrowthisBook.action?bookid='+bookid,
                height:550,
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
                    {field:'borrowerId',title:"学号",width:200,sort:true},
                    {field:'borrowerName',title:'姓名',width:200,sort:true}
                ]],
                //重新加载设置表格背景颜色
                done:function (res,curr,count) {
                    tableList = res.data;
                    $('th').css({'background-color':'#5C9EFF','color':'#fff','font-weight':'bold'})
                }
            });
        $("#applyButton").click(function () {
            $.ajax({
                url:"RequestingBook.action",
                method:"GET",
                async:false,
                data:{
                    bookid:bookid
                },
                success:function (data) {
                    var obj = data.data;
                    layer.alert(obj);
                }
            })
        })
            $("#chatTiao").click(function () {
                window.open("chat.html?stuid="+stuId);
            })
})

})