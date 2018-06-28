package com.atw.test.springbootproj.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Karl
 * @Description
 * @date 2018/6/28 22:29
 */
@Component
/**
 * 读取指定配置文件 即xxx.properties
 */
@PropertySource(value = {"classpath:other.properties"})
@ConfigurationProperties(prefix = "other")
public class Other {
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Other{" +
				"name='" + name + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}
