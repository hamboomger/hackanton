package com.hamboomger.model.common.exception;

/**
 * @author ddorochov
 */
public class EntityBuildingException extends RuntimeException {
	public EntityBuildingException(String message) {
		super(message);
	}

	public EntityBuildingException(String message, Throwable cause) {
		super(message, cause);
	}
}
