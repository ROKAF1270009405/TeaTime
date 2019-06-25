<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Font Awesome Icons -->
<link href="./Resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
	rel="stylesheet">
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="./Resources/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet">

<!-- Theme CSS - Includes Bootstrap -->
<link href="./Resources/css/creative.min.css" rel="stylesheet">

</head>
<body>
	<c:set var="currpage" value="${requestScope.currpage}"></c:set>
	<c:set var="startblock" value="${requestScope.startblock}"></c:set>
	<c:set var="endblock" value="${requestScope.endblock}"></c:set>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage}"></c:set>

	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${list}">
				<tr class="table-info">
					<td>${board.qnano}</td>
					<td>${board.title}</td>
					<td>${board.state}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${startblock>1 }">
		<a href="list.do?currpage=${startblock-1 }">이전</a>
	</c:if>
	<c:forEach var="i" begin="${startblock}" end="${endblock}">
		<c:if test="${i==currpage }">
			<c:out value="${i}"></c:out>
		</c:if>
		<c:if test="${i!=currpage}">
			<a href="list.do?currpage=${i}"><c:out value="${i}"></c:out></a>
		</c:if>
	</c:forEach>
	<c:if test="${endblock<totalpage}">
		<a href="list.do?currpage=${endblock+1}">다음</a>
	</c:if>



</body>
</html>