<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="data" value="${requestScope.data}"></c:set>

	<c:if test="${data!=null}">
		<ul>
			<li><label for="id">아이디</label>${data.id}</li>
			<li><label for="hp">연락처</label>${data.hp}</li>
			<li><label for="email">이메일</label>${email}</li>
			<li><label for="date">작성일</label>${data.regidate}</li>
			<li><label for="title">제목</label>${data.title}</li>
			<li><label for="content">내용</label>${data.content}</li>
		</ul>
		<button onclick="del()">삭제</button>
		<button>수정</button>
	</c:if>
</body>
</html>