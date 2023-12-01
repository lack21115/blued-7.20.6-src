package com.oplus.quickgame.sdk.hall.b;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/b/a.class */
public class a {
    private static String a(Object obj) {
        if (obj != null) {
            try {
                return URLEncoder.encode(obj.toString(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String a(Map<String, Object> map) {
        com.oplus.quickgame.sdk.hall.c.b b = com.oplus.quickgame.sdk.hall.c.b.b(map);
        if (TextUtils.isEmpty(b.d()) || TextUtils.isEmpty(b.b()) || TextUtils.isEmpty(b.c())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b.d());
        sb.append("://");
        sb.append(b.b());
        sb.append(b.c());
        Map<String, Object> a2 = b.a();
        if (a2 != null && a2.size() > 0) {
            sb.append("?");
            for (Map.Entry<String, Object> entry : a2.entrySet()) {
                if (sb.charAt(sb.length() - 1) != '?') {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(a(entry.getValue()));
            }
        }
        return sb.toString();
    }

    public static Map<String, Object> a(String str) {
        Uri parse;
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getHost()) && !TextUtils.isEmpty(parse.getPath())) {
                com.oplus.quickgame.sdk.hall.c.b c2 = com.oplus.quickgame.sdk.hall.c.b.b((Map<String, Object>) hashMap).d(parse.getScheme()).b(parse.getHost()).c(parse.getPath());
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                    for (String str2 : queryParameterNames) {
                        if (!TextUtils.isEmpty(str2)) {
                            c2.a(str2, parse.getQueryParameter(str2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }
}
