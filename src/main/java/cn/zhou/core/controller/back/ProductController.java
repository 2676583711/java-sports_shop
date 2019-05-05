package cn.zhou.core.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 产品 controller
 * 
 */
@Controller
@RequestMapping(value = "/admin")
public class ProductController {

	@RequestMapping(value = "/frame/product_main.do") /// frame/product_main.do
	public String productMain() { // frame/product_main.do
		return "frame/product_main";
	}

	@RequestMapping(value = "/frame/product_left.do")
	public String productLeft() {// frame/product_main.do

		return "frame/product_left";
	}

	/*
	 * product directory
	 */
	@RequestMapping(value = "/product/list.do")
	public String productList() {// frame/product_main.do

		return "/product/list";
	}

	@RequestMapping(value = "/product/add.do")
	public String productAdd() {// frame/product_main.do

		return "/product/add";
	}

}
