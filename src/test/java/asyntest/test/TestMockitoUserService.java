package asyntest.test;

import java.util.concurrent.atomic.AtomicBoolean;

import org.assertj.core.api.Assertions;
import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import asyntest.service.UserDao;
import asyntest.service.UserServiceWithDao;

@RunWith(MockitoJUnitRunner.class)
public class TestMockitoUserService {
	@Test
	public void testAwaitilityUntilWithMockito() {
		UserDao userDao = (UserDao) Mockito.mock(UserDao.class);
		UserServiceWithDao userService = new UserServiceWithDao(userDao);
		ArgumentCaptor<String> usernameCaptor = ArgumentCaptor.forClass(String.class);
		AtomicBoolean addMethodCalled = new AtomicBoolean(false);
		Mockito.doAnswer(invocationOnMock -> addMethodCalled.getAndSet(true)).when(userDao)
				.add(usernameCaptor.capture());
		userService.addUser("test");
		Awaitility.await().untilTrue(addMethodCalled);
		Assertions.assertThat(usernameCaptor.getValue()).isEqualTo("test");
	}
}
