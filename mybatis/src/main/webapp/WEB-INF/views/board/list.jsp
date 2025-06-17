<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Board List</h1>
		
		<table border="1" style="text-align: center;" class="table table-success table-striped">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일자</th>
				<th>수정일자</th>
			</tr>
			<c:if test="${not empty boardList }">
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.no }</td>
						<td>
							<a href="${root }/board/read?no=${board.no}">
								${board.title }
							</a>
						</td>
						<td>${board.writer }</td>
						<td>
							<fmt:formatDate value="${board.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<fmt:formatDate value="${board.updatedAt }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty boardList }">
				<td colspan="5">조회된 데이터가 없습니다.</td>
			</c:if>
		</table>	
		<div class="d-grid gap-1">
			<a href="${root }/board/insert" class="btn btn-primary mb-2">글쓰기</a>
			<button onclick="history.back()" class="btn btn-dark">뒤로가기</button>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>