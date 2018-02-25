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
	var colnum = 3;
	var pageSize = 4;
	var pageNum = 1;
	var rownum = 2;
	function isEmptyObject(obj) {

		for (k in obj) {
			return false;
		}
		return true;
	}
	function getbooklist(pageNum, pageSize) {

		$
				.ajax({
					url : "ajax/getbookinfo",
					type : "POST",
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					data : JSON.stringify({
						"pageNum" : pageNum,
						"pageSize" : pageSize
					}),
					success : function(result) {

						var listnum = 0;
						for (var i = 0; i < rownum; i++) {
							for (var j = 0; j < colnum; j++) {
								if (!isEmptyObject(result[listnum])) {

									$(
											"#booklist tr:eq(" + i + ") td:eq("
													+ j + ")")
											.html(
													"<a href=book/getcontent"
										+ result[listnum].idbookinfo
										+ ">"
															+ result[listnum].bookname
															+ "</a>");
									listnum++;
								} else {
									$(
											"#booklist tr:eq(" + i + ") td:eq("
													+ j + ")").html("");
								}

							}
						}
					},
					error : function() {
					alert("fail");
					}
				});
	}

	$(document).ready(function() {

		for (var i = 0; i < rownum; i++) {
			$("#booklist").append("<tr><td></td><td></td><td></td></tr>");
		}
		getbooklist(pageNum, pageSize);
		$("#page a").click(function() {
			pageNum = $(this).text();
			getbooklist(pageNum, pageSize);
		});
	});
</script>
</head>

<body>
	<h1 align="center">booklist</h1>
	<table id="booklist" align="center"></table>
	<hr>
	<table align="center" id="page">
		<tr>
			<td><a href="#" onclick=" return false; ">1</a></td>
			<td><a href="#" onclick=" return false; ">2</a></td>
			<td><a href="#" onclick=" return false; ">3</a></td>
			<td><a href="#" onclick=" return false; ">4</a></td>
		</tr>
	</table>
</body>
</html>
