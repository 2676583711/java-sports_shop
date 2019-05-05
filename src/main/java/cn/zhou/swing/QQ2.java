package cn.zhou.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//这里将frame的边框设置成不可见，所以也不能移动窗口了。
//本文目的旨在使用BorderLayout来设计界面，所以暂不实现拖动窗口的功能。
//添加BorderLayout布局管理器，并在五个部位添加一个JPanel

public class QQ2 extends JFrame {
	// 窗体的标题
	public static final String LOG_TITLE = "登录";
	// 窗体的宽度
	public static final int WINDOW_WIDTH = 380;
	// 窗体的高度
	public static final int WINDOW_HEIGHT = 300;
	// 窗体的位置的横坐标
	public static final int LOCATION_X = 497;
	// 窗体的纵坐标
	public static final int LOCATION_Y = 242;

	public static void main(String[] args) {
		// 启动程序
		new QQ2();
	}

	// 构造器初始化JFrame窗体
	public QQ2() {
		// 设置布局管理器为BorderLayout
		setLayout(new BorderLayout());
		// 设置北部面板
		add(CreatePanel.CreateNorthPanel(), BorderLayout.NORTH);
		// 设置中部面板
		add(CreatePanel.CrateCenterPanel(), BorderLayout.CENTER);

		// 设置西部面板
		add(CreatePanel.CreateWestPanel(), BorderLayout.WEST);

		// 设置南部面板
		add(CreatePanel.CreateSouthPanel(), BorderLayout.SOUTH);

		// 设置东部面板
		add(CreatePanel.CrateEastPanel(), BorderLayout.EAST);

		// 设置窗体标题
		setTitle(LOG_TITLE);
		// 设置窗体大小
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// 设置窗体位置
		setLocation(LOCATION_X, LOCATION_Y);
		// 设置frame边框不可见
		setUndecorated(true);
		// 禁止改变窗口大小
		setResizable(false);

		// 设置关闭窗口的同时关闭整个程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体可见
		setVisible(true);
	}
}

//面板创建类
class CreatePanel {

	/**
	 * 创建北部面板
	 * 
	 * @return
	 */
	public static JPanel CreateNorthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(0, 140));

		ImageIcon image = new ImageIcon("images/qs.jpg");
		Image image2 = image.getImage();
		image2.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		image.setImage(image2);

		JLabel background = new JLabel(image);
		background.setBounds(0, 0, 420, 180);
		panel.add(background);
		return panel;
	}

	/**
	 * 创建西部面板
	 */
	public static JPanel CreateWestPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(130, 0));

		ImageIcon image = new ImageIcon("images/qq2.jpg");

		Image image2 = image.getImage();
		image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		image.setImage(image2);

		JLabel background = new JLabel(image);
		background.setBounds(0, 0, 120, 120);

		panel.add(background);
		return panel;
	}

	/**
	 * 创建南部面板
	 */
	public static JPanel CreateSouthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(0, 50));
		
//		MyLineBorder myLineBorder = new MyLineBorder(new Color(192, 192, 192), 1, true);

		/**
		 * 登录按钮
		 */
		ImageIcon image = new ImageIcon("images/qb2.jpg");

		Image image2 = image.getImage();
		image2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		image.setImage(image2);

		JButton btn = new JButton(image);
		btn.setBounds(130, 0, image.getIconWidth() - 10, image.getIconHeight() - 10);
//		btn.setBorder(myLineBorder);
		panel.add(btn);
		return panel;
	}

	/**
	 * 创建中部面板
	 */
	public static JPanel CrateCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(0, 180));
		MyLineBorder myLineBorder = new MyLineBorder(new Color(192, 192, 192), 1, true);

		/**
		 * 用户名框
		 */
		JTextField username = new JTextField();
		username.setBounds(0, 15, 175, 30);
		username.setBorder(myLineBorder);

		/**
		 * 密码名框
		 */
		JPasswordField password = new JPasswordField(JPasswordField.LEFT);
		password.setBounds(0, 44, 175, 30);
		password.setBorder(myLineBorder);

		JCheckBox rember_pwd = new JCheckBox("记住密码");
		rember_pwd.setBounds(0, 80, 80, 20);

		JCheckBox login_auto = new JCheckBox("自动登录");
		login_auto.setBounds(100, 80, 80, 20);

		panel.add(rember_pwd);
		panel.add(username);
		panel.add(password);
		panel.add(login_auto);
		return panel;
	}

	/**
	 * 创建东部面板
	 */
	public static JPanel CrateEastPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(100, 0));

		JLabel regeist = new JLabel("注册账号");
		regeist.setForeground(new Color(100, 149, 238));
		regeist.setBounds(0, 13, 60, 30);
		regeist.setFont(new Font("宋体", 0, 12));

		JLabel regetpwd = new JLabel("找回密码");
		regetpwd.setForeground(new Color(100, 149, 238));
		regetpwd.setBounds(0, 43, 60, 30);
		regetpwd.setFont(new Font("宋体", 0, 12));

		panel.add(regetpwd);
		panel.add(regeist);
		return panel;
	}
}

//MyLineBorder类实现一个圆角矩形， 和一个浅色边框
class MyLineBorder extends LineBorder {

	public MyLineBorder(Color color, int thickness, boolean roundedCorners) {
		super(color, thickness, roundedCorners);
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Color oldColor = g.getColor();
		Graphics2D g2 = (Graphics2D) g;
		int i;
		g2.setRenderingHints(rh);
		g2.setColor(lineColor);
		for (i = 0; i < thickness; i++) {
			if (!roundedCorners)
				g2.drawRect(x + i, y + i, width - i - i - 1, height - i - i - 1);
			else
				g2.drawRoundRect(x + i, y + i, width - i - i - 1, height - i - i - 1, 5, 5);
		}
		g2.setColor(oldColor);
	}
}
