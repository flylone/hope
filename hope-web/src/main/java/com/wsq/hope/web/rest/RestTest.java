package com.wsq.hope.web.rest;

public class RestTest {
    public static void main(String[] args) {
        RestBuilder builder = new RestBuilder();
        String resp = builder.build().executeForString("https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/static/protocol/https/plugins/every_cookie_4644b13.js");
        System.out.println(resp);
    }
}
