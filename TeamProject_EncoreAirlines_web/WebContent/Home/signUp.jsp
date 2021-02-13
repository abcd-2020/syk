<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>

<style>
/* 사이드바 래퍼 스타일 */
#page-wrapper {
	padding-left: 250px;
}

#sidebar-wrapper {
	position: fixed;
	width: 250px;
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
	width: 250px;
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

.sidebar-nav>.sidebar-brand {
	font-size: 1.3em;
	line-height: 3em;
}
</style>
<title>Encore Airlines : Sign Up</title>
<script>
function check(){
	if(f.id.value=="" || f.id.value==null){
		alert("id는 필수 입력입니다.");
		return;
	}
	if(f.password.value=="" || f.password.value==null){
		alert("password는 필수 입력입니다.");
		return;
	}
	if(f.name.value=="" || f.name.value==null){
		alert("name은 필수 입력입니다.");
		return;
	}
	if(f.passportNumber.value=="" || f.passportNumber.value==null){
		alert("Passport Number 는 필수 입력입니다.");
		return;
	}
	f.submit();
}
</script>

</head>
<body>



	<div class=”page-header“>
		<h2>Encore Airlines</h2>
	</div>

	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="nav-item"><a class="nav-link" href="logIn.jsp">Log In</a></li>
				<li class="nav-item"><a class="nav-link" href="signUp.jsp">Sign	Up</a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<div class="container">
			<form name="f" action="${pageContext.request.contextPath }/Signup" 	method="post">
				<fieldset>
					<legend>Sign Up</legend>
					<div class="form-group">
						<label for="exampleInputEmail1">ID</label>
							 <input type="text"
							class="form-control" id="id" name="id"
							aria-describedby="emailHelp" placeholder="Enter ID">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Name</label> <input type="text"
							class="form-control" id="name" name="name" placeholder="Name">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Passport Number</label> <input
							type="text" class="form-control" id="passportNumber"
							name="passportNumber" placeholder="Passport Number">
					</div>


					<!-- 	<a href="signUp.jsp">
				<button type="button" class="btn btn-primary">Join Us</button>
			</a> -->

					<div class="form-check">
						<label class="form-check-label"> <input type="radio"
							class="form-check-input" name="type" id="rdCust" value="c">
							As a Customer
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="radio"
							class="form-check-input" name="type" id="rdEmp" value="e">
							As a Employee
						</label>
					</div>
					<div>
						<input type="button" class="btn btn-primary" OnClick="check()" value="Confirm">
						<!-- <button type="button" class="btn btn-primary" OnClick="check()">Confirm -->

					</div>
				</fieldset>
			</form>
		</div>

		<!-- /본문 -->
	</div>












	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
</body>
</html>