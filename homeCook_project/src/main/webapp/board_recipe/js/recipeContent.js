$(document).ready( function() {
	
	getComment(1);
	getLike();
	addHit();
	checkLikePeople();
	
	commentPageNum = parseInt($("#commentPageNum").val());	//value=1
	
	//코멘트 '추가'버튼 눌린 경우
	$("#comment_write").click( function() {
	
		if($('#rcomment_content').val()=="") {
			alert("댓글을 먼저 입력하세요*^^*");
		}	
		else {
			$.ajax({
				type : "POST",
				url : "recipeCommentWrite.app",
				async : true,
				dataType : "json",
				data : {
					recipe_num : $('#recipe_num').val(),
					rcomment_content : $('#rcomment_content').val()
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
		url : "recipeCommentRead.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),
			endRow : commentPageNum*20
		},
		success : function(data) {
			var html = '';
			var userId = $('#userId').val()
			
			$.each(data.recipeCommentUserVO, function(entryIndex, entry) {
				var formatted_date = new Date(entry.rcomment_date);		
	
				html += '<div class="row">';
				html += '<div class="col-md-2 col-sm-3 text-center">' + entry.name + '</div>';
				html += '<div class="col-md-10 col-sm-9">';
				html += '<div class="panel" style="background: #F5F5F5">' + entry.rcomment_content;
				
				html += '<div id="inlineFooter" style="float: right">';	
				
				if(userId==entry.id)
				{				
					html += '<a onclick="recipeCommentDelete(' + entry.rcomment_num +')">댓글 삭제 </a>' ;
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
			$('#rcomment_content').val("");	//댓글 입력값 초기화	
		},
	});
}

//코멘트 삭제
function recipeCommentDelete(comment_num) {	
	$.ajax({
		type : "POST",
		url : "recipeCommentDelete.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),
			rcomment_num : comment_num,		
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
	document.getElementById("rcomment_content").focus();
}

/**************************좋아요 처리*************************************/
//좋아요
function clickLike() {
	$('#like').hide() ;
	$('#dislike').show() ;
	
	$.ajax({
		type : "POST",
		url : "recipeLike.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},		
		success : function(data) {
			var recipe_like = data.recipe_like ;
			$('#recipe_like_form').text(recipe_like);			
		},
	});
}

//좋아요 취소
function clickDislike() {
	$('#like').show() ;
	$('#dislike').hide() ;
	
	$.ajax({
		type : "POST",
		url : "recipeDislike.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},
		success : function(data) {
			var recipe_like = data.recipe_like ;
			$('#recipe_like_form').text(recipe_like);			
		},	
	});
}

//좋아요 수 가져오기
function getLike() {
	$.ajax({
		type : "POST",
		url : "getRecipeLike.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},
		success : function(data) {		
			var recipe_like = data.recipe_like ;
			
			$('#recipe_like_form').text(recipe_like);
		},
	});
}

//전에 좋아요 눌렀는지 확인
function checkLikePeople() {
	$.ajax({
		type : "POST",
		url : "checkLikePeople.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},
		success : function(data) {		
			var checkLikePeople = data.checkLikePeople ;
			
			if(checkLikePeople==0) {
				$('#like').show() ;
				$('#dislike').hide() ;	
			}
			else if(checkLikePeople>0) {
				$('#like').hide() ;
				$('#dislike').show() ;			
			}
		},
	});	
}

//조회수 추가
function addHit() {
	$.ajax({
		type : "POST",
		url : "recipeHit.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},		
	});	
}
