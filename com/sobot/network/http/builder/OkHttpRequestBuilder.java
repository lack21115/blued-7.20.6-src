package com.sobot.network.http.builder;

import com.sobot.network.http.request.RequestCall;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/builder/OkHttpRequestBuilder.class */
public abstract class OkHttpRequestBuilder {
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected Object tag;
    protected String url;

    public abstract OkHttpRequestBuilder addHeader(String str, String str2);

    public abstract RequestCall build();

    public abstract OkHttpRequestBuilder headers(Map<String, String> map);

    public abstract OkHttpRequestBuilder tag(Object obj);

    public abstract OkHttpRequestBuilder url(String str);
}
