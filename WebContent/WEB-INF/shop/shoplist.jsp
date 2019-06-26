<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	   $('#add').click(function(){
		     location.href="shopadd.do";
	   });
});
</script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>사진</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="shop" items="${requestScope.list }">

				<tr>
					<td><img alt="이미지" src="${shop.photo }"></td>
					<td>${shop.name}</td>
					<td>${shop.addr}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
<button id="add">글쓰기</button>

</body>
</html>