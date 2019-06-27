<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
ul li {
	list-style: none;
}

ul {
	margin: 0px;
	padding: 0px;
	display: inline-block;
}

label {
	width: 100px;
}
</style>
<body>
	<h2>문의작성</h2>
	<form method="post" action="csinsertresult.do">
		<ul>
			<li><label for="id">아이디</label>${id}</li>
			<li><label for="hp">연락처</label><input type="text" name="hp"
				id="hp" required="required" placeholder="연락처를 입력해주세요."></li>
			<li><label for="email">이메일</label>${email}</li>
			<li><label for="title">제목</label><input type="text" name="title"
				id="title" required="required" placeholder="제목을 입력해주세요."></li>
			<li><label for="content">내용</label> <textarea id="content"
					name="content" rows="10" cols="30" placeholder="내용을 입력해주세요."></textarea>
			</li>
		</ul>
		<input type="submit" value="완료">
		<button type="button" onclick="location.href='customerservicelist.do'">취소</button>
	</form>
</body>
</html>