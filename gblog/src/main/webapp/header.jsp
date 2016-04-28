<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>
<link rel="stylesheet"
	href="${path }/gblog/sources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${path }/gblog/css/style.css">
<!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
#nav-top {
	width: auto;
	margin: 0 auto;
	padding: 0 200px;
}

@media ( max-width : 1500px) {
	#nav-top {
		width: auto;
		margin: 0 auto;
		padding-left: 0;
		padding-right: 20px;
	}
}

@media ( max-width : 768px) {
	#nav-top {
		width: auto;
		margin: 0 auto;
		padding: 0;
	}
}

#wapper {
	width: 100%;
}

#nav-top .navbar-brand {
	font: bold 18px "微软雅黑", arial, sans-serif;
	width: auto;
	margin-top:-4px;
}

.navbar-responsive-collapse {
	width: auto;
	margin-right:20px!important;
}

ul.navbar-nav li {
	width: auto;
	text-align: center;
}

ul.navbar-right li {
	width: auto;
}

ul.navbar-right li a {
	font-weight: 200;
	font-size: 15px;
	color: #DDDDD1 !important;
}

ul.navbar-nav a {
	font: bold 16px "微软雅黑", arial, sans-serif;
}

#nav-top ul.navbar-nav a:hover {
	background-color: #444442;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="headnav-wapper" id="wapper">
				<div class="navbar navbar-fixed-top navbar-inverse" id="nav-top"
					role="navigation">
					<div class="navbar-header">
						<a href="${path }/gblog" class="navbar-brand">gblog</a>
						<button class="btn btn-primary navbar-toggle"
							data-toggle="collapse" data-target=".navbar-responsive-collapse"
							type="button">
							<span class="sr-only">navigation</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse navbar-responsive-collapse">
						<ul class="nav navbar-nav">
							<li><a href="#">image</a></li>
							<li><a href="#">music</a></li>
							<li><a href="#">article</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">sign in</a></li>
							<li><a href="#">sign up</a></li>
						</ul>
						<form action="#" class="navbar-form navbar-right">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="search">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default">
											<span class="glyphicon glyphicon-search"></span>
										</button>
									</span>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${path }/gblog/sources/jquery.js"></script>
	<script src="${path }/gblog/sources/jquery.color-2.1.2.js"></script>
	<script src="${path }/gblog/sources/bootstrap/js/bootstrap.js"></script>
</body>
</html>