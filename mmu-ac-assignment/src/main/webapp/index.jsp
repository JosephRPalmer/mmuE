<html>
<head>
<!-- implements bootstrap css library and custom CSS, script calls also shown -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="custom.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="scripts/scriptscustom.js"
        type="text/javascript"></script>
       
        
<title>MMU Enterprise Assignment - 1.0.0-FINAL</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">MMU Enterprise Assignment - 1.0.0-FINAL</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
                      </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
   <div class="container">

      <div class="headi">
        <h1>Test the API here</h1>
        </div>
<div class="boi">
<p>
        	<h2>Search the Database</h2>
        	<p>
<button id="all" onclick='pagedatareq("http://mmuenterprise-1193.appspot.com/webapi/Staff", "staff-table")' type="button" class="btn btn-default">List Staff</button>
   <script type="text/javascript">
   //script appends search queries to url
    function InvokeSearch(input, type){
        var searcher = document.getElementById('nameinput').value;
        document.getElementById(input).innerHTML = "";
        return "http://mmuenterprise-1193.appspot.com/webapi/Staff/" + type + searcher;
         }
</script>

    <form action="#">
  <label for="namestring">Forename:</label>
  <input type="text" id="nameinput"/>
  <input type="button" value="Search as JSON"
        onclick='pagedatareq(InvokeSearch("staff-table", "searchjs?search=") , "staff-table", "js")' type="button" class="btn btn-default"/>
  <input type="button" value="Search as XML"
       type="button" class="btn btn-default"/>
  <input type="button" value="Search as Plain Text"
        onclick='pagedatareq(InvokeSearch("staff-table", "searchpt?search="), "staff-table", "js")'type="button" class="btn btn-default"/>
     <script>
     //script fires on onclick so that it saves data from form to database
        function finalsave(){
        	   var name = document.getElementById("name").value;
        	    var surname = document.getElementById("surname").value;
        	    var location = document.getElementById("location").value;
        	    var phone = document.getElementById("phone").value;
        	    var email = document.getElementById("email").value;
        	    var staffID = document.getElementById("id").value;
        	    var parameters="name="+name+"&surname="+surname+"&id="+staffID+"&phone="+phone+"&email="+email+"&*location="+location;
        	    $.ajax({
        	    	headers: { 
        	            
        	            'Content-Type': 'text/plain' 
        	        },
        	      url: "http://mmuenterprise-1193.appspot.com/webapi/Staff/save?" + parameters,
        	        type: "POST",
        	        //data:$("#saver").serialize(),
        	       //data: "name="+name+"&surname="+surname+"&id="+staffID+"&location="+location+"&phone="+phone+"&email="+email,
        	        success: alert("Success"),
        	        error: alert("Error")
        	})}
        	</script>
        	<p>
        	<h2>Add to Database</h2>
        	<p>
   </form>
   <form action="#" id="saver">
    <label for="namestring">Forename:</label>
  <input type="text" id="name"/><p>
   <label for="surnamestring">Surname:</label>
  <input type="text" id="surname"/><p>
   <label for="IDstring">Staff ID:</label>
  <input type="text" id="id"/><p>
   <label for="locstring">Location:</label>
  <input type="text" id="location"/></p>
   <label for="phonestring">Phone:</label>
  <input type="text" id="phone"/><p>
   <label for="emailstring">Email:</label>
  <input type="text" id="email"/><p>
  
  
   <input type="button" value="Save Data"
        onclick='finalsave()'type="button" class="btn btn-default"/>
   </form>
    <div id="outer"style="overflow-y: auto; height:300px;">
  
    <div id="staff-table" class="ajaxResult">
    
    </div>
    
    </div></div>
    
    
    
   
    
    </div>
   
    
    
</body>
</html>
