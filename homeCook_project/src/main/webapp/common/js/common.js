var vcode;
var email;

$(document).ready(function () {
	
	$('#btnLogin').click(function () {
		$.ajax({
			type: "POST",
			url: "login.app",
			async: true,
			dataType: "json",
			data: {
				email:$("#login_email").val(),
				password:$("#login_password").val()
			},
			
			success : function(data) {
				if(data.status == 'success') {
					location.href = 'cooksMain.app'
				} else {
					alert("아이디 또는 암호가 맞지 않습니다");
				}
		
			},
			error : function(xhr) {
				console.log("error", xhr);
				alert("error html = " + xhr.statusText);
			} // error
			
		}); // ajax
		
	}); // click(function)

	$('#authBtn').click(function(){
		
		if($('#input_email').val() == "") {
			alert("이메일을 입력하세요.");
			return;
		}
		
		$.post('findEmailCheck.app'
		        , {
		        	input_email : $('#input_email').val()
		        }
		        , function(data){
		        	 
		          if (data.status == "empty") {
		        	  document.getElementById('findPwd_email').style.color = "red";
		        	  document.getElementById('findPwd_email').innerHTML = "존재하지 않는 아이디 입니다.";
		        	  $('#input_email').focus(); // 중복되는 아이디가 있을 경우 포거스를 아이디로 맞춤.
		        	  
		          } else {
		        	  $.ajax({
		  				type: "POST",
		  				url: "emailAuth.app",
		  				async: true,
		  				dataType: "json",
		  				data: {
		  					input_email : $('#input_email').val()
		  				},
		  				
		  				success : function(data) {
		  					
		  					if (data.status == 'success') {
		  						vcode = data.vcode;
		  						email = data.email;
		  						
		  						document.getElementById('findPwd_email').style.color = "blue";
		  						document.getElementById('findPwd_email').innerHTML = "메일이 전송되었습니다.";
		  						
		  					} else 
		  						alert("인증 실패!");
		  				},
		  				error : function(xhr) {
		  					console.log("error", xhr);
		  					alert("error html = " + xhr.statusText);
		  				} // error
		  				
		  			}); // ajax
		        	  
		          } // else
		        	  
		        } // function () ajax 익명함수.
		        , 'json');
			
			
	}); // ('#authBtn').click(function()


	$('#pinNumbereBtn').click(function(){
		
		if(vcode == $("#pinNumber").val()) {
			alert("인증 성공!");
			
			close_findPassword();
			$('#changePwd').modal();
			
		}else{
			alert("인증번호를 다시 확인하세요.");
		}
	}); // ('#pinNumbereBtn').click(function()
	
	
	$('#changePwdBtn').click(function () {
		
		changePassword(); // 비밀번호 변경 함수.
		
	});


}); //document.ready


//로그인 창 닫기 (로그인 창 -> 회원가입 창 && 로그인 창 -> 비밀번호찾기 창)
function close_signIn() {
	$('#loginCloseBtn').click();
	
}	 

//비밀번호 찾기 창 닫기(비밀번호 찾기 -> 비밀번호 변경 창)
function close_findPassword() {
	$('#findPwdClose').click();
}

//Email 확인.
function findEmailCheck() {
	$.post('findEmailCheck.app'
	        , {
	        	input_email : $('#input_email').val()
	        }
	        , function(data){
	        	 
	          if (data.status == "empty") {
	        	  document.getElementById('findPwd_email').style.color = "red";
	        	  document.getElementById('findPwd_email').innerHTML = "존재하지 않는 아이디 입니다.";
	        	  $('#input_email').focus(); // 중복되는 아이디가 있을 경우 포거스를 아이디로 맞춤.
	          } 
	        }
	        , 'json');
}

function changePassword() {
	
	if(!newCheckPwd()) return;
	
	$.post('changePwd.app' ,
			{
				email : email,
				new_pwd : $('#new_pwd').val()
			}
	, function(data) {
		if(data.status = "success") {
			location.href = 'cooksMain.app'
		} 
	}
			
	, 'json'); 
}

//keyup() 비밀번호 유효성검사
function newCheckPwd() { 
	var pwd = document.getElementById("new_pwd").value;
	var rePwd = document.getElementById("re_newPwd").value;
		
	if (pwd == null || pwd.length == 0) {
		document.getElementById('changeValid_pwd').style.color = "red";
		document.getElementById('changeValid_pwd').innerHTML = "비밀번호를 입력해주세요.";
		return false;
	} else if (pwd != rePwd) {
		document.getElementById('changeValid_pwd').style.color = "red";
		document.getElementById('changeValid_pwd').innerHTML = "비밀번호가 일치하지 않습니다.";
		return false;
	} else if(pwd == rePwd){
		document.getElementById('changeValid_pwd').style.color = "blue";
		document.getElementById('changeValid_pwd').innerHTML = "비밀번호가 확인되었습니다.";
		return true;
	}
}