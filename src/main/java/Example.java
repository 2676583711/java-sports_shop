import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 使用java－GUI实现一个简单的登录界面
 * 
 * @author zhou
 *
 */
public class Example extends JFrame {

	public Example() {
		// 调用父类的无参构造器
		super();
		// 设置窗口可见
		setVisible(true);
		// 设置窗口大小
		setSize(500, 400);
		// 设置窗口初始位置
		setLocation(400, 100);
		// 设置关闭窗口的同时关闭程序
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 设置背景色
		setBackground(Color.orange);
		// 设置窗口名称
		setTitle("java-gui-login");
	}

	// main
	public static void main(String[] args) {
		// 实例化实验程序对象，并且添加panel容器,同时启动程序
		// new Example().add(new Panel());

	}
}

//***********************************************

// *************************************************************

/**
 * Panel容器
 * 
 * @author zhou
 *
 */
class Panel extends JPanel {

	public Panel() {
		super();
		// 设置背景色
		setBackground(Color.orange);
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.black);
		textArea.setSize(10, 30);
		add(textArea);

	}

}
