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
</script>
</head>
<body>

<form method="post" action="shopsearch.jsp">
		<input type="text" name="text" id="text"> 
		<input type="submit" value="검색">
	</form>
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
					<td><a href="detail.do?shopno=${shop.shopno }">${shop.name}</a></td>
					<td>${shop.addr}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>