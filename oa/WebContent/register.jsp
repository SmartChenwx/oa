<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
</head>
<body>
	<div>
		<form name="regForm" id="regForm" action="userReg.action" method="post" onsubmit="">
			用户名：<input type="text" name="phone_mobile" id="phone_mobile"><br>
			密码：<input type="password" name="login_password" id="pwd"><br>
			确认密码：<input type="password" name="login_password_2" id="pwd2"><br>
			<button type="submit" onclick="this.submit()">注册</button>
		</form>
	</div>
</body>
</html>