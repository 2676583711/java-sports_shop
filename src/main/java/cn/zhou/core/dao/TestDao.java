package cn.zhou.core.dao;

import cn.zhou.core.bean.TestBean;

import java.util.List;

public interface TestDao {


    public void add(TestBean testBean);

    public List<TestBean> query(Integer id);
}
