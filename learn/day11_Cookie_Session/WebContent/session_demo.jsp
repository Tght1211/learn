<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	sessionID:<%=session.getId()%><br>
	<a href="GetSessionServlet?method=doGet">获取Session</a><br>
	<a href="ChiSessionServlet?method=doGet">持久化Session</a><br>
<!-- 	<a href="ChiSessionServlet?method=doPost">设置非活动时间Session</a><br> -->
	<a href="ShiSessionServlet?method=doGet">立即失效Session</a><br>
	<%=session.getAttribute("stu") %>
	
</body>
</html>