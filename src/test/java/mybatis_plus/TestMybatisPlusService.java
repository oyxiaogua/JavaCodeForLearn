package mybatis_plus;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis_plus.bean.TestUser;
import mybatis_plus.service.ITestUserService;

public class TestMybatisPlusService extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(TestMybatisPlusService.class);
	private ITestUserService testUserService;

	@Before
	public void init() {
		testUserService = (ITestUserService) context.getBean("testUserService");
	}
	
	@Test
	public void testSelectById(){
		TestUser testUser = testUserService.selectById(1);
		log.info("testUser={}",testUser);
	}

}
