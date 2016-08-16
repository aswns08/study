function freeWriteUpdate() {
	var free_num = parseInt($('#free_num').val());
	var pageNum = parseInt($('#pageNum').val());
	
	location.href = "freeContent.app?free_num="+ free_num + "&pageNum="+ pageNum;
}