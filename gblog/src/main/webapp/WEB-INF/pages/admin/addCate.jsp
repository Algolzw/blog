<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>添加类别</title>
<%
	String path = request.getContextPath();
	String base = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort();
%>
<link rel="stylesheet"
	href="${path }/gblog/sources/fileinput/css/fileinput.css">
</head>
<body>
	<jsp:include page="${ path}/header.jsp"></jsp:include>
	<div class="content-wapper">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-lg-offset-3 col-md-offset-3">
					<form action="${path}/gblog/addcate" method="post" class="add-form" enctype="multipart/form-data">
						<fieldset>
							<legend>添加新类别</legend>
							<div class="">
								<input id="file-input" type="file" name="file" class="file-loading">
							</div>
							<div class="form-group">
								<label>类别名称</label> <input class="form-control" type="text" name="name"
									placeholder="name">
							</div>
							<div class="form-group">
								<label>类别说明</label>
								<textarea class="form-control place" name="comment"></textarea>
							</div>
							<div class="form-group pull-left">
								<label>显示顺序</label>
									<select class="form-control" name="mark">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
									</select>
							</div>
							<div class="form-group form-btn pull-right">
								<button type="submit" class="btn btn-default btn-primary">上传</button>
								<a href="#" class="btn btn-default">取消</a>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="${path }/gblog/js/addcate.js"></script>
	<script
		src="${path }/gblog/sources/fileinput/js/plugins/canvas-to-blob.js"></script>
	<script src="${path }/gblog/sources/fileinput/js/fileinput.js"></script>
	<script
		src="${path }/gblog/sources/fileinput/js/fileinput_locale_zh.js"></script>
</body>
</html>