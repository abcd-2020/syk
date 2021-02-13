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
<script type="text/javascript">
function del(){
	flag = confirm("Are you sure that you want to delete the board?");
	if(flag){
		//자바스크립트 페이지 이동
		location.href="${pageContext.request.contextPath }/BoardDel?board_id=${b.board_id }";
	}else{
		alert("Deletion has been cancelled");
	}
}
</script>
</head>
<body>

<div class=”page-header“>
<h2> Encore Airlines	<em><small>     Log On As Customer Board list Search/Update/delete. ID : ${sessionScope.id}</small></em></h2>
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
		<c:if test="${sessionScope.id!=b.writer }">
  			<c:set var="str"></c:set>
		</c:if>
		<h3>Details</h3>
		<form action="${pageContext.request.contextPath }/BoardRead" method="post">
			<table border="1">
				<tr>
  					<th>No.</th><td><input type="text" name="board_id" value="${b.board_id }" readonly></td>
				</tr>
				<tr>
				  <th>Writer</th><td><input type="text" name="writer" value="${b.writer }" readonly></td>
				</tr>
				<tr>
				  <th>Written date</th><td><input type="text" value="${b.w_date }" readonly></td>
				</tr>
				<tr>
				  <th>Title</th><td><input type="text" name="title" value="${b.title }" ${str }></td>
				</tr>
				<tr>
				  <th>Content</th><td><textarea rows="20" cols="45" name="content" ${str }>${b.content }</textarea></td>
				</tr>
				<c:if test="${sessionScope.id==b.writer }">
				  <tr>
		    <td colspan="2">
		  		<input type="submit" value="Edit">
		  		<input type="button" value="Delete" onclick="del()">
		    </td>
		  </tr>
		</c:if>
		</table>
</form>
	</div>
  <!-- /본문 -->
</div>
	
</body>
</html>