package com.tramini.plugin.a.g;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/g.class */
public final class g {
    public static String a(com.tramini.plugin.b.a aVar) {
        com.tramini.plugin.a.c.c cVar;
        ConcurrentHashMap<String, com.tramini.plugin.a.c.c> e = aVar.e();
        if (e != null) {
            for (String str : e.keySet()) {
                if (!TextUtils.isEmpty(str) && (cVar = e.get(str)) != null && !TextUtils.isEmpty(cVar.f26811a) && cVar.f26811a.startsWith("http")) {
                    return str;
                }
            }
            return "";
        }
        return "";
    }
}
