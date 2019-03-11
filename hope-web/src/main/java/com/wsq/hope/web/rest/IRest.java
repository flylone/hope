package com.wsq.hope.web.rest;

import java.util.List;

public interface IRest {
    <T> List<T> executeForList(String url, Class<T> clzz);

    <T> T executeForObject(String url, Class<T> clzz);

    String executeForString(String url);
}
