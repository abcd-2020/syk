<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    width: 300px;
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
    width: 300px;
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
<h2> Encore Airlines	<em><small>     Log On As Airlines Staff Check-In. ID : ${sessionScope.id}</small></em></h2>
</div>
	
	<div id="page-wrapper">
  <!-- 사이드바 -->
   <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/emp/emp_addSchedule.jsp">Add Schedule</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/emp/emp_RUDSchedule.jsp">Search/Update/Delete Schedule</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/emp/emp_checkIn.jsp">Check-In</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath }/BoardList">Board List Search</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/emp/emp_myInfo.jsp">My Information</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/emp/emp_logOut.jsp">Logout</a>
		</li>
		
    </ul>
  </div>
  <!-- /사이드바 -->

  <!-- 본문 -->
	<div class="container">
  
   <h2>Entire Booked List</h2>
  	<div class="form-group">
  	
		<form action="${pageContext.request.contextPath }/TicketCheckIn" method="post"> 
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">BOOKED_NUM</th>
					<th scope="col">STATE</th>
					<th scope="col">FLIGHT_NUM</th>
					<th scope="col">ID</th>
					<th scope="col">SEAT_COUNT</th>
				</tr>
			</thead>
			
			<tbody>
				<c:if test="${empty bookedlist}">
					Do not find Searched Infomation.
				</c:if>
				<c:if test="${not empty bookedlist}">
					<c:forEach var="b" items="${bookedlist}">
						<tr class="table-active">
							<td>${b.booked_num}</td>
							<td>${b.state}</td>
							<td>${b.flight_num}</td>
							<td>${b.id}</td>
							<td>${b.seat_count}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		
	<!-- 	<div class="form-group">
			 <h6>Input City Name.</h6>
 			 <input type="text" value="searchName" class="form-control" placeholder="Input No." name="searchName" id="searchName">
		</div>
		<div class="form-group">
		     <h6>Input Start Date. ex>2021-01-01 01:01</h6>
 			 <input type="text" value="startTime" class="form-control" placeholder="Input No." name="startTime" id="startTime">
 			 <h6>Input Start Name. ex>2021-01-01 01:01</h6>
 			 <input type="text" value="endTime" class="form-control" placeholder="Input No." name="endTime" id="endTime">
		</div> -->
		<input name="type" id="type" type="submit" class="btn btn-info" value="Search">
		<!-- <input name="type" id="type" type="submit" class="btn btn-info" value="DepartTime">
		<input name="type" id="type" type="submit" class="btn btn-info" value="ArriveCity">
		<input name="type" id="type" type="submit" class="btn btn-info" value="ArriveTime"> -->
		<!-- <button type="button" class="btn btn-secondary">Secondary</button> -->
		<br />
		<br />
		<br />
		<br />
		<br />
		</form>
	</div>
	
	<h2>Ticket Check In</h2>
	<div class="form-group">
		<form action="${pageContext.request.contextPath }/TicketCheckIn2" method="post">
			<fieldset>
				<div class="form-group">
						<label for="exampleInputEmail1">Flight Num</label>
						 <input type="text"
						class="form-control" id="flightNum" name="flightNum" value="flightNum"
						aria-describedby="emailHelp" placeholder="Enter Flight Numer">
						
						<label for="exampleInputEmail1">Customer ID</label>
						 <input type="text"
						class="form-control" id="customer_id" name="customer_id" value="customer_id"
						aria-describedby="emailHelp" placeholder="Enter Customer ID">
				</div>
				<div>
					<input type="submit" class="btn btn-primary" value="Check In">
					<!-- <button type="button" class="btn btn-primary" OnClick="check()">Confirm -->
				</div>
			</fieldset>
		</form>
	</div>
		
		
	
  </div>
	
  <!-- /본문 -->
</div>
	
</body>
</html>