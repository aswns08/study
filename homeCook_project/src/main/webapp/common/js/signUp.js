var regExp5 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; //이메일
var regExp6 = /^[a-zA-Z가-힣]([-_\.]?[a-zA-Z가-힣])*$/i; // 이름

$(document).ready(function () {
	
	// 포커스 아웃될 때 이메일 중복 체크
	$('#signUp_email').focusout(function () {
		if(!emptyIdCheck()) { 
			$('#signUp_email').focus();
			return;
		} else if(!checkEmail()) {
			 return;
		} else
			checkEmailfromDB(); // 이메일 중복체크
	});  // focusout
	
	// 회원가입 버튼 누를 때
	$('#btnSignUp').click(function () {
		if(!emptyCheck()) return; // 이메일이 비어있으면 가입 불가.
		if(!checkEmail()) return; // 이메일 형식이 잘못되면 가입 불가.
		if(!checkUname()) return; // 이름 형식이 비어있으면 가입 불가.
		
		signUp();
	}); // click(function)
	
	
}); //document.ready


//  DB에서 이메일 중복체크
function checkEmailfromDB() {
	$.post('emailCheck.app'
	        , {
	        	signUp_email : $('#signUp_email').val()
	        }
	        , function(data){
	          if (data.status == 'success') {
	        	  document.getElementById('validCheck_email').style.color = "blue";
	        	  document.getElementById('validCheck_email').innerHTML = "멋진 아이디 입니다.";
	          } else {
	        	  document.getElementById('validCheck_email').style.color = "red";
	        	  document.getElementById('validCheck_email').innerHTML = "사용할 수 없는 아이디 입니다.";
	        	  $('#signUp_email').focus(); // 중복되는 아이디가 있을 경우 포거스를 아이디로 맞춤.
	          }
	        }
	        , 'json');
}


function emptyIdCheck() {
	if( $('#signUp_email').val().length == 0 ) {
		//alert("이메일은 필수 항목 입니다.");
		return false;
	} 
	return true;
}

function emptyCheck() {
	if( $('#signUp_pwd').val().length == 0 ) {
		alert("비밀번호는 필수 항목 입니다.");
		 return false;
		 
	} else if( $('#signUp_uname').val().length == 0 ) {
		alert("이름은 필수 항목 입니다.");
		return false;
		
	} else if( $('#signUp_uaddress').val().length == 0 ) {
		alert("주소는 필수 항목 입니다.");
		return false;
		
	} else if( $('#signUp_phone').val().length == 0 ) {
		alert("번호는 필수 항목 입니다.");
		return false;
	}
	return true;
}


// keyup() 이메일 유효성검사
function checkEmail() {
	var signUpEmail = document.getElementById("signUp_email").value;

	if (signUpEmail == null || signUpEmail.length == 0) {
		document.getElementById('validCheck_email').style.color = "red";
		document.getElementById('validCheck_email').innerHTML = "이메일을 입력해주세요.";
		return false;
		
	} else if(!regExp5.test($('#signUp_email').val())){
		document.getElementById('validCheck_email').style.color = "red";
		document.getElementById('validCheck_email').innerHTML = "이메일을 잘못 입력하였습니다.";	
		return false;

	} else{
		return true;
	}
}

// keyup() 비밀번호 유효성검사
function checkPwd() { 
	var pwd = document.getElementById("signUp_pwd").value;
	var rePwd = document.getElementById("singUp_rePwd").value;
		
	if (pwd == null || pwd.length == 0) {
		document.getElementById('validCheck_pwd').style.color = "red";
		document.getElementById('validCheck_pwd').innerHTML = "비밀번호를 입력해주세요.";
		return false;
	} else if (pwd != rePwd) {
		document.getElementById('validCheck_pwd').style.color = "red";
		document.getElementById('validCheck_pwd').innerHTML = "비밀번호가 일치하지 않습니다.";
		return false;
	} else if(pwd == rePwd){
		document.getElementById('validCheck_pwd').style.color = "blue";
		document.getElementById('validCheck_pwd').innerHTML = "비밀번호가 확인되었습니다.";
		return true;
	}
}

// 이름 유효성검사
function checkUname() { 
	var signUpUname = document.getElementById("signUp_uname").value;
	if (signUpUname == null || signUpUname.length == 0) {
		document.getElementById('validCheck_uname').style.color = "red";
		document.getElementById('validCheck_uname').innerHTML = "이름을 입력해주세요.";
		return false;
		
	} else if( !regExp6.test($('#signUp_uname').val()) ){
		document.getElementById('validCheck_uname').style.color = "red";
		document.getElementById('validCheck_uname').innerHTML = "이름을 잘못 입력하였습니다.(숫자, 특수문자 입력불가!)";
		return false;
		
	}else{
		document.getElementById('validCheck_uname').style.color = "blue";
		document.getElementById('validCheck_uname').innerHTML = "확인되었습니다.";
		return true;
	}
}


// 회원가입 ajax 함수.
function signUp() {
	$.ajax({
		type: "POST",
		url: "signUp.app",
		async: true,
		dataType: "json",
		data: {
			id:$("#signUp_email").val(),
			password:$("#signUp_pwd").val(),
			name:$("#signUp_uname").val(),
			address:$("#signUp_uaddress").val(),
			phone:$("#signUp_phone").val()
		},
		success : function(data) {
			if(data.status == 'success') {
				alert("회원가입이 완료되었습니다. ^^");
				location.href = 'cooksMain.app'
			} else {
				alert("등록실패");
			}
		},
		error : function(xhr) {
			console.log("error", xhr);
			alert("error html = " + xhr.statusText);
		} // error
	}); // ajax
} // signUp()