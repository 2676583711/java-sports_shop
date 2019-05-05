package cn.zhou.core.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import cn.zhou.common.test.TestSpringJunit;
import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.bean.TestBean;
import cn.zhou.core.service.BrandService;
import cn.zhou.core.service.TestService;

@Transactional
public class TestTestService extends TestSpringJunit {

	@Resource
	private TestService testService;

	@Resource
	private static BrandService brandService;

	@Test
	public void testadd() {

		// 此方法有名称限制
		/*
		 * ClassPathXmlApplicationContext ac = new
		 * ClassPathXmlApplicationContext("classpath:application-context.xml");
		 * ac.getBean("TestService");
		 */

		testService.add((new TestBean(110, "abc", new Date())));

		// 抛出运行时异常，测试事务
		// throw new RuntimeException();
	}

	@Test
	public void testQuery() {

		System.out.println(testService.query(110));

	}

	

}