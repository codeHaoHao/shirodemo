<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>后台模板</title>
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/jquery-ui-1.10.4.custom.min.css" />
		<link rel="stylesheet" href="assets/css/index.css" />
		<link rel="stylesheet" href="assets/css/admin.css" />
		<link rel="stylesheet" href="assets/css/page/typography.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
	</head>
	<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.html" class="logo"><span>欢迎管理员admin</span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">用户管理</h4></li>
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
	                            <img src="assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5><a href="#">Mat Helme</a> </h5>
	                        <ul class="list-inline">
	                            <li>
	                                <a href="${pageContext.request.contextPath }/logout.action">退出登录</a>
	                            </li>
	
	                         
	                        </ul>
	                    </div>
	                    <!-- End User -->
	            
						 <ul class="am-list admin-sidebar-list">
						    <li><a href="${pageContext.request.contextPath }/index.action"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a href="${pageContext.request.contextPath }/adminIndex.action" class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        <!-- <li><a href="table_basic.html" class="am-cf"> 基本表格</span></a></li>
						        <li><a href="table_complete.html">完整表格</a></li> -->
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 文章管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
						        <li><a href="${pageContext.request.contextPath }/adminManagerMoments.action" class="am-cf"> 管理文章</span></a></li>
						        <!-- <li><a href="chart_columnar.html" class="am-cf"> 柱状图</span></a></li>
						        <li><a href="chart_pie.html" class="am-cf"> 饼状图</span></a></li> -->
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
						        <li><a href="#" class="am-cf"> 基本表单</a></li>
						        <li><a href="#">表单验证</a></li>   
						      </ul>
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
		<!-- Start right Content here -->
		<div id="loadAdminManagerUser" class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="card-box">
					<!-- Row start -->
					<div class="am-g">
						<div class="am-u-sm-12 am-u-md-6">
				          <div class="am-btn-toolbar">
				            <div class="am-btn-group am-btn-group-xs">
				             <!--  <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
				              <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
				              <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>
				              <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button> -->
				            </div>
				          </div>
				        </div>	
				        
						<div class="am-u-sm-12 am-u-md-3">
				          <div class="am-input-group am-input-group-sm">
				            <input type="text" name="search" class="am-form-field">
				          <span class="am-input-group-btn">
				            <button @click="search()" class="am-btn am-btn-default" type="button">搜索</button>
				          </span>
				          </div>
				        </div>
				      </div>
					  <!-- Row end -->
					  
					  <!-- Row start -->
					  	<div class="am-g">
        <div  class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
											<th class="table-check"><input type="checkbox" /></th>
											<th class="table-id">ID</th>
											<th class="table-title">用户名</th>
											<th class="table-type">密码</th>
											<th class="table-author am-hide-sm-only">姓名</th>
											<th class="table-date am-hide-sm-only">出生日期</th>
											<th class="table-date am-hide-sm-only">年龄</th>
											<th class="table-date am-hide-sm-only">性别</th>
											<th class="table-date am-hide-sm-only">是否锁定</th>
											<th class="table-set">操作</th>
										</tr>
              </thead>
              <tbody >
              <tr v-for="(data,index) in dataList">
                <td><input type="checkbox" /></td>
                <td>{{data.id}}</td>
                <td><a href="#">{{data.username}}</a></td>
                <td>{{data.password}}</td>
                <td class="am-hide-sm-only">{{data.name}}</td>
                <td class="am-hide-sm-only">{{data.dataOfBirth}}</td>
                <td class="am-hide-sm-only">{{data.age}}</td>
                <td class="am-hide-sm-only">{{data.gender}}</td>
                <td class="am-hide-sm-only">{{data.locked}}</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button @click="edit(index)" class="am-btn am-btn-default am-btn-xs am-text-secondary" type="button"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                      <button @click="editPassword(index)" class="am-btn am-btn-default am-btn-xs am-hide-sm-only" type="button"><span class="am-icon-copy"></span> 修改密码</button>
                      <button @click="deleteButton(index)" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" type="button"><span class="am-icon-trash-o"></span> 锁定</button>
                    </div>
                  </div>
                </td>
              </tr>
              
              </tbody>
            </table>
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
            <hr />
            <p>注：.....</p>
          </form>
        </div>

      </div>
					  <!-- Row end -->
					  
					</div>
				
				
				
				
				</div>
			

			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>

	<div id="dialog-edit" title="编辑">
		

		<form>
			<fieldset>
				<label for="id">id</label> 
				<input type="text" name="id" id="id" class="text ui-widget-content ui-corner-all" readonly="readonly"/> <br/>
				<label for="username">用户名</label> 
				<input type="text" name="username" class="text ui-widget-content ui-corner-all" readonly="readonly"/> <br/>
				
				<label for="name">姓名</label> 
				<input type="text" name="name"  class="text ui-widget-content ui-corner-all"/><br/>
				<label for="age">年龄</label> 
				<input type="text" name="age"  class="text ui-widget-content ui-corner-all"/><br/>
				 <label>性别： </label>
				<label class="am-radio-inline">
				<input type="radio"  value="1" name="docVlGender"  required> 男
				</label>
				<label class="am-radio-inline">
				<input type="radio" value="0" name="docVlGender"> 女
				</label><br/>
			</fieldset>
		</form>
	</div>
	<div id="dialog-editPassword" title="编辑">
		

		<form>
			<fieldset>
				<label for="newPassword">新密码</label> 
				<input type="text" name="newPassword"  class="text ui-widget-content ui-corner-all" /> <br/>
				
			</fieldset>
		</form>
	</div>
	
	<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		<!-- vue.js需要的开发包 -->
		<script src="assets/js/vue.js"></script>
		<script src="assets/js/vue-resource.js"></script>
		<script type="text/javascript" src="assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="assets/js/jquery-ui-1.10.4.custom.min.js"></script>
		<script type="text/javascript" src="assets/admin/js/adminIndex.js" ></script>
	</body>
	
</html>
