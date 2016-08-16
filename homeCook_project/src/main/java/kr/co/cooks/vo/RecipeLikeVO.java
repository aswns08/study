package kr.co.cooks.vo;

public class RecipeLikeVO {
	private int recipe_num;			//글번호
	private String id ;				//아이디
	
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
	
	@Override
	public String toString() {
		return "RecipeLikeVO [recipe_num=" + recipe_num + ", id=" + id + "]";
	}
}
