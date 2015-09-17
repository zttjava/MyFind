package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JdbcUtils;
import domain.User;

public class UserDao {
	public void add(User user){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into user(id,username,password,phonenumber,email,school) values(?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getId());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.setString(4, user.getPhonenumber());
			st.setString(5, user.getEmail());
			st.setString(6, user.getSchool());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	public User find(String username,String password){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where username=? and password=?";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setEmail(rs.getString("email"));
				user.setSchool(rs.getString("school"));
				return user;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	public User find(String username){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where username=?";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setEmail(rs.getString("email"));
				user.setSchool(rs.getString("school"));
				return user;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
