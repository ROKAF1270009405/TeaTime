<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

	<form method="post" action="shopaddresult.do">
		<ul id="test">
			<li><label for="name">가게이름</label> <input type="text" id="name"
				name="name"></li>
			<li><label for="content">가게설명</label> <textarea name="content"
					id="content" cols="30" rows="5" maxlength="100"></textarea></li>
			<li><label for="photo">사진첨부</label> <input type="text" id="photo"
				name="photo"></li>
				<li><label for="addr">주소</label> <input type="text" id="addr"
				name="addr"></li>
				<li><label for="workingtime">운영시간</label> <input type="text" id="workingtime"
				name="workingtime"></li>
			<li class="button"><input type="submit" value="완료"></li>
		</ul>
	</form>

<hr>



</body>
</html>