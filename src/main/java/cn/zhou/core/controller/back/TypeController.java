package cn.zhou.core.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 商品类型 controller
 */

@Controller
@RequestMapping(value = "/admin/")
public class TypeController {

	@RequestMapping(value = "type/list.do")
	public String brandAdd() {// frame/product_main.do

		return "type/list";
	}
}
