package cn.zhou.core.controller.back;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhou.common.ImgServerUrl;
import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.service.BrandService;
import division_page.Pagination;

/*
 * 品牌
 */
@Controller
@RequestMapping(value = "/admin")
public class BrandController {

	@Resource
	BrandService brandService;

	/*
	 * @RequestParam(value = "img", required = false)
	 * value是html/jsp中的上传表单的name,required表示是否必须上传图片
	 */

	@RequestMapping(value = "/brand/add.do")
	public String brandAdd(String name, String description, Integer sort, Integer isDisplay, String imageUrl,
			ModelMap mm) { // frame/product_main.do

		// 判断添加内容不为空，若为空不进行添加操作

		if (StringUtils.isBlank(name) || name.isEmpty() || name == null && sort == null & isDisplay == null) {
			return "/brand/add";
		}

		BrandBean brandBean = new BrandBean();
		brandBean.setName(name);
		brandBean.setDescription(description);
		brandBean.setSort(sort);
		brandBean.setIsDisplay(isDisplay);
		brandBean.setImageUrl(imageUrl);
		brandService.add(brandBean);

		// 数据回显
		mm.addAttribute("brandBean", brandBean);

		return "/brand/add";
	}

	/*
	 * 跳转修改页面
	 */
	@RequestMapping(value = "/brand/edit.do")
	public String brandEdit(Integer id, Model map) {// frame/product_main.do
		map.addAttribute("brandBean", brandService.queryById(id));
		return "/brand/edit";
	}

	// Integer id, String name, String description, String image_url, String
	// web_site, Integer sort,
	// Integer is_display
	// 修改品牌信息
	@RequestMapping(value = "/brand/update.do")
	public String update(Integer id, String name, String imageUrl, String description, Integer sort, Integer isDisplay,
			ModelMap mm) {

		// 封装需要修改的数据
		BrandBean brandBean = new BrandBean();
		brandBean.setId(id);
		brandBean.setName(name);
		brandBean.setImageUrl(imageUrl);
		brandBean.setDescription(description);
		brandBean.setSort(sort);
		brandBean.setIsDisplay(isDisplay);

		// 向业务层提交修改操作
		brandService.updateById(brandBean);
		mm.addAttribute("isDisplay", isDisplay);

		// 修改完成，重定向到展示页面
		return "redirect:/admin/brand/divide.do";
	}

	/*
	 * 查询品牌数据
	 */
	@RequestMapping(value = "/brand/list.do")
	public String brandList(Integer id, String name, Integer isDisplay, Integer pageNo, Model model) {// brand/list.jsp

		if (name != null & isDisplay != null) {
			model.addAttribute("name", name);
			model.addAttribute("isDisplay", isDisplay);
		}
		// 返回服务器地址
		model.addAttribute("serverUrl", ImgServerUrl.URL);

		// 查询品牌数据并返回数据, pageNo, brandService.queryTotal()
		BrandBean brandBean = new BrandBean();
		brandBean.setId(id);
		brandBean.setName(name);
		brandBean.setIsDisplay(isDisplay);

		// 查询品牌数据并返回数据
		model.addAttribute("brandBean", brandService.query(brandBean));

		return "/brand/list";
	}

	/*
	 * 
	 * // divide 查询品牌数据
	 * 
	 * 分页查询
	 * 
	 * 
	 */
	@RequestMapping(value = "/brand/divide.do")
	public String divide(String name, Integer isDisplay, Integer pageCode, ModelMap model) {// brand/list.jsp
		// 设置品牌查询条件
		BrandBean brandBean = new BrandBean();

		// 返回分页查询所需要的url
		StringBuilder parameter = new StringBuilder().append("/admin/brand/divide.do?");

		if (StringUtils.isNotBlank(name)) {
			model.addAttribute("name", name);
			parameter.append("name=").append(name).append("&");
			brandBean.setName(name);
		}
		if (isDisplay != null) {
			model.addAttribute("isDisplay", isDisplay);
			parameter.append("isDisplay=").append(isDisplay);
			brandBean.setIsDisplay(isDisplay);
		} else {
			parameter.append("isDisplay=").append(1);
			// brandBean.setIsDisplay(1);
		}

		// 设置页码给品牌
		brandBean.setPageCode(Pagination.judgePageCode(pageCode));
		// 设置页面尺寸
		brandBean.setPageSize(10);
		// 设置每页第一条数据索引
		brandBean.setStartIndex(Pagination.getStartIndex(pageCode, 10));

		// 返回分页路径
		String url = "/admin/brand/divide.do";
		Pagination.setUrl(url, parameter.toString());
		// 返回分页显示所需的条件,properties
		model.addAttribute("pageBean", Pagination.getPageBean(pageCode, brandService.queryTotal(brandBean), 10,
				brandService.query(brandBean)));

// 	model.addAttribute("pageBean", Pagination.getPageBean(pageCode, brandService.queryTotal(brandBean), parameter,
// 			brandService.query(brandBean)));

		return "/brand/list";
	}

	/*
	 * 删除品牌
	 */

	@RequestMapping(value = "/brand/delete.do")
	public String delete(Integer id) {

		// 根据id删除品牌
		brandService.deleteById(id);
		return "redirect:/admin/brand/divide.do";
	}

	/*
	 * 多个删除
	 */
	@RequestMapping(value = "/brand/deletes.do")
	public String deletes(Integer[] ids, String name, Integer isDisplay) {

		// 根据多个id(即id数组)进行多个删除操作
		brandService.deleteByIds(ids);

		return "redirect:/admin/brand/divide.do";
	}



	public static void main(String[] args) {
		System.out.println("hello,deepin");
	}
}
