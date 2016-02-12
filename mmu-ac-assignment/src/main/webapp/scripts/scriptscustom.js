//functions to provide output to jsp

function topage(data, id) {
  if ((data.readyState == 4) &&
      (data.status == 200)) {
	  
        var end = "<pre>" + data.responseText + "</pre>";
      	
        document.getElementById(id).innerHTML = end;
  }
}

function callreq() {
	if (window.XMLHttpRequest) {
	    return(new XMLHttpRequest());
	  } else if (window.ActiveXObject) { 
	    return(new ActiveXObject("Microsoft.XMLHTTP"));
	  } else {
	    return(null); 
	  }
}

function pagedatareq(url, id) {
	
  var getrequest = callreq();
  getrequest.onreadystatechange = 
    function() { topage(getrequest, 
                                  id); };
  getrequest.open("GET", url, true);
  getrequest.send(null);
}


