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
<style>
ul li {
	padding-left: 0px;
	list-style: none;
}

ul {
	padding-left: 0px;
}

label {
	width: 100px;
}

.rightbtn {
	float: right;
}

.btnbottom {
	clear: both;
}

.contentheight {
	height: 200px;
}

.form {
	width: 1000px;
	min-height: 500px;
	background-color: rgba(0, 0, 0, 0.075);
	padding: 50px 50px;
}

#replyboard{
	margin-top: 20px;
}
</style>

<link rel="stylesheet" type="text/css" href="css/form.css">
<body>
	<c:set var="data" value="${requestScope.data}"></c:set>

	<c:if test="${data!=null}">
		<div id="shop">
			<ul>
				<h1>문의사항</h1>
				<hr>
				<input id="num" type="hidden" value="${data.qnano}">
				<li><label for="id">아이디</label>${sessionScope.dto.id}</li>
				<li><label for="hp">연락처</label>${data.hp}</li>
				<li><label for="email">이메일</label>${sessionScope.dto.mail}</li>
				<li><label for="date">작성일</label>${data.regidate}</li>
				<li><label for="title">제목</label>${data.title}</li>
				<li><label class="contentheight" for="content">내용</label>${data.content}</li>
			</ul>
			<c:if test="${sessionScope.dto.authority==1}">
				<a class="btn btn-primary" href="csreply.do?num=${data.qnano}">답변하기</a>
				<a class="btn btn-secondary" href="csdelete.do?num=${data.qnano}">삭제</a>
			</c:if>
			<c:if test="${sessionScope.dto.authority==0}">
			<a class="btn btn-primary" href="csdelete.do?num=${data.qnano}">삭제</a>
				<a class="btn btn-secondary" href="csmodify.do?num=${data.qnano}">수정</a>
			</c:if>
			<a class="btn btn-secondary rightbtn" href="customerservicelist.do">목록으로</a>
	</c:if>
	<c:if test="${data.reply!=null}">
		<div id="replyboard">
			<h1>문의답변</h1>
			<hr>
			<div id="replyboard"></div>
		</div>
	</c:if>
	</div>
</body>
</html>