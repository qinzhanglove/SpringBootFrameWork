package com.springboot.frame.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;

public final class CommonPropertiesUtil {
	private Properties prop;

	private static final CommonPropertiesUtil util = new CommonPropertiesUtil();

	public static CommonPropertiesUtil getInstance() {
		return util;
	}

	private CommonPropertiesUtil() {
		init();
	}

	private void init() {
		prop = new Properties();
		try {
			prop.load(new
					 InputStreamReader(CommonPropertiesUtil.class.getClassLoader().
							 getResourceAsStream("i18n/common_properties_zh.properties"),"UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public static String getString(String key, String defaultValue) {
	// return getInstance().prop.getProperty(key, defaultValue);
	// }

	public static String getString(String key) {
		return getInstance().prop.getProperty(key);
	}

	public static Integer getInt(String key, int defaultValue) {
		String value = getString(key);
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static Integer getInt(String key) {
		String value = getString(key);
		return Integer.parseInt(value);
	}

	public static String getString(String key, Object... params) {
		String s = getString(key);
		return MessageFormat.format(s, params);
	}

	public static String getAcceptedMessage(Object... params) {
		return getString("doctor.accepted.consult.message", params);
	}
}
