package cn.zhou.core.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;

import cn.zhou.common.test.TestSpringJunit;
import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.service.BrandService;
import division_page.DividePage;
import division_page.PageBean;

public class TestDividePage extends TestSpringJunit {

	@Resource
	BrandService brandService;

	@Test
	public void test1() {

		// brandService.query(DividePage.getPageBean(1, BrandBean.class, 10));//
		// brandBean
		// BrandBean.class,
		BrandBean brandBean = new BrandBean();

		PageBean<BrandBean> pageBean = DividePage.getPageBean(1, brandService.query(brandBean), 10);
		System.out.println("DividePage.getPageBean(1, BrandBean.class, 10)==" + pageBean);
	}

	/*
	 * 测试自制的 分页包
	 */
	public static <T> void main(String[] args) {
		/*
		 * List<BrandBean> beandList = new ArrayList<BrandBean>();
		 * 
		 * beandList.add(new BrandBean(1, "110", 55));
		 * 
		 * System.out.println(DividePage.getPageBean(-2, beandList, 63).toString() +
		 * ":\n:;" + DividePage.getPageBean(-5, beandList, 63).getPageCode());
		 */

	}
}
