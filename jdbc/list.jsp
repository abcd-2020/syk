<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
button{
background-color:yellow;
}
#x{
background-color:orange;
}
.y{
color:blue;
}
</style>
</head>
<body>
<h3>members</h3>
<c:if test="${empty list }">
등록된 멤버가 없습니다.
</c:if>
<c:if test="${not empty list }">
<table border="1">
  <tr><th>id</th><th>pwd</th><th>name</th><th>email</th></tr>
  <c:forEach var="m" items="${list }">
    <tr>
      <td style="color:red;width:100px">${m.id }</td><td>${m.pwd }</td><td class="y">${m.name }</td><td>${m.email }</td>
    </tr>
  </c:forEach>
</table>
</c:if>
<button>가나다</button>
<button id="x">가나다</button>
<button>가나다</button>
</body>
</html>