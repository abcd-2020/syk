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
<script type = "text/javascript" >
/*javascript 함수 check() 정의. type=text/javascript 명시는 해도되고 안해도되고*/
function check(){
	alert("Are you sure to proceed?");
	br.submit(); //form에서 submit버튼 누르는것이랑 같음. 서버로 전송
}
</script>

</head>
<body>

<div class=”page-header“>
<h2> Encore Airlines	<em><small>     Log On As Administrator Manage Account. ID : ${sessionScope.id}</small></em></h2>
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
	<form action="${pageContext.request.contextPath }/AdminAccController" method="post">
		<fieldset>
			<legend>Encore Airlines DB Management</legend>
			<br/><label> Unused customer accounts: </label><br/>
			

			
			<c:if test="${empty mem_list }">
			${noIds}
			</c:if>
			
			<c:if test="${not empty mem_list }">
			<table border="1" class="table table-hover">
			<tr>
			<c:forEach var="m" items="${mem_list }">
			${m.id} / ${m.name} / ${m.passportNum} / ${m.type} / ${m.login_time} <br/>
			</c:forEach>
			</tr>
			
			<tr><th colspan ="11">Insert more ID's to delete [example]id1,id2,...</th>
			<tr><th>ID</th> <td colspan = "10"><input type = "text" name="ids_delete"></td> </tr>
			
			<tr><th colspan ="11">Insert ID's to keep [example]id1,id2,...</th>
			<tr><th>ID</th> <td colspan = "10"><input type = "text" name="ids_save"></td> </tr>
			
			<tr><th colspan="11"><input type="submit" value="submit" onclick="check()"></th></tr>
			
			</table>
			</c:if>
			
		</fieldset>
	</form>
	</div>
  <!-- /본문 -->
</div>
	
</body>
</html>