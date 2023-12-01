package com.tencent.qcloud.core.http;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.qcloud.core.auth.QCloudSelfSigner;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpRequest.class */
public class HttpRequest<T> {
    protected final boolean calculateContentMD5;
    protected final Map<String, List<String>> headers;
    protected final String keyTime;
    protected final String method;
    protected final Set<String> noSignHeaders;
    protected final Set<String> noSignParams;
    protected final Map<String, String> queries;
    protected final RequestBody requestBody;
    protected final Request.Builder requestBuilder;
    protected final ResponseBodyConverter<T> responseBodyConverter;
    protected final Object tag;
    protected final URL url;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpRequest$Builder.class */
    public static class Builder<T> {
        boolean calculateContentMD5;
        String keyTime;
        String method;
        RequestBodySerializer requestBodySerializer;
        ResponseBodyConverter<T> responseBodyConverter;
        Object tag;
        Map<String, List<String>> headers = new HashMap(10);
        Map<String, String> queries = new HashMap(10);
        Set<String> noSignHeaderKeys = new HashSet();
        Set<String> noSignParamsKeys = new HashSet();
        boolean isCacheEnabled = true;
        HttpUrl.Builder httpUrlBuilder = new HttpUrl.Builder();
        Request.Builder requestBuilder = new Request.Builder();

        public Builder<T> addHeader(String str, String str2) {
            if (str != null && str2 != null) {
                this.requestBuilder.addHeader(str, str2);
                HttpRequest.addHeaderNameValue(this.headers, str, str2);
            }
            return this;
        }

        public Builder<T> addHeaders(Map<String, List<String>> map) {
            if (map != null) {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    for (String str : entry.getValue()) {
                        if (key != null && str != null) {
                            this.requestBuilder.addHeader(key, str);
                            HttpRequest.addHeaderNameValue(this.headers, key, str);
                        }
                    }
                }
            }
            return this;
        }

