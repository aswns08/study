//글 등록하기 버튼 눌렸을 때
function freeWrite() {

	var free_title = $('#free_title').val();
	var free_content = $('#free_content').val();
	
	if(free_title=="") {
		alert("제목을 입력해주세요");
	}
	else if(free_content=="") {
		alert("내용을 입력해주세요");
	}
	else{
		document.freeWriteForm.submit() ;
	}		
}