function recipeWriteUpdate() {
	var recipe_num = parseInt($('#recipe_num').val());
	var pageNum = parseInt($('#pageNum').val());
	
	location.href = "recipeContent.app?recipe_num="+ recipe_num + "&pageNum="+ pageNum;
}