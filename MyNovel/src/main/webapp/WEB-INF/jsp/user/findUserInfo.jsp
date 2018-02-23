<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'findUserInfo.jsp' starting page</title>

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
	<h1 align="center">查询用户</h1>
	<hr>
	选择查询方式(可复选)
	<br>
	<br>
	<form action="usermanage/findUserInfo">
		<label>姓名<input type="radio" name="select" value="username"></label>
		<label>密码<input type="radio" name="select" value="password"></label>
		<br> <br>
		<table>
			<tr>
				<td><input type="text" name="content" value="${content}"></td>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>
	<hr>
	<table cellspacing="10" border="4">
		<c:forEach var="user" items="${requestScope.users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>