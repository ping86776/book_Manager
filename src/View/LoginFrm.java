package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Dao.UserDao;
import Util.StringUtil;
import client.User;
import sqlconnect.DBconnect;
import java.awt.Toolkit;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private JPasswordField passwordText;
	
	private DBconnect dbconn=new DBconnect();
	private UserDao userDao=new UserDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrm.class.getResource("/image/Library_64px_1175086_easyicon.net.png")));
		setResizable(false);
		setTitle("管理员登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("图书管理系统");
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/image/Library_64px_1175086_easyicon.net.png")));
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/image/anonymus_black_man_person_user_32px_127_easyicon.net.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("密    码");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/image/password_32px_1169936_easyicon.net.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		
		passwordText = new JPasswordField();
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//登录按钮行为
				LoginValueActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/image/login_24px_1101698_easyicon.net.png")));
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消重置按钮行为
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/image/cancel_24px_1209039_easyicon.net.png")));
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(99)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userNameText, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton_1)
										.addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))))
					.addGap(131))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel)
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame窗体居中
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录验证和判断输入是否为空值判断方法
	 * @param e
	 */
	private void LoginValueActionPerformed(ActionEvent e) {
		String userName =this.userNameText.getText();
		String password =new String(this.passwordText.getPassword()); //char转换成string类型
		if(StringUtil.IsEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;			
		}
		if(StringUtil.IsNotEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user=new User(userName,password);  //登录验证
		Connection conn=null;
		try {
			conn=dbconn.getconn();
			User CurrentUser=userDao.login(conn, user);
			if(CurrentUser!=null) {
				dispose();           //销毁登录窗口
				new MainFrm().setVisible(true);       //设置新窗口可见
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
			this.userNameText.setText("");
			this.passwordText.setText("");
			
		}catch(Exception se) {
			se.printStackTrace();
			
		}finally {
			try {
				dbconn.closeconn(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	/**
	 * 登录重置事件方法
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameText.setText("");
		this.passwordText.setText("");
		
	}
}
