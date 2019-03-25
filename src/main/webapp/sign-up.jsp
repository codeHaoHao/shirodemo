<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Minimal and Clean Sign up / Login and Forgot Form by FreeHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<!-- jQuery -->
	<script src="assets/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="assets/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="assets/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="assets/js/main.js"></script>

  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/animate.css">
	<link rel="stylesheet" href="assets/css/style.css">

	<!-- Modernizr JS -->
	<script src="assets/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>

		<div class="container">
			
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<script type="text/javascript">
					$(function() {
						
						 $("#re-password").blur(function () {
							 var password=$("#password").val();
								
								var repassword = $("#re-password").val();
								if (password!=repassword) {
									$("#re-password").css({
										"color":"red",
										"border-bottom":"1px solid red"
									});
								}
								if (password==repassword) {
									$("#re-password").css({
										"color":"",
										"border-bottom":"1px solid rgba(0, 0, 0, 0.1)"
									});
								}
							})
						$("#sign-up").click(function() {
							var userName = $("#userName").val();
							var name = $("#name").val();
							var password=$("#password").val();
							var repassword = $("#re-password").val();
							if(userName==""){alert("用户名不能为空");return;}
							else if(name==""){alert("姓名不能为空");return;}
							else if(password==""){alert("密码不能为空");return;}
							else if(password!=repassword){alert("两次密码不一样");return;}
							
							var user = {
									"username":userName,
									"name":name,
									"password":password,
							}
							$.ajax({
								type:"post",
			      				dataType:"json",
			      				url:"register.action",
			      				async:true,
			      				data:user,
			      				success:function(data){
			      					if(data==0){
			      						alert("账号已存在");
			      					}else if(data==1){
			      						alert("注册成功");
			      						
			      						window.location.href='${pageContext.request.contextPath}/login.jsp'
			      					}
			      					
			      				},
			      				error:function(){
			      					alert("error");
			      				}
							})
						})
					})
						
						
					</script>

					<!-- Start Sign In Form -->
					<form action="#" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>Sign Up</h2>
						<div class="form-group">
							<!-- <div class="alert alert-success" role="alert">Your info has been saved.</div> -->
						</div>
						<div class="form-group">
							<label for="name" class="sr-only">账号</label>
							<input type="text" name="username" class="form-control" id="userName" placeholder="账号" autocomplete="off">
							
						</div>
						<div class="form-group">
							<label for="email" class="sr-only">姓名</label>
							<input type="text" name="name" class="form-control" id="name" placeholder="姓名" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" name="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="re-password" class="sr-only">确认密码</label>
							<input type="password" class="form-control" id="re-password" placeholder="确认密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> Remember Me</label>
						</div>
						<div class="form-group">
							<p>Already registered? <a href="login.jsp">Sign In</a></p>
						</div>
						<div class="form-group">
							<input type="button" id="sign-up" value="Sign Up" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->

				</div>
			</div>
			
		</div>
	
	
	
	</body>
</html>

