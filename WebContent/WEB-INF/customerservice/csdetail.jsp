<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<script>
	$(document).ready(function() {
		let num = $('#num').attr('value');
		console.log(num);
		$.ajax({
			url : "csreplydetail.do",
			dataType : "html",
			data : "num=" + num,
			success : function(data) {
				console.log(data);
				$("#replyboard").append(data);
			},
			error : function(data) {
				console.log('error');
			}
		});
	});
</script>
<body>
	<c:set var="data" value="${requestScope.data}"></c:set>

	<c:if test="${data!=null}">
		<ul>
			<input id="num" type="hidden" value="${data.qnano}">
			<input id="replydate" type="hidden" value="${data.replyregidate}">
			<input id="reply" type="hidden" value="${data.reply}">
			<li><label for="id">아이디</label>${id}</li>
			<li><label for="hp">연락처</label>${data.hp}</li>
			<li><label for="email">이메일</label>${email}</li>
			<li><label for="date">작성일</label>${data.regidate}</li>
			<li><label for="title">제목</label>${data.title}</li>
			<li><label for="content">내용</label>${data.content}</li>
		</ul>

		<a href="csreply.do?num=${data.qnano}">답변하기</a>
		<a href="csdelete.do?num=${data.qnano}">삭제</a>
		<a href="csmodify.do?num=${data.qnano}">수정</a>
		<a href="customerservicelist.do">목록으로</a>
	</c:if>
	<div id="replyboard"></div>
</body>
</html>