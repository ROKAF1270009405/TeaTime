<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>TeaTime</title>


</head>

<body id="page-top">
 <%
        if(session.getAttribute("dto") == null) // 로그인이 안되었을 때
        { 
        	%>
        	<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="teatime.do">TeaTime</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto my-2 my-lg-0">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="teatime.do">login </a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="best.do">best</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="customerservicelist.do">contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
        <%
        }
        else // 로그인 했을 경우
        {
    %>



	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="teatime.do">TeaTime</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			
			
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto my-2 my-lg-0">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="teatime.do">logout </a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="best.do">best</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="customerservicelist.do">contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<%
}
    %>
</body>
</html>