package cn.zhou.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.dao.BrandDao;
import division_page.PageBean;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Resource
	BrandDao brandDao;

	/**
	 * 添加品牌
	 */
	@Override
	public void add(BrandBean brandBean) {
		brandDao.add(brandBean);
	}

	/**
	 * 查询品牌信息
	 */
	@Override
	public List<BrandBean> query(BrandBean brandBean) {
		return brandDao.query(brandBean);
	}

	/**
	 * 根据id查询品牌数据
	 */
	@Override
	public BrandBean queryById(Integer id) {
		return brandDao.queryById(id);
	}

	/**
	 * 根据品牌名称查询品牌数据
	 */
	@Override
	public List<BrandBean> queryByName(String name) {

		return brandDao.queryByName(name);
	}

	/**
	 * 查询品牌数据总记录数
	 */
	@Override
	public Integer queryTotal(BrandBean brandBean) {
		return brandDao.queryTotal(brandBean);
	}

	/**
	 * 根据品牌id删除数据
	 */
	@Override
	public void deleteById(Integer id) {
		brandDao.deleteById(id);
	}

	/**
	 * 批量删除品牌数据，根据多个id
	 */
	@Override
	public void deleteByIds(Integer[] ids) {
		brandDao.deleteByIds(ids);
	}

	/***
	 * 根据品牌id修改数据
	 */
	@Override
	public void updateById(BrandBean brandBean) {
		brandDao.updateById(brandBean);
	}

}
