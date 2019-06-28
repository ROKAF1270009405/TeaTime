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



.teatime {
	background-image: url('http://localhost:8080/MiniPro2/img/cup.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	height: 900px;
	margin-top: 13px;
}

#main_img_wrap {
	width: 100%;
}

#text {
	margin: 0 auto 0 auto;
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
.main-p-right{
	margin: 10px;
	display: inline-block;
	float: right;
}
.main-p-left{
	margin: 10px;
	display: inline-block;
	float: left;
}
.clear-hr{
	clear: both;
}
</style>
</head>
<body>


	<header class="teatime">
		<div class="container h-100">
			<div
				class="row h-100 align-items-center justify-content-center text-center">
				<div class="col-lg-10 align-self-end">
					<h1 class="text-uppercase text-white font-weight-bold">
						여유로운 TeaTime을 위한<br> 빠르고 정확한 리뷰!
					</h1>
					<hr class="divider my-4">
				</div>
				<div class="col-lg-8 align-self-baseline">
					<p class="text-white-75 font-weight-light mb-5">
					<form method="post" action="teatime.do">

						<input type="text" name="text" id="text" value="검색을 해주세요"
							onclick="this.value=''"
							class="btn-white btn-primary-white btn-xl js-scroll-trigger">




						<input type="submit" value="검색"
							class="btn btn-primary btn-xl js-scroll-trigger"><br>

						<label for="select_text" 
							class="btn btn-primary btn-xl js-scroll-trigger"> <input
							type="radio" name="select_text" value="1" checked="checked">매장이름
							&nbsp; <input type="radio" name="select_text" value="2">주소
							&nbsp; <input type="radio" name="select_text" value="3">메뉴이름
							&nbsp; <input type="radio" name="select_text" value="4">음식종류<br>
						</label>
						<!-- <select name="select_text" id="select">
			<option value="1">매장이름</option>
			<option value="2">주소</option>
			<option value="3">메뉴이름</option>
			<option value="4">음식종류</option>
		</select> <input type="text" name="text" id="text"> <input
			type="submit" value="검색"> -->
					</form>
				</div>
			</div>
		</div>
	</header>

		
	<p class="main-p-left">
		<b>TeaTime</b>
	</p>
	
	<p class="main-p-right">
		<a href="shopadd.do"><b>글쓰기</b></a>
	</p>
	
	<hr class="clear-hr">
	
	<div id=main_img_wrap>
		<c:forEach var="shop" items="${requestScope.list }">
		
		<div class="col-lg-4 col-sm-6">
          <a class="portfolio-box">
            <img class="img-fluid" src="${shop.photo }" alt="이미지">
            <div class="portfolio-box-caption">
              <div class="project-category text-white-50">
               <a href="detail.do?shopno=${shop.shopno }">${shop.name}</a>
              </div>
              <div class="project-name">
                ${shop.addr}
              </div>
            </div>
          </a>
        </div>
		<%-- 
			<ul class="main_img">
				<li><img alt="이미지" src="${shop.photo }"></li>
				<li><a href="detail.do?shopno=${shop.shopno }">${shop.name}</a></li>
				<li>${shop.addr}</li>
			</ul> --%>
			
			
			
		</c:forEach>
	</div>

</body>
</html>