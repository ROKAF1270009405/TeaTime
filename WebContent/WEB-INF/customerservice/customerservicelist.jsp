<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header> 
	<!-- <img src="img/cslist.jpg"/> -->
	</header>
	<section> <c:set var="currpage"
		value="${requestScope.currpage}"></c:set> <c:set var="startblock"
		value="${requestScope.startblock}"></c:set> <c:set var="endblock"
		value="${requestScope.endblock}"></c:set> <c:set var="list"
		value="${requestScope.list}"></c:set> <c:set var="totalpage"
		value="${requestScope.totalpage}"></c:set>

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
	</c:if> <c:forEach var="i" begin="${startblock}" end="${endblock}">
		<c:if test="${i==currpage }">
			<c:out value="${i}"></c:out>
		</c:if>
		<c:if test="${i!=currpage}">
			<a href="list.do?currpage=${i}"><c:out value="${i}"></c:out></a>
		</c:if>
	</c:forEach> <c:if test="${endblock<totalpage}">
		<a href="list.do?currpage=${endblock+1}">다음</a>
	</c:if> </section>


</body>
</html>