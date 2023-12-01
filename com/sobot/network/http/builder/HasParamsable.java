package com.sobot.network.http.builder;

import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/builder/HasParamsable.class */
public interface HasParamsable {
    OkHttpRequestBuilder addParams(String str, String str2);

    OkHttpRequestBuilder params(Map<String, String> map);
}
