<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%-- <%@ page session="false" %> --%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<style>
		.loginbody{border: 1px solid; border-radius: 5px; text-align: center; width: 300px; margin: 10px auto;}
	</style>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/nav.jsp"/>
<div class="loginbody">
<h1>
	Login Service 
</h1>
<h3>
<c:out value="${error}"></c:out>
<c:out value="${logout}"></c:out>
</h3>
<form method="post" action="/login">
	<div>
		<input type="text" name="username" >
	</div>
	<div>
		<input type="password" name="password" >
	</div>
	<div>
		<button type="submit">로그인</button>
	</div>
	<div>
		<a href="join">회원가입</a>
	</div>
	<div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</div>
</div>
</form>
</body>
</html>
