package cn.zhou.core.controller.back;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.zhou.common.ImgServerUrl;
import cn.zhou.common.ResponseSend;
import cn.zhou.jersey.JerseyServer;

/*
 * 图片上传Controller
 *
 *1. jsp/html 上传设置,input输入框中multipart属性设置
 *2. 异步上传ｊｓ配置ajax,jq封装库
 *3.配置spring的图片上传解析器commonmultipart
 *
 *4.并且返回图片路径
 */

@Controller
public class UploadController {

	// @RequestParam(value = "img", required = false) MultipartFile img
	@RequestMapping(value = "/upload/uploadImg.do")
	public void uploadImg(@RequestParam(required = false) MultipartFile img, HttpServletResponse response) {

		// 获取上传的图片扩展名(即后缀)
		String extensionName = FilenameUtils.getExtension(img.getOriginalFilename());

		// 使用时间，为图片生成名称，以防图片名称重复(即前缀)
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		// 使用毫秒级别，生成图片名称
		String format = df.format(new Date());

		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			format += r.nextInt(100);
			// System.out.println("format=" + "." + format);
		}

		// 图片路径
		String path = "/upload/pictures/" + format + "." + extensionName;

		System.out.println("imgurl-path=" + path);

		// "http://localhost:8088/img_service"
		String url = ImgServerUrl.URL + path;

		new JerseyServer().uploadImg(url, img);

		// 可以返回字符串，但是最好返回 json格式的数据
		// response.getWriter().write(url);
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);

//		try {
//			response.getWriter().write(jo.toString());
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/*
		 * 为了复用性，封装工具类，使用工具类
		 */

		ResponseSend.sendJson(response, jo.toString());
	}

}
