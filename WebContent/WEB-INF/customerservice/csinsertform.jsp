<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form method="post" action="csinsertresult.do">
		<ul>
			<li><label for="id">아이디</label></li>
			<li><label for="hp">연락처</label><input type="text" name="hp"
				id="hp" required="required" placeholder="연락처를 입력하세요."></li>
			<li><label for="email">이메일</label>
			<li><label for="title">제목</label><input type="text" name="title"
				id="title" required="required" placeholder="제목을 입력하세요."></li>
			<li><label for="content">내용</label>
			<textarea rows="10" cols="30" placeholder="내용을 입력하세요."></textarea>
			</li>
			<li><input type="submit" value="완료"> <input type="reset"
				value="취소"></li>
		</ul>

	</form>
</body>
</html>