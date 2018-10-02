<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UserAction_upd.action?pageIndex=${pageIndex}" method="post">
	编号<input type="text" name="id" value="${user.id} " readonly="readonly"/><br/>
	姓名<input type="text" placeholder="${user.name}" name="name"/><br/>
	密码<input type="text" placeholder="${user.pwd}" name="pwd"/><br/>
	生日<input type="date" placeholder="${user.dt}" name="dt" /><br/>
	<input type="submit" value="修改">
	</form>
</body>
</html>