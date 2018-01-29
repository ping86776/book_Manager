package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import client.Book;

/**
 * 图书 Dao类
 * @author Ping
 *
 */

public class BookDao {
	/**
	 * 图书添加
	 * @param conn
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn,Book book)throws Exception{
		String sql="insert into t_book values(null,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setInt(2, book.getBookTypeId());
		pstmt.setString(3, book.getBookTypeName());
		pstmt.setString(4, book.getBookDesc());
		return pstmt.executeUpdate();
		
				
	}
}
