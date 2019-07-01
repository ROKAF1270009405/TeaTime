<%@page import="java.util.List"%>
<%@page import="com.teatime.mypage.model.MypageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h3 {
	margin-top: 50px;
}

ul {
	list-style: none;
}

ul li {
	margin: 10px;
}

img {
	width: 300px;
}
</style>
</head>
<body>
	<h3>내가 쓴 리뷰 보기</h3>
	<%
		request.setCharacterEncoding("utf-8");
		List<MypageDTO> list = (List<MypageDTO>) request.getAttribute("list");

		for (int i = 0; i < list.size(); i++) {
	%>
	<hr>
	<%
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
			<li><img src="<%=mydto.getPhoto()%>" alt="이미지"></li>
			<li>리뷰 : <%=mydto.getContent()%></li>
		</ul>

		<a
			href="modifyreviewform.do?reviewno=<%=mydto.getReviewno()%>&shopno=<%=mydto.getShopno()%>&name=<%=mydto.getName()%>">리뷰
			수정</a> <a href="deletemyreview.do?num=<%=mydto.getReviewno()%>">리뷰 삭제</a>
	</div>
	<%
		}
		}
	%>

</body>
</html>