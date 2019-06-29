<%@page import="com.teatime.mypage.model.MypageDTO"%>
<%@page import="com.teatime.member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	.my-div{
		width: 70%;
		
		margin: 0 auto 0 auto;
		background-color: rgba(0,0,0,0.1);
		padding: 10px;
	}
	.my-div h1,h4{
		display: inline-block;
	}
	
	.my-div .back-div{
		width : 200px;
		border: 2px solid silver;
		background-color: white;
	}
	.modi-button{
    		margin-top: 50px;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(
			function() {
				$.urlParam = function(name) {

					var results = new RegExp('[\?&]' + name + '=([^&#]*)')
							.exec(window.location.href);
					if (results == null) {
						return null;
					} else {
						return results[1] || 0;
					}
				}

				/* $("#result").load("review.do");
				console.log('hi'); */

				let id = $.urlParam('id');
				console.log(id);
				$.ajax({
					url : "myreviewpage.do",
					data : "id=" + id,
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

	<%
		request.setCharacterEncoding("utf-8");
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
	%>

	<div class="my-div">
		<h1 class="admin"><%=dto.getNickname()%></h1><h4>님의 마이페이지 입니다.</h4><hr>

		<strong>아이디</strong>  <div class="back-div"><%=dto.getId()%></div><br>
		
		<strong>닉네임</strong>  <div class="back-div"><%=dto.getNickname()%></div><br>

		<strong>E-mail</strong> <div class="back-div"><%=dto.getMail()%></div><br>
		
	<button class="modi-button">수정</button>&nbsp;&nbsp;&nbsp;&nbsp;<button>돌아가기</button>
	
		<div id="result"></div>
	
	</div>
	

	

</body>
</html>