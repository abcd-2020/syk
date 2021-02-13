<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<h2> Encore Airlines	<em><small>     Log On As Administrator Manage board. ID : ${sessionScope.id}</small></em></h2>
</div>
	
	<div id="page-wrapper">
  <!-- 사이드바 -->
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/admin/admin_account.jsp">Manage Account</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/admin/admin_board.jsp">Manage board</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/Home/admin/admin_logOut.jsp">Logout</a>
		</li>
		
    </ul>
  </div>
  <!-- /사이드바 -->

  <!-- 본문 -->
	<div class="container" >
		<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<form action="${pageContext.request.contextPath }/AdminBoardController" method="get">
		<fieldset>
			<legend>Encore Airlines DB Management</legend>
			<label> Manage Customer Q&A Board </label>
			<br/>click to proceed with Board management<br/>
				<br />
					<br />
						<br />
			<div style="float:right">
			
			
			<input type="submit" value="proceed" class="btn btn-primary">
<!-- 			<div class="form-group"> -->
<!-- 				<label for="exampleInputEmail1">ID</label>  -->
<!-- 				<input type="text" class="form-control" id="inputID" name="id" aria-describedby="emailHelp" placeholder="Enter ID">  -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="exampleInputPassword1">Password</label> -->
<!-- 				 <input	type="password" class="form-control" id="exampleInputPassword1"	name="password" placeholder="Password"> -->
<!-- 			</div> -->
<!-- 			<button type="submit" class="btn btn-primary">Log In</button> -->
<!-- 			<a href="signUp.jsp"> -->
<!-- 				<button type="button" class="btn btn-primary">Join Us</button> -->
<!-- 			</a> -->
		</div>
		</fieldset>
	</form>
	</div>
  <!-- /본문 -->
</div>
	
</body>
</html>