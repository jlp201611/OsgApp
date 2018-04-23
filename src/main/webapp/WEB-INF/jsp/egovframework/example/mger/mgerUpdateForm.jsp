<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>mgerUpdateForm</h1>

	<form action="/mgerUpdateProd.do" method="post">
		<table>
			<thead>
				
					<tr><th>아이디</th><td><input type="text" id="id" name="id" value="${result.ID}" readonly="readonly"/></td></tr>
					<tr><th>이름</th><td><input type="text" id="name" name="name" value="${result.NAME}" readonly="readonly"/></td></tr>

				<tr>
					<th>성별</th>
					<td><select id="sex" name="sex">
					
							<option value="M"<c:if test="${result.SEX eq 'M'}">selected</c:if>>남</option>
							<option value="W"<c:if test="${result.SEX eq 'W'}">selected</c:if>>여</option>

					</select></td>
				</tr>

				<tr><th>전화번호</th><td><input type="text" id="hp" name="hp" value="${result.HP}" /></td></tr>
					<tr><th>주소</th><td><input type="text" id="address" name="address" value="${result.ADDRESS}" /></td></tr>
				
			</thead>	
		</table>		
		<button type="submit">가입하기</button>
	</form>
		<a href="/mgerList.do">취소</a>
</body>
</html>