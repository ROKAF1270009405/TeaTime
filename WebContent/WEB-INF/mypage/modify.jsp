<%@page import="com.teatime.review.model.ReviewDTO"%>
<%@page import="com.teatime.member.MemberDTO"%>
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
		ReviewDTO rdto = (ReviewDTO) request.getAttribute("rdto");
		
	%>
	<form action="modifyresultmyreview.do" method="post">
		<label for="content">content : </label>
		<input type="text" value="<%=rdto.getContent()%>" id="content" name="content">
		<label for="reviewno"></label>
 		<input type="hidden" id="reviewno" name="reviewno" value="<%=rdto.getReviewno()%>">
 		<input type="submit" value="수정 완료">
 		<input type="reset" value="다시 쓰기">
	</form>
</body>
</html>