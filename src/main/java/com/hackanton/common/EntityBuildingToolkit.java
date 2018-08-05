package com.hackanton.common;

import com.hackanton.common.exception.EntityBuildingException;

import java.util.List;

/**
 * @author ddorochov
 */
public class EntityBuildingToolkit {
	public static void checkNull(Object object, String name) {
		if(object == null)
			throw new EntityBuildingException(name + " parameter cannot be null");
	}

	public static void checkNullOrEmpty(String str, String name) {
		checkNull(str, name);
		if(str.isEmpty())
			throw new EntityBuildingException(str + " parameter cannot be empty");
	}

	public static void checkNullOrEmpty(List<?> list, String name) {
		checkNull(list, name);
		if(list.isEmpty())
			throw new EntityBuildingException(list + " parameter cannot be empty");
	}
}
