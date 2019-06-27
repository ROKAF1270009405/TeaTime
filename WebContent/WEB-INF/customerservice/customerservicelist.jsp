<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.div1 {
	width: 100%;
	background-image: url('img/cslist.png');
	background-repeat: no-repeat;
	background-size: contain;
}
</style>
<body>
	<div class="div1">
		<h1>고객센터</h1>
		<p>궁금하신 점을 문의하면 자세히 답변해드리겠습니다.</p>
		<a href="csinsertform.do">글쓰기</a>
	</div>
	<div>
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
						<td><a href="csdetail.do?num=${board.qnano}">${board.title}</a></td>
						<td><c:if test="${board.state==1}">답변완료</c:if>
						<c:if test="${board.state==0}">답변 대기중</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${startblock>1 }">
			<a href="customerservicelist.do?currpage=${startblock-1 }">이전</a>
		</c:if>
		<c:forEach var="i" begin="${startblock}" end="${endblock}">
			<c:if test="${i==currpage }">
				<c:out value="${i}"></c:out>
			</c:if>
			<c:if test="${i!=currpage}">
				<a href="customerservicelist.do?currpage=${i}"><c:out
						value="${i}"></c:out></a>
			</c:if>
		</c:forEach>
		<c:if test="${endblock<totalpage}">
			<a href="customerservicelist.do?currpage=${endblock+1}">다음</a>
		</c:if>
	</div>
</body>
</html>