        public Builder<T> addHeadersUnsafeNonAscii(Map<String, List<String>> map) {
            if (map != null) {
                Headers.Builder builder = new Headers.Builder();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    for (String str : entry.getValue()) {
                        if (key != null && str != null) {
                            builder.addUnsafeNonAscii(key, str);
                            HttpRequest.addHeaderNameValue(this.headers, key, str);
                        }
                    }
                }
                this.requestBuilder.headers(builder.build());
            }
            return this;
        }

        public Builder<T> addNoSignHeaderKeys(Set<String> set) {
            this.noSignHeaderKeys.addAll(set);
            return this;
        }

        public Builder<T> addNoSignParamKeys(Set<String> set) {
            this.noSignParamsKeys.addAll(set);
            return this;
        }

        public Builder<T> body(RequestBodySerializer requestBodySerializer) {
            this.requestBodySerializer = requestBodySerializer;
            return this;
        }

        public HttpRequest<T> build() {
            prepareBuild();
            return new HttpRequest<>(this);
        }

        public Builder<T> contentMD5() {
            this.calculateContentMD5 = true;
            return this;
        }

        public Builder<T> converter(ResponseBodyConverter<T> responseBodyConverter) {
            this.responseBodyConverter = responseBodyConverter;
            return this;
        }

        public Builder<T> encodedQuery(String str) {
            this.httpUrlBuilder.encodedQuery(str);
            return this;
        }

        public Builder<T> encodedQuery(String str, String str2) {
            if (str != null) {
                this.queries.put(str, str2);
                this.httpUrlBuilder.addEncodedQueryParameter(str, str2);
            }
            return this;
        }

        public Builder<T> encodedQuery(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        this.queries.put(key, entry.getValue());
                        this.httpUrlBuilder.addEncodedQueryParameter(key, entry.getValue());
                    }
                }
            }
            return this;
        }

        public Set<String> getNoSignHeaderKeys() {
            return this.noSignHeaderKeys;
        }

        public Set<String> getNoSignParamsKeys() {
            return this.noSignParamsKeys;
        }

        public Builder<T> host(String str) {
            this.httpUrlBuilder.host(str);
            return this;
        }

        public Builder<T> method(String str) {
            this.method = str;
            return this;
        }

        public Builder<T> path(String str) {
            String str2 = str;
            if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
                str2 = str.substring(1);
            }
            if (str2.length() > 0) {
                this.httpUrlBuilder.addPathSegments(str2);
            }
            return this;
        }

        public Builder<T> port(int i) {
            this.httpUrlBuilder.port(i);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void prepareBuild() {
            this.requestBuilder.url(this.httpUrlBuilder.build());
            if (!this.isCacheEnabled) {
                this.requestBuilder.cacheControl(CacheControl.FORCE_NETWORK);
            }
            if (this.responseBodyConverter == null) {
                this.responseBodyConverter = (ResponseBodyConverter<T>) ResponseBodyConverter.string();
            }
        }

        public Builder<T> query(String str, String str2) {
            if (str != null) {
                this.queries.put(str, str2);
                this.httpUrlBuilder.addQueryParameter(str, str2);
            }
            return this;
        }

        public Builder<T> query(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        this.queries.put(key, entry.getValue());
                        this.httpUrlBuilder.addQueryParameter(key, entry.getValue());
                    }
                }
            }
            return this;
        }

        public Builder<T> removeHeader(String str) {
            this.requestBuilder.removeHeader(str);
            this.headers.remove(str);
            return this;
        }

        public Builder<T> scheme(String str) {
            this.httpUrlBuilder.scheme(str);
            return this;
        }

        public Builder<T> setKeyTime(String str) {
            this.keyTime = str;
            return this;
        }

        public Builder<T> setUseCache(boolean z) {
            this.isCacheEnabled = z;
            return this;
        }

        public Builder<T> tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder<T> url(URL url) {
            HttpUrl httpUrl = HttpUrl.get(url);
            if (httpUrl != null) {
                this.httpUrlBuilder = httpUrl.newBuilder();
                return this;
            }
            throw new IllegalArgumentException("url is not legal : " + url);
        }

        public Builder<T> userAgent(String str) {
            this.requestBuilder.addHeader("User-Agent", str);
            HttpRequest.addHeaderNameValue(this.headers, "User-Agent", str);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequest(Builder<T> builder) {
        this.requestBuilder = builder.requestBuilder;
        this.responseBodyConverter = builder.responseBodyConverter;
        this.headers = builder.headers;
        this.queries = builder.queries;
        this.noSignHeaders = builder.noSignHeaderKeys;
        this.noSignParams = builder.noSignParamsKeys;
        this.keyTime = builder.keyTime;
        this.method = builder.method;
        this.calculateContentMD5 = builder.calculateContentMD5;
        if (builder.tag == null) {
            this.tag = toString();
        } else {
            this.tag = builder.tag;
        }
        this.url = builder.httpUrlBuilder.build().url();
        if (builder.requestBodySerializer != null) {
            this.requestBody = builder.requestBodySerializer.body();
        } else {
            this.requestBody = null;
        }
        this.requestBuilder.method(builder.method, this.requestBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addHeaderNameValue(Map<String, List<String>> map, String str, String str2) {
        List<String> list = map.get(str);
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList(2);
            map.put(str, arrayList);
        }
        arrayList.add(str2.trim());
    }

    public void addHeader(String str, String str2) {
        List<String> list = this.headers.get(str);
        if (list == null || list.size() < 1) {
            this.requestBuilder.addHeader(str, str2);
            addHeaderNameValue(this.headers, str, str2);
        }
    }

    public void addQuery(String str, String str2) {
        if (str != null) {
            this.queries.put(str, str2);
        }
    }

    public Request buildRealRequest() {
        return this.requestBuilder.build();
    }

    public long contentLength() throws IOException {
        RequestBody requestBody = this.requestBody;
        if (requestBody == null) {
            return -1L;
        }
        return requestBody.contentLength();
    }

    public String contentType() {
        RequestBody requestBody = this.requestBody;
        String str = null;
        if (requestBody == null) {
            return null;
        }
        MediaType contentType = requestBody.contentType();
        if (contentType != null) {
            str = contentType.toString();
        }
        return str;
    }

    public String getKeyTime() {
        return this.keyTime;
    }

    public Set<String> getNoSignHeaders() {
        return this.noSignHeaders;
    }

    public Set<String> getNoSignParams() {
        return this.noSignParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QCloudSelfSigner getQCloudSelfSigner() throws QCloudClientException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QCloudSigner getQCloudSigner() throws QCloudClientException {
        return null;
    }

    public RequestBody getRequestBody() {
        return this.requestBody;
    }

    public ResponseBodyConverter<T> getResponseBodyConverter() {
        return this.responseBodyConverter;
    }

    public String header(String str) {
        List<String> list = this.headers.get(str);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    public Map<String, List<String>> headers() {
        return this.headers;
    }

    public String host() {
        return this.url.getHost();
    }

    public String method() {
        return this.method;
    }

    public Map<String, String> queries() {
        return this.queries;
    }

    public void removeHeader(String str) {
        this.requestBuilder.removeHeader(str);
        this.headers.remove(str);
    }

    public void setOkHttpRequestTag(String str) {
        this.requestBuilder.tag(str);
    }

    public void setUrl(String str) {
        this.requestBuilder.url(str);
    }

    public boolean shouldCalculateContentMD5() {
        return this.calculateContentMD5 && QCloudStringUtils.isEmpty(header("Content-MD5"));
    }

    public Object tag() {
        return this.tag;
    }

    public URL url() {
        return this.url;
    }
}
