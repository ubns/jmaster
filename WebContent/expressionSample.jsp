<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		int i = 10;
		Date today = new Date();
	%>
	
	<h2>式で値を表示</h2>
	iの値は<%= i %>です。
	<br>todayの値は<%= today %>です。
	
</body>
</html>