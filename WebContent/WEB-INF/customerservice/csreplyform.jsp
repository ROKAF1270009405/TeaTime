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
<body>
	<c:set var="num" value="${requestScope.num}"></c:set>
	<div id="shop">
		<h2>답변작성</h2>
		<hr>
		<form method="post" action="csreplyresult.do">
			<ul>
				<li><label for="title">제목</label>
					<p>문의에 대한 답변입니다.</p>
				<li><label for="replycontent">내용</label> <textarea
						id="replycontent" name="replycontent" rows="10" cols="30"
						placeholder="내용을 입력해주세요."></textarea></li>
			</ul>
			<input type="submit" value="완료">
			<button class="btn btn-secondary" type="button"
				onclick="location.href='customerservicelist.do'">취소</button>
		</form>
	</div>
</body>
</html>