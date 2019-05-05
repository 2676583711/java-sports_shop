package cn.zhou.common.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    @ContextConfiguration(locations = "classpath:application-context.xml")
    @RunWith(SpringJUnit4ClassRunner.class)
    这两个配合使用，可以解决Service注入名称差异性
    
    /sport_shop/src/main/resources/application-context.xml
     * classpath:application-context.xml"
 */
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringJunit {

}
