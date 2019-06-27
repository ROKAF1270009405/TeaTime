<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="data" value="${requestScope.data}"></c:set>
	
	<c:if test="${data!=null}">
		<ul>
			<li><label>제목</label>문의에 대한 답변입니다.</li>
			<li><label>작성일</label>${data.replyregidate}</li>
			<li><label>내용</label>${data.reply}</li>
		</ul>
		
		<%-- <a href="csreply.do?num=${data.qnano}">답변하기</a>
		<a href="csdelete.do?num=${data.qnano}">삭제</a>
		<a href="csmodify.do?num=${data.qnano}">수정</a>
		<a href="customerservicelist.do">목록으로</a> --%>
	</c:if>

</body>
</html>