package mybatis_plus;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import baseTest.BaseTest;
import mybatis_plus.bean.TestUser;
import mybatis_plus.dao.TestUserMapper;

public class TestMybatisPlusMapper extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(TestMybatisPlusMapper.class);
	private TestUserMapper userMapper;

	@Before
	public void init() {
		userMapper = (TestUserMapper) context.getBean("testUserMapper");
	}

	@Test
	public void testInsertTestUser() {
		TestUser user = new TestUser();
		user.setName("test");
		user.setAge(22);
		user.setCreateDate(new Date());
		int result = userMapper.insert(user);
		log.info("result={}", result);
	}

	@Test
	public void testInsertUserByAnnotation() {
		TestUser user = new TestUser();
		user.setName("test");
		user.setAge(22);
		user.setCreateDate(new Date());
		int result = userMapper.insertUserByAnnotation(user);
		log.info("result={}", result);
	}

	@Test
	public void testSelectPage() {
		List<TestUser> userList = userMapper.selectPage(new Page<TestUser>(1, 10),
				new EntityWrapper<TestUser>().eq("name", "test").ge("age", 10).orderBy("id", false).orderBy("name"));
		log.info("userList={}", userList);
	}

	@Test
	public void testSelectPage_2() {
		EntityWrapper<TestUser> ew = new EntityWrapper<TestUser>();
		ew.where("name={0}", "test").orNew("age>{0} and age<={1}", 10,30).isNotNull("create_date").orderBy("name,age");
		List<TestUser> userList = userMapper.selectPage(new Page<TestUser>(1, 10), ew);
		log.info("userList={}", userList);
	}

	@Test
	public void testSelectMap() {
		List<Map<String, Object>> maplist = userMapper.selectMapsPage(new Page<TestUser>(1, 10),
				new EntityWrapper<TestUser>().eq("name", "test"));
		log.info("maplist={}", maplist);
	}

	@Test
	public void testDeleteByMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 10);
		map.put("name", "'test'");
		userMapper.deleteByMap(map);
	}
	
	@Test
    public void testSelectCount(){
        int total=userMapper.selectCount(null);
        log.info("total={}", total);
    }

}
