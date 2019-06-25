<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TeaTime</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<c:set var = "page" value="${param.page }"></c:set>
<c:if test = "${page!=null }">
 <jsp:include page = "${page }"></jsp:include>
 </c:if>
 <c:if test="${page==null }">
  <jsp:include page="nopage.jsp"></jsp:include>
</c:if>
<br>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>