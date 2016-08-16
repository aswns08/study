$(function () {
	
	$('#r_IdCheckBnt').click(function() {
		
		if($("#id").val() == "") {
			alert("식당주인 아이디를 입력하세요.");
		} else {
			id_Check();
		}
			
	}); // click()
	
}); // $function()

function id_Check(){
	
	$.ajax({
		type: "POST",
		url: "ResIdOverlapCheck.app",
		async: true,
		dataType: "json",
		data: {
			id:$("#id").val()
		},
		
		success : function(data) {
			if(data.status == 'success') {
				alert("등록 가능합니다.");
			} else{
				alert("등록 불가한 아이디입니다.");
				$("#id").val("");
			}
	
		},
		error : function(xhr) {
			console.log("error", xhr);
			alert("error html = " + xhr.statusText);
		} // error
		
	}); // ajax
}
