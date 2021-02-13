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

<!-- <script type="text/javascript">
function del(){
	flag = confirm("정말삭제하시겠습니까?");
	if(flag){
		//자바스크립트 페이지 이동
		location.href="${pageContext.request.contextPath }/ReservationCancel?num=${b.num }";
	}else{
		alert("삭제 취소");
	}
}
</script> -->


</head>
<body>

<div class=”page-header“>
<h2> Encore Airlines	<em><small>     Log On As Customer Reservation. ID : ${sessionScope.id}</small></em></h2>
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
  
  <div class="container">
  
   <h2>Found List</h2>
  	<div class="form-group">
  	
		<form action="${pageContext.request.contextPath }/SearchTicketList2" method="post">
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">FLIGHT_NUM</th>
					<th scope="col">DEPART_CITY</th>
					<th scope="col">DEPART_TIME</th>
					<th scope="col">ARRIVE_CITY</th>
					<th scope="col">ARRIVE_TIME</th>
					<th scope="col">WORKING_DATE</th>
					<th scope="col">SEAT_COUNT</th>
					<th scope="col">PRICE</th>
					<th scope="col">STATE</th>
				</tr>
			</thead>
			
			<tbody>
				<c:if test="${empty orderedlist}">
					Do not find Searched Infomation.
				</c:if>
				<c:if test="${not empty orderedlist }">
					<c:forEach var="m" items="${orderedlist}">
						<tr class="table-active">
						
							<td>${m.flight_num}</td>
							<td>${m.depart_city}</td>
							<td>${m.depart_time}</td>
							<td>${m.arrive_city}</td>
							<td>${m.arrive_time}</td>
							<td>${m.working_date}</td>
							<td>${m.seat_count}</td>
							<td>${m.price}</td>
							<td>${m.state}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		
		<div class="form-group">
			 <h6>Input City Name.</h6>
 			 <input type="text" value="searchName" class="form-control" placeholder="Input No." name="searchName" id="searchName">
		</div>
		<div class="form-group">
		     <h6>Input Start Date. ex>2021-01-01 01:01</h6>
 			 <input type="text" value="startTime" class="form-control" placeholder="Input No." name="startTime" id="startTime">
 			 <h6>Input Start Name. ex>2021-01-01 01:01</h6>
 			 <input type="text" value="endTime" class="form-control" placeholder="Input No." name="endTime" id="endTime">
		</div>
		<input name="type" id="type" type="submit" class="btn btn-info" value="DepartCity">
		<input name="type" id="type" type="submit" class="btn btn-info" value="DepartTime">
		<input name="type" id="type" type="submit" class="btn btn-info" value="ArriveCity">
		<input name="type" id="type" type="submit" class="btn btn-info" value="ArriveTime">
		<!-- <button type="button" class="btn btn-secondary">Secondary</button> -->
		<br />
		<br />
		<br />
		<br />
		<br />
		</form>
	</div>
	
	<h2>Reservation</h2>
	<div class="form-group">
		<form action="${pageContext.request.contextPath }/Reservation" method="post">
			<fieldset>
				<div class="form-group">
					<label for="exampleInputEmail1">Flight Num()</label>
						 <input type="text"
						class="form-control" id="flightNum" name="flightNum"
						aria-describedby="emailHelp" placeholder="Enter Flight Numer">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Number of Seat </label> 
					<input 	type="text" class="form-control" id="seatNum"
						name="seatNum" placeholder="Number of Seat">
				</div>
				<div>
					<input type="submit" class="btn btn-primary" value="Book">
					<input type="button" onclick="del()" class="btn btn-primary" value="Cancel">
					<!-- <button type="button" class="btn btn-primary" OnClick="check()">Confirm -->
				</div>
			</fieldset>
		</form>
		<form></form>
	</div>
		
		
	
  </div>
	
  <!-- /본문 -->
</div>
	
</body>
</html>