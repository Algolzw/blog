<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>首页</title>
<c:set var="path" value="${pageContext.request.contextPath }" />

<link rel="stylesheet" href="${path }/css/index.css">
</head>
<body class="body">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container content-wapper wapper-index">
		<div class="row">
			<div id="catesList">
				<ul class="list-inline">
					<c:forEach var="cate" items="${cates }">
						<li class="">
							<div class="cate-block">
								<div class="img">
									<img alt="${cate.name }" class="img-responsive"
										src="${path }/${cate.cover }">
									<div class="info-wapper">
										<a class="remark" href="${path }/image/imagesincate/${cate.cateId}"> <span class="cate-name"> <c:out
													value="${cate.name }" />
										</span><br> <span class="cate-comment"><c:out
													value="${cate.comment }" /></span>
										</a>
										<div class="mask"></div>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<script src="${path }/js/index.js"></script>

</body>
</html>