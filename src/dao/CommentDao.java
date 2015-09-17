package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JdbcUtils;
import domain.Comment;

public class CommentDao {
	public void add(Comment comment){
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
			String sql = "insert into comment(id,content,username,articleid) values(?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, comment.getId());
			st.setString(2, comment.getContent());
			st.setString(3, comment.getUsername());
			st.setString(4, comment.getArticleid());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	public int getArticleCommentCount(String articleid){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from comment where articleid = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, articleid);
			rs = st.executeQuery();
			int count = 0;
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
	}
	
}
