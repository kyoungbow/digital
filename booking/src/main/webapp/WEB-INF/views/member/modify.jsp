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
	<h1>Delete Member</h1>
	<sec:authentication property="principal" var="pcp"/>
	<sec:authorize access="isAuthenticated()">
	
	<form method="post">
	
	
	<div>
		<div>
			<label>비밀번호</label>
			<input type="password" id="pw" name="pw"  value="${member.pw}">
		</div>
		<div>
			<label>비밀번호 확인</label >
			<input type="password" id="pw" name="pw"  value="${member.pw}">
		</div>
	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</div>
	<button type="submit" onclick="">수정</button>
	</form>
	</sec:authorize>
	
<script>
$("#chkpw").click(function() {
	
	var id = $("#id").val();
	
	$.ajax({
		url:"/member/chkid",
		type:"POST",
		data:{id:id},
		dataType:"json",
		success:function(cnt){
			if(cnt == 0){
				console.log("가능")
				console.log(cnt)
				$("#pw").focus();
				alert("가입 가능한 아이디입니다.")
			} else {
				console.log("불가능")
				console.log(cnt);
				$("#id").focus();
				alert("가입 불가능한 아이디입니다.")
				return false;
			}
		}, error:function(error) {
			alert("에러발생")
			console.log(error)
		}
		
	})
})
function memberJoin(){
	
	var join = true;
	var id = $("#id").val();
	var pw = $("#pw").val();
	var pw2 = $("#pw2").val();
	var name = $("#name").val();
	var phone  = $("#phone").val();
	var email = $("#email").val();
	var addr = $("#address").val();
	var detailaddr = $("#detailaddr").val();
	var postcode = $("#postcode").val();
	var num = pw.search(/[0-9]/g);
	var eng = pw.search(/[a-z]/ig);
	var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(pw == ""){
		alert("비밀번호를 입력하세요.");
		$("#pw").focus();
	 	return false;
	} 	else if(pw.length < 8 || pw.length > 15){
		alert("비밀번호는 최소 8자 최대 15자 입니다.");
		$("#pw").focus();
	 	return false;
	} else if(pw.search(/\s/) != -1){
	 	alert("비밀번호는 공백 없이 입력해주세요.");
	 	$("#pw").focus();
	 	return false;
	} else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
	 	alert("영문, 숫자, 특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
	 	$("#pw").focus();
	 	return false;
	} else if(pw2 == ""){
		alert("비빌번호를 확인하세요.");
		$("#pw2").focus();
		return false;
	} else if(pw != pw2){
		alert("비밀번호가 다릅니다.");
		$("#pw2").focus();
		return false;
	} else if(name == ""){
		alert("이름을 입력하세요.");
		$("#name").focus();
		return false;
	} else if(phone == ""){
		alert("전화번호를 입력하세요.");
		$("#phone").focus();
		return false;
	} else if(email == ""){
		alert("이메일을 입력하세요.");
		$("#email").focus();
		return false;
	} else if(addr == "" || postcode == ""){
		alert("주소를 입력하세요");
		return false;
	} else {
		alert("회원가입 되었습니다.")	 
	}
};
</script>
</body>
</html>