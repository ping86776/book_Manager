package Dao;

import java.sql.*;
import client.User;
import sqlconnect.DBconnect;

/**
 * 用户登录验证类
 * @author Ping
 *
 */
public class UserDao {
	public User login(User user){
		User resultUser =null;
		PreparedStatement pstmt = null;
		Connection conn=null;
		try {
			conn=DBconnect.getconn();
			String sql="select * from t_user where userName=?and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				resultUser=new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBconnect.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return resultUser;
	}
}
