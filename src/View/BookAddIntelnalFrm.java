package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Dao.BookDao;
import Dao.BookTypeDao;
import client.BookType;
import sqlconnect.DBconnect;

public class BookAddIntelnalFrm extends JInternalFrame {
	private JTextField BookNameTxt;
	private BookType bookType=new BookType(); //图书类别实体类
	private DBconnect dbconn=new DBconnect();    //数据库连接类
	private BookTypeDao bookTypeDao=new BookTypeDao();  //数据库增删改查类
	private BookDao bookDao=new BookDao();
	private JComboBox BookTypeJcb=new JComboBox();//下拉框

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
		
		BookNameTxt = new JTextField();
		BookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书类别：");
		label_1.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/book_A_13.965485921889px_1191578_easyicon.net.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		BookTypeJcb = new JComboBox();
		
		JLabel label_2 = new JLabel("图书描述：");
		label_2.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/library_16px_1173951_easyicon.net.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JTextArea BookDescTxt = new JTextArea();
		
		JButton button = new JButton("添加");
		button.setIcon(new ImageIcon(BookAddIntelnalFrm.class.getResource("/image/user_modify_24px_556807_easyicon.net.png")));
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JButton button_1 = new JButton("取消");
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
									.addComponent(BookNameTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BookTypeJcb, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addComponent(BookDescTxt)))
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
						.addComponent(BookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(BookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(BookDescTxt, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		this.InitBookType();
	}
	
	private void InitBookType() {
		Connection conn=null;
		try {
			conn=dbconn.getconn();
			ResultSet rs=bookTypeDao.Query(conn,new BookType());
			while(rs.next()) {
				BookType bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.BookTypeJcb.addItem(bookType.getBookTypeName());				
				
			}
			System.out.println(bookType);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbconn.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
