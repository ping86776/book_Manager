package sqlconnect;

import java.sql.*;



/**
 * 数据库工具类
 * @author Ping
 *
 */

public class DBconnect {
	private String dburl="jdbc:mysql://localhost:3306/db_book";
	private String dbUserName="root";            //用户
	private String dbpassword="86776";			//密码
	private String jdbcName="com.mysql.jdbc.Driver";   //驱动名称
	/**
	 * 建立数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getconn()throws Exception{
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
	public void closeconn(Connection conn)throws Exception{
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
