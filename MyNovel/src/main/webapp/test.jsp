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

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function addcontenttab() {
		var table = document.getElementById("tad");
		oneRow = table.insertRow();//插入一行  
		cell1 = oneRow.insertCell();//单单插入一行是不管用的，需要插入单元格  
		cell2 = oneRow.insertCell();
		cell1.innerHTML = "sdf";
		cell2.innerHTML = "<a href='#'>retet</a>";
	}
	function delRow() {
		var rowNums = document.getElementById("tad").rows.length;
		document.getElementById("tad").deleteRow(rowNums - 1);
	}
</script>
</head>

<body>
	<table width="100%" height="300px" border="1px" id="tad">
		<tr>
			<td>1</td>
			<td>1</td>
		</tr>
		<tr>
			<td>3</td>
			<td>1</td>
		</tr>
		<tr>
			<td>5</td>
			<td>1</td>
		</tr>
	</table>
	<input type="button" onclick="addcontenttab()" value="添加行">
	<input type="button" onclick="delRow()" value="删除行">
	<table id="myTable" border="1" cellspacing="0">
		<tr>
			<td>姓名</td>
			<td>学号</td>
			<td>班级</td>
			<td>成绩</td>
			<td>性别</td>
		</tr>
		<tr>
			<td><input type="text" name="name" value="zs"
				onchange="changeContent()" /></td>
			<td><input type="text" name="no" value="2251"
				onchange="changeContent()" /></td>
			<td><input type="text" name="classname" value="电子商务"
				onchange="changeContent()" /></td>
			<td><input type="text" name="score" value="93"
				onchange="changeContent()" /></td>
			<td><input type="text" name="sex" value="男"
				onchange="changeContent()" /></td>
		</tr>

	</table>
</body>
</html>
