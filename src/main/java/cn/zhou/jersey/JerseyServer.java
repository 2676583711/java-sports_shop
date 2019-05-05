package cn.zhou.jersey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class JerseyServer {
	/*
	 * 使用jersey客户端向服务器发送图片
	 * 
	 * 如果返回 ４０３forbiden 错误，表示tomcat配置没有成功 因为tomcat 默认是不允许读写的
	 * 409表示路径错误，即路径写错，或者干脆就是不存在该路径
	 */

	public static void main(String[] obj) {

		// 创建jersey客户端
		Client client = new Client();
		String url = "http://localhost:8088/img_service/upload/pictures/test2.jpg";
		// 服务器地址
		// String url = "/home/zhou/girl2.jpg";
		// 根据服务器地址连接服务器
		WebResource webResource = client.resource(url);

		// 硬盘图片的地址
		String path = "/home/zhou/图片/picture/girl2.jpg";
		// com.sun.jersey.api.client.ClientHandlerException:
		// java.lang.IllegalArgumentException: URI is not absolute
		try {
			// 把硬盘中的图片读取到内存中
			InputStream inputStream = new FileInputStream(new File(path));

			// 使用服务器连接把内存中图片进行发送
			webResource.put(inputStream);

			System.out.println("webResource.put()....is ok!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void uploadImg(String url, MultipartFile img) {

		// 创建jersey客户端
		Client client = new Client();
		// String url = "http://localhost:8088/img_service/upload/pictures/test2.jpg";
		// 服务器地址
		// String url = "/home/zhou/girl2.jpg";
		// 根据服务器地址连接服务器
		WebResource webResource = client.resource(url);

		// 硬盘图片的地址
		// String path = "/home/zhou/图片/picture/girl2.jpg";
		// com.sun.jersey.api.client.ClientHandlerException:
		// java.lang.IllegalArgumentException: URI is not absolute
		try {
			// 把硬盘中的图片读取到内存中
//			InputStream inputStream = new FileInputStream(new File(path));

			// 使用服务器连接把内存中图片进行发送
			webResource.put(img.getBytes());

			System.out.println("webResource.put()....is ok!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadImg(String url, String path, MultipartFile img) {

		// 创建jersey客户端
		Client client = new Client();
		// String url = "http://localhost:8088/img_service/upload/pictures/test2.jpg";
		// 服务器地址
		// String url = "/home/zhou/girl2.jpg";
		// 根据服务器地址连接服务器
		WebResource webResource = client.resource(url);

		// 硬盘图片的地址
		// String path = "/home/zhou/图片/picture/girl2.jpg";
		// com.sun.jersey.api.client.ClientHandlerException:
		// java.lang.IllegalArgumentException: URI is not absolute
		try {
			// 把硬盘中的图片读取到内存中
//			InputStream inputStream = new FileInputStream(new File(path));

			// 使用服务器连接把内存中图片进行发送
			webResource.put(img.getBytes());

			System.out.println("webResource.put()....is ok!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
