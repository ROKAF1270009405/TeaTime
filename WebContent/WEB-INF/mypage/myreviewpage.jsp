<%@page import="java.util.List"%>
<%@page import="com.teatime.mypage.model.MypageDTO"%>
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
		List<MypageDTO> list = (List<MypageDTO>) request.getAttribute("list");

		for (int i = 0; i < list.size(); i++) {
			MypageDTO mydto = list.get(i);

			if (mydto.getContent() == null) {
	%>

	<p>아니 리뷰가 없다고 써주고 싶은데 왜 안 나오는거야 도대체 아오 진짜
		짜증나고 배고프고 졸려서 집에 가고싶은데 언제까지 해야되는거야!!!!</p>

	<%
		} else {
	%>
	<div>
		<ul>
			<li>매장명 : <%=mydto.getName()%></li>
			<li>평점 : <%=mydto.getGpa()%></li>
			<li>사진 : <%=mydto.getPhoto()%></li>
			<li>리뷰 : <%=mydto.getContent()%></li>
		</ul>
		
		<a href="/WEB-INF/mypage/myreviewmodifyform.jsp">수정</a>		
	</div>

	<%
		}
		}
	%>

</body>
</html>