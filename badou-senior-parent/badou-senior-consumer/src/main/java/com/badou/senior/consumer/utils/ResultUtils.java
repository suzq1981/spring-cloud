package com.badou.senior.consumer.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {

	public static Map<String, Object> OK = new HashMap<String, Object>();
	public static Map<String, Object> NOT_OK = new HashMap<String, Object>();

	static {
		OK.put("success", true);
		NOT_OK.put("success", false);
	}

}
