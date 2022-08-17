<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/nav.jsp"/>
	<h1>mypage</h1>
	<sec:authentication property="principal" var="pcp"/>
	<sec:authorize access="isAuthenticated()">
	
	<form method="post">
	
	
	<div>
		<div>
			<label>아이디</label>
			<input type="text" name="id" name="id" readonly value="${member.id}">
		</div>
		<div>
			<label>비밀번호</label >
			<input type="password" id="pw" name="pw"  value="${member.pw}">
		</div>
	
		<div>
			<label>이름</label>
			<input type="text" id="name" name="name" readonly value="${member.name}">
		</div>
		<div>
			<label>전화번호</label>
			<input type="text" id="phone" name="phone"  value="${member.phone}">
		</div>
		<div>
			<label>이메일</label>
			<input type="text" id="email" name="email"  value="${member.email}" >
		</div>
		<div>
			<label>주소</label>
			<button type="button" id="btnAddr">주소변경</button><br>
			<input type="text" id="address" name="address"  value="${member.address}"><br>
			<input type="text" id="detailaddr" name="detailaddr"  value="${member.detailaddr}"><br>
			<input type="text" id="postcode" name="postcode"  value="${member.postcode}">
			
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</div>
	<button type="submit">수정</button>
	</form>
	</sec:authorize>
	
<script>
$("#btnAddr").click(function() {
    new daum.Postcode({
    	 oncomplete: function(data) {
    		 var addr = ''; // 주소 변수

             //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
             if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                 addr = data.roadAddress;
             } else { // 사용자가 지번 주소를 선택했을 경우(J)
                 addr = data.jibunAddress;
             }

             

             // 우편번호와 주소 정보를 해당 필드에 넣는다.
             document.getElementById('postcode').value = data.zonecode;
             document.getElementById("address").value = addr;
             // 커서를 상세주소 필드로 이동한다.
             document.getElementById("detailaddr").focus();
         }
    	
    }).open();
	
});
</script>
</body>
</html>