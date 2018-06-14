package com.projects.sharath.viewpagerwithft;

/**
 * Created by Sharath on 14-Jun-18.
 */

public class ViewPagerModel {

    private String quotes, quote_types, names, roles;
    private int profile;

    //empty constructor
    public ViewPagerModel() {
    }

    public ViewPagerModel(String quotes, String quote_types, String names, String roles, int profile) {
        this.quotes = quotes;
        this.quote_types = quote_types;
        this.names = names;
        this.roles = roles;
        this.profile = profile;
    }

    //getter and setters

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getQuote_types() {
        return quote_types;
    }

    public void setQuote_types(String quote_types) {
        this.quote_types = quote_types;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
