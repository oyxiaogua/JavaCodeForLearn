package mybatis_plus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BaseTest {
	public static ApplicationContext context = new FileSystemXmlApplicationContext(
			"src/main/resources/spring/spring-all.xml");

}
