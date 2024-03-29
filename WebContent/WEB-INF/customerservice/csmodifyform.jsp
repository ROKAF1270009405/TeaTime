<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/form.css">
<style>
label {
	width: 80px;
}

.btn1 {
	width: 100%;
	padding: 14px 20px;
}
</style>
<body>

	<c:set var="data" value="${requestScope.data}"></c:set>
	<div id="shop">
		<h2>문의작성</h2>
		<hr>
		<form method="post" action="csmodifyresult.do">
			<ul>
				<input type="hidden" value="${data.qnano}" name="num" id="num">
				<li><label for="id">아이디</label>${sessionScope.dto.id}</li>
				<li><label for="hp">연락처</label><input type="text" name="hp"
					id="hp" required="required" value="${data.hp}"></li>
				<li><label for="title">제목</label><input type="text"
					name="title" id="title" required="required" value="${data.title}"></li>
				<li><label for="content">내용</label> <textarea id="content"
						name="content" rows="10" cols="30">${data.content}</textarea></li>
			</ul>
			<input type="submit" value="완료">
			<button class="btn btn-secondary btn1" type="button"
				onclick="location.href='csdetail.do?num=${data.qnano}'">취소</button>
		</form>
	</div>
</body>
</html>