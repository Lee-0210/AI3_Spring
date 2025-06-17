<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;" class="mb-3">회원가입</h1>
		<form action="${root}/user/signin" method="post">
			<div class="row mb-3">
				<label for="name" class="col-sm-2 col-form-label">성함</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name">
				</div>
			</div>
			<div class="row mb-3">
				<label for="id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="id" name="id">
				</div>
			</div>
			<div class="row mb-3">
				<label for="password" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password">
				</div>
			</div>
			<div class="row mb-3">
				<label for="username" class="col-sm-2 col-form-label">닉네임</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="username" name="username">
				</div>
			</div>
			<div class="row mb-3">
				<label for="email" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" name="email">
				</div>
			</div>
			<div class="text-center d-grid gap-1">
				<button type="submit" class="btn btn-primary">회원가입</button>
				<button onclick="history.back()" class="btn btn-dark">뒤로가기</button>
			</div>
		</form>
	</div> 
	
	<hr>
	
	<div>
		<h2>회원가입</h2>
		<form:form modelAttribute="user" method="post" action="${root}/user/signin">
		    아이디: <form:input path="id" />
		    <form:errors style="color: red;" path="id" cssClass="error" /><br/>
		
		    닉네임: <form:input path="username" />
		    <form:errors style="color: red;" path="username" cssClass="error" /><br/>
		
		    비밀번호: <form:password path="password" />
		    <form:errors style="color: red;" path="password" cssClass="error" /><br/>
		
		    이름: <form:input path="name" />
		    <form:errors style="color: red;" path="name" cssClass="error" /><br/>
		
		    이메일: <form:input path="email" />
		    <form:errors style="color: red;" path="email" cssClass="error" /><br/>
		
		    <button type="submit">회원가입</button>
		</form:form>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
		crossorigin="anonymous"></script>
</body>
</html>