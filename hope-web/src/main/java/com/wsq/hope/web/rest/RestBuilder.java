package com.wsq.hope.web.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RestBuilder {
    private RestTemplateBuilder builder;
    private HttpHeaders headers;
    private HttpMethod method = HttpMethod.GET;
    private Map<String, String> variables = new HashMap<>();
    private Object body;

    public RestBuilder() {
        this.builder = new RestTemplateBuilder();
    }

    public RestBuilder addHeader(String key, String value) {
        if (this.headers == null) {
            this.headers = new HttpHeaders();
        }
        headers.add(key, value);
        return this;
    }

    public RestBuilder addMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public RestBuilder addVariable(String key, String value) {
        this.variables.put(key, value);
        return this;
    }

    public RestBuilder addVariables(Map<String, String> variables) {
        this.variables.putAll(variables);
        return this;
    }

    public RestBuilder additionalInterceptors(Collection<? extends ClientHttpRequestInterceptor> interceptors) {
        this.builder = this.builder.additionalInterceptors(interceptors);
        return this;
    }

    public RestBuilder rootUri(String rootUri) {
        this.builder = this.builder.rootUri(rootUri);
        return this;
    }

    public RestBuilder basicAuthorization(String username, String password) {
        this.builder = this.builder.basicAuthorization(username, password);
        return this;
    }

    public RestBuilder readTimeout(int readTimeout) {
        this.builder = this.builder.setReadTimeout(readTimeout);
        return this;
    }

    public RestBuilder connectTimeout(int connectTimeout) {
        this.builder = this.builder.setConnectTimeout(connectTimeout);
        return this;
    }


    public IRest build() {
        RestImpl impl = new RestImpl(builder.build());
        impl.setBody(this.body);
        impl.setHeaders(this.headers);
        impl.setMethod(this.method);
        impl.setVariables(this.variables);
        return impl;
    }
}
