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

@RunWith(SpringJUnit4ClassRunner.class)
// bean容器配置
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class AppTest {

	@Autowired
	private CityMapper cityMapper;

	@Test
	public void testAbc1() {
		Assert.notNull(cityMapper);
	}

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

}