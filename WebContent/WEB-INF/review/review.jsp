<%@page import="com.teatime.review.model.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
<style>
img {
	width: 100px;
}


/* 
shop ul {
	list-style-type: none;
	float: left;
	display: block;
	width: 1000px;
	
} */

#shop ul{
padding-left: 0 !important;
}

div {
	width: 100%;
}

#shop ul li {
	display: inline-block;
}
#shop {
margin:10px;
border:10px;
}
.date{
float:right;
}
.content{
clear:both;
}
.delbtn{
float : right;
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
  top: -20px !important;
  position: relative;
  text-transform: uppercase;
  margin-right: 15px;
  margin-top: -20px;
  font-weight: 700;
  top:0px;
  left: -18%;
  margin-bottom: -15px !important;
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
  background-color: rgb(242, 71, 24);
}
.delbtn:hover:before,
.delbtn.hover:before,
.delbtn:hover:after,
.delbtn.hover:after {
  border-color:rgba(244,98,58,1.2);
  height: 100%;
  width: 100%;
}
</style>

</head>
<body>

<a href="addreviewform.do?shopno=${shopno }&name=${name}"><button value="글쓰기" class="delbtn">글쓰기</button></a>


	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="shopno" value="${requestScope.shopno }"></c:set>
	<c:set var="sessiondto" value="${sessionScope.dto }"></c:set>

	<c:set var="id" value="${sessiondto.id }"></c:set>

	<c:forEach var="board" items="${list }">
			<div id="shop">
				<c:set var="dto" value="${board }"></c:set>
				<ul>
					<li class="id">아이디 : ${board.id }</li>&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="date">작성일 : ${board.date }</li>
					평점 : <%-- ${board.gpa } --%>
					<c:if test="${board.gpa == 5.0}">
					<li>★★★★★</li>
						<%-- <li class="reviewli"><img src="/reviewimg/${happy.png}"></li> --%>
					</c:if>
					<c:if test="${board.gpa == 2.5}">
					<li>★★☆</li>
						<%-- <li class="reviewli"><img src="/reviewimg/${happy.png}"></li> --%>
					</c:if>
					<c:if test="${board.gpa == 0}">
					<li>☆</li>
						<%-- <li class="reviewli"><img src="/reviewimg/${happy.png}"></li> --%>
					</c:if>
				</ul>
				<hr>
				<div class="content">
				<p>${board.content }</p>
				</div>
				<ul>
					<c:forEach var="img" items="${board.photo }">
						<li class="reviewli"><img src="reviewuploadimg/${img }"></li>
					</c:forEach>
				</ul>

				<c:set var="name" value="${board.name }"></c:set>
				<c:if test="${id eq board.id}">
				
					<a href="deletemyreview.do?num=${board.reviewno}" class="btnnext">
					
					<input type="button" value="삭제" class="delbtn">
						</a>
					<input type="button" value="수정" class="delbtn"
						onclick="location.href='modifyreviewform.do?shopno=${shopno }&name=${name}&reviewno=${board.reviewno }'">
					
				</c:if>
			</div>
	</c:forEach>
	<br>
	
</body>
</html>