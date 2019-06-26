<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
//추가 기능 넣어야 함.
</script>
</head>
<body>

<c:forEach var="board" items="${requestScope.list }">
<div id="wrap">
<div class="shop_photo">${board.photo}</div><!-- endshop_img -->
<div class="shop_name"><a href = "detail.do?num=${board.boardno}">${board.name}</a></div><!-- endshop_title -->
<div class="shop_addr">${board.addr}</div><!-- endshop_title -->
</div><!-- endwrap -->

</c:forEach>

</body>
</html>