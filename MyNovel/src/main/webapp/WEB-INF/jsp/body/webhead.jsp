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

<title>My JSP 'webhead.jsp' starting page</title>

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
	<table>
		<tr>
			<td><c:choose>
					<c:when test="${empty sessionScope.user}">未登录</c:when>
					<c:otherwise>
						<td><img height="129" width="184" alt="当前头像"
							src="<%=basePath %>facepic/${sessionScope.user.faceimage}"></td>
						<a href="user/usermanage/userinfo">${user.username}</a>
					</c:otherwise>
				</c:choose></td>
		</tr>

		<tr>
			<td><a href="registerPage">注册</a></td>
			<td><a href="userloginPage">登录</a></td>
			<td><a href="user/usermanage/userlogout">注销</a></td>
			<td><a href="book/bookmanage/addbookinfopage">发布新书</a></td>
		</tr>
	</table>
</body>
</html>
