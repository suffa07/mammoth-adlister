package com.codeup.adlister.dao;

/**
 * Created by DelMonroe on 6/9/17.
 */
public class Config {

    private String url;
    private String user;
    private String password;

    public Config() {
        this.url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC";
        this.user = "adlist_user";
        this.password= "codeup";
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}
