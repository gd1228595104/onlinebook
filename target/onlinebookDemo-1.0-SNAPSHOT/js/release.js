window.onload=function(){
	//发布希望书籍跟闲置书籍的详细界面
                var detailsArr = document.getElementsByClassName("issue-details");
                var issueArr = document.getElementsByClassName("issue");
                
                for(var i=0;i<issueArr.length;i++){
                    issueArr[i].index = i;
                    issueArr[i].onclick = function () {
                        for(var i=0;i<issueArr.length;i++){
                            issueArr[i].classList.remove("issue-current");
                            
                        }
                        this.classList.add("issue-current");
                        
                        for(var j=0;j<detailsArr.length;j++){
                            
                            detailsArr[j].classList.remove("show");
                            detailsArr[j].classList.add("issue-hide");

                        }
                        
                        detailsArr[this.index].classList.add("show");
                    }
                }

                

}