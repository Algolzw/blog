<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>添加类别</title>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="${path }/sources/fileinput/css/fileinput.css">
</head>
<body>
	<c:import url="../header.jsp" />
	<div class="content-wapper">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-lg-offset-3 col-md-offset-3">
					<sf:form action="${path}/imagecate/save" method="post" commandName="piccate" class="add-form" enctype="multipart/form-data">
						<fieldset>
							<legend>添加新类别</legend>
							<div class="">
								<input id="file-input" type="file" name="path" class="file-loading">
							</div>
							<div class="form-group">
								<label>类别名称</label> 
									<sf:input path="name" id="name" cssClass="form-control" placeholder="name" />
							</div>
							<div class="form-group">
								<label>类别说明</label>
								<sf:textarea class="form-control place" path="comment" />
							</div>
							<div class="form-group pull-left">
								<label>显示顺序</label>
									<sf:select class="form-control" path="mark">
										<sf:option value="1">1</sf:option>
										<sf:option value="2">2</sf:option>
										<sf:option value="3">3</sf:option>
										<sf:option value="4">4</sf:option>
										<sf:option value="5">5</sf:option>
										<sf:option value="6">6</sf:option>
										<sf:option value="7">7</sf:option>
										<sf:option value="8">8</sf:option>
									</sf:select>
							</div>
							<div class="form-group form-btn pull-right">
								<input type="submit" class="btn btn-default btn-primary" value="上传" />
								<a href="#" class="btn btn-default">取消</a>
							</div>
						</fieldset>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<script src="${path }/js/addcate.js"></script>
	<script
		src="${path }/sources/fileinput/js/plugins/canvas-to-blob.js"></script>
	<script src="${path }/sources/fileinput/js/fileinput.js"></script>
	<script
		src="${path }/sources/fileinput/js/fileinput_locale_zh.js"></script>
</body>
</html>