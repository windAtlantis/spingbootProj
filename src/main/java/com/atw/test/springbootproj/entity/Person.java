package com.atw.test.springbootproj.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Karl
 * @Description
 * @date 2018/6/12 23:51
 */
@Component
/**
 * 批量绑定
 */
@ConfigurationProperties(prefix = "person")
public class Person {

	private String name;
	private int age;
	private String sex;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				'}';
	}
}
