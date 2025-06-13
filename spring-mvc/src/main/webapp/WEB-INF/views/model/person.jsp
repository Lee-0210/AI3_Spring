<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름 : ${person.name }</h1>
	<h1>나이 : ${person.age }</h1>
	<h1>문자열 파라미터로 : ${paramName}</h1>
	
	<form action="<%=request.getContextPath() %>/model/person2" method="post">
		<input type="text" name="name"/>
		<input type="text" name="age" />
		<button type="submit">등록</button>
	</form>
</body>
</html>