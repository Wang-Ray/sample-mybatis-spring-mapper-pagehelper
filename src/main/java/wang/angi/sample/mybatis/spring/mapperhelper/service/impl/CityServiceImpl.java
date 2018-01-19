package wang.angi.sample.mybatis.spring.mapperhelper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import wang.angi.sample.mybatis.spring.mapperhelper.model.City;
import wang.angi.sample.mybatis.spring.mapperhelper.service.CityService;

/**
 * CityService实现
 */
@Service("cityService")
public class CityServiceImpl extends BaseService<City> implements CityService {

	@Override
	public List<City> selectByCity(City city, int page, int rows) {
		Example example = new Example(City.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(city.getName())) {
			criteria.andLike("name", "%" + city.getName() + "%");
		}
		if (StringUtil.isNotEmpty(city.getState())) {
			criteria.andLike("state", "%" + city.getState() + "%");
		}
		if (city.getId() != null) {
			criteria.andEqualTo("id", city.getId());
		}
		// 分页查询
		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

}
