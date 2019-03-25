<%@page import="cn.lijiahao.demo.po.User"%>
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
        <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
        <!--[if (gt IE 9)|!(IE)]><!-->
        <!-- custom CSS -->
        <link href="assets/indexFilder/css/main.css" rel="stylesheet" type="text/css" />
        <!-- END custom CSS -->
        <!--<![endif]-->
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="assets/indexFilder/js/jquery.min.js"></script>
		<script src="assets/indexFilder/js/bootstrap.min.js"></script>
		<!-- Custom JavaScript -->
        <script src="assets/indexFilder/js/main.js"></script>
        <!-- 用于获取用户ip -->
        <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
        <title>Home</title>
        <style type="text/css">
        	/*  .masonry{
        		column-count: 4; 
        		column-gap: 0;
        	}
        	.item {
        		break-inside: avoid;
        		box-sizing: border-box; 
        		padding: 10px;
        	} */ 
        	
.masonry {
  -webkit-column-count: 1;
          column-count: 1;
  -webkit-column-gap: 0;
          column-gap: 0;
  counter-reset: item-counter;
}
@media screen and (min-width: 400px) {
  .masonry {
    -webkit-column-count: 2;
            column-count: 2;
  }
}
@media screen and (min-width: 600px) {
  .masonry {
    -webkit-column-count: 3;
            column-count: 3;
  }
}
@media screen and (min-width: 800px) {
  .masonry {
    -webkit-column-count: 4;
            column-count: 4;
  }
}

