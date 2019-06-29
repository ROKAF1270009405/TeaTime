<%@page import="java.util.List"%>
<%@page import="com.teatime.mypage.model.MypageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
.wrap {
	witdh: 1600px;
	display: inline-block;
}

ul {
	list-style: none;
	position: relative;
	width: 300px;
}

a {
	display: block;
}
</style> -->
</head>
<body>
	<h3>내가 쓴 리뷰 보기</h3>
	<%
		request.setCharacterEncoding("utf-8");
		List<MypageDTO> list = (List<MypageDTO>) request.getAttribute("list");

		for (int i = 0; i < list.size(); i++) {
	%> <hr><%
			MypageDTO mydto = list.get(i);
			if (mydto.getContent() == null) {
	%>

	<%
		} else {
	%>
	<div class="wrap">
		<ul>
			<li>매장명 : <%=mydto.getName()%></li>
			<li>평점 : <%=mydto.getGpa()%></li>
			<li>사진 : <%=mydto.getPhoto()%></li>
			<li>리뷰 : <%=mydto.getContent()%></li>
		</ul>
		<a href="modifymyreview.do?reviewno=<%=mydto.getReviewno()%>">수정</a>
		<a href="deletemyreview.do?num=<%=mydto.getReviewno()%>">삭제</a>
	</div>

	<%
		}
		}
	%>

</body>
</html>