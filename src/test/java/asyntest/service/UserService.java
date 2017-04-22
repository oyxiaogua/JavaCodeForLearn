package asyntest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class UserService {
	public final List<String> users = new ArrayList<>();

	public void addUser(String username) {
		new Thread(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(100, 500));
			} catch (InterruptedException e) {
			}
			users.add(username);
		}).start();
	}

	public void addUserAndSay(String username) {
		new Thread(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(100, 500));
			} catch (InterruptedException e) {
			}
			users.add(username);
			say(username);
		}).start();
	}

	public String say(String username) {
		return "Hello " + username;
	}

	public List<String> getUsers() {
		return users;
	}

}