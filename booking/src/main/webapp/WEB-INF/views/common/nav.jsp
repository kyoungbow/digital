<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<style>
	.navheader {text-align: center;}
</style>
<jsp:include page="../common/head.jsp"/>

<header>
	<h1 class="navheader">
		<sec:authorize access="isAuthenticated()">
			<a href="/member/index">오늘 뭐 먹지?</a>
		</sec:authorize>
	</h1>
</header>
