<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board Insert</title>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">
</head>
<body>
	<h1>게시글 쓰기</h1>
    
    <form class="" action="${ pageContext.request.contextPath }/board/insert" method="POST">
        <table>
            <tr>
                <td><label for="title">제목</label></td>
                <td><input type="text" name="title"  /></td>
            </tr>
            <tr>
                <td><label for="writer">작성자</label></td>
                <td><input type="text" name="writer" /></td>
            </tr>
            <tr>
                <td><label for="content">내용</label></td>
                <td>
                    <textarea rows="5" cols="20" name="content" ></textarea>
                </td>
            </tr>
        </table>
        <div>
            <input type="submit" value="등록" class="btn btn-primary"/>
        </div>
    </form>
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
		crossorigin="anonymous"></script>
</body>
</html>