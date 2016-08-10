<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath }"/>
    <jsp:include page="base/head.jsp"/>
    <title>首页</title>
    <jsp:include page="base/css.jsp"/>
    <link rel="stylesheet" href="${path}/static/sources/plugins/justifiedGallery/justifiedGallery.min.css">
    <link rel="stylesheet" href="${path}/static/css/style.css">
    <link rel="stylesheet" href="${path }/static/css/index.css">
</head>
<body>
<jsp:include page="base/header.jsp"/>

<div class="wapper">
    <div class="carousel" id="myCarousel" data-ride="carousel">

        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
            <li data-target="#myCarousel" data-slide-to="4"></li>
        </ol>
        <div class="carousel-inner">

            <div class="item ei_imgLiquid active">
                <img src="${path}/static/images/cover/home-marquee.jpg" alt="slide1">
            </div>
            <div class="item ei_imgLiquid">
                <img src="${path}/static/images/cover/cover_1.jpg" alt="slide2">
            </div>
            <div class="item ei_imgLiquid">
                <img src="${path}/static/images/cover/cover_3.jpg" alt="slide3">
            </div>
            <div class="item ei_imgLiquid">
                <img src="${path}/static/images/cover/on-top-of-the-world.jpg" alt="slide3">
            </div>
            <div class="item ei_imgLiquid">
                <img src="${path}/static/images/cover/wildsee-pizol.jpg" alt="slide3">
            </div>
        </div>

        <div class="carousel-layer clearfix"></div>

        <div class="carousel-content">
            <div class="carousel-content-intro">
                <h1>S.H.A.R.E</h1>
                <p>让生活更精彩,让世界与众不同.</p>
                <p>Make your life fantastic.Make the world different.</p>
            </div>
        </div>

        <%--<a class="carousel-control left" href="#myCarousel" role="button" data-slide="prev">--%>
        <%--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
        <%--<span class="sr-only">Previous</span>--%>
        <%--</a>--%>
        <%--<a href="#myCarousel" class="carousel-control right" role="button" data-slide="next">--%>
        <%--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
        <%--<span class="sr-only">Next</span>--%>
        <%--</a>--%>
    </div>

    <section class="index-fromone">
        <div class="container-fluid slogan">
            <article>
                <h2>Photo & Store</h2>
                <site>
                    <p>
                        生活没有低谷，只有蓄势待发；自由没有界限，更远的旅行只有一步之遥.
                    </p>
                    <p class="pull-right">——by 小米</p>
                </site>
            </article>
        </div>
        <div class="container-fluid fromone-bucket">
            <div class="row">
                <div class="col-md-4">
                    <div class="imgLiquid center-block">
                        <img src="${path}/static/tmp/stock-photo-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="imgLiquid center-block">
                        <img src="${path}/static/tmp/stock-photo-2.jpg" alt="">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="imgLiquid center-block">
                        <img src="${path}/static/tmp/stock-photo-3.jpg" alt="">
                    </div>
                </div>

            </div>
        </div>
    </section>

    <%--<hr class="divider"/>--%>

    <section class="index-fromone">
        <div class="container-fluid slogan">
            <article>
                <h2>Design & Inspiration</h2>
                <p>
                    世上的喜剧不需要金钱就能产生,世上的悲剧大半和金钱脱不了关系
                </p>
                <p class="pull-right">——by 三毛</p>
            </article>
        </div>
        <div class="inspiration ei_imgLiquid">
            <img src="${path}/static/tmp/portfolio.jpg" alt="">
        </div>
    </section>

    <section class="index-fromone">
        <div class="container-fluid slogan">
            <article>
                <h2>Explore And Share Photos</h2>
                <site>
                    <p>
                        寂静在喧嚣里低头不语,沉默在黑夜里与目光交接,于是我们看错了世界,却说世界欺骗了我们.
                    </p>
                    <p class="pull-right">——by Tagore</p>
                </site>
            </article>
        </div>
    </section>


    <section class="index-fromone wall">
        <header class="photo-wall-title">
            照片墙
        </header>
        <div class="photo-wall">
            <div class="container-fluid">
                <div class="photo-wall-main">
                    <div>
                        <a href="${path}/static/tmp/stock-photo-4.jpg">
                            <img src="${path}/static/tmp/stock-photo-4.jpg" alt="stock-photo">
                        </a>
                    </div>
                    <div>
                        <a href="${path}/static/tmp/stock-photo-5.jpg">
                            <img src="${path}/static/tmp/stock-photo-5.jpg" alt="stock-photo">
                        </a>
                    </div>
                    <div>
                        <a href="${path}/static/tmp/stock-photo-6.jpg">
                            <img src="${path}/static/tmp/stock-photo-6.jpg" alt="stock-photo">
                        </a>
                    </div>
                    <div>
                        <a href="${path}/static/tmp/stock-photo-7.jpg">
                            <img src="${path}/static/tmp/stock-photo-7.jpg" alt="stock-photo">
                        </a>
                    </div>
                    <div>
                        <a href="${path}/static/tmp/stock-photo-8.jpg">
                            <img src="${path}/static/tmp/stock-photo-8.jpg" alt="stock-photo">
                        </a>
                    </div>
                    <div>
                        <a href="${path}/static/tmp/stock-photo-9.jpg">
                            <img src="${path}/static/tmp/stock-photo-9.jpg" alt="stock-photo">
                        </a>
                    </div>
                    <div>
                        <a href="${path}/static/tmp/stock-photo-10.jpg">
                            <img src="${path}/static/tmp/stock-photo-10.jpg" alt="stock-photo">
                        </a>
                    </div>
                    <div>
                        <a href="${path}/static/tmp/stock-photo-11.jpg">
                            <img src="${path}/static/tmp/stock-photo-11.jpg" alt="stock-photo">
                        </a>
                    </div>
                </div>


            </div>
        </div>
    </section>

</div>


<%--<div class="container content-wapper wapper-index">--%>
<%--<div class="row">--%>
<%--<div id="catesList">--%>
<%--<ul class="list-inline">--%>
<%--<c:forEach var="cate" items="${cates }">--%>
<%--<li class="">--%>
<%--<div class="cate-block">--%>
<%--<div class="img">--%>
<%--<img alt="${cate.name }" class="img-responsive"--%>
<%--src="${path }/${cate.cover }">--%>
<%--<div class="info-wapper">--%>
<%--<a class="remark" href="${path }/image/imagesincate/${cate.cateId}"> <span--%>
<%--class="cate-name"> <c:out--%>
<%--value="${cate.name }"/>--%>
<%--</span><br> <span class="cate-comment"><c:out--%>
<%--value="${cate.comment }"/></span>--%>
<%--</a>--%>
<%--<div class="mask"></div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<jsp:include page="base/js.jsp"/>
<script src="${path}/static/sources/plugins/justifiedGallery/jquery.justifiedGallery.min.js"></script>
<script src="${path}/static/sources/plugins/photoset/jquery.colorbox.js"></script>
<script src="${path }/static/js/index.js"></script>
</body>
</html>