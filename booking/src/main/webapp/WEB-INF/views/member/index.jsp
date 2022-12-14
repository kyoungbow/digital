<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
	<title>Home</title>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/nav.jsp"/>
<h1>
	첫화면
</h1>
<sec:authorize access="isAnonymous()">

<a href="/member/login">로그인하기</a>
<a href="/member/join">회원가입</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<a href="/member/mypage">마이페이지</a>
<c:if test="${member.authList[0].auth == 'ROLE_MEMBER'}">
<a href="/store/storeRegister">가게등록하기</a>
</c:if>
<c:if test="${member.authList[0].auth == 'ROLE_MANAGER'}">
<a href="/store/getStore">가게관리</a>
</c:if>
<c:if test="${member.authList[0].auth == 'ROLE_ADMIN'}">
<a href="/member/admin">회원관리</a>
</c:if>
	<form action="/logout" method="post" onsubmit="return confirm('로그아웃하시겠습니까?')">
		<button>Logout</button>
		<sec:csrfInput/>
	</form>
</sec:authorize>
</body>
</html>
