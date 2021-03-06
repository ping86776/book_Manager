package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.BookTypeDao;
import sqlconnect.DBconnect;
import javax.swing.ImageIcon;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = new JDesktopPane();  //内部窗体

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/image/Library_64px_1175086_easyicon.net.png")));
		setTitle("图书管理界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本功能菜单");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/image/gear_24.12px_1189518_easyicon.net.png")));
		mnNewMenu.setFont(new Font("黑体", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("图书类别管理");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/image/tablet_15.695099818512px_1191605_easyicon.net.png")));
		menu.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		mnNewMenu.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("图书类别添加");
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/image/notes_16.316981132075px_1191617_easyicon.net.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddIntelnalFrm bookTypeAddIntelnalFrm=new BookTypeAddIntelnalFrm();
				bookTypeAddIntelnalFrm.setVisible(true);
				table.add(bookTypeAddIntelnalFrm);
			}
		});
		menuItem_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("图书类别查询");
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/image/search_15.853345554537px_1191635_easyicon.net.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerIntelnalFrm bookTypeManagerIntelnalFrm=new BookTypeManagerIntelnalFrm();
				bookTypeManagerIntelnalFrm.setVisible(true);
				table.add(bookTypeManagerIntelnalFrm);
			}
		});
		menuItem_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("图书管理");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/image/book_A_13.965485921889px_1191578_easyicon.net.png")));
		menu_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("图书添加");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAddIntelnalFrm bookAddIntelnalFrm=new BookAddIntelnalFrm();
				bookAddIntelnalFrm.setVisible(true);
				table.add(bookAddIntelnalFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/image/notes_16.316981132075px_1191617_easyicon.net.png")));
		menuItem_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_5 = new JMenuItem("图书查询");
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/image/search_15.853345554537px_1191635_easyicon.net.png")));
		menuItem_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_4 = new JMenuItem("图书删除");
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/image/cancel_24px_1205790_easyicon.net.png")));
		menuItem_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem = new JMenuItem("注销登录");
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/ui_15.709355131698px_1191606_easyicon.net.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"是否退出？","注销",JOptionPane.YES_NO_OPTION);
				if(result==0) {
					dispose();
					new LoginFrm().setVisible(true);
				}
				
			}
		});
		menuItem.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		mnNewMenu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
						
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 1906, Short.MAX_VALUE)
		);
		table.setBackground(Color.LIGHT_GRAY);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 994, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1906, Short.MAX_VALUE)
		);
		gl_table.setVerticalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 994, Short.MAX_VALUE)
		);
		table.setLayout(gl_table);
		contentPane.setLayout(gl_contentPane);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//窗口最大化
		this.setSize(988, 800);
		this.setLocationRelativeTo(null);
		
	}
}
