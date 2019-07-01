$(document).ready(
	function(){
    
             $(".alter").on("click",function(){
             	var t=$(this).prev().val(); 
                $(this).prev().val("").focus().val(t);
             	$(this).prev().attr("disabled",false);
             	$(this).prev().focus();
             });



              $(".pa-modify").on("click", function () {
                
                $("#pa-alter").attr("class","");
          });
             $("#pa-off").on("click", function () {
                
                $("#pa-alter").attr("class","hide");
          });

              $(".paa-modify").on("click", function () {
                
                $("#paa-alter").attr("class","");
          });
             $("#paa-off").on("click", function () {
                
                $("#paa-alter").attr("class","hide");
          });


	});
