<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/form.css">
<body>
	<c:set var="data" value="${requestScope.data}"></c:set>
	<div id="shop">
		<c:if test="${data!=null}">
			<h1>문의답변</h1>
			<hr>
			<ul>
				<li><label>제목</label>문의에 대한 답변입니다.</li>
				<li><label>작성일</label>${data.replyregidate}</li>
				<li><label>내용</label>${data.reply}</li>
			</ul>
		</c:if>
	</div>
</body>
</html>