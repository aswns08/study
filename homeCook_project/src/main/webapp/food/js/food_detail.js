$(document).ready( function() {
	getRecipe();
	getIngre();
	getOrigin();
	loadReviewList(currentPageNum);
	
	// 글쓰기폼 눌렀을 때 발생하는 이벤트
	$('#re_Content').click(function() {
		$('#re_Content').removeAttr('placeholder');
		
		if ($('#reContentWrap').hasClass('fullSize')) { } 
		
		else {
			$('#reContentWrap').addClass('fullSize');
			$('#addBtn').css('display', '');

		} //else
	});
	
	// 글쓰기 폼에서 포커스가 아웃되면 글쓰기폼이 줄어들게 해주는 코드.
	$('#tweetFrom').focusout(function() {
		if ($('#re_Content').val().length > 0) {

		} else {

			$('#re_Content').attr('placeholder', '여러분의 후기를 남겨주세요~');
			$('#reContentWrap').removeClass('fullSize');
		}
	});
	
	// 리뷰 글쓰기 버튼
	$('#writeReviewBtn').click(function() {
		
		if($('#re_Content').val() == "") {
			alert("내용을 입력해주세요.");
			
		} else {
			document.tweetFrom.submit();
		}
		
	});
	
	// 별점 이벤트
	$(".star_rating a" ).click(function() {
		var re_Grade = 0;
	     $(this).parent().children("a").removeClass("on");
	     $(this).addClass("on").prevAll("a").addClass("on");
	     
	     if( $('#reviewStar5').hasClass("on") ) {
	    	 $('#re_Grade').val('5');
	    	 
	     } else if( $('#reviewStar4').hasClass("on") ) {
	    	 $('#re_Grade').val('4');
	    	 
	     } else if( $('#reviewStar3').hasClass("on") ) {
	    	 $('#re_Grade').val('3');
	    	 
	     } else if( $('#reviewStar2').hasClass("on") ) {
	    	 $('#re_Grade').val('2');
	    	 
	     } else if( $('#reviewStar1').hasClass("on") ) {
	    	 $('#re_Grade').val('1');
	     }
	     return false;
	});
	
	
});

function getRecipe() {
	var f_recipe = $('#f_recipe').val();		//레시피내용
	//var f_number = f_recipe.indexOf("**********");	//**********을 구분자로 문자열 배열에 저장
	//alert("f_number" + f_number);
	
	var html = "";
	var recipe = f_recipe.split("**********")
	for(var i=0 ; i<recipe.length-1 ; i++) {
		
		html += '<label for="foodName" class="col-sm-1 control-label"><font size="4">' + (i+1) + '</font></label>';
		html += '<p><font size="4">' +recipe[i] + '</font></p>';	
		
	}
	$('#show_recipe').html(html);	
}

function getIngre() {
	var f_ingredients = $('#f_ingredients').val();
	
	var html = '<p><font size="4">';
	var ingredients = f_ingredients.split("*****")
	for(var i=0 ; i<ingredients.length-1 ; i++) {	 
		
		html += ingredients[i] + ',   ';		
	}
	
	html+= '</font></p>';
	$('#show_ingre').html(html);	
}

function getOrigin() {
	var f_origin = $('#f_origin').val();		//원산지 
	//var f_number = f_origin.indexOf("*****");
	
	var html = '<p>';
	var origin = f_origin.split("*****")
	for(var i=0 ; i<origin.length-1 ; i++) {	 
		
		html += origin[i] + ',   ';		
	}
	html += '</p>';
	$('#show_origin').html(html);	
}

//구매하기
function beforBuy() {
	var f_num = $('#f_num').val();
	var foodCount = document.getElementById("foodCount").value;	//음식 수량
	//alert(foodCount);
	
	location.href="buyFoodForm.app?f_num="+f_num+"&count="+foodCount;
}

//리뷰리스트
function loadReviewList(pageNum) {
	if(pageNum <= 0) pageNum = currentPageNum;
	
	$.getJSON('reviewList.app?pageNum='+pageNum+'&f_num='+$('#f_num').val()+'&r_num='+$('#r_num').val(), function(data) {
		
		console.log(data);
		
		if(data.loginUser_Id != null) {
			loginUser_Id = data.loginUser_Id;
		}
			
		var reviewList = data.reviewList;
		// 기존 리뷰 리스트 삭제
		$('.data-row').remove();
		// 새로 리뷰 리스트를 생성
		for(var i=0 ; i < reviewList.length ; i++) {
			
			if(reviewList[i].saveFileName == null) { reviewList[i].saveFileName = 'NoImage.jpg' }
			console.log("사진 : ", reviewList[i].saveFileName);
			
			var reviewContent = [];
			reviewContent = reviewList[i].re_Content.split('<br />')
			
			// 날짜 포맷.
			var formatted_date = new Date(reviewList[i].re_Date);
			
			if(reviewList[i].re_Grade == 5) { reviewList[i].re_Grade = '★★★★★' }
			else if(reviewList[i].re_Grade == 4) { reviewList[i].re_Grade = '★★★★' }
			else if(reviewList[i].re_Grade == 3) { reviewList[i].re_Grade = '★★★' }
			else if(reviewList[i].re_Grade == 2) { reviewList[i].re_Grade = '★★' }
			else reviewList[i].re_Grade = '★'
			
			$('<tr>').addClass('data-row').css('height', '5em')
					 .attr('id', 'replyNo_'+reviewList[i].re_Num)
			.append($('<td>').html(reviewList[i].re_Num).css('vertical-align', 'middle'))
			.append(
					$('<td>').append(
							$('<img>').attr('src', 'fileUpload/'+reviewList[i].saveFileName).css('width', '95%').css('height', '5em')
							)
							.css('vertical-align', 'middle')
						)
			.append(
					$('<td>').append(
							$('<a>').attr('href', 'contentReview.app?re_Num='+reviewList[i].re_Num+"&f_num="+$('#f_num').val()+"&r_num="+$('#r_num').val())
									.attr('data-replyNo', reviewList[i].re_Num) //.attr('onClick', 'return false') a태그 url이 # 일 경우
									.html(reviewContent[0]) 
							)
							.css('vertical-align', 'middle')
						)
			.append($('<td>').html(reviewList[i].name).css('vertical-align', 'middle').css('text-align', 'center'))
			.append($('<td>').html(formatted_date.toLocaleString()).css('vertical-align', 'middle').css('text-align', 'center'))
			.append($('<td>').html(reviewList[i].re_Grade).css('vertical-align', 'middle').css('text-align', 'center'))
			.appendTo('#reviewListTbody')
		} // for
		
	});
}

//장바구니에 넣으시겠습니까?
function jangbaguni() {

	$.ajax({
		type : "POST",
		url : "addJang.app",
		async : true,
		dataType : "json",
		data : {
			f_num : $('#f_num').val(),	
			f_price : $('#f_price').val(),	
			f_count : document.getElementById("foodCount").value
		},
		success : function(data){
			if(data.status=="success"){
				
			 var txt;
			    var r = confirm("장바구니에 담았습니다. 확인하러가시겠습니까?");
				    
			    if (r == true) {
			    	location.href="showJang.app";
			    }						
			}					
		}
	});
   
}
