$(document).ready(function(){
	//엔터키로 검색
	$('#food_Search').keypress(function(event){
		 if(event.keyCode == 13){
			 foodSearch();
		 }
	});

});

function foodSearch() {
	var food_Search = $('#food_Search').val();
	
	//검색창에 입력한 음식이 없는 경우
	if(food_Search=="") {
		alert("검색할 음식을 입력해주세요");
	}
	//검색창에 입력한 음식이 있는 경우
	else {		
		//alert("검색할 음식===>" +food_Search);	
		$('#food_Search').val("");
		location.href="foodSearch.app?f_name=" + food_Search;
	}
}