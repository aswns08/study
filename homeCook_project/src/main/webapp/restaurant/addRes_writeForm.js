$(function () {
	
	$('#addResBtn').click(function(event) {
		
		if($("#r_Num").val() == "" || $("#r_Name").val() == "" || $("#id").val() == "" || $("#r_Address").val() == "" || $("#r_Phone").val() == "" || $("#r_Foodtype").val() == "" || $("#r_Info").val() == "") {
			alert("입력하지 않은 내용이 있습니다.");
			
		} else {
			document.AddRestaurant.submit();
		}
			
	}); // click()
	
	$('#addRescancel').click(function(event) {
		location.href = "cooksMain.app"
	});
	
}); // $function()
