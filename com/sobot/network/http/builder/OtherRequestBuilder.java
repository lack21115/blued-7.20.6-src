package com.sobot.network.http.builder;

import com.sobot.network.http.request.OtherRequest;
import com.sobot.network.http.request.RequestCall;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.RequestBody;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/builder/OtherRequestBuilder.class */
public class OtherRequestBuilder extends OkHttpRequestBuilder {
    private String content;
    private String method;
    private RequestBody requestBody;

    public OtherRequestBuilder(String str) {
        this.method = str;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public OtherRequestBuilder addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new LinkedHashMap();
        }
        this.headers.put(str, str2);
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new OtherRequest(this.requestBody, this.content, this.method, this.url, this.tag, this.params, this.headers).build();
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public /* bridge */ /* synthetic */ OkHttpRequestBuilder headers(Map map) {
        return headers((Map<String, String>) map);
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public OtherRequestBuilder headers(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public OtherRequestBuilder requestBody(String str) {
        this.content = str;
        return this;
    }

    public OtherRequestBuilder requestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public OtherRequestBuilder tag(Object obj) {
        this.tag = obj;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public OtherRequestBuilder url(String str) {
        this.url = str;
        return this;
    }
}
