package com.springboot.frame.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigPropertiesUtil {
	private Properties prop;

	private static final ConfigPropertiesUtil util = new ConfigPropertiesUtil();

	public static ConfigPropertiesUtil getInstance() {
		return util;
	}

	private ConfigPropertiesUtil() {
		init();
	}

	private void init() {
		InputStream in = ConfigPropertiesUtil.class.getClassLoader().getResourceAsStream(
				"i18n/config.properties");

		prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getString(String key, String defaultValue) {
		return getInstance().prop.getProperty(key, defaultValue);
	}

	public static String getString(String key) {
		return getInstance().prop.getProperty(key);
	}
	
	public static Integer getInt(String key) {
		String value = getString(key);
		return Integer.parseInt(value);
	}
	
	public static Integer getInt(String key, int defaultValue) {
		String value = getString(key);
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}
}
