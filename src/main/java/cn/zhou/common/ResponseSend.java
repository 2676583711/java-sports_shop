package cn.zhou.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ResponseSend {

	// 发送数据
	public static void send(HttpServletResponse response, String text, String contentType) {
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 发送json格式数据
	 */
	public static void sendJson(HttpServletResponse response, String text) {
		String contentType = "application/json;charset=utf-8";
		send(response, text, contentType);
	}

	/*
	 * 发送xml格式数据
	 */
	public static void sendXml(HttpServletResponse response, String text) {
		String contentType = "text/xml;charset=utf-8";
		send(response, text, contentType);
	}

	/*
	 * 发送text文本格式数据
	 */
	public static void sendText(HttpServletResponse response, String text) {
		String contentType = "text/plain;charset=utf-8";
		send(response, text, contentType);
	}
}
