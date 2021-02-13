<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">
<title>Encore Airlines : My Infomation</title>
</head>
<body>

	<ul class="nav nav-pills flex-column">
		<li class="nav-item">
			<a class="nav-link active" href="#">Encore Airlines</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">My Infomation</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#" onclick="history.back()">Previous</a>
		</li>
	</ul>
	
	<div class="container" >
	<form>
		<fieldset>
			<div class="form-group">
				<label for="exampleInputEmail1">ID</label> 
				<input type="text" class="form-control" readonly="readonly" id="id" aria-describedby="emailHelp"> 
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label>
				 <input	type="password" class="form-control" id="pwd">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Name</label>
				 <input	type="text" class="form-control" id="name" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Passport Number</label>
				 <input	type="text" class="form-control" id="passportNumber">
			</div>
			
			<button type="submit" class="btn btn-primary">Update</button>
		<!-- 	<a href="signUp.jsp">
				<button type="button" class="btn btn-primary">Join Us</button>
			</a> -->
		</fieldset>
	</form>
	</div>
	
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>

</body>
</html>