<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ tagliburi="http://shiro.apache.org/tags" prefix="shiro" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>发文章</title>
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/index.css" />
		<link rel="stylesheet" href="assets/css/admin.css" />
		<link rel="stylesheet" href="assets/css/page/typography.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
		<script type="text/javascript" src="assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="assets/js/ajaxfileupload.js"></script>
	</head>
	<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.html" class="logo"><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">发表文章</h4></li>
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
	                             <a href="${pageContext.request.contextPath }/userIndex.action">
	                           <img src="<shiro:principal property='avatar'/>" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                           </a>
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5><a href="#"><shiro:principal property="name"/></a> </h5>
	                        <ul class="list-inline">
	                            <li>
	                                <a href="#">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	
	                            <li>
	                                <a href="#" class="text-custom">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	                        </ul>
	                    </div>
	                   <ul class="am-list admin-sidebar-list">
						    <li><a href="${pageContext.request.contextPath }/index.action"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a class="am-cf" href="${pageContext.request.contextPath }/userEditSelfInformation.action" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 修改个人信息 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 用户文章 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        <li><a href="${pageContext.request.contextPath }/userMoments.action" class="am-cf"> 查看已发的文章</span></a></li>
						        <li><a href="${pageContext.request.contextPath }/returnUserPublisMoments.action">发布新文章</a></li>
						      </ul>
						    </li>
						   <li class="admin-parent">
						      <a class="am-cf" href="${pageContext.request.contextPath }/returnHistoryInformation.action" data-am-collapse="{target: '#collapse-nav3'}"><i class="am-icon-file" aria-hidden="true"></i>历史浏览记录 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      
						    </li>
						    <li class="admin-parent">
						      <a href="${pageContext.request.contextPath }/userLikeMoments.action" class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-list"></span> 喜欢的文章  <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      
						    </li>
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
		<script>
			
			$(function() {
				
				$("#publishMomentsButton").click(function() {
				var moments={
						"title":$("input[name='title']")[0].value,
						"content":CKEDITOR.instances.editor1.getData(),
						"sys_cid":$("select[name='categoryId']")[0].value,
						"slogan":$("input[name='slogan']")[0].value
				};
				$.ajaxFileUpload({
					type:"post",
					url:"userPublishMoments.action",
					secureuri:false,//是否需要安全协议，一般设置为false
					data:moments,//传递的参数
					fileElementId:"xdaTanFileImg",//文件上传域的ID
					dataType:"JSON",//返回值类型
					success:function(data){
      					if(data!=null){
      						if(data==1){
      							confirm("添加成功");
      						}
      					}else{
      						alert("失败")
      					}
      				},
      				error:function(){
      					alert("error");
      				}
				})
				/* $.ajax({
					type:"post",
					dataType:"json",
					url:"userPublishMoments.action",
					async:true,
      				data:moments,
      				success:function(data){
      					if(data!=null){
      						if(data==1){
      							confirm("添加成功");
      						}
      					}else{
      						alert("失败")
      					}
      					
      					
      				},
      				error:function(){
      					alert("error");
      				}
					
				}) */
				
				
			})
		})
			
		
		</script>
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-sm-12">
							<div class="card-box">
								<ul class="am-nav am-fr">
								  <li class="am-dropdown" data-am-dropdown>
								   
								    
								  </li>
								</ul>
								<script type="text/javascript">            
            						//判断浏览器是否支持FileReader接口
            						if (typeof FileReader == 'undefined') {
                						document.getElementById("xmTanDiv").InnerHTML = "<h1>当前浏览器不支持FileReader接口</h1>";
               							 //使选择控件不可操作
                						document.getElementById("xdaTanFileImg").setAttribute("disabled", "disabled");
           							 }

            						//选择图片，马上预览
            						function xmTanUploadImg(obj) {
                					var file = obj.files[0];
                
                					console.log(obj);console.log(file);
                					console.log("file.size = " + file.size);  //file.size 单位为byte

                					var reader = new FileReader();

                					//读取文件过程方法
                					reader.onloadstart = function (e) {
                    					console.log("开始读取....");
                					}
                					reader.onprogress = function (e) {
                    					console.log("正在读取中....");
                					}
                					reader.onabort = function (e) {
                    					console.log("中断读取....");
                					}
                					reader.onerror = function (e) {
                    					console.log("读取异常....");
                					}
                					reader.onload = function (e) {
                    					console.log("成功读取....");

                    				var img = document.getElementById("xmTanImg");
                    				img.src = e.target.result;
                    				//或者 img.src = this.result;  //e.target == this
               				 }

                					reader.readAsDataURL(file)
            			}
        		</script>
								<form class="am-form" enctype="multipart/form-data" data-am-validator>
								  <fieldset>
								    <legend>文章信息</legend>
								    <div class="am-form-group">
								      <label for="doc-vld-name-2">文章题目</label>
								      <input name="title" type="text" id="doc-vld-name-2" minlength="3" placeholder="输入文章题目（至少 3 个字符）" required/>
								    </div>
									<div class="am-form-group">
								      <label for="doc-vld-name-2">文章显示图片</label>
								      <input name="photo" type="file" id="xdaTanFileImg" onchange="xmTanUploadImg(this)" accept="image/*"/>
								      <!-- <input name="photo" id="imageFile1" type="file" id="doc-ipt-file-1"> -->
            						  <p class="am-form-help">预览：</p>
            						   <img id="xmTanImg" width="268px" height="151.28px"/>
								    </div>
								    
								
									<div class="am-form-group">
								      <label for="doc-vld-name-2">文章标语：</label>
								      <input name="slogan" type="text" id="doc-vld-name-2" placeholder="输入文章标语" required/>
								    </div>
								    
								    <div class="am-form-group">
								      <label for="doc-select-1">文章类型</label>
								      <select name="categoryId" id="doc-select-1" required>
								        <option value="">-=请选择一项=-</option>
								        <c:forEach var="category" items="${categoryList }">
								        	<option value="${category.id }">${category.name}</option>
								        </c:forEach>
								      </select>
								      <span class="am-form-caret"></span>
								    </div>
								
								   
								
								    <div class="am-form-group">
								      <label for="doc-vld-ta-2">内容：</label>
								       <!-- <textarea id="doc-vld-ta-2" rows="15" name="" cols="50" warp="virtual" ></textarea> -->
								      <!-- 	在需要使用编辑器的地方插入textarea标签 -->
									   <textarea rows="10" cols="30" class="ckeditor" name="content" id="editor1"></textarea>
									   <script type="text/javascript">
     										CKEDITOR.replace('editor1');
     										
  									   </script>
								    </div>
								
								    <button type="button" id="publishMomentsButton" class="am-btn am-btn-secondary">提交</button>
								  </fieldset>
								</form> 
								
							
							</div>
						</div>
					<!-- Row end -->
				</div>
			
			
			
			
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		
	</body>
	
</html>
