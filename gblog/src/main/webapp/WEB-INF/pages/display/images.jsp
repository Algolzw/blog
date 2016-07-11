<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>${cate.name }</title>
<c:if test="${empty cate}">
	<c:redirect url="images"></c:redirect>
</c:if>
<c:set var="path" value="${pageContext.request.contextPath}" />
</head>
<body style="height:auto;background-size:cover;background:#222;">
	<c:import url="../header.jsp"></c:import>
	<div class="content-wapper container">
		<div class="content-center">
			<div class="content-header">
				<div class="btn-group pull-right btn-group-bordered">
					<a class="btn btn-default actived">热度</a> <a
						class="btn btn-default">最新</a>
				</div>
				<div class="cate-title">
					<h3>
						<i class="mark-title glyphicon glyphicon-tags"></i>${cate.name }<label>${cate.comment }</label>
					</h3>
				</div>
			</div>
			<div class="content-core">
				<div class="row">
				<c:forEach var="image" items="${images }" >
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt="${image.comment }"
									src="${path }/${image.urlPath}"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#"><c:out value="${image.name }" /></a>
									<span class="pull-right"><c:out value="${image.hot }" /></span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/3.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/2.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/1.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/3.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/2.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/3.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/2.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/1.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/3.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/2.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/1.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/3.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/2.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/3.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="imgitem col-md-3 col-sm-6">
						<div class="row">
							<div class="img-holder col-md-12">
								<a href=""><img class="img-item" alt=""
									src="${path }/static/images/2.jpg"> <span class="layer"></span>
								</a>
								<div class="img-footer">
									<a href="#">新春</a>
									<span class="pull-right">12</span>
									<span class="pull-right img-hot"><i class="glyphicon glyphicon-heart"></i></span>
									
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>
	<script src="${path }/static/js/images.js"></script>
</body>
</html>