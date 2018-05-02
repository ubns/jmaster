<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	int counter = 0;

	int getCounter() {
		counter++;
		return counter;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

あなたは、<%= getCounter() %>番目のアクセスです。

</body>
</html>