<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeaTime</title>
<style>

#wrap{
	width: 100%;
	height: 340px;
}
div {
	width: 25%;
	height: 100%;
	overflow: hidden;
}

</style>
</head>
<body>
	
	<ul>
		<c:set var ="detail" value="${requestScope.dto }"></c:set>
		<li>${detail.name }</li>
		<li>${detail.content }</li>
		<li>${detail.photo }</li>
		<li>${detail.addr }</li>
		<li>${detail.workingtime }</li>
		<li>${detail.date }</li>
	</ul>
	
	<table>
	<tr><td>aadasdadsSD</td></tr>
	</table>
</body>
</html>