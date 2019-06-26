<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeaTime</title>
<style>
#wrap {
	width: 100%;
	height: 340px;
}

div {
	width: 25%;
	height: 100%;
	overflow: hidden;
}

#result {
	width: 50%;
	height: auto;
	overflow: visible;
} 
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
		$.urlParam = function(name){

		    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		    if (results==null){
		       return null;
		    }
		    else{
		       return results[1] || 0;
		    }
		}
	
		/* $("#result").load("review.do");
		console.log('hi'); */

		let shopno = $.urlParam('shopno');
		console.log(shopno);
		$.ajax({
			url : "review.do",
			data : "shopno=" + shopno,
			dataType : "html",
			success : function(data) {
				$('#result').append(data);
			},
			error : function(data) {
				console.log('error');
			}
		});
	});
</script>
</head>
<body>
	<c:set var="detail" value="${requestScope.dto }"></c:set>
	<c:set var="shopno" value="${detail.shopno}"></c:set>
	<ul>

		<li>${detail.name }</li>
		<li>${detail.content }</li>
		<li>${detail.photo }</li>
		<li>${detail.addr }</li>
		<li>${detail.workingtime }</li>
		<li>${detail.date }</li>
	</ul>

	<table>
		<tr>
			<td>aadasdadsSDdd</td>
		</tr>
	</table>
	<div id="result"></div>
</body>
</html>