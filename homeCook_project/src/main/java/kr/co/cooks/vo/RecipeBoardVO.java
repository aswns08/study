package kr.co.cooks.vo;

import java.sql.Timestamp;

//레시피 게시판 VO
public class RecipeBoardVO {
	private int recipe_num;			//글번호
	private String id ;				//아이디
	private String recipe_title; 	//글 제목
	private String recipe_content;	//글 내용
	private Timestamp recipe_date;	//날짜
	private int recipe_hit;			//조회수
	private int recipe_like;		//좋아요
	
	public int getRecipe_num() {
		return recipe_num;
	}
	public void setRecipe_num(int recipe_num) {
		this.recipe_num = recipe_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRecipe_title() {
		return recipe_title;
	}
	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}
	public String getRecipe_content() {
		return recipe_content;
	}
	public void setRecipe_content(String recipe_content) {
		this.recipe_content = recipe_content;
	}
	public Timestamp getRecipe_date() {
		return recipe_date;
	}
	public void setRecipe_date(Timestamp recipe_date) {
		this.recipe_date = recipe_date;
	}
	public int getRecipe_hit() {
		return recipe_hit;
	}
	public void setRecipe_hit(int recipe_hit) {
		this.recipe_hit = recipe_hit;
	}
	public int getRecipe_like() {
		return recipe_like;
	}
	public void setRecipe_like(int recipe_like) {
		this.recipe_like = recipe_like;
	}
	
	
	@Override
	public String toString() {
		return "boardRecipeVO [recipe_num=" + recipe_num + ", id=" + id
				+ ", recipe_title=" + recipe_title + ", recipe_content="
				+ recipe_content + ", recipe_date=" + recipe_date
				+ ", recipe_hit=" + recipe_hit + ", recipe_like=" + recipe_like
				+ "]";
	}
}
