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

	<h1>mgreView</h1>
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
				<tr>
					<td>${result.ID}</td>
					<td>${result.NAME}</td>
					<td>${result.HP}</td>
					<td>${result.ADDRESS}</td>
					<td>${result.SEX}</td>
					<td>${result.DELETE_YN}</td>
				</tr>				
		</thead>		
	</table>		
	<a href="/mgerList.do">리스트로</a> | <a href="/mgerUpdateForm.do?id=${result.ID}">수정하기</a> | | <a href="/mgerDeleteProd.do?id=${result.ID}">삭제하</a>

	

</body>
</html>
