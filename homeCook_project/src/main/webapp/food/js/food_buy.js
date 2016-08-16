$(document).ready( function() {
	var totalPrice = $('#totalPrice').val();
	$('#finalResultPrice').val(totalPrice);		//총 결제금액 세팅
	
});

function resultPrice() {
	var totalPrice = parseInt($('#totalPrice').val()) ;			//음식 합계 ( 음식가격 * 수량 )
	var userMileage = parseInt($('#userMileage').val());		//사용자가 보유하고있는 마일리지
	var useMileage = $('#mileageForm').val();					//쓰려고 입력한 마일리지
	
	
	//쓰려는 마일리지가 없는 경우
	if(useMileage==""){			
		$('#finalResultPrice').val(totalPrice);					//총 결제금액 세팅
	}
	
	//쓰려는 마일리지가 있는 경우
	else {
		useMileage = parseInt($('#mileageForm').val());			//쓰려고 입력한 마일리지	
	
		//마일리지 조건문
		if((useMileage>=0) &&  (useMileage<=userMileage) && (useMileage<=totalPrice)) {
			var resultPrice = totalPrice-useMileage ;
			$('#finalResultPrice').val(resultPrice);			
			$('#o_price').val(resultPrice);	
		}
		
		else {
			alert("잘못 입력하셨습니다. 고객님이 보유하고 있는 마일리지는"+userMileage+"입니다 ");
			$('#mileageForm').val("");
			$('#finalResultPrice').val(totalPrice);		//총 결제금액 세팅
		}
	}
//	alert("보유하고있는 마일리지 : " + userMileage + ",  사용하려는 마일리지 : " + useMileage);
}


function buy() {
	var f_num = $('#f_num').val();					//음식 번호
	var count = $('#count').val();					//수량 
	var o_price = $('#finalResultPrice').val();		//음식 가격 * 수량 -마일리지
	var s_num = $('#s_num').val();					//장바구니번호
		
	//쓰려고 입력한 마일리지
	if($('#mileageForm').val()==""){	//쓰려는 마일리지가 0인 경우
		var useMileage = 0 ;
	}
	else {	//쓰려는 마일리지가 0이 아닌 경우
		var useMileage = $('#mileageForm').val();	
	}
	
	location.href="buyFood.app?f_num=" + f_num +"&count="+ count + "&useMileage=" + useMileage +"&o_price="+ o_price + "&s_num=" + s_num ;
}

