package kr.co.cooks.vo;

import java.sql.Timestamp;

//레시피 코멘트 VO
public class RecipeCommentVO {
	private int rcomment_num;			//코멘트번호
	private String id ;					//아이디
	private String rcomment_content;	//글 내용
	private Timestamp rcomment_date;	//날짜
	private  int recipe_num;			//글번호
	
	public int getRcomment_num() {
		return rcomment_num;
	}
	public void setRcomment_num(int rcomment_num) {
		this.rcomment_num = rcomment_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRcomment_content() {
		return rcomment_content;
	}
	public void setRcomment_content(String rcomment_content) {
		this.rcomment_content = rcomment_content;
	}
	public Timestamp getRcomment_date() {
		return rcomment_date;
	}
	public void setRcomment_date(Timestamp rcomment_date) {
		this.rcomment_date = rcomment_date;
	}
	public int getRecipe_num() {
		return recipe_num;
	}
	public void setRecipe_num(int recipe_num) {
		this.recipe_num = recipe_num;
	}
	
	
	@Override
	public String toString() {
		return "RecipeCommentVO [rcomment_num=" + rcomment_num + ", id=" + id
				+ ", rcomment_content=" + rcomment_content + ", rcomment_date="
				+ rcomment_date + ", recipe_num=" + recipe_num + "]";
	}
}
