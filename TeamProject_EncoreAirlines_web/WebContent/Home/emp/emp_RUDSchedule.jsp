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
	<div class="container" >

		<fieldset>
			<legend>Welcome to Encore Airlines</legend>
			<label>Manage flight schedules</label>
			<br/>
			<a href ="${pageContext.request.contextPath }/FlightSelect">View current schedule</a>
			<br/>
			<c:if test="${empty cur_list}">
			There's no flight schedule available<br/>
			</c:if>
			
			<c:if test="${not empty cur_list}">
			<table border="1" class="table table-hover">
			<tr><th scope="col">Flight No.</th>
			<th scope="col">Depart City</th>
			<th scope="col">Depart Time</th>
			<th scope="col">Arrive City</th>
			<th scope="col">Arrive Time</th>
			<th scope="col">Working Dates</th>
			<th scope="col">Seat Count</th>
			<th scope="col">Price</th>
			<th scope="col">State</th></tr>
			
				<c:forEach var="f" items="${cur_list}">
					<tr class="table-active">
<%-- 					<td><input type="checkbox" name="flight_num" id="flight_num" value="f.flight_num"></td> --%>
					<td><a href="${pageContext.request.contextPath}/FlightUpdate?flight_num=${f.flight_num}">
					${f.flight_num}</a></td>
					<td>${f.depart_city}</td>
					<td>${f.depart_time}</td>
					<td>${f.arrive_city}</td>
					<td>${f.arrive_time}</td>
					<td>${f.working_date}</td>
					<td>${f.seat_count}</td>
					<td>${f.price}</td>
					<td>${f.state}</td>
					</tr>
				</c:forEach>
				
<!-- 			<tr><th>Flight No.</th><td colspan =2><input type="text" name="flight_num"></td></tr> -->
<!-- 			<tr><td colspan = "2"> -->
<!-- 			<input type="submit" value="Update" > -->
<!-- 			<input type="button" value="Delete" onclick="del()"></td></tr> -->
			</table>
			</c:if>
		</fieldset>

	</div>
  <!-- /본문 -->
</div>
	
</body>
</html>