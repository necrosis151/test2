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

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function changeCode() {
		$("#Img").attr("src", "ajax?t=" + genTimestamp());
	}
	function genTimestamp() {
		var time = new Date();
		return time.getTime();
	}

	$(document).ready(function() {
		changeCode();
		$("#Img").click(function() {
			changeCode();
		});
	});
</script>
</head>

<body>
	<h1>登录</h1>
	<form action="user/userlogin" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"></td>

			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
				<td><input type="password" name="password"></td>

			</tr>
			<tr style="height: 55px; " align="center">
				<td><input name="captcha" type="text" style="width: 102px; "></td>
				<td><img style="height: 43px; width: 215px" id="Img"
					alt="点击更换" title="点击更换" src="" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td align="center"><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>
