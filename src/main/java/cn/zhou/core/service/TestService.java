package cn.zhou.core.service;

import cn.zhou.core.bean.TestBean;

import java.util.List;

public interface TestService {

    public void add(TestBean testBean);

    public List<TestBean> query(Integer id);


}
