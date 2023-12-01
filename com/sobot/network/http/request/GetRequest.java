package com.sobot.network.http.request;

import java.util.Map;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/GetRequest.class */
public class GetRequest extends OkHttpRequest {
    public GetRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2) {
        super(str, obj, map, map2);
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected Request buildRequest(RequestBody requestBody) {
        return this.builder.get().build();
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected RequestBody buildRequestBody() {
        return null;
    }
}
