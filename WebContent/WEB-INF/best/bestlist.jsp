
<%@page import="com.teatime.shop.model.ShopDTO"%>
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
<style>
.mo{
	width:80%;
    margin: 50px auto;
}
table {
	width:100%;
	border-collapse: collapse;
	text-align: center;
	line-height: 1.5;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
thead th {
	/* width: 130px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: rgb(244,98,58);
    margin: 20px 10px;
    text-align: center;
}
th:nth-child(1) {
	width: 5%;
}
th:nth-child(2){
	width: 20%;
}
th:nth-child(3){
	width: 20%;
}
th:nth-child(4){
	width: 20%;
}
td{
    padding: 10px;
    vertical-align: middle;
}
tr:nth-child(2n) {
    background-color: rgba(244,98,58,0.2) !important;
}
a {
	text-decoration: none;
	color: black;
}
#page{
	padding-top:10px;
	width:100%;
	text-align: center;
	font-size: 20px;
}
.site{
	width:100%;
}
.site img{
	
}
.delbtn {
  background-color: rgb(244,98,58);
  border-radius:15%;
  border: none;
  color: #ffffff;
  cursor: pointer;
  /* display: inline-block; */
  font-family: 'BenchNine', Arial, sans-serif;
  font-size: 20px;
  line-height: 1em;
  margin-left: 10px;
  outline: none;
  padding: 5px 7.5px 5px;
  position: relative;
  text-transform: uppercase;
  font-weight: 700;
  top:0px;
}
.delbtn:before, .delbtn:after {
  border-color: transparent;
  -webkit-transition: all 0.25s;
  transition: all 0.25s;
  border-style: solid;
  border-width: 0;
  content: "";
  height: 12px;
  position: absolute;
  width: 12px;
}

.delbtn:before {
  border-color: rgb(244,98,58);
  border-right-width: 2px;
  border-top-width: 2px;
  right: -5px;
  top: -5px;
}
.delbtn:after {
  border-bottom-width: 2px;
  border-color: rgba(244,98,58,1.2);
  border-left-width: 2px;
  bottom: -5px;
  left: -5px;
}
.delbtn:hover,
.delbtn.hover {
  background-color: rgba(244,98,158,1.2);
}
.delbtn:hover:before,
.delbtn.hover:before,
.delbtn:hover:after,
.delbtn.hover:after {
  border-color:rgba(244,98,58,1.2);
  height: 100%;
  width: 100%;
}
#list{
	margin-bottom: 10px;
}
.trs td:nth-child(1) img{
	width: 300px;
		
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
  $(document).ready(function(){
	  $('.trs:odd').css("background-color","#9DCFFF");
	  /* let kind = $('.btn').val();
	  console.log(kind);
	   */
	  $('.kind').on('change',function () {
		  let startdate = $(this).val();
		  $('#sp').css('display','');
		  $('#enddate').css('display','');
		  $('#enddate').attr('min', startdate);
	    console.log( $(this).val());
		  //$('form').submit();
		  
		 /*  $.ajax({
			  url:"http://localhost:8080/MiniPro2/best.do",
			  type:'GET',
			  data:kind,
			  success:function(data){
				  console.log("ajax : "+kind);
			  },
			  error:function(){
				  
			  }
		  }); */
	  });
	  
  });
</script>
</head>
<body>
<c:set var="bestlist" value="${requestScope.bestlist }"></c:set>


<div class="mo">
<div id="list">
<form method="post" action="best.do" name="frm">
	<select name="kind" id="kind" >
	<optgroup label="정렬 기준" style="font-size: 13px"></optgroup>
		<option value="good" selected="selected">좋아요</option>
		<option value="gpa">평점</option>
	</select>
	<input type="date" name="startdate" id="startdate" class="kind"><span id="sp" style="display: none;">&nbsp;&nbsp;~&nbsp;&nbsp;</span><input type="date" name="enddate" id="enddate" style="display: none;">
	<button class="delbtn">확인</button>	
</form>
</div>
<!-- <form method="post" action="best.do">
	<button class="btn" value="good" id="kind" name="kind">좋아요 베스트</button>
</form> -->
	<table>
		<thead>
			<tr><th>사진</th><th>매장명</th><th>매장평점</th><th>매장주소</th><th>좋아요수</th></tr>
		</thead>
		<tbody>
		<c:forEach var="best" items="${bestlist }">
			<tr class="trs">
				<td><div class="site"><img alt="이미지" src="${best.photo }"></div></td>
				<td><a href="detail.do?shopno=${best.shopno }">${best.name }</a></td>
				<td><fmt:formatNumber value="${best.gpa }" pattern=".0"/></td>
				<td><c:out value="${best.addr }"></c:out></td>
				<td><c:out value="${best.count }"></c:out></td>
			</tr>	
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>