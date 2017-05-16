<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path",path);
    request.setAttribute("basePath",basePath);
%>
<html>
<head>
<title>Login</title>
<script type="text/javascript" src="${path}/ssm/js/index.js"></script>
<script type="text/javascript" src="${path}/ssm/js/jquery.min.js"></script>
<script type="text/javascript">
	var path = '${basePath}';
</script>
</head>
<body>
	<a href="${path}/user/getLogin.html">登陆</a>
	<a href="${path}/user/getRegister.html">注册</a>
	<!-- <button type="button" onclick="login()">登陆</button> -->
</body>
</html>
