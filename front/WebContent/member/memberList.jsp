<%@page import="front.co.yedam.app.member.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<style>
.malebg {
	background-color: blue;
}

.fmalebg {
	background-color: red;
}
.nogenderbg{
	background-color : gray;
	}
</style>
</head>
<body>
	<!-- Navigation bar -->
	<%=getServletContext().getRealPath("/")%>
	<%-- JSP 주석 --%>
	<!--  HTML 주석 -->
	<h3>회원목록</h3>	
	<table border="1">
		<tr align="center">
			<td>ID</td>
			<td>Name</td>
			<td>Gender</td>
			<td colspan="2">Member Edit</td>
		</tr>
		<%
			ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
			for (MemberVO vo : list) {
		%>
		<tr <%if ("m".equals(vo.getGender())) {%> class="malebg"
			<%} else if ("f".equals(vo.getGender())) {%> 
			class="fmalebg" 
			<%} else{%>
			class = "nogenderbg"
			<%} %>
			>
			<td><%=vo.getId()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getGender()%></td>
			<td><a href="MemberUpdateForm.do?id=<%=vo.getId()%>">수정</a></td>
			<td><a href="MemberDelete.do?id=<%=vo.getId()%>">삭제</a></td>
		</tr>
		<%}	%>
	</table>
</body>
</html>