<%@page import="com.teatime.dto.ShopDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>List</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
  $(document).ready(function(){
	   $('#add').click(function(){
		   location.href="add.do";
	   });
	   $('.modify').click(function(){
		   let no = $(this).val();
		   location.href="modify.do?no="+no;
	   });
	   $('.delete').click(function(){
		   let no = $(this).val();
		   location.href="delete.do?no="+no;
	   });
  });
</script>
</head>
<body>
<c:set var="list" value="${requestScope.list }"></c:set>
	
	<table>
		<thead>
			<tr><th>사진</th><th>매장명</th><th>매장평점</th><th>매장주소</th></tr>
		</thead>
		<tbody>
		<c:forEach var="best" items="${list }">
			<tr class="trs">
				<td><c:out value="${best.s.photo }"></c:out></td>
				<td><c:out value="${best.s.name }"></c:out></td>
				<td><c:out value="${best.gpa }"></c:out></td>
				<td><c:out value="${best.s.addr }"></c:out></td>
			</tr>	
		</c:forEach>
		</tbody>
	</table>
	<button id="add">추가</button>
<script>
	$('.trs:odd').css("background-color","#9DCFFF");
</script>
</body>
</html>