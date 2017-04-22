package asyntest.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class UserServiceWithDao {
	private UserDao userDao;

	public UserServiceWithDao(UserDao userDao) {
        this.userDao = userDao;
    }

	public void addUser(String username) {
		new Thread(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(100, 500));
			} catch (InterruptedException e) {
			}

			userDao.add(username);
		}).start();
	}
}
