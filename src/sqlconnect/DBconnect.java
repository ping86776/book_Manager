package sqlconnect;

import java.sql.*;



/**
 * 数据库工具类
 * @author Ping
 *
 */

public class DBconnect {
	private static final String dburl="jdbc:mysql://localhost:3306/db_book";
	private static final String dbUserName="root";            //用户
	private static final String dbpassword="86776";			//密码
	private static final String jdbcName="com.mysql.jdbc.Driver";   //驱动名称
	/**
	 * 建立数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getconn()throws ClassNotFoundException, SQLException{
		Class.forName(jdbcName);   //注册jdbc驱动
		Connection conn = DriverManager.getConnection(dburl, dbUserName, dbpassword);
		//连接数据库
		return conn;							
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @throws Exception
	 */
	public static void closeconn(Connection conn)throws Exception{
		if(conn!=null) {
			conn.close();
		}
	}
	public static void main(String[] args) {
		DBconnect dbconn=new DBconnect();
		try {
			dbconn.getconn();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
	
}
