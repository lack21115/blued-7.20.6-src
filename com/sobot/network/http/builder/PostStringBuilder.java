package com.sobot.network.http.builder;

import com.sobot.network.http.request.PostStringRequest;
import com.sobot.network.http.request.RequestCall;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.MediaType;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/builder/PostStringBuilder.class */
public class PostStringBuilder extends OkHttpRequestBuilder {
    private String content;
    private MediaType mediaType;

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostStringBuilder addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new LinkedHashMap();
        }
        this.headers.put(str, str2);
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new PostStringRequest(this.url, this.tag, this.params, this.headers, this.content, this.mediaType).build();
    }

    public PostStringBuilder content(String str) {
        this.content = str;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public /* bridge */ /* synthetic */ OkHttpRequestBuilder headers(Map map) {
        return headers((Map<String, String>) map);
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostStringBuilder headers(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostStringBuilder tag(Object obj) {
        this.tag = obj;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostStringBuilder url(String str) {
        this.url = str;
        return this;
    }
}
