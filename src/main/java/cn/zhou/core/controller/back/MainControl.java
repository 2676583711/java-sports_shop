package cn.zhou.core.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 访问后台页面的控制器
 *
 * 后台主页面
 */
@Controller
@RequestMapping(value = "/admin/")
public class MainControl {

    // 跳转后台首页
    @RequestMapping(value = "index.do")
    public String index() {

        return "index";
    }

    // 跳转后台首页的头页面
    @RequestMapping(value = "top.do")
    public String top() {

        return "top";
    }

    // 跳转后台首页的身体页面
    // http://localhost:8080/back_page/index.jsp
    @RequestMapping(value = "main.do")
    public String main() {

        return "main";
    }

    // 跳转后台首页的身体页面的左页面
    @RequestMapping(value = "left.do")
    public String left() {

        return "left";
    }

    // 跳转后台首页的身体页面的右页面
    @RequestMapping(value = "right.do")
    public String right() {

        return "right";
    }
}
