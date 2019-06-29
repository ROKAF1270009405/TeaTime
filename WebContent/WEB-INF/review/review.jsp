<%@page import="com.teatime.review.model.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
<style>
img {
	width: 100px;
}



shop ul {
	list-style-type: none;
	float: left;
	display: block;
	width: 1000px;
}

div {
	width: 100%;
}

#shop ul li {
	display: inline-block;
}
#shop {
margin:10px;
border:10px;
}
.date{
float:right;
}
.content{
clear:both;
}
.delbtn{
float : right;
}

</style>

</head>
<body>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="shopno" value="${requestScope.shopno }"></c:set>
	<c:set var="sessiondto" value="${sessionScope.dto }"></c:set>

	<c:set var="id" value="${sessiondto.id }"></c:set>

	<c:forEach var="board" items="${list }">
			<div id="shop">
				<c:set var="dto" value="${board }"></c:set>
				<ul>
					<li class="id">${board.id }</li>
					<li class="reivewno">${board.reviewno}</li>
					<li class="date">${board.date }</li>
					${board.gpa }
					<c:if test="${board.gpa == 5.0}">
						<li class="reviewli"><img src="/reviewimg/${happy.png}"></li>
					</c:if>
					<c:if test="${board.gpa == 2.5}">
					dddd
						<li class="reviewli"><img src="/reviewimg/${happy.png}"></li>
					</c:if>
					<c:if test="${board.gpa == 0}">
					dddd
						<li class="reviewli"><img src="/reviewimg/${happy.png}"></li>
					</c:if>
				</ul>
				<div class="content">
				<p>${board.content }</p>
				</div>
				<ul>
					<c:forEach var="img" items="${board.photo }">
						<li class="reviewli"><img src="reviewuploadimg/${img }"></li>
					</c:forEach>
				</ul>

				<c:set var="name" value="${board.name }"></c:set>
				<c:if test="${id eq board.id}">
					<a href="deletemyreview.do?num=${board.reviewno}" class="btnnext"><input
						type="button" value="삭제" class="delbtn">
						</button></a>
					<input type="button" value="수정" class="delbtn"
						onclick="location.href='modifyreviewform.do?shopno=${shopno }&name=${name}&reviewno=${board.reviewno }'">
					</button>
				</c:if>
			</div>
	</c:forEach>

	<a href="addreviewform.do?shopno=${shopno }&name=${name}"><button value="글쓰기" class="delbtn">글쓰기</button></a>
</body>
</html>