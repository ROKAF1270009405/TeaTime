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
	background-image: url('img/cslist.png');
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	padding:200px 0px;
}

.tableboard {
	min-height: 250px;
	margin-left : 10%;
	magint-right: 100px;
	padding-right: 10%;
	margin-left: 10%;
}

.stateth {
	width: 200px;
}

.numth {
	width: 100px;
}

thead tr th, #qnano, #state {
	text-align: center;
}

#state1 {
	color: #f4623a;
}

#title {
	color: black;
}
</style>
<body>
	<section class="div1 page-section bg-primary">
		<div class="container h-100">
			<div
				class="row h-100 align-items-center justify-content-center text-center">
				<div class="col-lg-10 align-self-end">
					<h1 class="text-uppercase text-white font-weight-bold">고객센터</h1>
					<hr class="divider my-4">
					<p class="text-white-75 font-weight-light mb-5">궁금하신 점을 문의하면
						자세히 답변해드리겠습니다.</p>
					<a class="btn btn-primary btn-xl" href="csinsertform.do">글쓰기</a>
				</div>
			</div>
		</div>
	</section>

	<c:set var="currpage" value="${requestScope.currpage}"></c:set>
	<c:set var="startblock" value="${requestScope.startblock}"></c:set>
	<c:set var="endblock" value="${requestScope.endblock}"></c:set>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage}"></c:set>
	<div class="tableboard">
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="numth" scope="col">번호</th>
					<th scope="col">제목</th>
					<th class="stateth" scope="col">상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list}">
					<c:if test="${board.state==1}">
						<tr class="table-secondary">
					</c:if>
					<c:if test="${board.state==0}">
						<tr class="table-light">
					</c:if>
					<td id="qnano">${board.qnano}</td>
					<td><a id="title" href="csdetail.do?num=${board.qnano}">${board.title}</a></td>
					<td id="state"><c:if test="${board.state==1}">
							<span id="state1">답변완료</span>
						</c:if> <c:if test="${board.state==0}">답변 대기중</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="text-center">
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