<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>답변작성</h2>
	<form method="post" action="csreplyresult.do">
		<ul>
			<li><label for="title">제목</label>
			<p>문의에 대한 답변입니다.</p>
			<li><label for="content">내용</label> <textarea id="content"
					name="content" rows="10" cols="30" placeholder="내용을 입력해주세요."></textarea>
			</li>
		</ul>
		<input type="submit" value="완료">
		<button type="button" onclick="location.href='customerservicelist.do'">취소</button>
	</form>
</body>
</html>