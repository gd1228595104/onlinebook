
        $(function () {
            var wjx_none = '♡'; // 空心五角星
            var wjx_sel = '♥'; // 实心五角星

            //需求1：鼠标放上去当前的li和之前所有的li内容全部变为实心五角星，移开变为空心。
            $(".container span").on("mouseenter", function () {
                //当前五角星，和之前的所有五角星，全部是实心的，其他的为空心
//                $(this).text(wjx_sel).prevAll("li").text(wjx_sel);
//                $(this).nextAll("li").text(wjx_none);
                $(this).text(wjx_sel).prevAll("span").text(wjx_sel).end().nextAll("span").text(wjx_none);
            });

            $(".container span").on("mouseleave", function () {
                //bug：如果没有点击过li，那么会出现无法清除的现象，处理办法就是先判断，看看是否有current类
                if($("span.current").length === 0){
                    $(".container span").text(wjx_none);
                }else{
                    //当鼠标移开的时候，谁有current类名，那么当前和之前所有的li前部是实心五角星，后面的所有li都是空心
                    $("span.current").text(wjx_sel).prevAll("span").text(wjx_sel).end().nextAll("span").text(wjx_none);
                }
            });


            //需求2：鼠标点击那个li，当你前li和之前所有的li都变成实心五角星，其他变为空心。
            $(".container span").on("click", function () {
                //点击哪个li给他加一个类名。清空其他所有的li的类名
                $(this).attr("class","current").siblings("span").removeAttr("class");
            });


        });
