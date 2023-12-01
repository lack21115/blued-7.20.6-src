package com.sobot.network.http.request;

import com.sobot.network.http.callback.Callback;
import com.sobot.network.http.request.ProgressRequestBody;
import com.sobot.network.http.utils.Exceptions;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/OkHttpRequest.class */
public abstract class OkHttpRequest {
    protected Request.Builder builder = new Request.Builder();
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected Object tag;
    protected transient ProgressRequestBody.UploadInterceptor uploadInterceptor;
    protected String url;

    /* JADX INFO: Access modifiers changed from: protected */
    public OkHttpRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2) {
        this.url = str;
        this.tag = obj;
        this.params = map;
        this.headers = map2;
        if (str == null) {
            Exceptions.illegalArgument("url can not be null.", new Object[0]);
        }
        initBuilder();
    }

    private void initBuilder() {
        this.builder.url(this.url).tag(this.tag);
        appendHeaders();
    }

    public void addHeader(String str, String str2) {
        Map<String, String> map = this.headers;
        if (map == null || map.isEmpty()) {
            this.headers = new HashMap();
        }
        this.headers.put(str, str2);
        appendHeaders();
    }

    protected void appendHeaders() {
        Headers.Builder builder = new Headers.Builder();
        Map<String, String> map = this.headers;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (String str : this.headers.keySet()) {
            builder.add(str, this.headers.get(str));
        }
        this.builder.headers(builder.build());
    }

    public RequestCall build() {
        return new RequestCall(this);
    }

    protected abstract Request buildRequest(RequestBody requestBody);

    protected abstract RequestBody buildRequestBody();

    public Request generateRequest(Callback callback) {
        return buildRequest(wrapRequestBody(buildRequestBody(), callback));
    }

    public String getBaseUrl() {
        return this.url;
    }

    public OkHttpRequest uploadInterceptor(ProgressRequestBody.UploadInterceptor uploadInterceptor) {
        this.uploadInterceptor = uploadInterceptor;
        return this;
    }

    protected RequestBody wrapRequestBody(RequestBody requestBody, Callback callback) {
        return requestBody;
    }
}
