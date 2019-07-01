$(document).ready(
    function () {
            var heart_none = '♡'; // 空心心形
            var heart_sel = '♥'; // 实心心形
            
           
                $(".container span").on("click", function () {
                
                 if($(this).hasClass('xin')){
                     $(this).attr("class","current");
                    $(".container .current").text(heart_sel);
                   
                } else {
                   
                     $(this).attr("class","xin");
                
                    $(".xin").text(heart_none);
                }
          });
                 
});

           
            
        

