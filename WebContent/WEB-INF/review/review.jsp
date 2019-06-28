<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
img {
	width: 100px;
}

section {
	dislay: block;
	height: 150px;
}

section ul {
	list-style-type: none;
	float: left;
	display: block;
}

section ul li {
	display: inline-block;
}
</style>
</head>
<body>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="shopno" value="${requestScope.shopno }"></c:set>
	<c:set var="sessiondto" value="${sessionScope.dto }"></c:set>

	<c:set var="id" value="${sessiondto.id }"></c:set>

	<c:forEach var="board" items="${list }">
		<section class="review">
			<ul>
				<li class="id">${board.id }</li>
				<li class="date">${board.reviewno}</li>
				<li class="content">${board.content}</li>
				<ul>
					<c:forEach var="img" items="${board.photo }">
						<li class="reviewli"><img src="reviewuploadimg/${img }"></li>
					</c:forEach>
				</ul>
				<li>${board.gpa}</li>
				<c:set var="name" value="${board.name }"></c:set>
				<c:if test="${id eq board.id}">
					<input type="button" value="삭제">
					<input type="button" value="수정" onclick="location.href='modifyreviewform.do?shopno=${shopno }&name=${name}'">
				</c:if>
			</ul>
		</section>
	</c:forEach>

	<a href="addreviewform.do?shopno=${shopno }&name=${name}">글쓰기</a>
</body>
</html>