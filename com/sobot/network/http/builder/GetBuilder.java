package com.sobot.network.http.builder;

import com.sobot.network.http.request.GetRequest;
import com.sobot.network.http.request.RequestCall;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/builder/GetBuilder.class */
public class GetBuilder extends OkHttpRequestBuilder implements HasParamsable {
    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public GetBuilder addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new LinkedHashMap();
        }
        this.headers.put(str, str2);
        return this;
    }

    @Override // com.sobot.network.http.builder.HasParamsable
    public GetBuilder addParams(String str, String str2) {
        if (this.params == null) {
            this.params = new LinkedHashMap();
        }
        this.params.put(str, str2);
        return this;
    }

    protected String appendParams(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(str + "?");
        if (map != null && !map.isEmpty()) {
            for (String str2 : map.keySet()) {
                sb.append(str2);
                sb.append("=");
                sb.append(map.get(str2));
                sb.append("&");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public RequestCall build() {
        if (this.params != null) {
            this.url = appendParams(this.url, this.params);
        }
        return new GetRequest(this.url, this.tag, this.params, this.headers).build();
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public GetBuilder headers(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public /* bridge */ /* synthetic */ OkHttpRequestBuilder headers(Map map) {
        return headers((Map<String, String>) map);
    }

    @Override // com.sobot.network.http.builder.HasParamsable
    public GetBuilder params(Map<String, String> map) {
        this.params = map;
        return this;
    }

    @Override // com.sobot.network.http.builder.HasParamsable
    public /* bridge */ /* synthetic */ OkHttpRequestBuilder params(Map map) {
        return params((Map<String, String>) map);
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public GetBuilder tag(Object obj) {
        this.tag = obj;
        return this;
    }

    @Override // com.sobot.network.http.builder.OkHttpRequestBuilder
    public GetBuilder url(String str) {
        this.url = str;
        return this;
    }
}
