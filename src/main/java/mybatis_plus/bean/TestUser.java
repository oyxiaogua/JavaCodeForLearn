package mybatis_plus.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("test_user")
public class TestUser {
	private long id;
	private String name;
	private int age;
	@TableField(value = "create_date")
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String toString() {
		return "TestUser [id=" + id + ", name=" + name + ", age=" + age + ", createDate=" + createDate + "]";
	}
}
