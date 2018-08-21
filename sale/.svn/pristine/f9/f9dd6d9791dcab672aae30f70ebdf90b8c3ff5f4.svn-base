<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/userAction_login" method="post">
	用户名<input type="text" name="uname"></br>
	密码<input type="password" name="pwd"></br>
	<input type="submit" value="登陆">
	你还没有账号吗？那还等什么？<a href="${pageContext.request.contextPath}/regist.jsp">赶紧注册吧</a></br>
	<font color="red" ><s:property value="exception.message" />
	</form>
</body>
</html>