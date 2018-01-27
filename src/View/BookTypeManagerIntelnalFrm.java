package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.BookTypeDao;
import client.BookType;
import sqlconnect.DBconnect;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class BookTypeManagerIntelnalFrm extends JInternalFrame {
	private JTable bookTypeTable= new JTable();  //查询表单
	private DBconnect dbconn=new DBconnect();    //数据库连接类
	private BookTypeDao bookTypeDao=new BookTypeDao();  //数据库增删改查类
	private JTextField s_bookeTypeNameTxt = new JTextField();   //查询表单输入框
	private BookType bookType=new BookType();
	private JTextField idTxt;  //修改表单编号框
	private JTextField bookTypeNameTxt; //修改表单输入框
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerIntelnalFrm frame = new BookTypeManagerIntelnalFrm();
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
	public BookTypeManagerIntelnalFrm() {
		setBackground(Color.LIGHT_GRAY);
		setFrameIcon(new ImageIcon(BookTypeManagerIntelnalFrm.class.getResource("/image/Folder_Library_24px_1174182_easyicon.net.png")));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("图书类别管理");
		setBounds(100, 100, 815, 777);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("     图书类别名称");
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		
		s_bookeTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("查询");
		button.setIcon(new ImageIcon(BookTypeManagerIntelnalFrm.class.getResource("/image/query_24px_1181401_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeQueryActionPerformed(e);
			}
		});
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JPanel 表单操作 = new JPanel();
		表单操作.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(125)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(表单操作, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(s_bookeTypeNameTxt, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(button))))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookeTypeNameTxt, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(表单操作, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("编号：");
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("图书类别名称");
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("描述：");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JTextArea bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.setIcon(new ImageIcon(BookTypeManagerIntelnalFrm.class.getResource("/image/user_modify_24px_556807_easyicon.net.png")));
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManagerIntelnalFrm.class.getResource("/image/cancel_24px_1205790_easyicon.net.png")));
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		GroupLayout gl_表单操作 = new GroupLayout(表单操作);
		gl_表单操作.setHorizontalGroup(
			gl_表单操作.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_表单操作.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_表单操作.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_表单操作.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_表单操作.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_表单操作.createSequentialGroup()
							.addGap(111)
							.addComponent(btnNewButton)
							.addGap(103)
							.addComponent(btnNewButton_1)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_表单操作.setVerticalGroup(
			gl_表单操作.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_表单操作.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_表单操作.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_表单操作.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_表单操作.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		表单操作.setLayout(gl_表单操作);
				
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(57);
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(124);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(270);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.InitTable(bookType);//调用初始化表格数据方法
		System.out.println(bookType);
		
		

	}
	/**
	 * 查询按钮事件
	 * @param evt
	 */
	
	private void BookTypeQueryActionPerformed(ActionEvent evt) {
		String s_bookTypeName=this.s_bookeTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.InitTable(bookType);
		
	}

	/**
	 * 初始化表格数据方法
	 * @param bookType
	 */
	private void InitTable(BookType bookType) {
		DefaultTableModel dfm=(DefaultTableModel) bookTypeTable.getModel();
		dfm.setRowCount(0);       //清空表格防止下次输入查询时重复显示
		Connection conn=null;
		try {
			conn=dbconn.getconn();
			ResultSet rs=bookTypeDao.Query(conn, bookType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dfm.addRow(v);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbconn.closeconn(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
