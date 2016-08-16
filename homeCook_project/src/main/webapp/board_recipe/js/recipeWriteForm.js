//글 등록하기 버튼 눌렸을 때
function recipeWrite() {
	var recipe_title = $('#recipe_title').val();
	var recipe_content = $('#recipe_content').val();
	
	if(recipe_title=="") {
		alert("제목을 입력해주세요");
	}
	else if(recipe_content=="") {
		alert("내용을 입력해주세요");
	}
	else{
		document.recipeWriteForm.submit() ;
	}	
}