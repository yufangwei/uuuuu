<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UserAction_login.action?pageIndex=1 " method="post">
		输入账号：<input type="text" name="name" id="name"/><br/><br/>
		输入密码：<input type="password" name="pwd" id="pwd"/><br/><br/>
		<input type="submit" value="登录"/>
	</form>
	<a href="resgiter.jsp">注册</a>
</body>
</html>