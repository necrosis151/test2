<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>My JSP 'goAddContentPage.jsp' starting page</title>

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
		<c:forEach items="${requestScope.bookInfos}" var="book">
			<tr>
				<td><table border="1">
						<tr>
							<td><a href="book/bookmanage/mainList${book.idbookinfo}">${book.bookname}</a></td>
						</tr>
						<tr>
							<td><table>
									<tr>
										<td>简介:</td>
										<td>${book.bookmessage}</td>
									</tr>
									<tr>
										<td>类型:</td>
										<td><c:forEach items="${book.types}" var="types">${types.type}&nbsp;</c:forEach></td>
									</tr>
									<tr>
										<td colspan="2"><table>
												<tr>
													<td><a
														href="book/bookmanage/updateBIPage${book.idbookinfo}">修改信息</a></td>
													<td><a
														href="book/bookmanage/mainList${book.idbookinfo}">管理内容</a></td>
													<td><a
														href="book/bookmanage/deleteB${book.idbookinfo}">删除全部</a></td>
												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>

					</table></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
