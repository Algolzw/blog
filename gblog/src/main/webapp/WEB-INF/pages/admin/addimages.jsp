<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>上传图片</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" href="${path }/static/sources/fileinput/css/fileinput.css">
</head>
<body>
<c:import url="${path }/WEB-INF/pages/header.jsp"></c:import>
	<div class="content-wapper">
		<div class="container-fluid">
		<div class="row">
			<div class="col-md-8 col-md-offset-2" style="border:1px solid #FFF;">
				<form class="addimages">
					<fieldset>
						<div class="">
							
						</div>
					</fieldset>
				</form>
			</div>
		</div>
			
		</div>
	</div>
	<script type="text/javascript" src="${path }/static/sources/fileinput/js/plugins/canvas-to-blob.js"></script>
	<script type="text/javascript" src="${path }/static/sources/fileinput/js/fileinput.js"></script>
	<script type="text/javascript" src="${path }/static/sources/fileinput/js/fileinput_locale_zh.js"></script>
	<script type="text/javascript">
		$(document).on("ready",function(){
			
		});
	</script>
</body>
</html>