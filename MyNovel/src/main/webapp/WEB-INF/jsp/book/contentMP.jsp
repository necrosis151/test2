<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'contentMP.jsp' starting page</title>

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
	var list = "${bookContents}";
	var len = list.length;
	var colnum = 3;
	var rownum = Math.ceil(len / colnum);
	$(document).ready(function() {
		var num=0;
		for (var i = 0; i < rownum; i++) {
			$("#bclist").append("<tr><td></td><td></td><td></td></tr>");
			for (var j = 0; j < colnum; j++) {
				$("#bclist tr:eq(i) td:eq(j)").append("<a>"+num+"</a>");
num++;
			}
		}

	});
</script>
</head>

<body>
	<table align="center">
		<tr>
			<td>${requestScope.bookinfo.bookname}</td>
		</tr>

		<tr>
			<td>${requestScope.bookinfo.bookmessage}</td>
		</tr>

		<tr>
			<td><table id="bclist"></table></td>
		</tr>

	</table>
</body>
</html>
