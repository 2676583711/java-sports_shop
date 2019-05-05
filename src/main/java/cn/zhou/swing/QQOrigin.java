package cn.zhou.swing;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 模仿qq登录界面
 * 
 * @author zhou
 *
 */
public class QQOrigin extends JFrame {
	// main方法程序入口
	public static void main(String[] args) {
//		new QQ().add(new QQJPanel());

		new QQOrigin();
	}

	/*
	 * 构造方法
	 */
	public QQOrigin() {
		// 设置窗口标题
		setTitle("QQ登录");
		// 窗体组件初始化
//		init();

		setContentPane(new QQJPanel());

		// 设置关闭窗口的同时关闭整个程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置布局方式为绝对定位
		setLayout(null);

		setBounds(0, 0, 355, 265);
		// 设置窗体的标题图标
		Image image = new ImageIcon("e:/a.gif").getImage();
		setIconImage(image);

		// 窗体大小不能改变
		setResizable(false);

		// 居中显示
		setLocationRelativeTo(null);

		// 窗体可见
		setVisible(true);

	}

	/*
	 * 初始化方法
	 */
	public void init() {

		// 创建一个容器
		Container con = getContentPane();
//		JPanel jp = new JPanel();

		// 小容器
		JLabel jl1 = new JLabel();

		// 设置背景图片
		Image image1 = new ImageIcon("e:/background.jpg").getImage();
		jl1.setIcon(new ImageIcon(image1));
		jl1.setBounds(0, 0, 355, 265);

		// QQ登录头像设定
		JLabel jl2 = new JLabel();
		Image image2 = new ImageIcon("D:/qq.gif").getImage();
		jl2.setIcon(new ImageIcon(image2));
		jl2.setBounds(40, 95, 50, 60);

		// 用户号码登录输入框
		JTextField username = new JTextField();
		username.setBounds(100, 100, 150, 20);

		// 用户号码登录输入框旁边的文字
		JLabel jl3 = new JLabel("注册账号");
		jl3.setBounds(260, 100, 70, 20);

		// 密码输入框
		JPasswordField password = new JPasswordField();
		password.setBounds(100, 130, 150, 20);

		// 密码输入框旁边的文字
		JLabel jl4 = new JLabel("找回密码");
		jl4.setBounds(260, 130, 70, 20);

		// 是否记住密码
		JCheckBox jc1 = new JCheckBox("记住密码");
		jc1.setBounds(105, 155, 80, 15);
		// 登录选项
		JCheckBox jc2 = new JCheckBox("自动登录");
		jc2.setBounds(185, 155, 80, 15);

		// 用户登录状态选择
		// 列表框
		JComboBox jcb = new JComboBox();
		jcb.addItem("在线");
		jcb.addItem("隐身");
		jcb.addItem("离开");
		jcb.setBounds(40, 150, 55, 20);

		// 网容器里面加入用户登录状态选择
		jl1.add(jcb);

		// 按钮设定
		// 小按钮
		JButton bu1 = new JButton("登录");
		bu1.setBounds(280, 200, 65, 20);
		// 给按钮添加1个事件
		bu1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				if ("登录".equals(str)) {
					String getName = username.getText();
					JOptionPane.showConfirmDialog(null, "您输入的用户名:" + getName);
				}

			}
		});

		// 设置多账号
		JButton bu2 = new JButton("多账号");
		bu2.setBounds(5, 200, 75, 20);

		// qq的登录界面的设置
		JButton bu3 = new JButton("设置");
		bu3.setBounds(100, 200, 65, 20);

		// 所有组件用容器装载
		jl1.add(jl2);
		jl1.add(jl3);
		jl1.add(jl4);
		jl1.add(jc1);
		jl1.add(jc2);
		jl1.add(bu1);
		jl1.add(bu2);
		jl1.add(bu3);

		con.add(jl1);
		con.add(username);
		con.add(password);

	}
}

class QQJPanel2 extends JPanel {
	public QQJPanel2() {

		// 小容器
		JLabel jl1 = new JLabel();

		// 设置背景图片
		Image image1 = new ImageIcon("e:/background.jpg").getImage();
		jl1.setIcon(new ImageIcon(image1));
		jl1.setBounds(0, 0, 355, 265);

		// QQ登录头像设定
		JLabel jl2 = new JLabel();
		Image image2 = new ImageIcon("D:/qq.gif").getImage();
		jl2.setIcon(new ImageIcon(image2));
		jl2.setBounds(40, 95, 50, 60);

		// 用户号码登录输入框
		JTextField username = new JTextField();
		username.setBounds(100, 100, 150, 20);

		// 用户号码登录输入框旁边的文字
		JLabel jl3 = new JLabel("注册账号");
		jl3.setBounds(260, 100, 70, 20);

		// 密码输入框
		JPasswordField password = new JPasswordField();
		password.setBounds(100, 130, 150, 20);

		// 密码输入框旁边的文字
		JLabel jl4 = new JLabel("找回密码");
		jl4.setBounds(260, 130, 70, 20);

		// 是否记住密码
		JCheckBox jc1 = new JCheckBox("记住密码");
		jc1.setBounds(105, 155, 80, 15);
		// 登录选项
		JCheckBox jc2 = new JCheckBox("自动登录");
		jc2.setBounds(185, 155, 80, 15);

		// 用户登录状态选择
		// 列表框
		JComboBox jcb = new JComboBox();
		jcb.addItem("在线");
		jcb.addItem("隐身");
		jcb.addItem("离开");
		jcb.setBounds(40, 150, 55, 20);

		// 网容器里面加入用户登录状态选择
		jl1.add(jcb);

		// 按钮设定
		// 小按钮
		JButton bu1 = new JButton("登录");
		bu1.setBounds(280, 200, 65, 20);
		// 给按钮添加1个事件
		bu1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				if ("登录".equals(str)) {
					String getName = username.getText();
					JOptionPane.showConfirmDialog(null, "您输入的用户名:" + getName);
				}

			}
		});

		// 设置多账号
		JButton bu2 = new JButton("多账号");
		bu2.setBounds(5, 200, 75, 20);

		// qq的登录界面的设置
		JButton bu3 = new JButton("设置");
		bu3.setBounds(100, 200, 65, 20);

		// 所有组件用容器装载
		jl1.add(jl2);
		jl1.add(jl3);
		jl1.add(jl4);
		jl1.add(jc1);
		jl1.add(jc2);
		jl1.add(bu1);
		jl1.add(bu2);
		jl1.add(bu3);

		add(jl1);
		add(username);
		add(password);
	}

}