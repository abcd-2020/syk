<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
//자바스트립트 코드 
function check(){
	if(f.id.value=="" || f.id.value==null){
		alert("id는 필수 입력 사항입니다.");
		return;
	}
	if(f.pwd.value=="" || f.pwd.value==null){
		alert("pwd는 필수 입력 사항입니다.");
		return;
	}
	if(f.name.value=="" || f.name.value==null){
		alert("name는 필수 입력 사항입니다.");
		return;
	}
	if(f.email.value=="" || f.email.value==null){
		alert("email는 필수 입력 사항입니다.");
		return;
	}
	f.submit();//서버로 전송
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/Join" method="post" name="f">
<table border="1">
<tr><th>id</th><td><input type="text" name="id"></td></tr>
<tr><th>pwd</th><td><input type="password" name="pwd"></td></tr>
<tr><th>name</th><td><input type="text" name="name"></td></tr>
<tr><th>email</th><td><input type="text" name="email"></td></tr>
<tr> <td colspan="2">
<input type="button" value="가입" onclick="check()">
</td></tr>
</table>
</form>
</body>
</html>