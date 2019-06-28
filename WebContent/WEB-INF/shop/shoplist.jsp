<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
#main_img_wrap {
	width: 100%;
}

.main_img {
	display: inline-block;
}

.main_img {
}

ul li {
	list-style-type: none;
}

.main_img li:nth-child(1) {
	width: 300px;
	height: 300px;
	float: left;
	background-color: orange;
	display: inline-block;
	overflow: hidden;
	
	margin: 0 auto 0 auto;
	padding: 0px;
}
</style>
</head>
<body>

	<form method="post" action="teatime.do">
	
		<input type="text" name="text" id="text">
		<input type="submit" value="검색"><br>
		<label for ="select_text"></label>
		<input type = "radio" name="select_text" value="1" checked="checked">매장이름
		<input type = "radio" name="select_text" value="2" >주소
		<input type = "radio" name="select_text" value="3" >메뉴이름
		<input type = "radio" name="select_text" value="4" >음식종류
		
		
		<!-- <select name="select_text" id="select">
			<option value="1">매장이름</option>
			<option value="2">주소</option>
			<option value="3">메뉴이름</option>
			<option value="4">음식종류</option>
		</select> <input type="text" name="text" id="text"> <input
			type="submit" value="검색"> -->
	</form>

	<p><a href="shopadd.do"><b>글쓰기</b></a></p>
	
	<div id=main_img_wrap>
		<c:forEach var="shop" items="${requestScope.list }">
			<ul class="main_img">
				<li><img alt="이미지" src="${shop.photo }"></li>
				<li><a href="detail.do?shopno=${shop.shopno }">${shop.name}</a></li>
				<li>${shop.addr}</li>
			</ul>
		</c:forEach>
	</div>
</body>
</html>