package com.efs.sdk.net.b;

import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/b/a.class */
public final class a {
    public static long a(Map<String, Long> map, String str, String str2) {
        if (map.containsKey(str) && map.containsKey(str2)) {
            return map.get(str2).longValue() - map.get(str).longValue();
        }
        return 0L;
    }
}
