<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="with=device-width,initial-scale=1">
    <title>用户登录</title>
    <c:set var="path" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${path }/sources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path }/css/login.css">
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="">
            <div class="login-area">
                <form  method="post" class="">
                    <fieldset>
                        <legend>Login</legend>
                        <div class="form-group has-feedback">
                            <label class="control-label">用户名</label>
                            <input type="text" id="username" class="form-control" name="username" tabindex="1" placeholder="userame">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="control-label">密码</label>
                            <input type="password" id="password" class="form-control" name="password" tabindex="2" placeholder="password">
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <div class="login-btn">
                            <button class="btn btn-default btn-primary" id="submit" tabindex="3" type="button">登录</button>
                            <a href="#" class="btn btn-default btn-success" tabindex="4">注册</a>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="source">
                <p>by @<a href="#" class="">Algo</a><span class="pull-right">2016</span></p>
            </div>
        </div>
    </div>

</div>

<script src="${path }/sources/jquery.js"></script>
<script src="${path }/sources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path }/js/login.js"></script>
</body>
</html>
</html>