package com.web.library.groups.webviewsdk.c;

import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/c/a.class */
public class a {
    public static String a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null) {
            for (String str : map.keySet()) {
                if (!d.a(str)) {
                    String str2 = map.get(str);
                    stringBuffer.append(str + "=" + str2 + "&");
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    public static Map<String, String> a(String str) {
        return a(str, false);
    }

    public static Map<String, String> a(String str, boolean z) {
        String[] split;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        if (d.a(str)) {
            return hashMap;
        }
        try {
            URI uri = new URI(str);
            String query = z ? uri.getQuery() : uri.getRawQuery();
            if (query != null && !"".equals(query) && (split = query.split("&")) != null && split.length != 0) {
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String[] split2 = split[i2].split("=");
                    if (split2 != null && split2.length == 2) {
                        if (z) {
                            str2 = split2[0];
                            str3 = URLDecoder.decode(split2[1], "UTF-8");
                        } else {
                            str2 = split2[0];
                            str3 = split2[1];
                        }
                        hashMap.put(str2, str3);
                    }
                    i = i2 + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
