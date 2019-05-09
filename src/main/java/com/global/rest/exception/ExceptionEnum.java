package com.global.rest.exception;

public enum ExceptionEnum {


	DATA_NOT_FOUND("error.generic.invalidRequest");

	private final String value;

	ExceptionEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getCodeValue() {
		return value + ".code";
	}

	public String getMessageValue() {
		return value + ".message";
	}
}
