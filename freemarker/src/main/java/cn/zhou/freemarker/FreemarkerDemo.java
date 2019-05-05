package cn.zhou.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 学习 freemarker 页面静态化技术
 */
public class FreemarkerDemo {

	public static void main(String[] args) throws IOException, TemplateException {
		/*
		 * freemarker 新版本实例化时，需要加入版本参数了
		 */
		Configuration c = new Configuration(Configuration.VERSION_2_3_28);

		// 设置模板目录
		c.setDirectoryForTemplateLoading(new File("read/"));
		Locale locale;

		// 设置编码
		c.setDefaultEncoding(StandardCharsets.UTF_8.name());

		FileWriter fw = new FileWriter(new File("output/o.html"));

		// 创建数据模型
		HashMap hm = new HashMap();
		// 添加字符串
		hm.put("f", "hello,freemarker");

		// 添加html换行
		hm.put("hh", "<hr/>");

		// 添加list集合
		ArrayList list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		hm.put("list", list);

		// 添加map集合
		HashMap test = new HashMap();
		test.put("a", "a.value");
		test.put("b", "b.value");
		test.put("c", "c.value");

		hm.put("test", test);

		// 加载模板文件
		Template t = c.getTemplate("test.html");
		t.process(hm, fw);

		System.out.println("freemarker is ok");
		fw.flush();
		fw.close();
	}
}
