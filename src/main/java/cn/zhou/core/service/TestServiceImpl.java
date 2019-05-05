package cn.zhou.core.service;

import cn.zhou.core.bean.TestBean;
import cn.zhou.core.dao.TestDao;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;

import javax.annotation.Resource;
import java.awt.dnd.Autoscroll;
import java.util.List;


@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;


    @Override
    public void add(TestBean testBean) {
        testDao.add(testBean);
    }

    @Override
    public List<TestBean> query(Integer id) {
        return testDao.query(id);
    }
}
