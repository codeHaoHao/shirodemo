<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ tagliburi="http://shiro.apache.org/tags" prefix="shiro" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta content="" name="description">
        <meta content="" name="keywords">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="HandheldFriendly" content="true">
        <meta content="telephone=no" name="format-detection">
        <!-- favicon -->
        <link rel="shortcut icon" type="assets/indexFilder/image/png" href="favicon.png" />
        <!--[if (gt IE 9)|!(IE)]><!-->
        <!-- custom CSS -->
        <link href="assets/indexFilder/css/main.css" rel="stylesheet" type="text/css" />
        <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		<script src="https://cdn.bootcss.com/vue-resource/1.5.1/vue-resource.js"></script>
		<!-- All JavaScript libraries -->
		<script src="assets/indexFilder/js/jquery.min.js"></script>
		<script src="assets/indexFilder/js/bootstrap.min.js"></script>
		<!-- Custom JavaScript -->
        <script src="assets/indexFilder/js/main.js"></script>
        <!-- END custom CSS -->
        <!--<![endif]-->
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
        
        <title>News</title>
    </head>
    <body>
        <!-- Header -->
        <header id="header" class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="wrap-logo">
                                <a href="${pageContext.request.contextPath }/index.action" class="logo"></a>
                            </div>
                        </div>
                        <div class="col-sm-offset-2 col-md-offset-5 col-sm-6 col-md-4 hidden-xs">
                        
                        
                              <!-- 用户没有登录时显示 -->
                            <shiro:notAuthenticated>
                            <!-- 用户rememberMe时 -->
                        	<shiro:user>
                        		<div class="col-xs-4 col-sm-5">
                            <a href="login.jsp">
                            	<div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active"><shiro:principal property="name"/></em>
                                    </div>
                                </div>
                            </a>
                            </div>
                            <div class="col-xs-4 col-sm-5">
                            <a href="${pageContext.request.contextPath }/logout.action">
                                <div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">退出</em>
                                    </div>
                                </div>
                                </a>
                                </div>
                        	</shiro:user>
                        	<shiro:guest>
                            <div class="col-xs-4 col-sm-5">
                            
                            <a href="login.jsp">
                            	<div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">登录</em>
                                    </div>
                                </div>
                            </a>
                            </div>
                            <div class="col-xs-4 col-sm-5">
                            <a href="sign-up.jsp">
                                <div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">注册</em>
                                    </div>
                                </div>
                             </a>
                             </div>
                             </shiro:guest>
                            </shiro:notAuthenticated>
                            <!-- 用户登录后显示 -->
                            <shiro:authenticated>
                            <div class="col-xs-4 col-sm-5">
                            <a href="${pageContext.request.contextPath }/userIndex.action">
                            	<div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active"><shiro:principal property="name"/></em>
                                    </div>
                                </div>
                            </a>
                            </div>
                            <div class="col-xs-4 col-sm-5">
                            <a href="${pageContext.request.contextPath }/logout.action">
                                <div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">退出</em>
                                    </div>
                                </div>
                                </a>
                                </div>
                            </shiro:authenticated>
                            
                            
                            
                            
                        </div>
                    </div>
                </div>
            </div>
            <div class="wsmenucontent overlapblackbg"></div>
            <div class="wsmenuexpandermain slideRight">
                <a id="navToggle" class="animated-arrow slideLeft">
                    <span></span>
                </a>
            </div>
            <div class="header_down">
                <div class="container">
                    <div class="wrapper clearfix bigmegamenu">
                        <!--Main Menu HTML Code-->
                        <nav class="wsmenu slideLeft clearfix">
                            <ul class="mobile-sub wsmenu-list">
                                <li class="visible-xs">
                                    <form class="navbar-form mob_search" role="search">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                        </div>
                                        <button type="submit" class="btn btn-search">
                                            <i class="icon-search"></i>
                                        </button>
                                    </form>
                                </li>

                               <c:forEach var="category" items="${categoryList }">
									<li class="active">
									<a href="${pageContext.request.contextPath }/index.action?type=${category.id}">
                                    <span class="wsmenu-click"></span>
                                    <a href="${pageContext.request.contextPath }/index.action?type=${category.id}">${category.name }</a>
                                    </a>
                                </li>
								</c:forEach>
                                <li class="navbar-right hidden-xs">
                                    <form class="navbar-form " role="search">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                        </div>
                                        <button type="submit" class="btn btn-search">
                                            <i class="icon-search"></i>
                                            <br>Search
                                        </button>
                                    </form>
                                </li>
                                <li>
                                    <div class="visible-xs col-sm-offset-5 col-sm-4">
                                         <!-- 用户没有登录时显示 -->
                            <shiro:notAuthenticated>
                            <!-- 用户rememberMe时 -->
                        	<shiro:user>
                        		<div class="col-xs-4 col-sm-5">
                            <a href="login.jsp">
                            	<div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active"><shiro:principal property="name"/></em>
                                    </div>
                                </div>
                            </a>
                            </div>
                            <div class="col-xs-4 col-sm-5">
                            <a href="${pageContext.request.contextPath }/logout.action">
                                <div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">退出</em>
                                    </div>
                                </div>
                                </a>
                                </div>
                        	</shiro:user>
                        	<shiro:guest>
                            <div class="col-xs-4 col-sm-5">
                            
                            <a href="login.jsp">
                            	<div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">登录</em>
                                    </div>
                                </div>
                            </a>
                            </div>
                            <div class="col-xs-4 col-sm-5">
                            <a href="sign-up.jsp">
                                <div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">注册</em>
                                    </div>
                                </div>
                             </a>
                             </div>
                             </shiro:guest>
                            </shiro:notAuthenticated>
                            <!-- 用户登录后显示 -->
                            <shiro:authenticated>
                            <div class="col-xs-4 col-sm-5">
                            <a href="${pageContext.request.contextPath }/userIndex.action">
                            	<div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active"><shiro:principal property="name"/></em>
                                    </div>
                                </div>
                            </a>
                            </div>
                            <div class="col-xs-4 col-sm-5">
                            <a href="${pageContext.request.contextPath }/logout.action">
                                <div class="weather">
                                    <div class="weather__temperature">
                                        <em class="active">退出</em>
                                    </div>
                                </div>
                                </a>
                                </div>
                            </shiro:authenticated>
                                    </div>
                                </li>
                            </ul>
                        </nav>
                        <!--Menu HTML Code-->
                    </div>
                </div>
            </div>
        </header>
        <!-- END header -->
        <!-- header slider -->
        <div class="wrapper">
            <article class="container articles">
                <div class="row">
                    <div class="col-sm-4 col-md-3 right_sidebar hidden-xs hidden-sm" data-spy="affix" data-offset-top="112" data-offset-bottom="80">
                        <div class="news-tabs">
                            <p class="news-tabs__title h2">用户其他文章</p>
                            
                            
                            
                            <c:forEach var="moment" items="${momentsList }">
                            <ul class="news-tabs__nav nav nav-tabs shadow_text" role="tablist">
                                <li role="presentation" >
                                    <a  href="${pageContext.request.contextPath }/news.action?momentsId=${moment.id}" >
                                        <span class="time">阅读量, ${moment.amountOfReading }</span>
                                       		${moment.title }
                                    </a>
                                </li>
                                 </ul>
                             </c:forEach>
                               <ul class="news-tabs__nav nav nav-tabs shadow_text" role="tablist">
                                <li role="presentation" >
                                    <a  href="${pageContext.request.contextPath }/userAllMoments.action?id=${author.id}" >
                                        <span class="time"></span>
                                       		更多..
                                    </a>
                                </li>
                                 </ul>
                               
                           
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-9 p0 wrap-headline">
                        <img src="assets/indexFilder/img/content/article.jpg" alt="img" class="wrap-headline__img">
                        <div class="headline clearfix">
                            <div class="headline__data">
                                <a href="${pageContext.request.contextPath }/index.action?type=${category.id}" class="headline__category headline__category_orange">${category.name }</a>
                                <p class="headline__category">${moment.time }</p>
                            </div>
                            <div  class="share">
                                <ul class="share__list">
                                <li class="share__row">
                                   	<input type="hidden" value="${moments.id }" name="momentsIdInput"/>
                                        <a class="share__link share__link_bg-google" id="transpondMoment" href="#" style="text-decoration: none;">
                                        	<i  style="font-size: 0.5px;color: white;">转发</i>
                                         </a>
                                   
                                    </li>
                                   <li class="share__row">
                                   
                                        <a class="share__link share__link_bg-facebook" href="#" style="text-decoration: none;">
                                        	<i  style="font-size: 0.5px;color: white;">阅读量</i>
                                         </a>
                                        <span class="share__number" style="height: 35px;text-align: center;padding-top: 12px">${moments.amountOfReading }</span>
                                    </li>
                                    <li class="share__row">
                                        <a class="share__link share__link_bg-google" href="#" id="user_like" style="text-decoration: none;">
                                            <i   style="font-size: 0.5px;color: white;">点赞</i>
                                        </a>
                                        <span id="userLike" class="share__number" style="height: 35px;text-align: center;padding-top: 12px">${likeCounts }</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <script type="text/javascript">
                    	$(function() {
                    		var data = {
                    				sys_mid:"${moments.id}"
                    		}
							$("#user_like").click(function() {
								$.ajax({
									type:"post",
									dataType:"json",
									url:"userLike.action",
									data:data,
				      				async:true,
				      				success:function(data){
				      					var like = $("#userLike").html();
				      					if(data=="1"){
					      					$("#userLike").html(parseInt(like)+1)
				      					}else if(data=="0"){
				      						if(confirm("取消点赞成功"))$("#userLike").html(parseInt(like)-1)
				      					}
				      				},
				      				error:function(){
				      					confirm("您还没有登录，请先登录");
				      				}
									
								})
							})
						})
						
                    	
                    </script>
                    <div class="col-sm-12 col-md-9 article_text">
                        <div class="current">
                        
                            <h1 class="text-center yel_line current__title">${moments.title }</h1>
                            
                            	<c:choose>
                            		<c:when test="${not empty moments.transpondBy }">
                            			<p class="current__text">
                            			转发自：<a href="${pageContext.request.contextPath }/userAllMoments.action?id=${author.id}">${author.name }</a>
                            			</p>
                            		</c:when>
                            		<c:otherwise>
                            			<p class="current__text">
                            			作者：<a href="${pageContext.request.contextPath }/userAllMoments.action?id=${author.id}">${author.name }</a>
                            			</p>
                            		</c:otherwise>
                            	</c:choose>
                            	
                            
                           
                            <p class="current__text">
                            	标语：${moments.slogan }
                            </p>
                            <p class="current__text">
                            	${moments.content }
                            </p>
                           
                        </div>
                    </div>
                    <!-- <div class="col-sm-12 col-md-9 tags">
                        <p>Tags:</p>
                        <ul>
                            <li>
                                <a href="#" title="World" class="font">World</a>
                            </li>
                            <li>
                                <a class="yellow font" href="#" title="Sport">Sport</a>
                            </li>
                            <li>
                                <a href="#" title="Cats" class="font">Cats</a>
                            </li>
                        </ul>
                    </div> -->
                    <div  class="col-sm-9 col-md-8 col-lg-6 comments" >
                        <p class="comments__title">Comments</p>
                        <c:forEach var="comments" items="${commentsList }">
                        <div  class="comments__media">
                            <div class="media-middle">
                                <i class="media-object" style="background-image: url('${comments.user.avatar }')"></i>
                                <div class="comm_info">
                                    <h4 class="media-heading">${comments.user.name }</h4>
                                    <span class="time">today, 12:30</span>
                                </div>
                            </div>
                            <p class="media-body">${comments.content }</p>
                        </div>
                        </c:forEach>
                        <div class="comments__form" >
                            <form action="${pageContext.request.contextPath }/publishComments.action" method="get">
                             	<input type="hidden" value="${moments.id }" name="sys_mid"/>
                                <div class="form-group">
                                    <textarea name="content"  id="input" class="form-control" rows="7" required="required"></textarea>
                                </div>
                                <button  type="submit" class="btn btn-comment">send</button>
                            </form>
                        </div>
                    </div>
                </div>
            </article>
        </div>
        <!-- Footer -->
        <footer class="footer slate_gray">
            <div class="container">
                <div class="row">
                   
                    <div class="col-sm-6">
                        <div class="social navbar-right">
                            <p class="social__text">We are in social networks</p>
                            <ul class="social__list">
                                <li class="social__item">
                                    <a class="facebook" href="#">
                                        <i class="icon-facebook"></i>
                                    </a>
                                </li>
                                <li class="social__item">
                                    <a class="twitter" href="#">
                                        <i class="icon-twitter"></i>
                                    </a>
                                </li>
                                <li class="social__item">
                                    <a class="gplus" href="#">
                                        <i class="icon-gplus"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- END Footer -->
        <script src="assets/ajax/news.js"></script>
        
    </body>
</html>

