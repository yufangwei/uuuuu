<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<body>
		输入账号：<input type="text" name="name" id="name"/><br/><br/>
		输入密码：<input type="password" name="pwd" id="pwd"/><br/><br/>
		<input type="button" id="but" value="登录"/>
	</form>
	<a href="resgiter.jsp">注册</a>
</body>
<script type="text/javascript">
	$(function(){
		$("#but").click(function(){
			$("#tab").remove();
			$.ajax({
				url:"AjaxAction_ajax.action",
				type:"post",
				dataType:"json",
				data:"name="+$("#name").val()+"&pwd="+$("#pwd").val(),
				success:function(data){
					var table = $("<table border=1 id='tab'> <tr> <td>编号</td>  <td>呢称</td>  <td>密码</td>  <td>生日</td> </tr></table>");
					$(data.list).each(function(i,o){
  						var tr=("<tr><td>"+o.id+"</td> <td>"+o.name+"</td> <td>"+o.pwd+"</td> <td>"+o.dt+"</td> </tr>");
  						table.append(tr);
					})
					$("body").append(table);
				}
			})
		})
	})
</script>
</html>