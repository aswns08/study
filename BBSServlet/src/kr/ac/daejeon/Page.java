package kr.ac.daejeon;

public class Page {
	private int startRow, endRow;
	private StringBuffer sb;

	private Page() {

	}
	private static Page page = new Page();

	public static Page getInPage() {

		return page;
	}
	public void paging(int pageNum, int count, int pageSize, int pageBlock) {
		// 전체 글 갯수에서(count) 에서 페이지 사이즈(pageSize)를 나눠주면 전체페이지수를 구할 수 있음.
		// 단 전체 글 갯수를 실수형으로 형변환 후 나눠주고 소수점을 올림 시켜줘야한다. => 올림 메서드 Math.ceil
		int totalPage = (int) Math.ceil((double)count/pageSize);

		// 페이지 당 첫번째 글을 보여 줄 번호. 1페이지면 1번, 2페이지면 11번 .... (단, pageSize가 10일 경우에 )
		startRow = (pageNum -1) * pageSize + 1;
		// 페이지 당 마지막 글을 보여 줄 번호. 1페이지면 10번, 2페이지면 20번 .... (단, pageSize가 10일 경우에 ) 
		endRow = pageNum * pageSize;

		// 시작 페이지와 마지막 페이지를 설정.
		int startPage = ((pageNum-1)/pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;

		// 예를들어 totalPage가 7페이지인데 마지막 페이지가 10이면 안되기 때문에
		// endPage가 더 클 경우에는 totalPage와 endPage를 같게 만들어줘서 7페이지까지만 표시.
		if(endPage > totalPage) {
			endPage = totalPage;
		}

		sb = new StringBuffer();
		if(startPage < pageBlock) { // << 1 2 3 4 ... >> : 다음페이지 이미지( >> )를 append함.
			sb.append("<img src='images/pre.png' width='30' hieght='9'>");

		} else { // << 1 2 3 4 ... >> : 이전페이지 이미지( << )를 append함.
			sb.append("<img src='images/next.png' width='30' height='9'>");
			sb.append(" onclick='location.href=\"list.daejeon?pageNum=");
			sb.append(startPage - pageBlock);
			sb.append("\"' style='cursor:pointer'> ");
		}

		sb.append("&nbsp;|");

		for(int i=startPage ; i<=endPage ; i++) {
			if(i == pageNum) {
				sb.append("&nbsp;&nbsp;<b><font color='#91B7EF'>");
				sb.append(i);
				sb.append("</fonr></b>");
			} else {
				sb.append("&nbsp;&nbsp;<a href='list.daejeon?pageNum=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}

		sb.append("&nbsp;|");
		if(endPage < totalPage) {
			sb.append("<img src='images/hot.gif' width='30' height='9'");
			sb.append(" onclick='location.href=\"list.daejeon?pageNum=");
			sb.append(startPage + pageBlock);
			sb.append("\"' style='cursor:pointer'> ");
		} else {
			sb.append("<img src='images/hot.gif' width='30' heigth='9'>");
		}

	}

	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}	
	public StringBuffer getSb() {
		return sb;
	}


}
