package cn.zhou.core.controller;

import cn.zhou.core.bean.TestBean;
import cn.zhou.core.service.TestService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*
 * 测试controller
 * 以及添加时间转换器
 *
 */

@Controller // 转换日期格式
public class CenterController { // implements WebBindingInitializer

    @Resource
    TestService ts;

    @Transactional
    @RequestMapping("/test.do")
    public String t1(String name, Date birthday) throws UnsupportedEncodingException {

        System.out.println(name + ":" + birthday);

        ts.add(new TestBean(null, name, birthday));

        return "index";
    }

    /*
     * 局部配置,时间转换 全局配置在 springmvc的配置文件中进行配置
     */
//    @InitBinder
//    public void transform(WebDataBinder webDataBinder, WebRequest webRequest) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // HH:mm:ss
//        webDataBinder.registerCustomEditor(Date.class,
//                new CustomDateEditor(dateFormat, true));
//    }

}
