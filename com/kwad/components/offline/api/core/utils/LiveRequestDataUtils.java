package com.kwad.components.offline.api.core.utils;

import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/utils/LiveRequestDataUtils.class */
public final class LiveRequestDataUtils {
    public static String appendUrl(String str, Map<String, String> map) {
        String str2 = str;
        if (map != null) {
            if (map.size() <= 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (String str3 : map.keySet()) {
                if (map.get(str3) != null) {
                    sb.append(str3);
                    sb.append("=");
                    sb.append(map.get(str3));
                    sb.append("&");
                }
            }
            String sb2 = sb.toString();
            String substring = sb2.substring(0, sb2.length() - 1);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(str.contains("?") ? "&" : "?");
            str2 = sb3.toString() + substring;
        }
        return str2;
    }
}
