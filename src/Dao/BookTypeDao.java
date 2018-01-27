package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import client.BookType;

/**
 * 图书类别添加Dao类
 * @author Ping
 *
 */
public class BookTypeDao {
	/**
	 * 图书类别添加操作方法
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn,BookType bookType)throws Exception{				
		String sql="insert into t_booktype values(null,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);		
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书类别查询操作方法
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet Query(Connection conn,BookType bookType)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_booktype");
		if(StringUtil.IsNotEmpty(bookType.getBookTypeName())) {
			sb.append(" where bookTypeName like '%"+bookType.getBookTypeName()+"%'");
			//不输入类别空值动态返回Query所有值
		}
		System.out.println(sb.toString());
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		//用where替换and
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书类别删除操作方法
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn,String id)throws Exception{
		String sql="delete * from t_booktype where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 图书类别更新操作方法
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,BookType bookType)throws Exception{
		String sql="update *from t_booktype where id=?,bookTypeName=?,bookTypeDesc=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bookType.getId());
		pstmt.setString(2, bookType.getBookTypeName());
		pstmt.setString(3, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
		
		
	}
	
}
