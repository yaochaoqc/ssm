<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path",path);
    request.setAttribute("basePath",basePath);
%>
<html>
<head>
<script type="text/javascript" src="${path}/ssm/js/welcome.js"></script>
<script type="text/javascript" src="${path}/ssm/js/jquery.min.js"></script>
<title>welcome</title>
<script type="text/javascript">
	var path = '${basePath}';
</script>
</head>
<body>
	<div>欢迎你!${user.userName}</div>
	<table style="width: 600px">
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${users}" var="u" varStatus="status">
			<tr id="${u.id}">
				<td>${u.id}</td>
				<td>${u.userName}</td>
				<td>${u.password}</td>
				<td>${u.isSuper}</td>
				<td><button onclick="del('${u.id}')">删除</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
