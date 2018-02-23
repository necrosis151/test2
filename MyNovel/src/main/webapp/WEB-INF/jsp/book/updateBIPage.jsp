<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'updateBI.jsp' starting page</title>

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
	<h1 align="center">updatebookinfo</h1>
	<hr>
	<form action="book/bookmanage/upBI" method="post">
		<table>
			<tr>
				<td>书名:</td>
				<td><input type="text" name="bookname"
					value="${requestScope.bookinfo.bookname}"></td>
			</tr>
			<tr>
				<td>简介:</td>
				<td><input type="text" name="bookmessage"
					value="${requestScope.bookinfo.bookmessage}"></td>
			</tr>
			<tr>
				<td>类型:</td>
				<td>
					<table>
						<tr>
							<c:forEach items="${requestScope.types}" var="Ttype">
								<c:choose>
									<c:forEach items="${requestScope.bookinfo.types}" var="Btype">
										<c:when test="Btype==Ttype">
											<td>${Ttype.type}<input type="checkbox" name="typelists"
												value="${Ttype.idtypes}" checked="checked">&nbsp;&nbsp;
											</td>
										</c:when>
										<c:otherwise>
											<td>${Ttype.type}<input type="checkbox" name="typelists"
												value="${Ttype.idtypes}">&nbsp;&nbsp;
											</td>
										</c:otherwise>
									</c:forEach>
								</c:choose>
							</c:forEach>

						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="updatetime"
					value="${requestScope.bookinfo.updatetime"></td>
				<td><input type="hidden" name="idbookinfo"
					value="${requestScope.bookinfo.idbookinfo"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>
