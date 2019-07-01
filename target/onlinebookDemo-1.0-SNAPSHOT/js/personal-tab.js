

window.onload = function () {
                var iiiiallselect = document.getElementById("iiii-allselect");
                var iiiitbd = document.getElementById("iiii-tbd");
                var iiiiInpArr = iiiitbd.getElementsByTagName("input");

                var iiiiiallselect = document.getElementById("iiiii-allselect");
                var iiiiitbd = document.getElementById("iiiii-tbd");
                // var iiiiiInpArr = iiiiitbd.getElementsByTagName("input");

                var iiiiibAllselect = document.getElementById("iiiii-ballselect");
                var iiiiibTbd = document.getElementById("iiiii-btbd");
                // var iiiiibInpArr = iiiiibTbd.getElementsByTagName("input");

                var aaaAllselect = document.getElementById("aaa-allselect");
                var aaatbd = document.getElementById("aaa-tbd");
                // var aaaInpArr = aaatbd.getElementsByTagName("input");

                var aaabAllselect = document.getElementById("aaa-ballselect");
                var aaabtbd = document.getElementById("aaa-btbd");
                // var aaabInpArr = aaabtbd.getElementsByTagName("input");

                iiiiallselect.onclick = function () {
                for(var i=0;i<iiiiInpArr.length;i++){
                    iiiiInpArr[i].checked = this.checked;
                }
            }

            
            for(var i=0;i<iiiiInpArr.length;i++){
                iiiiInpArr[i].onclick = function () {
                    //开闭原则
                    var bool = true;
                    //检测每一个input的checked属性值。
                    for(var j=0;j<iiiiInpArr.length;j++){
                        if(iiiiInpArr[j].checked === false){
                            bool = false;
                        }
                    }
                    iiiiallselect.checked = bool;
                }
            }

            // aaabAllselect.onclick = function () {
            //     for(var i=0;i<aaabInpArr.length;i++){
            //         aaabInpArr[i].checked = this.checked;
            //     }
            // }

            
            // for(var i=0;i<aaabInpArr.length;i++){
            //     aaabInpArr[i].onclick = function () {
            //         //开闭原则
            //         var bool = true;
            //         //检测每一个input的checked属性值。
            //         for(var j=0;j<aaabInpArr.length;j++){
            //             if(aaabInpArr[j].checked === false){
            //                 bool = false;
            //             }
            //         }
            //         aaabAllselect.checked = bool;
            //     }




            
                
                var clickarr = document.getElementsByClassName("click");
                var divarr = document.getElementsByClassName("personal-main-right");
                
                for(var i=0;i<clickarr.length;i++){
                    clickarr[i].index = i;
                    clickarr[i].onclick = function () {
                        for(var i=0;i<clickarr.length;i++){
                            clickarr[i].classList.remove("personal-center-current");
                            
                        }
                        this.classList.add("personal-center-current");
                        
                        for(var j=0;j<divarr.length;j++){
                            divarr[j].classList.remove("show");

                        }
                        
                        divarr[this.index].classList.add("show");
                    }
                }
                
                //发布希望书籍跟闲置书籍
                var tablearr = document.getElementsByClassName("tb");
                var publisharr = document.getElementsByClassName("publish-books");
                
                for(var i=0;i<publisharr.length;i++){
                    publisharr[i].index = i;
                    publisharr[i].onclick = function () {
                        for(var i=0;i<publisharr.length;i++){
                            publisharr[i].classList.remove("publish-current");
                            
                        }
                        this.classList.add("publish-current");
                        
                        for(var j=0;j<tablearr.length;j++){
                            tablearr[j].classList.remove("show");
                            tablearr[j].classList.add("b-hide");

                        }
                        
                        tablearr[this.index].classList.add("show");
                    }
                }

                // 发表评论跟他人评论
                var iiiiidivArr = document.getElementsByClassName("iiiii-div");
                var evaluateArr = document.getElementsByClassName("evaluate");
                
                for(var i=0;i<evaluateArr.length;i++){
                    evaluateArr[i].index = i;
                    evaluateArr[i].onclick = function () {
                        for(var i=0;i<evaluateArr.length;i++){
                            evaluateArr[i].classList.remove("evaluate-current");
                            
                        }
                        this.classList.add("evaluate-current");
                        
                        for(var j=0;j<iiiiidivArr.length;j++){
                            iiiiidivArr[j].classList.remove("show");
                            iiiiidivArr[j].classList.add("div-hide");

                        }
                        
                        iiiiidivArr[this.index].classList.add("show");
                    }
                }

                


            }
            
        