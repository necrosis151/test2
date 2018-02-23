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

<title>My JSP 'novelList.jsp' starting page</title>

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
	var list = JSON.parse('${books}');
	var colnum = 3;
	var rownum = Math.ceil(list.length/colnum);
	function jtos(str) {		
		return JSON.stringify(str).replace(/\"/g, "");
	}
	
	
	$(document).ready(
			function() {
			for (var i = 0; i < rownum; i++) {
				$("#booklist").append("<tr><td></td><td></td><td></td></tr>");
			}	

				var listnum = 0;
				for (var i = 0; i < rownum; i++) {
					for (var j = 0; j < colnum; j++) {
						$("#booklist tr:eq("+i+") td:eq("+j+")").html("<a href=book/getcontent"+jtos(list[listnum]['idbookinfo'])+">"+jtos(list[listnum]['bookname'])+"</a>");
						listnum++;
					}
				}

			});
</script>
</head>

<body>
	<h1 align="center">booklist</h1>
	<table id="booklist" align="center"></table>
	
</body>
</html>
