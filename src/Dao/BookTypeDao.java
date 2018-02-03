package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;

import Util.StringUtil;
import View.BookAddIntelnalFrm;
import client.BookType;
import sqlconnect.DBconnect;

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
	public int add(BookType bookType){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int Result = 0;
		try {
			conn=DBconnect.getconn();
			String sql="insert into t_booktype values(null,?,?)";
			pstmt=conn.prepareStatement(sql);		
			pstmt.setString(1, bookType.getBookTypeName());
			pstmt.setString(2, bookType.getBookTypeDesc());
			Result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBconnect.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Result;
	}
	
	/**
	 * 图书类别查询操作方法
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet Query(BookType bookType){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		try {
			conn=DBconnect.getconn();
			StringBuffer sb=new StringBuffer("select * from t_booktype");
			if(StringUtil.IsNotEmpty(bookType.getBookTypeName())) {
				sb.append(" where bookTypeName like '%"+bookType.getBookTypeName()+"%'");//不输入类别空值动态返回Query所有值				
				}
			//System.out.println(sb.toString());
			pstmt=conn.prepareStatement(sb.toString());
			resultSet=pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//DBconnect.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
//	public int QueryId(BookType bookType) {
//		Connection conn=null;
//		PreparedStatement pstmt=null;
//		ResultSet resultSet=null;
//		int resultId=0;
//		try {
//			conn=DBconnect.getconn();
//			StringBuffer sb=new StringBuffer("select id from t_booktype where bookTypeName like '%"+BookTypeJcb.getSelectedItem()+"%'");
//			pstmt=conn.prepareStatement(sb.toString());
//			System.out.println(BookTypeJcb.getSelectedItem());
//			//System.out.println(sb.toString());
//			resultSet=pstmt.executeQuery();
//			while(resultSet.next()) {
//				resultId=resultSet.getInt("id");
//			}
//			//System.out.println(resultId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				DBconnect.closeconn(conn);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return resultId;
//	}
	
	/**
	 * 图书类别删除操作方法
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(String id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int DeleteResult=0;
		try {
			conn=DBconnect.getconn();
			String sql="delete from t_booktype where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			DeleteResult=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBconnect.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return DeleteResult;
		
	}
	
	/**
	 * 图书类别更新操作方法
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(BookType bookType){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updateResult=0;
		try {
			conn=DBconnect.getconn();
			String sql="update t_booktype set bookTypeName=?,bookTypeDesc=? where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(3, bookType.getId());
			pstmt.setString(1, bookType.getBookTypeName());
			pstmt.setString(2, bookType.getBookTypeDesc());
			updateResult=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBconnect.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updateResult;
		
		
		
	}
	
}
