<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath }"/>
<div class="nav-layer navbar-fixed-top"></div>
	<div class="container">
		<div class="row">
			<div class="headnav-wapper">
				<div class="col-lg-10 col-lg-push-1">

					<div class="navbar navbar-fixed-top navbar-inverse" id="nav-top" role="navigation">
						<div class="navbar-header">
							<a href="${path }/imagecate" class="navbar-brand">gblog</a>
							<button class="btn btn-primary navbar-toggle"
									data-toggle="collapse" data-target=".navbar-responsive-collapse"
									type="button">
								<span class="sr-only">navigation</span> <span class="icon-bar"></span>
								<span class="icon-bar"></span> <span class="icon-bar"></span>
							</button>
						</div>
						<div class="collapse navbar-collapse navbar-responsive-collapse">
							<ul class="nav navbar-nav">
								<li><a href="${path }/imagecate">image</a></li>
								<li><a href="#">music</a></li>
								<li><a href="#">article</a></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li><a href="${path }/login">sign in</a></li>
								<li><a href="#" class="btn btn-primary">sign up</a></li>
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
	</div>
