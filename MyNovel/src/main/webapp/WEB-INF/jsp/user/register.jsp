<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function check(obj) {
		var username = obj.username.value;
		var password = obj.password.value;
		if (username.length<3||username.length>9) {
			alert("长度不符合");
			return false;
		}
		if (password == "") {
			alert("password can not null");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<h1 align="center">register</h1>
	<form action="user/register" name="regform" enctype="multipart/form-data"
		onsubmit="return check(this)">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"></td>

			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
				<td><input type="password" name="password"></td>

			</tr>
			
			<tr>
				<td><input type="submit" value="提交"></td>
				<td align="center"><input type="reset" value="重置"></td>
			</tr>

		</table>
	</form>
</body>
</html>
