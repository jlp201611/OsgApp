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
<title>selectMger</title>
</head>
<body>

	<h1>selectMger</h1>

	<c:if test="${loginInfo == null}">
		<form action="/loginViewProc.do" method="post">
			아이디: <input type="text" name="id"> 비밀번호 : <input
				type="password" name="pw">
			<button type="submit">로그인</button>
		</form>
		<a href="/mgerInsertFrom.do">회원가입</a>		
	</c:if>
	<c:if test="${loginInfo != null}">
		${loginInfo.ID}님이 로그인 하셨습니다.
		<a href="/logut.do">로그아웃</a>
		
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>성별</th>
				<th>삭제여부</th>
			</tr>
		</thead>
		<thead>
			<c:forEach var="rs" items="${reuslt}">
				<tr>
					<td><a href="/mgerView.do?id=${rs.ID}">${rs.ID}</a></td>
					<td>${rs.NAME}</td>
					<td>${rs.HP}</td>
					<td>${rs.ADDRESS}</td>
					<td>${rs.SEX}</td>
					<td>${rs.DELETE_YN}</td>
				</tr>			
			</c:forEach>		
		</thead>		
	</table>		
	</c:if>

	

</body>
</html>
