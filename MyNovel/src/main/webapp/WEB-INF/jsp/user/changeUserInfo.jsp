<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changeUserInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="user/usermanage/update" enctype="multipart/form-data"
		method="post">
		<table>
			<tr>
				<td>当前头像<br>${sessionScope.user.faceimage}</td>
				<td><img height="129" width="184" alt="当前头像"
					src="<%=basePath %>facepic/${sessionScope.user.faceimage}"></td>
			</tr>
			<tr>
				<td>替换头像</td>
				<td><input type="file" name="faceimage"></td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"
					value="${sessionScope.user.username}"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password"
					value="${sessionScope.user.password}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>

		</table>
	</form>
  </body>
</html>
