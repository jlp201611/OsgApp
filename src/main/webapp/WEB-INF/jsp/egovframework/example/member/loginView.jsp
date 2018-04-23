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
	<h1>loginView</h1>

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
	</c:if>

</body>
</html>
