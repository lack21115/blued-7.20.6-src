package com.squareup.okhttp.internal.http;

import com.sobot.network.http.SobotOkHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/http/HttpMethod.class */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String str) {
        return str.equals("POST") || str.equals(SobotOkHttpUtils.METHOD.PATCH) || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean permitsRequestBody(String str) {
        return requiresRequestBody(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(SobotOkHttpUtils.METHOD.PATCH) || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
