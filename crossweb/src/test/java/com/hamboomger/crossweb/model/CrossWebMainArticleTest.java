package com.hamboomger.crossweb.model;

/**
 * Created by Medai on 04.12.2017.
 */
public class CrossWebMainArticleTest {
    private String url;
    private String name;
    public CrossWebMainArticleTest(String url, String name){
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CrossWebMainArticleTest{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
