$(function () {
	
	$('#noticeUpdateBnt').click(function() {
		
		if($("#no_Title").val() == "" || $("#no_Content").val() == "") {
			alert("제목 또는 내용을 입력하세요.");
		} else {
			updateNotice();
		}
	}); // click()
}); // $function()

function updateNotice() {
	
	$.ajax({
		type: "POST",
		url: "NoticeUpdate.app",
		async: true,
		dataType: "json",
		data: {
			no_Title : $('#no_Title').val(),
			no_Content : $('#no_Content').val(),
			no_Num : $('#no_Num').val(),
			pageNum: $('#pageNum').val()
		},
		
		success : function(data) {
			if(data.status == 'success') {
				location.href = "NoticeContent.app?no_Num="+data.no_Num+"&pageNum="+data.pageNum
			} 
	
		},
		error : function(xhr) {
			console.log("error", xhr);
			alert("error html = " + xhr.statusText);
		} // error
	}); // ajax
	
}