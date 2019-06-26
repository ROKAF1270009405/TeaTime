<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
button{
    background-color: white;
    border-style:none;
}
img{
width: 100px;
height: auto;
}
div{
<%-- background-image:: url('<%=request.getContextPath()%>/reviewimg/happy.png'); --%>
backgound-image: url("${pageContext.request.contextPath}/reviewimg/happy.png");
width: 100px;
height:100px;
}

button:hover{
/* background-color:black; */
/* backgound-image: url('reviewimg/happyck.png'); */
}
</style>
</head>
<body>
<jsp:useBean id="today" class="java.util.Date"/>
<fmt:formatDate var = "now" value="${today }" pattern="yyyyMMdd" />
<form method="post" action="addreviewaction.do">
		<ul>
			<li><label for="date">${now }</label></li>
			<li><label ><input type="text" name="shopno" value = "${requestScope.shopname }"/></label></li>
			<li><label for="date">${requestScope.id }</label></li>
			<li><label for="content">내용
			<textarea rows="10" cols="30" placeholder="내용을 입력하세요." name="content"></textarea>
			</label>
			<li>
			<button type="button" class="gpa"><img src="reviewimg/happy.png"  id="happy" onclick=change('happy')></button>
			<button type="button" class="gpa"><img src="reviewimg/surprised.png"  id="surprised" onclick=change('surprised')></button>
			<button type="button" class="gpa"><img src="reviewimg/sad.png" id="sad" onclick=change('sad')></button>
			</li>
			
			<li><input type="submit" value="완료"> <input type="reset"
				value="취소"></li>
		</ul>	
	</form>
	
	<script type="text/javascript">
	function change(id){
		var img1 = document.getElementById("happy");
		var img2 = document.getElementById("surprised");
		var img3 = document.getElementById("sad");
		img1.src = "<%=request.getContextPath()%>/reviewimg/happy.png";
		img2.src = "<%=request.getContextPath()%>/reviewimg/surprised.png";
		img3.src = "<%=request.getContextPath()%>/reviewimg/sad.png";
		
		var img = document.getElementById(id);
		var u1 = "<%=request.getContextPath()%>/reviewimg/";
		var uu = u1.concat(id,"ck.png");
		img.src = uu;
	}
	
	
	
	</script>
</body>
</html>