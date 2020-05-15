<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body align = "center">
<h3>회원정보</h3>
<form action="MemberUpdate.do" method="post">
ID : <input type="text" name = "id" id="id" readonly="readonly" value="${member.id}"/><br/>
비밀번호 : <input type = "text" name = "pwd" id="pwd" value="${member.pwd}"><br>
이름 : <input type="text" name = "name" id="name" value="${member.name}"><br>
취미 :
<input type = "checkbox" name ="hobby" value="h01" checked = "checked" 
<c:if test="${fn:contains(member.hobby, 'h01') }">checked="checked"</c:if>
/>등산
<input type = "checkbox" name ="hobby" value="h02" 
<c:if test="${fn:contains(member.hobby, 'h02') }">checked="checked"</c:if>
/>운동
<input type = "checkbox" name ="hobby" value="h03" 
<c:if test="${fn:contains(member.hobby, 'h03') }">checked="checked"</c:if>
/>독서
<input type = "checkbox" name ="hobby" value="h04" 
<c:if test="${fn:contains(member.hobby, 'h04') }">checked="checked"</c:if>
/>여행<br>
성별 : 
<input type="radio" name = "gender" value="m"/>남자 
<input type="radio" name = "gender" value="f"/>여자<br>

종교 : <select name="religion" id="religion">
<option value="r01">기독교</option>
<option value="r02">불교</option>
<option value="r03">천주교</option>
<option value="r04">무교</option>
</select><br>
자기소개:<br>
<textarea cols="30" rows="10" name="introduction" id="introduction" >
${member.introduction}
</textarea><br>
<input type="submit" value="전송"><input type="reset" value="지우기">

</form>

</body>
</html>