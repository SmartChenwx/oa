<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<!-- 导入ext的样式 -->
<link rel="styleSheet" type="text/css" href="<%=basePath%>imports/ext/resources/font-ext-all.css">
<!-- 导入ext的核心文件库 -->
<script type="text/javascript" src="<%=basePath%>imports\ext\ext-all.js"></script>
<!-- 国际化文件 -->
<script type="text/javascript" src="<%=basePath%>imports/ext/ext-locale-zh_CN.js"></script>
  <script type="text/javascript">
// 用户名合法性的判断
  $(function(){
		$("#phone").blur(function(){
				var phone = $("#phone").val();
				var len = $("#phone").val().length;
				if(len==0||phone==null){
							$("#userNameError").html("手机号不能为空！");
							$("#loginForm").attr("onsubmit","return false");
							}
					});
			});
			
// 密码合法性的判断
  	$(function(){
		$("#pwd").blur(function(){
			var len = $("#pwd").val().length;
			if(len==0){
				$("#pwdError").html("密码不能为空！");
				$("#loginForm").attr("onsubmit","return false");
				}
			})
  	  	})
  	  
  	  function check(){  
  	     fr=document.loginForm;  
  	     if(fr.phone_mobile.value==""){  
  	        fr.phone_mobile.focus();  
  	        return false;  
  	     }  
  	     if((fr.login_password.value=="")){  
  	             fr.login_password.focus();  
  	             return false;  
  	     }
  	       fr.submit();
  	     }
  </script>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="image/shortCut.png" type="image/x-icon" />
<title>OA欢迎您</title>
</head>
<body class="indexBody">
	<h1>
		<div class="loginDiv">
			<h2>OA办公管理系统</h2>
			<form name="loginForm" id="loginForm" action="login.action" method="post">
				账&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="phone_mobile" id="phone" class="loginInput">
				<label style="font-size:15px;">  
                    <input id="rembaccount" name="rembaccount" type="checkbox" value=""/>记住账号  
                </label>  <br>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="login_password" id="login_password" class="loginInput">
				<label style="font-size:15px;">  
                    <input id="rembpass" name="rembpass" type="checkbox" value=""/>记住密码  
                </label>  <br>
				<button type="submit" onclick="return check()" style="margin-left:30%;">登&nbsp;&nbsp;&nbsp;录</button><br>
				<p class="loginAP"><a href="" class="loginA">忘记密码?</a>&nbsp;|&nbsp;<a href="register.jsp"class="loginA">新用户注册</a></p><br><br>
				<p class="loginTips">主办单位：厦门繁荣昌盛人员服务有限公司</p>
				<p class="loginTips">联系电话：0592-8888888</p>
				<p class="loginTips">技术支持：© 厦门繁荣昌盛技术服务有限公司</p>
			</form>
		</div>
	</h1>
</body>
</html>