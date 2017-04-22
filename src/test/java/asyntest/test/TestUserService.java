package asyntest.test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.awaitility.core.ConditionEvaluationLogger;
import org.junit.Test;

import asyntest.service.UserService;

public class TestUserService {
	@Test
	public void testAddUserAsyncNormal() throws Exception {
		UserService userService = new UserService();
		userService.addUser("test");
		Assertions.assertThat(userService.getUsers()).contains("test");
	}

	@Test
	public void testAddUserAsyncAwaitilityUntil() throws Exception {
		UserService userService = new UserService();
		userService.addUser("test");
		Awaitility.await().atMost(600, TimeUnit.MILLISECONDS).until(new Callable<Boolean>() {
			public Boolean call() throws Exception {
				return userService.getUsers().contains("test");
			}
		});
	}

	@Test
	public void testAddUserAsyncAwaitilityUntilListener() throws Exception {
		UserService userService = new UserService();
		userService.addUser("test");
		Awaitility.await().atMost(600, TimeUnit.MILLISECONDS)
				.conditionEvaluationListener(new ConditionEvaluationLogger()).until(new Callable<Boolean>() {
					public Boolean call() throws Exception {
						return userService.getUsers().contains("test");
					}
				});
	}

	@Test
	public void testAddUserAsyncAwaitilityUntilPollDelay() throws Exception {
		UserService userService = new UserService();
		userService.addUser("test");
		 //轮询 pollInterval每隔多少时间段轮询, pollDelay每次轮询间隔时间
		//checked after 50ms then 50ms+100ms
		Awaitility.with().pollInterval(Duration.ONE_HUNDRED_MILLISECONDS).and().with()
				.pollDelay(50, TimeUnit.MILLISECONDS).await("add test success").until(new Callable<Boolean>() {
					public Boolean call() throws Exception {
						return userService.getUsers().contains("test");
					}
				});
	}
}
