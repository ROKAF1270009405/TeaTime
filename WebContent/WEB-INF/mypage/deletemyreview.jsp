<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int num = (Integer) request.getAttribute("result");
		if (num > 0) {
	%>
	<script>
		alert('삭제 되었습니다!');
		location.href = 'mypage.do';
	</script>

	<%
		} else {
	%>
	<script>
		alert('삭제가 안 돼요!');
		location.href = 'mypage.do';
	</script>

	<%
		}
	%>
</body>
</html>