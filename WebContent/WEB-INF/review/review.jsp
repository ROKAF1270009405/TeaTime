<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>gr</th>
				<th>lev</th>
				<th>ord</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${list }">
				<tr>
					<td>${board.reviewno}</td>
					<td><a href="detail.do?num=${board.reviewno}">${board.title}</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="insert.do">글쓰기</a>
</body>
</html>