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
<script type="text/javascript">
function del(){
	flag = confirm("are you sure to delete?");
	if(flag){
		//javascript page이동
		location.href="${pageContext.request.contextPath }/FlightDelete?flight_num=n.flight_num";
	}
	else{
		alert("cancel deletion")
	}
}
</script>
</head>
<body>

<div class=”page-header“>
<h2> Encore Airlines	<em><small>     Log On As Airlines Staff Search/Update/Delete Schedule. ID : ${sessionScope.id}</small></em></h2>
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
			<form action="${pageContext.request.contextPath }/FlightUpdate" method="post" name="n">
				<fieldset>
					<legend>Update Flight Ticket Schedule</legend>
					<div class="form-group">
						<label for="exampleInputEmail1">Flight Number</label>
							 <input type="text"
							class="form-control" id="flight_num" name="flight_num"
							aria-describedby="emailHelp" value="${f.flight_num}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Depart City</label> <input
							type="text" class="form-control" id="departCity"
							name="departCity" value="${f.depart_city}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Depart Time</label> <input type="text"
							class="form-control" id="departTime" name="departTime" value="${f.depart_time }">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Arrive City</label> <input
							type="text" class="form-control" id="arriveCity"
							name="arriveCity" value="${f.arrive_city }">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Arrive Time</label>
							 <input type="text"
							class="form-control" id="arriveTime" name="arriveTime"
							aria-describedby="emailHelp" value="${f.arrive_time}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Working Date</label>
							 <input type="text"
							class="form-control" id="workingDate" name="workingDate"
							aria-describedby="emailHelp" value="${f.working_date }">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Seat Count</label>
							 <input type="text"
							class="form-control" id="seatCount" name="seatCount"
							aria-describedby="emailHelp" value="${f.seat_count }">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Price</label>
							 <input type="text"
							class="form-control" id="price" name="price"
							aria-describedby="emailHelp" value="${f.price }">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">State</label>
							 <input type="text"
							class="form-control" id="state" name="state"
							aria-describedby="emailHelp" value="${f.state }">
					</div>

					<div>
						
						<input type="submit" class="btn btn-primary" value="Save">
						<input type="button" class="btn btn-primary" value="delete" onclick="del()">
						<!-- <button type="button" class="btn btn-primary" OnClick="check()">Confirm -->
					</div>
				</fieldset>
			</form>
		</div>
  <!-- /본문 -->
</div>
	
</body>
</html>