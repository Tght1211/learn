<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>王常杰的宝库</h1>
	<!-- WEB-INF资源客户端无法直接访问，需要去servlet -->
	<%-- 	<a href="${pageContexnt.request.contextPath }/download/等我们老了.mp3">等我们老了.mp3</a> --%>
	<a
		href="${pageContext.request.contextPath }/FileDownLoadDemo?fileName=等我们老了.mp3">等我们老了.mp3</a>
	<a
		href="${pageContext.request.contextPath }/FileDownLoadDemo?fileName=桌面.mp4">桌面.mp4</a>
	<a
		href="${pageContext.request.contextPath }/FileDownLoadDemo?fileName=dwhd.txt">dwhd.txt</a>
</body>
</html>