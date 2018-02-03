package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Dao.BookDao;
import Dao.BookTypeDao;
import Util.StringUtil;
import client.Book;
import client.BookType;
import sqlconnect.DBconnect;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddIntelnalFrm extends JInternalFrame {
	private JTextField bookNameTxt;  //图书名输入框
	private JTextArea bookDescTxt;	//图书描述文本框
	private BookType bookType=new BookType(); //图书类别实体类
	private DBconnect dbconn=new DBconnect();    //数据库连接类
	private BookTypeDao bookTypeDao=new BookTypeDao();  //数据库增删改查类
	private BookDao bookDao=new BookDao();  //图书验证类
	private JComboBox BookTypeJcb=new JComboBox();  //图书类别下拉框

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddIntelnalFrm frame = new BookAddIntelnalFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddIntelnalFrm() {
		setFrameIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/notes_16.316981132075px_1191617_easyicon.net.png")));
		setTitle("图书添加");
		setIconifiable(true);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setClosable(true);
		setBounds(100, 100, 590, 424);
		
		JLabel label = new JLabel("图书名称：");
		label.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/tablet_15.695099818512px_1191605_easyicon.net.png")));
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书类别：");
		label_1.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/book_A_13.965485921889px_1191578_easyicon.net.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		BookTypeJcb = new JComboBox();
		
		JLabel label_2 = new JLabel("图书描述：");
		label_2.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/library_16px_1173951_easyicon.net.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		bookDescTxt = new JTextArea();
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/user_modify_24px_556807_easyicon.net.png")));
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/cancel_24px_1205790_easyicon.net.png")));
		button_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BookTypeJcb, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addComponent(bookDescTxt)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(159)
							.addComponent(button)
							.addGap(106)
							.addComponent(button_1)))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(BookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		this.InitBookType();
	}
	
	/**
	 * 取消按钮事件
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		resetValue();
		
	}

	/**
	 * 图书添加按钮事件
	 * @param evt
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		String bookName=bookNameTxt.getText();
		String bookDesc=bookDescTxt.getText();
		String bookTypeName=(String) BookTypeJcb.getSelectedItem();
		if(StringUtil.IsEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
										
		int bookTypeId=QueryId(bookType); //获取BookTypeJcb图书类别Id
		System.out.println(bookTypeId);
		Book book=new Book(bookName,bookTypeId,bookTypeName,bookDesc);//数据封装在book对象中
		System.out.println(book);
		int num=bookDao.add(book);//数据库添加操作
		if(num==1) {
			JOptionPane.showMessageDialog(null, "添加成功！");
			resetValue();
		}else {
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
		
		
	}
	
	/**
	 * 重置表单事件
	 */
	private void resetValue() {
		bookNameTxt.setText("");
		bookDescTxt.setText("");
		if(BookTypeJcb.getItemCount()>0) {
			BookTypeJcb.setSelectedIndex(0);
		}
		
	}
	
	/**
	 * 初始化下拉框事件
	 */
	private void InitBookType() {
		ResultSet rs=bookTypeDao.Query(new BookType());
			try {
				while(rs.next()) {
					BookType bookType=new BookType();
					bookType.setId(rs.getInt("id"));
					bookType.setBookTypeName(rs.getString("bookTypeName"));
					BookTypeJcb.addItem(bookType.getBookTypeName());
//				    Vector v=new Vector();
//				    v.add(rs.getInt("id"));
//				    v.add(rs.getString("bookTypeName"));
//				    BookTypeJcb.addItem(v);												
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
				
	}
	
	public int QueryId(BookType bookType) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		int resultId=0;
		try {
			conn=DBconnect.getconn();
			StringBuffer sb=new StringBuffer("select id from t_booktype where bookTypeName like '%"+BookTypeJcb.getSelectedItem()+"%'");
			pstmt=conn.prepareStatement(sb.toString());
			//System.out.println(BookTypeJcb.getSelectedItem());
			//System.out.println(sb.toString());
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				resultId=resultSet.getInt("id");
			}
			//System.out.println(resultId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBconnect.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultId;
	}
}
