$(function () {
	
	$('#r_NumCheckBnt').click(function() {
		
		if($("#r_Num").val() == "") {
			alert("사업자등록번호를 입력하세요.");
		} else {
			r_NumCheck();
		}
			
	}); // click()
	
}); // $function()

function r_NumCheck(){
	
	$.ajax({
		type: "POST",
		url: "RestaurantOverlapCheck.app",
		async: true,
		dataType: "json",
		data: {
			r_Num:$("#r_Num").val()
		},
		
		success : function(data) {
			if(data.status == 'success') {
				alert("사용가능합니다.");
			} else{
				alert("이미 등록된 사업자등록번호입니다.");
				$("#r_Num").val("");
			}
	
		},
		error : function(xhr) {
			console.log("error", xhr);
			alert("error html = " + xhr.statusText);
		} // error
		
	}); // ajax
}
