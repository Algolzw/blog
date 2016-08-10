<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>操作成功</title>
<%
	String fromPage = "";
	String toPage = "";
	if (request.getAttribute("fromPage") != null) {
		 fromPage = request.getAttribute("fromPage").toString();
	}
	
	if (request.getAttribute("toPage") != null) {
		toPage = request.getAttribute("toPage").toString();
	}
%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<link rel="stylesheet" href="${path }/css/index.css">
<style>
	.main-content{
		margin-top:190px;
	}
	
	.main-content h1{
		color:#FFF;
		margin:60px;
		text-align:center;
	}
	
	.main-content div{
		margin-right:10px;
		text-align:center;
	}
	.main-content div a{
		margin-right:16px;
	}
</style>
</head>
<body class="body">
	<c:import url="../../base/header.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div class="col-md-12 main-content">
				<h1>操作失败！</h1>
				
				<div>
					<a href="${path}/imagecate" class="btn btn-info">返回主页</a>
				</div>
				
			</div>
		</div>
	</div>

</body>
</html>