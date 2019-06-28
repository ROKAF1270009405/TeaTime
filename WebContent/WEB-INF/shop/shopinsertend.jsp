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
		request.setCharacterEncoding("UTF-8");
		int result = (int) request.getAttribute("result");
		if (result == 1) {
			%>
			<script>
				alert("내용 추가가 완료되었습니다.");
				location.href="teatime.do";
			</script>
			<%
		} else {
			%>
			<script>
				alert("내용 추가에 실패했습니다.");
				location.href="shopadd.do";
			</script>
			<%
		}
	%>
</body>
</html>