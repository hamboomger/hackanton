package com.hackanton.crossweb.parsing;

/**
 * @author ddorochov
 */
public class CrosswebEventNameAndLink {
	private String name;
	private String url;

	CrosswebEventNameAndLink(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

}
