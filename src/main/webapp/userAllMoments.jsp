<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ tagliburi="http://shiro.apache.org/tags" prefix="shiro" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>用户界面</title>
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="shortcut icon" type="assets/indexFilder/image/png" href="favicon.png" />
        
        <link href="assets/indexFilder/css/main.css" rel="stylesheet" type="text/css" />
        <!-- END custom CSS -->
        <!--<![endif]-->
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
		<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/index.css" />
		<link rel="stylesheet" href="assets/css/admin.css" />
		<link rel="stylesheet" href="assets/css/page/typography.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
		<link rel="stylesheet" href="assets/css/component.css" />
		<script type="text/javascript" src="assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
		
		
		<script type="text/javascript" src="assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="assets/js/charts/echarts.min.js" ></script>
		<script type="text/javascript" src="assets/js/charts/indexChart.js" ></script>
		
	</head>
	<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.html" class="logo"><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">${author.name }的文章</h4></li>
				</ul>
				
				<ul class="am-nav am-navbar-nav am-navbar-right">
					<li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
					<li class="hidden-xs am-hide-sm-only">
                        <form role="search" class="app-search">
                            <input type="text" placeholder="Search..." class="form-control">
                            <a href=""><img src="assets/img/search.png"></a>
                        </form>
                    </li>
				</ul>
			</div>
		</header>
		<!-- end page -->
		
		
		<div class="admin">
			<!--<div class="am-g">-->
		<!-- ========== Left Sidebar Start ========== -->
		<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
				<div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
                  <!-- sidebar start -->
				  <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
				    <div class="am-offcanvas-bar admin-offcanvas-bar">
				    	<!-- User -->
						<div class="user-box am-hide-sm-only">
	                        <div class="user-img">
	                           <a href="#">
	                           <img src="${author.avatar }" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                           </a> 
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5 style="margin-top: 50px;"><a href="#">${author.name }的主页</a> </h5>
	                        <h5 >个人简介：<span style="width:200px; margin-left:20px; display: -webkit-box;-webkit-line-clamp: 4;-webkit-box-orient: vertical;overflow: hidden;">${author.individualResume }</span> </h5>
	                    </div>
	                    <!-- End User -->
	            
						 <ul class="am-list admin-sidebar-list">
						    <li><a href="${pageContext.request.contextPath }/index.action"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <!-- <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 用户文章 <span class="am-icon-angle-right am-fr am-margin-right"></span></a> -->
						      <%-- <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        <li><a href="${pageContext.request.contextPath }/userMoments.action" class="am-cf"> 查看已发的文章</span></a></li>
						        <li><a href="${pageContext.request.contextPath }/returnUserPublisMoments.action">发布新文章</a></li>
						      </ul> --%>
						    </li>
						   <!--  <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 统计图表 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
						        <li><a href="html/chart_line.html" class="am-cf"> 折线图</span></a></li>
						        <li><a href="html/chart_columnar.html" class="am-cf"> 柱状图</span></a></li>
						        <li><a href="html/chart_pie.html" class="am-cf"> 饼状图</span></a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
						        <li><a href="html/form_basic.html" class="am-cf"> 基本表单</a></li>
						        <li><a href="html/form_validate.html">表单验证</a></li>   
						      </ul>
						    </li> -->
						  </ul>
				</div>
				  </div>
				  <!-- sidebar end -->
    
				<!--</div>
			</div>
		</div>-->
		<!-- ========== Left Sidebar end ========== -->
		
		
		
	<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<input type="hidden" value="${id }" name="momentsID"/>
			<div id="userAllMoments" class="content">
			
                        <div  class="row">
                        
                         
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
                    </div>
                        
                    
                    <div class="am-cf" >
              <div v-if="isdisable" class="am-fr">
                <ul  class="am-pagination">
                  <li v-if="page!=1" ><a href="#" @click="pageable(1)">«</a></li>
                  <!--  <li v-for="currpage in groupList" class="am-active"><a href="#">{{page+currpage}}</a></li> -->
                  <li v-for="currpage in groupList" v-if="page+currpage>0&&page+currpage<=totalpage?true:false" :class="currpage==0?'am-active':''"   ><a href="#" @click="pageable(page+currpage)">{{page+currpage}}</a></li>
                  
                  <li v-if="page!=totalpage" ><a href="#" @click="pageable(totalpage)">»</a></li>
                </ul>
              </div>
            </div>
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		<!-- vue.js需要的开发包 -->
		<script src="assets/js/vue.js"></script>
		<script src="assets/js/vue-resource.js"></script>
		<!-- vue.js -->
		<script type="text/javascript" src="assets/vue/userAllMoments.js"></script>
	</body>
	
</html>
