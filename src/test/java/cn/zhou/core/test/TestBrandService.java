package cn.zhou.core.test;

import javax.annotation.Resource;

import org.junit.Test;

import cn.zhou.common.test.TestSpringJunit;
import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.service.BrandService;

public class TestBrandService extends TestSpringJunit {

	@Resource
	BrandService brandService;

	private int a;

	public TestBrandService() {
		super();
		this.a = 100;
		System.out.println("******************a***********=" + this.a * 20);
	}

	@Test
	public void test1() {
		BrandBean brandBean = new BrandBean();

		brandBean.setIsDisplay(23);
		brandBean.setName("ak894");
		brandBean.setIsDisplay(0);
		brandBean.setSort(22);
		brandService.add(brandBean);

		for (int i = 1; i < 22; i++) {

		}
	}

	/*
	 * /sport_shop/src/main/resources/application-context.xml 测试brandService 的查询方法
	 */
	@Test
	public void test2() {
		BrandBean brandBean = new BrandBean();
		// brandBean.setId(1);
//		System.out.println("65565644556brand****************///*/*//**/:" + brandService.query(brandBean));	

		System.out.println("65565644556brand****************///*/*//**/:" + brandService.queryById(null));

	}

	@Test
	public void test3() {
		BrandBean brandBean = new BrandBean();
		System.out.println(brandService.queryTotal(brandBean));
	}
}
