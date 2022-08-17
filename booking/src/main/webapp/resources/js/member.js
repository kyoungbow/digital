/**
 * 
 */

console.log("member Module");
var memberService = (function(){
	
	function chkId() {
		var id = $("#id").val();
		
		$.ajax({
			url:"/member/chkid",
			type:"POST",
			data:{id:id},
			success:function(cnt){
				if(cnt == 0){
					console.log("가능")
					alert("가입 가능한 아이디입니다.")
				} else {
					console.log("불가능")
					alert("가입 불가능한 아이디입니다.")
				}
			}, error:function(error) {
				alert("에러발생")
				console.log(error)
			}
			
		})
	} // chkId
	 
})();