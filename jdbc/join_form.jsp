<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
//�ڹٽ�Ʈ��Ʈ �ڵ� 
function check(){
	if(f.id.value=="" || f.id.value==null){
		alert("id�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	if(f.pwd.value=="" || f.pwd.value==null){
		alert("pwd�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	if(f.name.value=="" || f.name.value==null){
		alert("name�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	if(f.email.value=="" || f.email.value==null){
		alert("email�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	f.submit();//������ ����
}
</script>
</head>
<body>
<h3>ȸ������</h3>
<form action="${pageContext.request.contextPath }/Join" method="post" name="f">
<table border="1">
<tr><th>id</th><td><input type="text" name="id"></td></tr>
<tr><th>pwd</th><td><input type="password" name="pwd"></td></tr>
<tr><th>name</th><td><input type="text" name="name"></td></tr>
<tr><th>email</th><td><input type="text" name="email"></td></tr>
<tr> <td colspan="2">
<input type="button" value="����" onclick="check()">
</td></tr>
</table>
</form>
</body>
</html>