package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/b.class */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> abF = new ConcurrentHashMap();
    private static SharedPreferences abG = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences aE;
        if (bVar == null || (aE = aE(context)) == null) {
            return;
        }
        try {
            bVar.a(aE);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : abF.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = abF.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : abF.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = abF.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static <T> void a(com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> bA = bA(key);
        CopyOnWriteArraySet copyOnWriteArraySet = bA;
        if (bA == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet();
            abF.put(key, copyOnWriteArraySet);
        }
        copyOnWriteArraySet.add(bVar);
    }

    private static SharedPreferences aE(Context context) {
        if (abG == null && context != null) {
            abG = context.getSharedPreferences("ksadsdk_config", 0);
        }
        return abG;
    }

    public static boolean aF(Context context) {
        synchronized (b.class) {
            try {
                SharedPreferences aE = aE(context);
                if (aE != null) {
                    SharedPreferences.Editor edit = aE.edit();
                    a(edit);
                    return edit.commit();
                }
                return false;
            } finally {
            }
        }
    }

    public static void aG(Context context) {
        synchronized (b.class) {
            try {
                SharedPreferences aE = aE(context);
                if (aE != null) {
                    a(aE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Set<com.kwad.sdk.core.config.item.b> bA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return abF.get(str);
    }

    public static void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : abF.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = abF.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.g(jSONObject);
                    }
                }
            }
        }
    }
}
