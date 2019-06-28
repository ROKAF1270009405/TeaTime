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
section{
 dislay:block;
 height:150px;
}

section ul{
list-style-type: none;
float:left;
display:block;
}

section ul li{
  display: inline-block;
}

</style>
</head>
<body>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="shopno" value="${requestScope.shopno }"></c:set>
	<c:forEach var="board" items="${list }">
		<section class="review">
			<ul>
				<li class="id">${board.id }</li>
				<li class="date">${board.reviewno}</li>
				<li class="content">${board.content}</li>
			</ul>
		
			<ul>
			<c:forEach var="img" items="${board.photo }">
				<li class="reviewli"><img src="reviewuploadimg/${img }"></li>
			</c:forEach>
			</ul>
			<div>${board.gpa}</div>
			<c:set var="name" value="${board.name }"></c:set>>
		</section>
	</c:forEach>

	<a href="addreviewform.do?shopno=${shopno }">글쓰기</a>
</body>
</html>