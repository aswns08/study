$(document).ready( function() {
	
	getComment(1);
	addHit();
	
	commentPageNum = parseInt($("#commentPageNum").val());	//value=1
	
	//코멘트 '추가'버튼 눌린 경우
	$("#comment_write").click( function() {
	
		if($('#fcomment_content').val()=="") {
			alert("댓글을 먼저 입력하세요*^^*");
		}	
		else {
			$.ajax({
				type : "POST",
				url : "freeCommentWrite.app",
				async : true,
				dataType : "json",
				data : {
					free_num : $('#free_num').val(),
					fcomment_content : $('#fcomment_content').val()
				},
				success : function(data){
					if(data.status=="success"){
						getComment(1);						
					}					
				}
			});			
		}
	});	
}); 

/**************************코멘트 처리*************************************/
//코멘트 가져오기
function getComment(commentPageNum)  {
	event.preventDefault();
	
	if(commentPageNum==1) {
		$('#commentPageNum').val(1);
	}
	
	commentPageNum = parseInt(commentPageNum);
	
	$.ajax({
		type : "POST",
		url : "freeCommentRead.app",
		async : true,
		dataType : "json",
		data : {
			free_num : $('#free_num').val(),
			endRow : commentPageNum*20
		},
		success : function(data) {
			var html = '';
			var userId = $('#userId').val()
			
			$.each(data.freeCommentUserVO, function(entryIndex, entry) {
				var formatted_date = new Date(entry.fcomment_date);		
	
				html += '<div class="row">';
				html += '<div class="col-md-2 col-sm-3 text-center">' + entry.name + '</div>';
				html += '<div class="col-md-10 col-sm-9">';
				html += '<div class="panel" style="background: #F5F5F5">' + entry.fcomment_content;
				
				html += '<div id="inlineFooter" style="float: right">';	
				
				if(userId==entry.id)
				{				
					html += '<a onclick="freeCommentDelete(' + entry.fcomment_num +')">댓글 삭제 </a>' ;
				}
				html += '</div>'
				
				html += '<div class="row">';
				html += '<div class="col-xs-9">';
				html += '<small class="text-muted">' +formatted_date.toLocaleString() + '</small>';
				html += '</div>';
				html += '</div>';
				html += '</div>';
				html += '</div>';
				html += '</div>';	
				
			});
			$('#show_comment').html(html);				
			$('#fcomment_content').val("");	//댓글 입력값 초기화	
		},
		error : function(xhr) {			
			alert("error html = " + xhr.statusText);
		}	
	});
}

//코멘트 삭제
function freeCommentDelete(comment_num) {	
	$.ajax({
		type : "POST",
		url : "freeCommentDelete.app",
		async : true,
		dataType : "json",
		data : {
			free_num : $('#free_num').val(),
			fcomment_num : comment_num,		
		},
		success : function(data){
			if(data.status=="success"){
				getComment(1);						
			}					
		}
	});		
}

//댓글달기 폼으로 포커스 이동
function getFocus() {
	document.getElementById("fcomment_content").focus();
}


//조회수 추가
function addHit() {
	$.ajax({
		type : "POST",
		url : "freeHit.app",
		async : true,
		dataType : "json",
		data : {
			free_num : $('#free_num').val(),			
		},		
		error : function(xhr) {			
			alert("error html = " + xhr.statusText);
		}		
	});	
}
