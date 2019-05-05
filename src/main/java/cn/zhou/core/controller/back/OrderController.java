package cn.zhou.core.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * order 订单controller
 */
@RequestMapping(value = "/admin/")
@Controller
public class OrderController {

	@RequestMapping(value = "frame/order_main.do")
	public String orderMain() {// frame/product_main.do

		return "frame/order_main";
	}

	@RequestMapping(value = "frame/order_left.do")
	public String orderLeft() {// frame/product_main.do

		return "frame/order_left";
	}

	@RequestMapping(value = "order/list.do")
	public String orderList() {// frame/product_main.do

		return "frame/order_left";
	}

	@RequestMapping(value = "order/view.do")
	public String orderView() {// frame/product_main.do

		return "frame/order_left";
	}

}
