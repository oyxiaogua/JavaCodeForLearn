package mybatis_plus.dao;

import org.apache.ibatis.annotations.Insert;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import mybatis_plus.bean.TestUser;

public interface TestUserMapper extends BaseMapper<TestUser> {

	@Insert("insert into test_user(name,age,create_date) values(#{name},#{age},#{createDate})")
	int insertUserByAnnotation(TestUser user);
}