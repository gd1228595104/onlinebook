layui.use("layer",function () {
        $.extend({
            hr:function (obj) {
               window.location.href = "book-message-two.html?bookid="+obj;
            }
        })
        $.extend({
            add0: function (m) {
                return m < 10 ? '0' + m : m
            },
            convertDate: function (date) {
                var time = new Date(date);
                var y = time.getFullYear();
                var m = time.getMonth() + 1;
                var d = time.getDate();
                var h = time.getHours();
                var mm = time.getMinutes();
                var s = time.getSeconds();
                return y + '-' + this.add0(m) + '-' + this.add0(d);
                // return y + '-' + this.add0(m) + '-' + this.add0(d) + ' '
                //     + this.add0(h) + ':' + this.add0(mm) + ':' + this.add0(s);
            }
        })
        //获取最新六条公告信息
        $.ajax({
            url:"AnnoInfo.action",
            method:"GET",
            async:false,
            ContentType:"application/json;charset=UTF-8",
            success:function (data) {
                var obj = data.data;
                $("#ano1").text(obj[0].announcement);
                $("#anotime1").text($.convertDate(obj[0].annotime));
                $("#ano2").text(obj[1].announcement);
                $("#anotime2").text($.convertDate(obj[1].annotime));
                $("#ano3").text(obj[2].announcement);
                $("#anotime3").text($.convertDate(obj[2].annotime));
                $("#ano4").text(obj[3].announcement);
                $("#anotime4").text($.convertDate(obj[3].annotime));
                $("#ano5").text(obj[4].announcement);
                $("#anotime5").text($.convertDate(obj[4].annotime));
                $("#ano6").text(obj[5].announcement);
                $("#anotime6").text($.convertDate(obj[5].annotime));

            }
        })
    //获取书籍信息
    $.ajax({
        url:"FindAllInaBook.action",
        method:"GET",
        async:false,
        data:{
            currPage:1,
            pageSize:8
        },
        success:function (data) {
            var row = data.data;
            var info = null;
            for(i = 0; i < row.length; i++) {
                info +="<div class=\"container\">\n" +
                    "<div class=\"book\"><a href=\"javascript:void(0)\"><img src=\"images/6.png\"></a></div>\n" +
                    "<div class=\"introduction\">\n" +
                    "<p class=\"bookname\" id='bookname"+i+"'>"+row[i].inactivebookname+"</p>\n" +
                    "<p class=\"bookid\" id='bookid"+i+"'>书籍id："+row[i].bookid+"</p>\n" +
                    "<p class=\"loaner\" id='loaner"+i+"'>上传者："+row[i].loanerName+"</p>\n" +
                    "<p class=\"loanerid\" id='loanerid"+i+"'>学号："+row[i].loanerId+"</p>\n" +
                    "</div>\n" +
                    "<button class=\"borrow\" id='btn"+i+"' onclick='$.hr("+row[i].bookid+")'>我想借</button>\n" +
                    "<button class=\"save\" id='save"+i+"'><span class=\"xin\">♡</span>收藏</button>\n" +
                    "</div>\n"
            }
            $("#mainbook").html(info);
        }
    })
        $("#confirm").click(function () {
            var stuid = null;
            var content = $("#complainContent").val();
            var complainStuid = $("#complainStuid").val();
            //获取登录的学生账号
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
                        stuid = data.sid;
                    }
                }
            })
            //发布投诉信息
            $.ajax({
                url:"ComplaintOtherUser.action",
                method:"Get",
                async:false,
                data:{
                    sid:stuid,
                    asid:complainStuid,
                    content:content
                },
                success:function (data) {
                    msg = data.data;
                    if(msg === "未登录"){
                        layer.alert("投诉失败,请确认您是否已登录账号或被投诉学号不存在")
                    }else {
                        layer.alert(data.data);
                    }
                },
                error:function (data) {
                    layer.alert("投诉失败");
                }
            })
        })

        //搜索框
        $("#searchButton").click(function () {
            var condition = $("#searchParam").val();//获取搜索的条件
            var content = $("#searchText").val(); //获取搜索的内容
            $.ajax({
                url:"SearchBar.action",
                method:"GET",
                async:false,
                data:{
                    condition:condition,
                    context:content,
                    currPage:1,
                    pageSize:8
                },
                success:function (data) {
                    var row = data.data;
                    var info = null;
                    for(i = 0; i < row.length; i++) {
                        info +="<div class=\"container\">\n" +
                            "<div class=\"book\"><a href=\"javascript:void(0)\"><img src=\"images/6.png\"></a></div>\n" +
                            "<div class=\"introduction\">\n" +
                            "<p class=\"bookname\" id='bookname"+i+"'>"+row[i].inactivebookname+"</p>\n" +
                            "<p class=\"bookid\" id='bookid"+i+"'>书籍id："+row[i].bookid+"</p>\n" +
                            "<p class=\"loaner\" id='loaner"+i+"'>上传者："+row[i].loanerName+"</p>\n" +
                            "<p class=\"loanerid\" id='loanerid"+i+"'>学号："+row[i].loanerId+"</p>\n" +
                            "</div>\n" +
                            "<button class=\"borrow\" id='btn"+i+"' onclick='$.hr("+row[i].bookid+")'>我想借</button>\n" +
                            "<button class=\"save\" id='save"+i+"'><span class=\"xin\">♡</span>收藏</button>\n" +
                            "</div>\n"
                    }
                    $("#mainbook").html(info);
                }
            })

        })

})