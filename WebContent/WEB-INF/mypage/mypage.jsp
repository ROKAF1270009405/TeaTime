<%@page import="com.teatime.member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		List<MemberDTO> list = (List<MemberDTO>) request.getAttribute("list");
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

			<%
				for (int i = 0; i < list.size(); i++) {
					MemberDTO dto = list.get(i);
			%>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getNickname()%></td>
				<td><%=dto.getMail()%></td>
			</tr>
			<%
				}
			%>


		</tbody>
	</table>

</body>
</html>