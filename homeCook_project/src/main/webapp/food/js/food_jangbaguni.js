$(document).ready( function(){
	var s_price = $('#s_price').val();
	var mileage = Math.floor(s_price*0.05);
	
	$('#showMileage').show(mileage);
})
