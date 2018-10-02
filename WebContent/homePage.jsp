<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
		<td>编号</td> <td>姓名</td> <td>密码</td> <td>出生日期</td> <td>可选操作</td>
		</tr>
		<c:forEach items="${allPage.getList()}" var="i">
		<tr>
		<td>${i.getId()}</td>
		<td>${i.getName()}</td>
		<td>${i.getPwd()}</td>
		<td>${i.getDt()}</td>
		<td><a href="${pageContext.request.contextPath}/UserAction_update.action?pageIndex=${allPage.pageIndex}&id=${i.getId()}">修改</a>
		&nbsp;&nbsp; 
		<a href="${pageContext.request.contextPath}/UserAction_del.action?id=${i.getId()}&pageIndex=${allPage.pageIndex}">删除</a> 
		</td>
		</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/ShowUser.action?pageIndex=1">首页</a> 
	<a href="${pageContext.request.contextPath}/ShowUser.action?pageIndex=${allPage.isfirst?1:allPage.pageIndex-1}">上一页</a> 
	<span>${allPage.pageIndex}/${allPage.pageCount}</span>
	<a href="${pageContext.request.contextPath}/ShowUser.action?pageIndex=${allPage.islast?allPage.pageCount:allPage.pageIndex+1}">下一页</a>
	<a href="${pageContext.request.contextPath}/ShowUser.action?pageIndex=${allPage.pageCount}">尾页</a>
</body>
</html>