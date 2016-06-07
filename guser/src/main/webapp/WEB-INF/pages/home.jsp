<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
</head>
<body>
<h1>  </h1>
	<form action="${path }/user/login" method="post">
		<input type="text" name="username" placeholder="username"><br><br>
		<input type="password" name="password" placeholder="password"><br><br>
		<input type="submit" value="login" >
	</form>
</body>
</html>