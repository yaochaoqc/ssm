<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path",path);
    request.setAttribute("basePath",basePath);
%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form action="${path}/user/register.html" method="post">
		<table>
			<tr>
				<td colspan="2"><h1>注册</h1></td>
			</tr>
			<tr>
				<td>请输入用户名:</td>
				<td><input type="text" name="userName" value=""></td>
			</tr>
			<tr>
				<td>请输入密 码:</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
