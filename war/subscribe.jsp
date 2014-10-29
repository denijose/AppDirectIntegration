<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/dashboard.css">
<title>Insert title here</title>

<script type="text/javascript">
    var firstName = '<%= request.getSession().getAttribute("firstName")%>';
    var lastName = '<%= request.getAttribute("lastName")%>';
	function init(){
		var temp='<%= request.getAttribute("jsonResponse") %>';
		jsonResponse = JSON.parse(temp);
		
		//create the subscription orders table
		document.getElementById("tableDivOrders").innerHTML = "";
		 var table = document.createElement('table');
		 table.className = "table table-striped table-hover";
		 table.innerHTML = "<tr><td>Created By</td><td>Company Name</td><td>Company Email</td><td>Company Phone Number</td>";
		 var orders = jsonResponse.orders;
		 for(var i=0;i<orders.length;i++){
			 var createdBy = orders[i].createdBy;
			 var companyName = orders[i].companyName;
			 var companyEmail = orders[i].companyEmail;
			 var companyPhone = orders[i].companyPhone;
			 table.innerHTML += "<tr><td>"+ createdBy +"</td><td>"+companyName+"</td><td>"+companyEmail+"</td><td>"+companyPhone+"</td>";
		 }
		 if(orders.length > 0)
		  document.getElementById("tableDivOrders").appendChild(table);
		 
		//create the subscription changes table
			document.getElementById("tableDivChanges").innerHTML = "";
			 var table = document.createElement('table');
			 table.className = "table table-striped table-hover";
			 table.innerHTML = "<tr><td>Created By</td><td>Account Affected</td>";
			 var changes = jsonResponse.changes;
			 for(var i=0;i<changes.length;i++){
				 var createdBy = changes[i].createdBy;
				 var changedForAccount = changes[i].changedForAccount;
				 table.innerHTML += "<tr><td>"+ createdBy +"</td><td>"+changedForAccount+"</td><td>";
			 }
			 if(changes.length > 0)
			  document.getElementById("tableDivChanges").appendChild(table);
			 
			//create the subscription orders table
				document.getElementById("tableDivCancellations").innerHTML = "";
				 var table = document.createElement('table');
				 table.className = "table table-striped table-hover";
				 table.innerHTML = "<tr><td>Created By</td><td>Cancelled Account</td><td>";
				 var cancellations = jsonResponse.cancellations;
				 for(var i=0;i<cancellations.length;i++){
					 var createdBy = cancellations[i].createdBy;
					 var cancelledForAccount = cancellations[i].cancelledForAccount;
					 table.innerHTML += "<tr><td>"+ createdBy +"</td><td>"+cancelledForAccount+"</td><td>";
				 }
				 if(cancellations.length > 0)
		 			document.getElementById("tableDivCancellations").appendChild(table);
				 
					//create the users assigned Table
					document.getElementById("tableDivUserAssignments").innerHTML = "";
					 var table = document.createElement('table');
					 table.className = "table table-striped table-hover";
					 table.innerHTML = "<tr><td>Created By</td><td>User Assigned</td><td>";
					 var users = jsonResponse.users;
					 for(var i=0;i<users.length;i++){
						 var createdBy = users[i].createdBy;
						 var assignedUsers = users[i].assignedUsers;
						 table.innerHTML += "<tr><td>"+ createdBy +"</td><td>"+assignedUsers+"</td><td>";
					 }
					 if(users.length > 0)
			 			document.getElementById("tableDivUserAssignments").appendChild(table);		 
					 
// 						//create the users unAssigned Table
// 						document.getElementById("tableDivUserUnassignments").innerHTML = "";
// 						 var table = document.createElement('table');
// 						 table.className = "table table-striped table-hover";
// 						 table.innerHTML = "<tr><td>Created By</td><td>User UnAssigned</td><td>";
// 						 var usersUnAssigned = jsonResponse.usersUnAssigned;
// 						 for(var i=0;i<usersUnAssigned.length;i++){
// 							 var createdBy = users[i].createdBy;
// 							 var unAssignedUsers = users[i].unAssignedUsers;
// 							 table.innerHTML += "<tr><td>"+ createdBy +"</td><td>"+unAssignedUsers+"</td><td>";
// 						 }
// 						 if(usersUnAssigned.length > 0)
// 				 			document.getElementById("tableDivUserUnassignments").appendChild(table);		 
	}
</script>
</head>
<body onload="init()">
		   
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Welcome <%= request.getSession().getAttribute("fullName") %></a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>  
            <li>
            	<form class="form-signin" role="form" action="/login?logout=true" method="post"> 
				<button type="submit" class="btn">
			  	<i class="icon-user icon-white"></i> Log Out </button>
            </form>
            </li>          
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
                
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview</a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>
          <form class="form-signin" role="form" action="/pull" method="get"> 
			<button type="submit" class="btn btn-danger">
		  	<i class="icon-user icon-white"></i> Refresh </button>
        </form>
        
          <h2 class="sub-header">Subsctription Orders</h2>
          <div class="table-responsive">
            <div id="tableDivOrders"></div>
          </div>
          <h2 class="sub-header">Subsctription Changes</h2>
          <div class="table-responsive">
            <div id="tableDivChanges"></div>
          </div>
          <h2 class="sub-header">Subsctription Cancellations</h2>
          <div class="table-responsive">
            <div id="tableDivCancellations"></div>	
          </div>
          <h2 class="sub-header">User Assignments</h2>
          <div class="table-responsive">
            <div id="tableDivUserAssignments"></div>	
          </div>
<!--           <h2 class="sub-header">User Unassignments</h2> -->
<!--           <div class="table-responsive"> -->
<!--             <div id="tableDivUserUnassignments"></div>	 -->
<!--           </div> -->
        </div>
      </div>
    </div>
 
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="http://getbootstrap.com/assets/js/docs.min.js"></script>
</body>
</html>