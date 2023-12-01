package com.cdo.oaps.ad;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/OapsParser.class */
public class OapsParser {
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

    private static String b(Object obj) {
        if (obj != null) {
            try {
                return URLDecoder.decode(obj.toString(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static Map<String, Object> decode(String str) {
        Uri parse;
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getHost()) && !TextUtils.isEmpty(parse.getPath())) {
                OapsWrapper path = OapsWrapper.wrapper((Map<String, Object>) hashMap).setScheme(parse.getScheme()).setHost(parse.getHost()).setPath(parse.getPath());
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                    for (String str2 : queryParameterNames) {
                        if (!TextUtils.isEmpty(str2)) {
                            path.set(str2, parse.getQueryParameter(str2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    public static String encode(Map<String, Object> map) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        if (TextUtils.isEmpty(wrapper.getScheme()) || TextUtils.isEmpty(wrapper.getHost()) || TextUtils.isEmpty(wrapper.getPath())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(wrapper.getScheme());
        sb.append("://");
        sb.append(wrapper.getHost());
        sb.append(wrapper.getPath());
        Map<String, Object> params = wrapper.getParams();
        if (params != null && params.size() > 0) {
            sb.append("?");
            for (Map.Entry<String, Object> entry : params.entrySet()) {
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
}
