package wang.angi.sample.mybatis.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import wang.angi.sample.mybatis.spring.mapperhelper.mapper.CityMapper;
import wang.angi.sample.mybatis.spring.mapperhelper.model.City;
import wang.angi.sample.mybatis.spring.mapperhelper.service.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")
public class AppTest {

	@Autowired
	private CityMapper cityMapper;

	@Autowired
	private CityService cityService;

	@Test
	public void testAbc1() {
		Assert.notNull(cityMapper);
	}

	@Test
	public void testAll() {
		City city = new City();
		city.setName("WuHan");
		city.setState("HuBei");
		city.setCountry("China");
		city.setCreatedBy("Angi");
		cityMapper.insert(city);

		City city2 = new City();
		city2.setId(6);
		city2.setName("ShangHai");
		cityMapper.updateByPrimaryKey(city2);

		City city1 = new City();
		city1.setName("EZhou");
		city1.setCreatedBy("水晶");
		cityMapper.insertSelective(city1);

		City city3 = new City();
		city3.setId(8);
		city3.setName("ShangHai");
		cityMapper.updateByPrimaryKeySelective(city3);

		Example cityExample = new Example(City.class);
		cityExample.or().andLike("name", "Wu%");
		cityExample.or().andEqualTo("createdBy", "水晶");
		cityMapper.selectByExample(cityExample);

		System.out.println(cityMapper.selectByPrimaryKey(1));
		PageHelper.startPage(2, 3);
		System.out.println(cityMapper.selectByExample(new Example(City.class)).size());

	}

	@Test
	public void testCityService() {
		Assert.notNull(cityService);
		System.out.println(cityService.selectByCity(new City(), 2, 3).size());
	}

}