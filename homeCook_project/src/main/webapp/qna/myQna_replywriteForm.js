$(function () {
	
	$('#qnaReplyWriteBtn').click(function() {

		if($("#q_Title").val() == "" || $("#q_Content").val() == "") {
			alert("제목 또는 내용을 입력하세요.");
		}else {
			QNAreply();
		} 
	}); // click()
}); // $function()

function QNAreply(){
	
	$.ajax({
		type: "POST",
		url: "MyQuestionReply.app",
		async: true,
		dataType: "json",
		data: {
			q_Title : $('#q_Title').val(),
			q_Content : $('#q_Content').val(),
			q_Num : $('#q_Num').val(),
			f_num:$("#f_num").val()
		},
		
		success : function(data) {
			
			if(data.status == 'success') {
				location.href = "MyQNAlist.app"
			} 
	
		},
		error : function(xhr) {
			console.log("error", xhr);
			alert("error html = " + xhr.statusText);
		} // error
	}); // ajax
}	



