package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import java.net.Proxy;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http/RequestLine.class */
public final class RequestLine {
    private RequestLine() {
    }

    private static boolean a(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    public static String get(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        boolean a2 = a(request, type);
        HttpUrl url = request.url();
        if (a2) {
            sb.append(url);
        } else {
            sb.append(requestPath(url));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static String requestPath(HttpUrl httpUrl) {
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        String str = encodedPath;
        if (encodedQuery != null) {
            str = encodedPath + '?' + encodedQuery;
        }
        return str;
    }
}
