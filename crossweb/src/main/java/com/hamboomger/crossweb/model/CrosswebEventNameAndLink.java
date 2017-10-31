package com.hamboomger.crossweb.model;

/**
 * @author ddorochov
 */
public class CrosswebEventNameAndLink {
	private String name;
	private String url;

	public CrosswebEventNameAndLink(String name, String url) {
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
