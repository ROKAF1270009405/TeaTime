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
* {
	padding: 20px;
}

/* table, th, td {
	border: 1px solid dodgerblue;
	border-collapse: collapse;
} */
</style>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
	%>


  
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getNickname()%></td>
				<td><%=dto.getMail()%></td>
			</tr>


		</tbody>
	</table> 
    
</body>
</html>