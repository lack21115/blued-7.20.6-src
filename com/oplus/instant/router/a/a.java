package com.oplus.instant.router.a;

import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.oplus.instant.router.g.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/a/a.class */
public class a {
    private static String a(Object obj) {
        if (obj != null) {
            try {
                return URLEncoder.encode(obj.toString(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                d.a("OapsParser", e);
                return obj.toString();
            }
        }
        return "";
    }

    public static String a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        if (hashMap.containsKey("scheme") && hashMap.containsKey("host") && hashMap.containsKey(OapsWrapper.KEY_PATH)) {
            StringBuilder sb = new StringBuilder();
            sb.append(hashMap.remove("scheme"));
            sb.append("://");
            sb.append(hashMap.remove("host"));
            sb.append(hashMap.remove(OapsWrapper.KEY_PATH));
            if (hashMap.size() > 0) {
                sb.append("?");
                for (String str : hashMap.keySet()) {
                    if (sb.charAt(sb.length() - 1) != '?') {
                        sb.append("&");
                    }
                    sb.append(str);
                    sb.append("=");
                    sb.append(a(hashMap.get(str)));
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static Map<String, Object> a(String str) {
        Uri parse;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getHost()) && !TextUtils.isEmpty(parse.getPath())) {
            hashMap.put("scheme", parse.getScheme());
            hashMap.put("host", parse.getHost());
            hashMap.put(OapsWrapper.KEY_PATH, parse.getPath());
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                for (String str2 : queryParameterNames) {
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put(str2, parse.getQueryParameter(str2));
                    }
                }
            }
        }
        return hashMap;
    }
}
