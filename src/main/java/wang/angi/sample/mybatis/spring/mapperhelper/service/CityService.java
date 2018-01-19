package wang.angi.sample.mybatis.spring.mapperhelper.service;

import java.util.List;

import wang.angi.sample.mybatis.spring.mapperhelper.model.City;

/**
 * CityService接口
 */
public interface CityService extends IService<City> {

	/**
	 * 根据条件分页查询
	 *
	 * @param country
	 * @param page
	 * @param rows
	 * @return
	 */
	List<City> selectByCity(City city, int page, int rows);

}
