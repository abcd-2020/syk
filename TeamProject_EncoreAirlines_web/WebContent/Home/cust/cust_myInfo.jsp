<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>

<style>
  /* 사이드바 래퍼 스타일 */
  
  #page-wrapper {
    padding-left: 250px;
  }
  
  #sidebar-wrapper {
    position: fixed;
    width: 400px;
    height: 100%;
    margin-left: -250px;
    background: #007bff;
    overflow-x: hidden;
    overflow-y: auto;
  }
  
  #page-content-wrapper {
    width: 100%;
    padding: 20px;
  }
  /* 사이드바 스타일 */
  
  .sidebar-nav {
    width: 400px;
    margin: 0;
    padding: 0;
    list-style: none;
  }
  
  .sidebar-nav li {
    text-indent: 1.5em;
    line-height: 2.8em;
  }
  
  .sidebar-nav li a {
    display: block;
    text-decoration: none;
    color: #fff;
  }
  
  .sidebar-nav li a:hover {
    color: #fff;
    background: rgba(255, 255, 255, 0.2);
  }
  
  .sidebar-nav > .sidebar-brand {
    font-size: 1.3em;
    line-height: 3em;
  }

</style>
<title>Encore Airlines</title>
</head>
<body>

<div class=”page-header“>
<h2> Encore Airlines	<em><small>     Log On As Customer My Information. ID : ${sessionScope.id}</small></em></h2>
</div>
	
	<div id="page-wrapper">
   <!-- 사이드바 -->
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/cust/cust_searchTicket.jsp">Search Tickets</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/cust/cust_booking.jsp">Reservation</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/cust/cust_bookingCancel.jsp">Reservation Search and cancel</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/cust/cust_selfCheckIn.jsp">Self Check-In</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/cust/cust_boardAdd.jsp">Register Board</a>
		</li>

		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/cust/cust_myInfo.jsp">My Information</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/cust/cust_logOut.jsp">Logout</a>
		</li>
		
    </ul>
  </div>
  <!-- /사이드바 -->

  <!-- 본문 -->
	<div class="container" >
	<form action="${pageContext.request.contextPath }/MyInfo" method="post">
		<fieldset>
			<legend>My Information Check</legend>
			<div class="form-group">
						<label for="exampleInputEmail1">ID</label>
							 <input type="text" 
							class="form-control" id="id" name="id"
							aria-describedby="emailHelp"  value="${sessionScope.id}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> 
						<input value="${sessionScope.password}" type="password" class="form-control" id="password" name="password" >
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Name</label> 
						<input type="text" value="${sessionScope.name}"	class="form-control" id="name" name="name" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Passport Number</label> 
						<input type="text" class="form-control" id="passportNum" value="${sessionScope.passportNum}" name="passportNum" >
					</div>


					<!-- 	<a href="signUp.jsp">
				<button type="button" class="btn btn-primary">Join Us</button>
			</a> -->
					
					<div>
						<input type="submit" class="btn btn-primary" value="Save">
						<!-- <button type="button" class="btn btn-primary" OnClick="check()">Confirm -->

					</div>
		</fieldset>
	</form>
	</div>
  <!-- /본문 -->
</div>
	
</body>
</html>