$(function () {
	
	$('#qnaWriteBtn').click(function() {
		
		if($("#q_Title").val() == "" || $("#q_Content").val() == "") {
			alert("제목 또는 내용을 입력하세요.");
		} else {
			
			$.ajax({
				type: "POST",
				url: "QNAWrite.app",
				async: true,
				dataType: "json",
				data: {
					q_Title:$("#q_Title").val(),
					q_Content:$("#q_Content").val(),
					r_num:$("#r_num").val(),
					f_num:$("#f_num").val()
				},
				
				success : function(data) {
					if(data.status == 'success') {
						location.href = "getFoodDetail.app?r_num="+data.r_num+"&f_num="+data.f_num
					} 
			
				},
				error : function(xhr) {
					console.log("error", xhr);
					alert("error html = " + xhr.statusText);
				} // error
				
			}); // ajax
			
		}
		
		
		
	}); // click()	
	
}); // $function()