package com.wsq.hope.web.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Setter;
import org.apache.commons.collections.MapUtils;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class RestImpl implements IRest {

    private RestTemplate restTemplate;
    @Setter
    private HttpHeaders headers;
    @Setter
    private HttpMethod method;
    @Setter
    private Map<String, String> variables;
    @Setter
    private Object body;

    public RestImpl(RestTemplate restTemplate) {
        reInitMessageConverter(restTemplate);
        this.restTemplate = restTemplate;
    }

    //修复乱码问题
    private void reInitMessageConverter(RestTemplate restTemplate){
        List<HttpMessageConverter<?>> converterList=restTemplate.getMessageConverters();
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (item.getClass() == StringHttpMessageConverter.class) {
                converterTarget = item;
                break;
            }
        }

        if (converterTarget != null) {
            converterList.remove(converterTarget);
        }
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converterList.add(converter);
    }

    @Override
    public <T> List<T> executeForList(String url, Class<T> clzz) {
        String index = UUID.randomUUID().toString();
        String respStr = executeForString(url, index);
        List<T> list = JSONArray.parseArray(respStr, clzz);
        return list;
    }

    @Override
    public <T> T executeForObject(String url, Class<T> clzz) {
        String index = UUID.randomUUID().toString();
        String respStr = executeForString(url, index);
        T object = JSONObject.parseObject(respStr, clzz);
        return object;
    }

    @Override
    public String executeForString(String url) {
        String index = UUID.randomUUID().toString();
        String respStr = executeForString(url, index);
        return respStr;
    }

    private String executeForString(String url, String index) {
        String fullUrl = url;
        if (MapUtils.isNotEmpty(variables)) {
            String parseUrl = variables.entrySet().stream().map(key -> key + "={" + key + "}").collect(Collectors.joining("&"));
            url = url + "?" + parseUrl;
        }
        HttpEntity<?> requestEntity = HttpEntity.EMPTY;
        if (body != null) {
            requestEntity = new HttpEntity<>(body, headers);
        }
        ResponseEntity<String> responseEntity = null;
        responseEntity = restTemplate.exchange(fullUrl, method, requestEntity, String.class);
        if (!HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            return null;
        }
        return responseEntity.getBody();
    }
}
