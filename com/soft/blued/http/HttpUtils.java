package com.soft.blued.http;

import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/HttpUtils.class */
public class HttpUtils {
    public static String a(Map<String, String> map, String str) {
        String str2 = str;
        if (map != null) {
            str2 = str;
            if (map.size() > 0) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    if (str.contains("?")) {
                        str = str + "&" + ((Object) next.getKey()) + "=" + ((Object) next.getValue());
                    } else {
                        str = str + "?" + ((Object) next.getKey()) + "=" + ((Object) next.getValue());
                    }
                }
            }
        }
        return str2;
    }
}
