<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<jsp:include page="../base/head.jsp" />
<title>上传图片</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<jsp:include page="../base/css.jsp" />
</head>
<body>
<jsp:include page="../base/header.jsp" />
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