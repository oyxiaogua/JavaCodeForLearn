package mybatis_plus.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import mybatis_plus.bean.TestUser;
import mybatis_plus.dao.TestUserMapper;
import mybatis_plus.service.ITestUserService;

public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService{

}
