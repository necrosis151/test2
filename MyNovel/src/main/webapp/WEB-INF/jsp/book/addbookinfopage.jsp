<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'addbookinfopage.jsp' starting page</title>

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
	function deleteTr(obj) {
		$(obj).parent().parent().remove();
		sortTable();
	}
	
	function sortTable() {
		var len = $("#filesTable tr").length;
		for (var i = 0; i < len; i++) {
			$("#filesTable tr:eq(" + i + ") td:first").text(i + 1 + ".");
	//		$("#filesTable tr:eq(" + i + ") td:eq(1) input:eq(0)").attr("name","file"+i+1);
					
		}
	}

	$(document)
			.ready(
					function() {

						$("#addFile")
								.click(
										function() {
											var html = '<tr><td></td>'
													+ '<td><input type="text" name="filenames"><input type="file" name="files"></td>'
													+ '<td><input type="button" onclick="deleteTr(this)" value="删除行"></td>'
													+ '</tr>';
											$(html).appendTo($("#filesTable"));
											sortTable();
										});
					});
</script>
</head>

<body>
	<h1 align="center">addbookinfo</h1>
	<hr>
	<form action="book/bookmanage/addbookinfo"
		enctype="multipart/form-data" method="post">
		<table id="upload">
			<tr>
				<td>书名:</td>
				<td><input type="text" name="bookname"></td>
			</tr>
			<tr>
				<td>简介:</td>
				<td><input type="text" name="bookmessage"></td>
			</tr>
			<tr>
				<td>类型:</td>
				<td>
					<table>
						<tr>
							<c:forEach items="${requestScope.types}" var="type">
								<td>${type.type}<input type="checkbox" name="typelists"
									value="${type.idtypes}">&nbsp;&nbsp;
								</td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input id="addFile" type="button" value="添加"></td>
			</tr>
			<tr>
				<td colspan="2"><table id="filesTable"></table></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>

</body>
</html>
