package kr.ac.daejeon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BBSDao implements BBSDaoService {

	Connection con ;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardVO> articleList;
	BoardVO article;
	
	private BBSDao() {

	}
	private static BBSDao ld = new BBSDao();

	public static BBSDao getInstance() {
		return ld;
	}

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; //0.0.1:자기컴퓨터를 가리킴 / 1521:port번호
			con = DriverManager.getConnection(url, "human", "1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con ;
	}

	@Override
	public void insertArticle(BoardVO article) throws IOException, SQLException {

		System.out.println(article);
		con=this.getConnection();
		pstmt = con.prepareStatement("insert into BBS values(bbs_seq.nextval,?,?,?,0,0,bbs_seq.currval,0,sysdate,?)");
		
		pstmt.setString(1, article.getId());
		pstmt.setString(2, article.getTitle());
		pstmt.setString(3, article.getContent());
		pstmt.setString(4, article.getFname());
		pstmt.executeUpdate();
		streamClose();
	}
	
	@Override
	public BoardVO getUpdate(int article_Num) throws IOException, SQLException {

		con=this.getConnection();
		pstmt=con.prepareStatement("select title, content from BBS where article_Num=?");
		pstmt.setInt(1, article_Num);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			article = new BoardVO();
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
		}
		streamClose();
		return article;
	}
	
	@Override
	public void updateArticle(int article_Num, String title, String content) throws IOException, SQLException {

		con=this.getConnection();
		pstmt=con.prepareStatement("update BBS set title=?, content=? where article_Num=?");
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, article_Num);
		pstmt.executeUpdate();
		
		streamClose();
		
	}
	
	@Override
	public void deleteArticle(int article_Num) throws IOException, SQLException {
		
		con=this.getConnection();
		pstmt=con.prepareStatement("delete from BBS where article_Num=?");
		pstmt.setInt(1, article_Num);
		rs = pstmt.executeQuery();
		
		streamClose();
	}
	
	@Override
	public void replyArticle(BoardVO article) throws IOException, SQLException {
		
		con=this.getConnection();
		pstmt=con.prepareStatement("update BBS set position=position+1 where group_Id=? and position>?");
		pstmt.setInt(1, article.getGroup_Id());
		pstmt.setInt(2, article.getPosition());
		pstmt.executeUpdate();
		
		pstmt=con.prepareStatement("insert into BBS values(bbs_seq.nextval,?,?,?,?,0,?,?,sysdate,?)");
		pstmt.setString(1, article.getId());
		pstmt.setString(2, article.getTitle());
		pstmt.setString(3, article.getContent());
		pstmt.setInt(4, article.getDepth()+1);
		pstmt.setInt(5, article.getGroup_Id());
		pstmt.setInt(6, article.getPosition()+1);
		pstmt.setString(7, article.getFname());
		pstmt.executeUpdate();
		
		streamClose();
	}
	
	@Override
	public BoardVO getArticle(int article_Num) throws IOException, SQLException {
		
		con=this.getConnection();
		pstmt=con.prepareStatement("select * from BBS where article_Num=?");
		pstmt.setInt(1, article_Num);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			article = new BoardVO();
			article.setArticle_Num(rs.getInt("article_Num"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setDepth(rs.getInt("depth"));
			article.setHit(rs.getInt("hit"));
			article.setGroup_Id(rs.getInt("group_Id"));
			article.setId(rs.getString("id"));
			article.setPosition(rs.getInt("position"));
			article.setWrite_Date(rs.getTimestamp("write_Date"));
			article.setFname(rs.getString("fname"));
			
		}
		streamClose();
		return article;
	}
	
	@Override
	public int getArticleCount() throws SQLException, IOException {
		int count=0;
		
		con=this.getConnection();
		pstmt = con.prepareStatement("select count(*) from BBS");
		rs=pstmt.executeQuery();
		if(rs.next()) {
			// rs.get데이터타입("컬럼명");  / 결과가 카운트 갯수 1개 밖에 없으므로 1로 값을 얻어옴
			count=rs.getInt(1);
		}

		streamClose();
		return count;
	}

	@Override
	public ArrayList<BoardVO> getArticles(int startRow, int endRow)
			throws SQLException, IOException {

		articleList = new ArrayList<>();
		con=this.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("select * ");
		query.append("from (select rownum rm,human.* from ");
		query.append("(select * from bbs order by group_id desc, position) human) ");
		query.append("where rm between ? and ?");
		
		pstmt=con.prepareStatement(query.toString());
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			article = new BoardVO();
			article.setArticle_Num(rs.getInt("article_Num"));
			article.setId(rs.getNString("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setDepth(rs.getInt("depth"));
			article.setHit(rs.getInt("hit"));
			article.setPosition(rs.getInt("position"));
			article.setWrite_Date(rs.getTimestamp("write_Date"));
			article.setFname(rs.getString("fname"));
			articleList.add(article);
		}
		streamClose();
		return articleList;

	}
	
	@Override
	public int login_check(String id, String pwd) throws IOException,
			SQLException {
		
		con=this.getConnection();
		String sql = "select pwd from login where id =?" ;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		
		int status = 0;
		if(rs.next()) {
			if(pwd.equals(rs.getString("pwd"))) {
				//if(pwd.equals(rs.getString(1))){
				status=1;
			} else {
				status=2;
			}
		} else {
			status=3;
		}
		streamClose();
		
		return status;
	}
	
	public void streamClose() {
		
		try{
			if(rs!=null) {
				rs.close();
			}
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
