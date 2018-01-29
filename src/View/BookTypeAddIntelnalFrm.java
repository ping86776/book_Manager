package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import Dao.BookTypeDao;
import Util.StringUtil;
import client.BookType;
import sqlconnect.DBconnect;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;

public class BookTypeAddIntelnalFrm extends JInternalFrame {
	private JTextField BookTypeNameText;
	private JTextArea BookTypeDescText;
	
	private DBconnect dbconn=new DBconnect();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddIntelnalFrm frame = new BookTypeAddIntelnalFrm();
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
	public BookTypeAddIntelnalFrm() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.LIGHT_GRAY);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setMaximizable(true);
		setEnabled(false);
		setIconifiable(true);
		setForeground(Color.LIGHT_GRAY);
		setFrameIcon(new ImageIcon(BookTypeAddIntelnalFrm.class.getResource("/image/Folder_Library_24px_1174182_easyicon.net.png")));
		setClosable(true);
		setTitle("图书类别添加");
		setBounds(100, 100, 500, 404);
		setResizable(true);
		
		JLabel lblNewLabel = new JLabel("图书类别添加");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1 = new JLabel("图书类别描述");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		BookTypeNameText = new JTextField();
		BookTypeNameText.setColumns(10);
		
		BookTypeDescText = new JTextArea();
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeAddIntelnalFrm.class.getResource("/image/Add_24px_1166404_easyicon.net.png")));
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeAddIntelnalFrm.class.getResource("/image/Reset_28px_1166480_easyicon.net.png")));
		button_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(BookTypeDescText))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(BookTypeNameText, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(88, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addComponent(button)
					.addGap(95)
					.addComponent(button_1)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(BookTypeNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(BookTypeDescText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(39))
		);
		getContentPane().setLayout(groupLayout);
		
		BookTypeDescText.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		

	}
	
	/**
	 * 图书添加按钮事件
	 * @param evt
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		String bookTypeName=this.BookTypeNameText.getText();
		String bookTypeDesc=this.BookTypeDescText.getText();
		//System.out.println("add"+bookTypeName);
		if(StringUtil.IsEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别不能为空！");
			return;
		}
		BookType bookType=new BookType(bookTypeName,bookTypeDesc);
		Connection conn=null;
		try {
			conn=dbconn.getconn();
			int n=bookTypeDao.add(conn, bookType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败！");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加发生错误！");
		}finally {
			try {
				dbconn.closeconn(conn);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "图书类别添加发生错误！");
			}
		}
		
	}

	/**
	 * 重置事件方法
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
		
	}

	/**
	 * 重置表单方法
	 */

	private void resetValue(){
			this.BookTypeNameText.setText("");
			this.BookTypeDescText.setText("");
		}
}
