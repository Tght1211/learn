<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		
		$post("AjaxDemo","name=John&location=Boston",function(){
			alert("Data Saved:")
		});
		

// 		$.get("AjaxDemo", {
// 			name : "John",
// 			age : "18"
// 		}, function(msg) {
// 			alert("msg: " + msg.name);
// 		},"json");

// 				$.ajax({
// 					type : "get",
// 					url : "AjaxDemo", 
// 					data : {"name":"zhangsan","age":18},
// 		         dataType:"json",
// 					success : function(msg) {
// 						alert("Data Saved:" + msg);
// 					}
// 		           error:function(){
// 		        	   alert("error!!!");
// 		           }
// 				});
	});
</script>
</head>
<body>
	<a href="www.bilibili.com">哔哩哔哩</a>
</body>
</html>