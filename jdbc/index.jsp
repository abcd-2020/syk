<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${joinMsg }
<h3><a href="${pageContext.request.contextPath }/Join">ȸ������</a>
<a href="${pageContext.request.contextPath }/Login">�α���</a>
<a href="${pageContext.request.contextPath }/MemList">�����</a></h3>
<c:if test="${not empty sessionScope.id }">
${sessionScope.id }�� �α��� ��
<h3><a href="${pageContext.request.contextPath }/MyInfo">������ ����</a>
<a href="${pageContext.request.contextPath }/Logout">�α׾ƿ�</a>
<a href="${pageContext.request.contextPath }/Out">Ż��</a>
<a href="${pageContext.request.contextPath }/addBoard">�Խ���</a></h3>
</c:if>
</body>
</html>