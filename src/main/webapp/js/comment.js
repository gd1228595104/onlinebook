
$(document).ready(
    function () {
            var wjx_none = '☆'; // 空心五角星
            var wjx_sel = '★'; // 实心五角星

            //需求1：鼠标放上去当前的li和之前所有的li内容全部变为实心五角星，移开变为空心。
            $(".comment li").on("mouseenter", function () {
                
                $(this).text(wjx_sel).prevAll("li").text(wjx_sel).end().nextAll("li").text(wjx_none);
            });

            $(".comment li").on("mouseleave", function () {
               
                if($("li.current").length === 0){
                    $(".comment li").text(wjx_none);
                }else{
                   
                    $("li.current").text(wjx_sel).prevAll("li").text(wjx_sel).end().nextAll("li").text(wjx_none);
                }
            });


            //需求2：鼠标点击那个li，当你前li和之前所有的li都变成实心五角星，其他变为空心。
            $(".comment li").on("click", function () {
                
                $(this).attr("class","current").siblings("li").removeAttr("class");
            });


        });