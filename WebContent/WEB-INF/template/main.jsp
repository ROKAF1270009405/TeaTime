<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.masthead{
height : 10px !important;
min-height: 0rem !important;
}
</style>
<title>TeaTime</title>
<!-- Font Awesome Icons -->
<link href="<%=request.getContextPath() %>/css/all.min.css" rel="stylesheet" type="text/css">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
	rel="stylesheet">
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="<%=request.getContextPath() %>/css/magnific-popup.css" rel="stylesheet">

<!-- Theme CSS - Includes Bootstrap -->
<link href= "<%=request.getContextPath() %>/css/creative.css" rel="stylesheet">

</head>
<body>
<header class="masthead"> 
	<jsp:include page="header.jsp"></jsp:include>
	<c:set var="page" value="${param.page }"></c:set>.
	<c:if test="${page!=null }">
		<jsp:include page="${page }"></jsp:include>
	</c:if>
	<c:if test = "${page==null }">
	<jsp:include page = "nodata.jsp"></jsp:include>
	</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
	</header>
	
	
	
	<!-- Bootstrap core JavaScript -->
	<script src="<%=request.getContextPath() %>/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/jquery/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="<%=request.getContextPath() %>/jquery/jquery.easing.min.js"></script>
	<script src="<%=request.getContextPath() %>/jquery/jquery.magnific-popup.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src= "<%=request.getContextPath() %>/jquery/creative.js"></script>
	
	
</body>
</html>