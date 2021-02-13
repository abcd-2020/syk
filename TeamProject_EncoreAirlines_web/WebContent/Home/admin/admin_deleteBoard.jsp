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
		<fieldset>
			<legend>Encore Airlines DB Management</legend>
			<label> Manage Customer Q&A Board </label>
			<form action="${pageContext.request.contextPath }/AdminBoardController" method="post" name="br">
			
			<c:if test="${empty bad_board_list }">
			${noBoards}
			</c:if>
			
			<c:if test="${empty bad_reply_list }">
			${noReplies}
			</c:if>
			
			<c:if test="${not empty bad_board_list }">
			<table border="1" class="table table-hover">
			<tr class="table-active">
			<c:forEach var="b" items="${bad_board_list }">
			<tr class="table-active"><th>Board ID</th> <td><input type = "text" name="board_id" value="${b.board_id}" readonly></td> </tr>
			<tr class="table-active"><th>Writer ID</th> <td><input type = "text" name="writer" value="${b.writer}" readonly></td> </tr>
			<tr class="table-active"><th>Write Date</th> <td><input type = "text" name="w_date" value="${b.w_date}" readonly></td> </tr>
			<tr class="table-active"><th>Title</th> <td><input type = "text" name="title" value="${b.title}" readonly></td> </tr>
			<tr class="table-active"><th>Content</th> <td><textarea rows="15" cols="15" name="content" readonly>${b.content}</textarea></td> </tr>
			</c:forEach>
			</tr></table></c:if>
			
			<c:if test="${not empty bad_reply_list }">
			<table border="1" class="table table-hover">
			<tr class="table-active">
			<c:forEach var="r" items="${bad_reply_list }">
			<tr class="table-active"><th>Reply ID</th> <td><input type = "text" name="reply_id" value="${r.reply_id}" readonly></td> </tr>
			<tr class="table-active"><th>Board ID</th> <td><input type = "text" name="board_id" value="${r.board_id}" readonly></td> </tr>
			<tr class="table-active"><th>Comments</th> <td><input type = "text" name="comments" value="${r.comments}" readonly></td> </tr>
			</c:forEach>
			</tr></table></c:if>
			<div style="float:right">
			<input class="btn btn-info" type="button" value="Delete" onclick="check()">
			</div>
			</form>
		</fieldset>
	</div>
	</div>
	
</body>
</html>