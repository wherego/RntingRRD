package com.better.rntingrrd.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table COOKIE.
 */
public class Cookie {

    private Long id;
    private String cookie;

    public Cookie() {
    }

    public Cookie(Long id) {
        this.id = id;
    }

    public Cookie(Long id, String cookie) {
        this.id = id;
        this.cookie = cookie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

}