$(document).ready(function(){
	$('#hansickImg2').css("display",  "none");
	$('#bunsickImg2').css("display",  "none");
	$('#yangsickImg2').css("display",  "none");
	$('#etcImg2').css("display",  "none");

	//한식
	$('#hansickImg').mouseover(function(){
		$('#hansickImg').css("display",  "none");
		//$('#hansickImg2').css("display",  "block").animate({width:'toggle'},300);
		$('#hansickImg2').css("display",  "block");
	});

	$('#hansickImg2').mouseout(function(){
		$('#hansickImg2').css("display","none");
		$('#hansickImg').css("display",  "block");
	});
	
	//분식
	$('#bunsickImg').mouseover(function(){
		$('#bunsickImg').css("display",  "none");
		$('#bunsickImg2').css("display",  "block");
	});

	$('#bunsickImg2').mouseout(function(){
		$('#bunsickImg2').css("display",  "none");
		$('#bunsickImg').css("display",  "block");
	});
	
	//양식
	$('#yangsickImg').mouseover(function(){
		$('#yangsickImg').css("display",  "none");
		$('#yangsickImg2').css("display",  "block");
	});

	$('#yangsickImg2').mouseout(function(){
		$('#yangsickImg2').css("display",  "none");
		$('#yangsickImg').css("display",  "block");
	});
	
	//기타
	$('#etcImg').mouseover(function(){
		$('#etcImg').css("display",  "none");
		$('#etcImg2').css("display",  "block");
	});

	$('#etcImg2').mouseout(function(){
		$('#etcImg2').css("display",  "none");
		$('#etcImg').css("display",  "block");
	});
});
