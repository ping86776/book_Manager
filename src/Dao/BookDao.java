package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import client.Book;
import sqlconnect.DBconnect;

/**
 * 图书 Dao类
 * @author Ping
 *
 */

public class BookDao {
	
	/**
	 * 图书添加操作方法
	 * @param book
	 * @return
	 */
	public int add(Book book){
		Connection conn=null;		
		PreparedStatement pstmt = null;
		int AddResult=0;
		try {
			conn=DBconnect.getconn();
			String sql="insert into t_book values(null,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setInt(2, book.getBookTypeId());
			pstmt.setString(3, book.getBookTypeName());
			pstmt.setString(4, book.getBookDesc());
			AddResult=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBconnect.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return AddResult;
		
				
	}
	
}
