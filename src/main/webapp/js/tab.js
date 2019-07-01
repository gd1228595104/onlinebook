
	    window.onload=function(){
	    	
	    	var b=document.getElementsByClassName("bottom-nav")[0];
	        var aArr=b.children;
	    	for (var i = 0; i < aArr.length; i++) {
	    		aArr[i].index=i;
	    		aArr[i].onmouseover=function(){
	    			for (var i = 0; i < aArr.length; i++) {
	    				aArr[i].className="";
	    				
	    			}
	    			this.className="current";
	    			
	    		}

	    	}


	    }
