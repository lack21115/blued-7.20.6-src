package com.sobot.network.http.builder;

import com.sobot.network.http.request.PostFileRequest;
import com.sobot.network.http.request.RequestCall;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.MediaType;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/builder/PostFileBuilder.class */
public class PostFileBuilder extends OkHttpRequestBuilder {
    private File file;
    private MediaType mediaType;

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostFileBuilder addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new LinkedHashMap();
        }
        this.headers.put(str, str2);
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new PostFileRequest(this.url, this.tag, this.params, this.headers, this.file, this.mediaType).build();
    }

    public OkHttpRequestBuilder file(File file) {
        this.file = file;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public /* bridge */ /* synthetic */ OkHttpRequestBuilder headers(Map map) {
        return headers((Map<String, String>) map);
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostFileBuilder headers(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public OkHttpRequestBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostFileBuilder tag(Object obj) {
        this.tag = obj;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public PostFileBuilder url(String str) {
        this.url = str;
        return this;
    }
}
