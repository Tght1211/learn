<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isErrorPage=true"" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int a = 100;
//		int a = i/0;
		%>
	<%!int a = 1;%>
	这是我的第<%=a %>个jsp页面！
	<h1>include</h1>
<%-- 	<%@ include file="NewFile.jsp" %> --%>
	<!-- 将另一个jsp页面包含进来，另一个页面的变量名字，不能与原页面冲突 -->
	<h1>动作标签</h1>
<%-- 	<jsp:forward page="NewFile.jsp"></jsp:forward> --%>
	<!-- 转发,可以携带参数 -->
	<h1>动态包含</h1>
	<jsp:include page="NewFile.jsp"></jsp:include>
</body>
</html>