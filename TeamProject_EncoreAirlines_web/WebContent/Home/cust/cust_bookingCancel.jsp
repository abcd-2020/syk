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
</head>
<body>

<div class=”page-header“>
<h2> Encore Airlines	<em><small>     Log On As Customer Resevation Search and cancel. ID : ${sessionScope.id}</small></em></h2>
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
  	
		<form action="${pageContext.request.contextPath }/ReservationSearch" method="post">
		
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
				<c:if test="${not empty bookedlist }">
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
		<input type="submit" class="btn btn-primary" value="Booked Search">
		
		<br />
		<br />
		<br />
		<br />
		<br />
		</form>
	</div>
	
	<h2>Reservation Cancel</h2>
	<div class="form-group">
		<form action="${pageContext.request.contextPath }/ReservationCancel" method="post">
			<fieldset>
				<div class="form-group">
					<label for="exampleInputEmail1">Booked Number</label>
						 <input type="text"
						class="form-control" id="bookedNum" name="bookedNum" value="bookedNum"
						aria-describedby="emailHelp" placeholder="Enter Booked Number">
						
						<label for="exampleInputEmail1">Booked Seat Count</label>
						 <input type="text"
						class="form-control" id="seatCount" name="seatCount" value="seatCount"
						aria-describedby="emailHelp" placeholder="Enter Seat Count">
				</div>
				<div>
					<input type="submit" class="btn btn-primary" value="Reservation Cancel">
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