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
<h2> Encore Airlines	<em><small>     Log On As Customer Register Board. ID : ${sessionScope.id}</small></em></h2>
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
	<div class="form-group">
		<fieldset>
			<h3>List</h3>
			<a href="${pageContext.request.contextPath }/AddBoard">Write Board</a><br/>
			<c:if test="${empty list2 }">No Board</c:if>
			
			<c:if test="${not empty list2 }">
				<table border="1" class="table table-hover">
			  		<tr class="table-active"><th>No.</th><th>Title</th><th>Writer</th></tr>
			  		<c:forEach var="b" items="${list2 }">
			    	<tr class="table-active">
				  	<td>${b.board_id }</td>
				  	<td><a href="${pageContext.request.contextPath }/BoardRead?board_id=${b.board_id }">${b.title }</a></td>
				  	<td>${b.writer }</td>
			    	</tr>
			  		</c:forEach>
				</table>
			</c:if>
		</fieldset>
		</div>
	</div>
  <!-- /본문 -->
</div>
	
</body>
</html>