.item {
  box-sizing: border-box;
  -webkit-column-break-inside: avoid;
          break-inside: avoid;
  padding: 10px;
  counter-increment: item-counter;
}
.item__content {
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 220px;
  font-size: 40px;
  color: #360007;
  background: currentColor;
  box-sizing: border-box;
  color: #720026;
}
.item__content--small {
  height: 100px;
}
.item__content--medium {
  height: 175px;
}
.item__content--large {
  height: 280px;
}
        </style>
    </head>
    <body>
    <script type="text/javascript">
    
    
    </script>
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
                    <div class="wrapper clearfix bigmegamenu" ">
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
                                <li class="active">
                                <a href="${pageContext.request.contextPath }/index.action">
                                    <span class="wsmenu-click"></span>
                                    <a href="${pageContext.request.contextPath }/index.action">Home</a>
                                    </a>
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
                                    <form class="navbar-form" role="search">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                        </div>
                                        <button type="submit" class="btn btn-search">
                                            <i class="icon-search"></i>
                                            <br/>Search
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
        <div class="slate_gray">
           <!--  <div class="container">
                <div class="row header_news_panel">
                    Tab panes
                    <div class="col-sm-8 tab-content tab-content_mob-p0">
                        <div role="tabpanel" class="tab-pane fade in active" id="home">
                            <img src="assets/indexFilder/img/content/slide1.jpg" alt="main img" class="tab-pane__img">
                            <div class="header_news_text tab-pane__block">
                                <p class="tab-pane__category yel_line">People</p>
                                <a class="tab-pane__title">The Visions's Rainbow</a>
                                <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="profile">
                            <img src="assets/indexFilder/img/content/slide2.jpg" alt="main img" class="tab-pane__img">
                            <div class="header_news_text tab-pane__block">
                                <p class="tab-pane__category yel_line">People</p>
                                <a class="tab-pane__title">The Visions's Rainbow</a>
                                <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="messages">
                            <img src="assets/indexFilder/img/content/slide1.jpg" alt="main img" class="tab-pane__img">
                            <div class="header_news_text tab-pane__block">
                                <p class="tab-pane__category yel_line">People</p>
                                <a class="tab-pane__title">The Visions's Rainbow</a>
                                <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="settings">
                            <img src="assets/indexFilder/img/content/slide2.jpg" alt="main img" class="tab-pane__img">
                            <div class="header_news_text tab-pane__block">
                                <p class="tab-pane__category yel_line">People</p>
                                <a class="tab-pane__title">The Visions's Rainbow</a>
                                <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            </div>
                        </div>
                    </div>
                    END Tab panes
                    Nav tabs
                    <div class="col-sm-4 news-tabs">
                        <p class="news-tabs__title h2">Last news</p>
                        <ul class="news-tabs__nav nav nav-tabs shadow_text" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" role="tab" data-toggle="tab">
                                    <span class="time">today, 10:11</span>
                                    Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                                </a>
                            </li>
                            <li role="presentation">
                                <a href="#profile" role="tab" data-toggle="tab">
                                    <span class="time">today, 11:22</span>
                                    Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                                </a>
                            </li>
                            <li role="presentation">
                                <a href="#messages" role="tab" data-toggle="tab">
                                    <span class="time">today, 12:33</span>
                                    Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                                </a>
                            </li>
                            <li role="presentation">
                                <a href="#settings" role="tab" data-toggle="tab">
                                    <span class="time">today, 14:44</span>
                                    Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                                </a>
                            </li>
                        </ul>
                    </div>
                    END Nav tabs
                </div>
            </div> -->
        </div>
      
        <!-- top news-->
        <section>
            <!-- top news -->
            <!-- title -->
            <div class="wrap wrap_white">
                <div class="container title">
                    <h1 class="title__h1 underscore">Popular content</h1>
                </div>
            </div>
            <!-- END title -->
            
            <div  class="wrap wrap_gray pt20">
                <div class="container " id="loadmoreList">
						
                        <div class="masonry">
                        
                        <c:forEach var="moments" items="${momentsList }">
                       <div class="column">
                        <div class="item " >
                            <div class="thumbnail thumbnail_small">
                                <%-- <a href="${pageContext.request.contextPath }/news.action?momentsId=${moments.id}" class="thumbnail__link"> --%>
                                <a href="${pageContext.request.contextPath }/news.action?momentsId=${moments.id}" class="thumbnail__link">
                                    <img src="${moments.image }" height="153" width="270" alt="News">
                                </a>
                                <div class="caption thumbnail__caption" style="margin-top: 10px;">
                                    <div class="news caption__news">
                                        <p class="news__category yellow-line">${moments.title }</p>
                                        <a href="${pageContext.request.contextPath }/news.action?momentsId=${moments.id}" class="news__link">
                                            <p class="news__text">${moments.slogan }</p>
                                        </a>
                                    </div>
                                    <div class="posted">
                                        <span class="posted__date">${moments.time }</span>
                                        <ul class="posted__icon">
                                            <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>
                                            </span>
                                            </li>
                                            <li>
                                                <span>
                                                <i class="icon-eye"></i>${moments.amountOfReading }
                                            </span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>
                        </c:forEach>
                        <div  v-for="moments in momentsList" class="item">
                       		
                            <div class="thumbnail thumbnail_small">
                                <a  :href="'${pageContext.request.contextPath }/news.action?momentsId='+moments.id" class="thumbnail__link">
                                    <img :src="moments.image" height="153" width="270" alt="News"/>
                                </a>
                                <div class="caption thumbnail__caption">
                                    <div class="news caption__news">
                                        <p class="news__category yellow-line">{{moments.title}}</p>
                                        <a :href="'${pageContext.request.contextPath }/news.action?momentsId='+moments.id" class="news__link">
                                            <p class="news__text">{{moments.slogan }}</p>
                                        </a>
                                    </div>
                                    <div class="posted">
                                        <span class="posted__date">{{moments.time|formatDate}}</span>
                                        <ul class="posted__icon">
                                            <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>11
                                            </span>
                                            </li>
                                            <li>
                                                <span>
                                                <i class="icon-eye"></i>{{moments.amountOfReading}}
                                            </span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <%-- <div id="loadmoreList" class="row">
                        
                         
                        <div  v-for="moments in momentsList" class="col-sm-3">
                       		
                            <div class="thumbnail thumbnail_small">
                                <a  :href="'${pageContext.request.contextPath }/news.action?momentsId='+moments.id" class="thumbnail__link">
                                    <img :src="moments.image" height="153" width="270" alt="News"/>
                                </a>
                                <div class="caption thumbnail__caption">
                                    <div class="news caption__news">
                                        <p class="news__category yellow-line">{{moments.title}}</p>
                                        <a :href="'${pageContext.request.contextPath }/news.action?momentsId='+moments.id" class="news__link">
                                            <p class="news__text">{{moments.slogan }}</p>
                                        </a>
                                    </div>
                                    <div class="posted">
                                        <span class="posted__date">{{moments.time|formatDate}}</span>
                                        <ul class="posted__icon">
                                            <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>11
                                            </span>
                                            </li>
                                            <li>
                                                <span>
                                                <i class="icon-eye"></i>{{moments.amountOfReading}}
                                            </span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> --%>
                </div>
                <!-- btn load-->
      
                <div class="ajax_load">
                    <i class="icon-arrows-cw"></i>Load more
                    <svg  id="loadmore" width="128" height="40" viewBox="0 0 128 40" xmlns="http://www.w3.org/2000/svg">
                        
                        <rect x='0' y='0' fill='none' width='128' height='40'></rect>
                    </svg>
                </div>
                <!-- END btn load-->
            </div>
            <!-- /container-->
        </section>
        <script type="text/javascript">
      var moreMomentsList;
      var vm = new Vue({
	        	el:"#loadmoreList",
	        	data:{
	        		momentsList:[]
	        	},
	        	filters:{
	        		formatDate:function(value){
	        			let date = new Date(value);
	        	        let y = date.getFullYear();
	        	        let MM = date.getMonth() + 1;
	        	        MM = MM < 10 ? ('0' + MM) : MM;
	        	        let d = date.getDate();
	        	        d = d < 10 ? ('0' + d) : d;
	        	        let h = date.getHours();
	        	        h = h < 10 ? ('0' + h) : h;
	        	        let m = date.getMinutes();
	        	        m = m < 10 ? ('0' + m) : m;
	        	        let s = date.getSeconds();
	        	        s = s < 10 ? ('0' + s) : s;
	        	        return y + '-' + MM + '-' + d + ' ' + h + ':' + m + ':' + s;
	        		}
	        	},
	        	 
	        })
      </script>
        <script type="text/javascript">
        var begin = 12;
       $(function() {
    	   
			$("#loadmore").click(function() {
				
				var loadmore = {
						"type":"${type}",
						"begin":begin,
						"size":"8"
				}
				$.ajax({
					type:"post",
					dataType:"json",
					data:loadmore,
					url:"loadmore.action",
      				async:true,
      				success:function(data){
      					
      					for(i in data){
      						vm.momentsList.push(data[i])
      						
      					} 
      					
      				},
      				error:function(){
      					confirm("error");
      				}
				})
				begin = begin+8;
			})
		})
       
       </script>
        
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
        <!-- All JavaScript libraries -->
		
    </body>
</html>
