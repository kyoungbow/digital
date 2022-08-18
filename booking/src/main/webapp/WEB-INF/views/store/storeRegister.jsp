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
<style>
	.storebody{border: 1px solid; border-radius: 5px; width: 300px; margin: 10px auto; padding: 30px 30px}
	.content {border: 1px solid; border-radius: 5px; width: 240px; height:100px;}
</style>

</head>
<body>
<div class="storebody">

	<h1>Store Register</h1>
	
	<form method="post" onsubmit="return storeRegister" id="register">
	<div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</div>
	<div>
		<div>
			<label>아이디</label>
			<input type="text" id="st_id" name="st_id" value="${member.id}" readonly>
		</div>
		<div>
			<label>사업장 등록 번호</label>
			<br>
			<input type="text" id="st_code" name="st_code" placeholder="사업장 등록 번호 입력하세요">
			<button type="button" id="chkCode">중복체크</button>
			
		</div>
		<div>
			<label>가게 이름</label >
			<input type="text" id="st_name" name="st_name" placeholder="가게 이름을 입력하세요">
		</div>
		<div>
			<label>가게 소개</label>
			<br>
			<textarea class="content" id="st_content" name="st_content" ></textarea>
		</div>
	
		<div>
			<label>가게 번호</label>
			<input type="text" id="st_tel" name="st_tel" placeholder="가게 번호 입력하세요">
		</div>
		<div>
			<label>주소</label>
			<button type="button" id="btnAddr">주소검색</button><br>
			<input type="text" id="st_addr" name="st_addr" readonly><br>
			<input type="text" id="st_detailaddr" name="st_detailaddr" placeholder="상세주소를 쓰세요"><br>
			<input type="hidden" id="st_postcode" name="st_postcode">
			
		</div>
		<div>
			<label>카테고리</label>
			<input type="text" id="st_cat" name="st_cat" >
		</div>
		<div>
			<label>오픈시간</label>
			<input type="text" id="st_open" name="st_open" >
		</div>
		<div>
			<label>마감시간</label>
			<input type="text" id="st_close" name="st_close" >
		</div>
	</div>
	<button type="submit">가게 등록</button>
	<br>
	<a href="/member/mypage">취소</a>

	</form>
</div>
	
	
	<script>
	
$("#chkCode").click(function() {
		
		var st_code = $("#st_code").val();
		
		$.ajax({
			url:"/store/chkCode",
			type:"POST",
			data:{st_code:st_code},
			dataType:"json",
			success:function(cnt){
				if(cnt == 0){
					console.log("가능")
					console.log(cnt)
					$("#st_name").focus();
					alert("가입 가능한 사업자 등록 번호입니다..")
				} else {
					console.log("불가능")
					console.log(cnt);
					$("#st_code").focus();
					alert("중복 사업자 등록 번호입니다.")
					return false;
				}
			}, error:function(error) {
				alert("에러발생")
				console.log(error)
			}
			
		})
	})
	
function storeRegister(){
		
		var register = true;
		var id = $("#st_id").val();
		var code =$("#st_code").val();
		var name = $("#st_name").val();
		var content = $("#st_content").val();
		var tel  = $("#st_tel").val();
		var addr = $("#st_addr").val();
		var detailaddr = $("#st_detailaddr").val();
		var cat = $("#st_cat").val();
		var open = $("#st_open").val();
		var close = $("#st_close").val();
		
		if(code == ""){
			alert("사업자 등록 번호는 필수 입니다.");
			$("#st_code").focus();
		 	return false;
		} else if(name == ""){
			alert("가게 이름을 적어주세요.");
			$("#st_name").focus();
			return false;
		} else if(content == ""){
			alert("가게 소개를 적어주세요");
			$("#st_content").focus();
			return false;
		} else if(tel == ""){
			alert("가게 번호를 적어주세요.");
			$("#st_name").focus();
			return false;
		} else if(tel == ""){
			alert("전화번호를 입력하세요.");
			$("#st_tel").focus();
			return false;
		} else if(addr == ""){
			alert("주소를 입력하세요");
			return false;
		} else {
			alert("가게가 등록되었습니다.")	 
		}
	};
	
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
                 document.getElementById('st_postcode').value = data.zonecode;
                 document.getElementById("st_addr").value = addr;
                 // 커서를 상세주소 필드로 이동한다.
                 document.getElementById("st_detailaddr").focus();
             }
        	
        }).open();
		
	});
	
	
	

	
	
	</script>
</body>
</html>