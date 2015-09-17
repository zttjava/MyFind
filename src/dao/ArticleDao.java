package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.JdbcUtils;
import domain.Article;
import domain.Comment;
import domain.User;

public class ArticleDao {
	public void add(Article article){
		/*private String articleid;
	private String title;
	private String content;
	private String emittime;
	private String lasttime;
	private String articletype;
	private User user;
	*/
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into article(articleid,title,content,emittime,lasttime,articletype,userid) values(?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, article.getArticleid());
			st.setString(2, article.getTitle());
			st.setString(3, article.getContent());
			st.setString(4, article.getEmittime());
			st.setString(5, article.getLasttime());
			st.setString(6, article.getArticletype());
			st.setString(7, article.getUser().getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	
	public List<Article> findAll(){
		/*private String articleid;
		private String title;
		private String content;
		private String emittime;
		private String lasttime;
		private String articletype;
		private User user;
		*/
		List<Article> list = new ArrayList<Article>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from article";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Article article =  new Article();
				article.setArticleid(rs.getString("articleid"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setEmittime(rs.getString("emittime"));
				article.setLasttime(rs.getString("lasttime"));
				article.setArticletype(rs.getString("articletype"));
				String userid = rs.getString("userid");
				String sql2 = "select * from user where id=?";
				PreparedStatement st2 = conn.prepareStatement(sql2);
				st2.setString(1, userid);
				ResultSet rs2 = st2.executeQuery();
				User user = null;
				if(rs2.next()){
					user = new User();
					user.setId(rs2.getString("id"));
					user.setUsername(rs2.getString("username"));
					user.setPassword(rs2.getString("password"));
					user.setPhonenumber(rs2.getString("phonenumber"));
					user.setEmail(rs2.getString("email"));
					user.setSchool(rs2.getString("school"));
				}
				article.setUser(user);
				list.add(article);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public List<Article> getPageData(int startindex,int pagesize){
			
    	
		List<Article> list = new ArrayList<Article>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from article order by emittime desc limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, startindex);
			st.setInt(2, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				Article article =  new Article();
				article.setArticleid(rs.getString("articleid"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setEmittime(rs.getString("emittime"));
				article.setLasttime(rs.getString("lasttime"));
				article.setArticletype(rs.getString("articletype"));
				String userid = rs.getString("userid");
				String sql2 = "select * from user where id=?";
				PreparedStatement st2 = conn.prepareStatement(sql2);
				st2.setString(1, userid);
				ResultSet rs2 = st2.executeQuery();
				User user = null;
				if(rs2.next()){
					user = new User();
					user.setId(rs2.getString("id"));
					user.setUsername(rs2.getString("username"));
					user.setPassword(rs2.getString("password"));
					user.setPhonenumber(rs2.getString("phonenumber"));
					user.setEmail(rs2.getString("email"));
					user.setSchool(rs2.getString("school"));
				}
				article.setUser(user);
				list.add(article);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	public int getTotalRecord(){
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from article";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			int result = 0;
			if(rs.next()){
				result = rs.getInt(1);
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public Article findArticle(String articleid){
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Article article = null;
		try {
			
			conn = JdbcUtils.getConnection();
			String sql = "select * from comment where articleid=?";
			Set<Comment> comments = new HashSet<Comment>();
			st = conn.prepareStatement(sql);
			st.setString(1, articleid);
			rs = st.executeQuery();
			while(rs.next()){
				Comment comment =  new Comment();
				comment.setId(rs.getString("id"));
				comment.setContent(rs.getString("content"));
				comment.setUsername(rs.getString("username"));
				comment.setArticleid(rs.getString("articleid"));
				comments.add(comment);
			}
			
			
			String sql2 = "select * from article where articleid=?";
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setString(1, articleid);
			ResultSet rs2 = st2.executeQuery();
			if(rs2.next()){
				article =  new Article();
				article.setArticleid(rs2.getString("articleid"));
				article.setTitle(rs2.getString("title"));
				article.setContent(rs2.getString("content"));
				article.setEmittime(rs2.getString("emittime"));
				article.setLasttime(rs2.getString("lasttime"));
				article.setArticletype(rs2.getString("articletype"));
				String userid = rs2.getString("userid");
				String sql3 = "select * from user where id=?";
				PreparedStatement st3 = conn.prepareStatement(sql3);
				st3.setString(1, userid);
				ResultSet rs3 = st3.executeQuery();
				User user = null;
				if(rs3.next()){
					user = new User();
					user.setId(rs3.getString("id"));
					user.setUsername(rs3.getString("username"));
					user.setPassword(rs3.getString("password"));
					user.setPhonenumber(rs3.getString("phonenumber"));
					user.setEmail(rs3.getString("email"));
					user.setSchool(rs3.getString("school"));
				}
				article.setUser(user);
				article.setComments(comments);
			}
			return article;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
