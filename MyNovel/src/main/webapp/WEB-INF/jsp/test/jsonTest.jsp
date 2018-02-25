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

<title>My JSP 'jsonTest.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	var data = [ {
		name : "传智播客",
		url : "http://www.itcast.cn",
		type : "IT最强培训机构"
	}, {
		name : "黑马程序员",
		url : "http://www.itheima.com",
		type : "大学生IT培训机构"
	}, {
		name : "传智前端学院",
		url : "http://web.itcast.cn",
		type : "前端的黄埔军校"
	} ];

	$(function() {
		//第一种：动态创建表格的方式，使用拼接html的方式 （推荐）
		// var html = "";
		// for( var i = 0; i < data.length; i++ ) {
		//     html += "<tr>";
		//     html +=     "<td>" + data[i].name + "</td>"
		//     html +=     "<td>" + data[i].url + "</td>"
		//     html +=     "<td>" + data[i].type + "</td>"
		//     html += "</tr>";
		// }
		// $("#J_TbData").html(html);

		//第二种： 动态创建表格的方式，使用动态创建dom对象的方式
		//清空所有的子节点
		$("#J_TbData").empty();

		//自杀
		// $("#J_TbData").remove();

		for (var i = 0; i < data.length; i++) {
			//动态创建一个tr行标签,并且转换成jQuery对象
			var $trTemp = $("<tr></tr>");

			//往行里面追加 td单元格
			$trTemp.append("<td>" + data[i].name + "</td>");
			$trTemp.append("<td>" + data[i].url + "</td>");
			$trTemp.append("<td>" + data[i].type + "</td>");
			// $("#J_TbData").append($trTemp);
			$trTemp.appendTo("#J_TbData");
		}
	});
	//定义json对象
	$(document)
			.ready(
					function() {
						var num = 0;
						$("#add")
								.click(

										function() {
											num = num + 1;
											var trtd = $('<tr><td>'
													+ num
													+ '每天只睡四个小时的诀窍</td><td>再一次起床</td><td>保持五个月每天只睡四个小时的话...</td><td>&nbsp;删除</td></tr>');
											trtd.appendTo($("#tables"));
										});
					});
	function goback() {
		var json = {
			"username" : "test",
			"password" : 123
		};

		$.ajax({
			url : "jsontest",
			type : "post",
			async : true,
			contentType : "application/json",
			data : JSON.stringify(json),
			dataType : 'json',
			success : function(data) {
				alert(JSON.stringify(data.username));
			}

		});
	}

	// Jquery Ajax请求
</script>
</head>

<body>
	<input type="button" onclick="goback()" value="按钮">
	<br>
	<form action="jsontest" method="post">
		<input type="text" name="username"> <input type="text"
			name="password"> <input type="submit" value="submit">
	</form>

	<input id="add" type="button" value="添加">
	<table id="tables">
		<tr>
			<th>标题</th>
			<th>发表人</th>
			<th>内容简介</th>
			<th>操作</th>
		</tr>
	</table>
	
	<table id="J_TbData"></table>
</body>
</html>
