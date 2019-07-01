
$(document).ready(
    function () {
              
             $(".xiangqing").on("click", function () {
                
                $("#detail").attr("class","");
          });
             $(".close-detail").on("click", function () {
                
                $("#detail").attr("class","hide");
          });


             $(".borrower-message").on("mouseenter", function () {
                
                $("#borrower-message").attr("class","");
          });
             $(".borrower-message").on("mouseleave", function () {
                
                $("#borrower-message").attr("class","hide");
          });



             $(".evaluate-publisher").on("click", function () {
                
                $("#evaluate-publisher").attr("class","");
          });
             $(".cancle-submit").on("click", function () {
                
                $("#evaluate-publisher").attr("class","hide");
          });


            $(".on-complain").on("click", function () {
                
                $("#complain").attr("class","");
          });
             $(".cancel-complain").on("click", function () {
                
                $("#complain").attr("class","hide");
          }); 

             $(".container-interest li").on("click", function () {
                if($(this).hasClass('tag')){
                     $(this).attr("class","selected");   
                } else {
                     $(this).attr("class","tag");
                }
          });
                 
});
