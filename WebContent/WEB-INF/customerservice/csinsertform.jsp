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
ul li {
	list-style: none;
}

ul {
	width: 100%;
	padding: 0px 40px;
	display: inline-block;
	padding: 0px 40px;
}

label {
	width: 100px;
}

.btn1 {
	width: 100%;
	padding: 14px 20px;
}
</style>

<body>
	<div id="shop">
		<h2>문의작성</h2>
		<hr>
		<form method="post" action="csinsertresult.do">
			<ul>
				<li><label for="id">아이디</label>${id}</li>
				<li><label for="hp">연락처</label><input type="text" name="hp"
					id="hp" required="required" placeholder="연락처를 입력해주세요."></li>
				<li><label for="title">제목</label><input type="text"
					name="title" id="title" required="required"
					placeholder="제목을 입력해주세요."></li>
				<li><label for="content">내용</label> <textarea id="content"
						name="content" rows="10" cols="30" placeholder="내용을 입력해주세요."></textarea>
				</li>
			</ul>
			<input type="submit" value="완료" class="btn btn-primary">
			<button class="btn btn-secondary btn1" type="button"
				onclick="location.href='customerservicelist.do'">취소</button>
	</div>
	</form>
</body>
</html>