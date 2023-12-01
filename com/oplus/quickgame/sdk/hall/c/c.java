package com.oplus.quickgame.sdk.hall.c;

import com.cdo.oaps.ad.OapsWrapper;
import com.oplus.quickgame.sdk.hall.exception.NotContainsKeyException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<Map<String, Object>> f24431a;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Map<String, Object> map) {
        this.f24431a = new WeakReference<>(map);
    }

    public static c b(Map<String, Object> map) {
        return new c(map);
    }

    public final c a(String str, Object obj) {
        Map<String, Object> map;
        WeakReference<Map<String, Object>> weakReference = this.f24431a;
        if (weakReference != null && (map = weakReference.get()) != null) {
            map.put(str, obj);
        }
        return this;
    }

    public final c a(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!entry.getKey().equals("scheme") && !entry.getKey().equals("host") && !entry.getKey().equals(OapsWrapper.KEY_PATH)) {
                a(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public final Object a(String str) throws NotContainsKeyException {
        Map<String, Object> map;
        WeakReference<Map<String, Object>> weakReference = this.f24431a;
        if (weakReference == null || (map = weakReference.get()) == null) {
            return null;
        }
        Object obj = map.get(str);
        if (obj != null) {
            return obj;
        }
        throw new NotContainsKeyException(str);
    }

    public final Map<String, Object> a() {
        Map<String, Object> map;
        HashMap hashMap = new HashMap();
        WeakReference<Map<String, Object>> weakReference = this.f24431a;
        if (weakReference != null && (map = weakReference.get()) != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!entry.getKey().equals("scheme") && !entry.getKey().equals("host") && !entry.getKey().equals(OapsWrapper.KEY_PATH)) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    public String toString() {
        Map<String, Object> map;
        StringBuilder sb = new StringBuilder();
        WeakReference<Map<String, Object>> weakReference = this.f24431a;
        if (weakReference != null && (map = weakReference.get()) != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append("[");
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(String.valueOf(entry.getValue()));
                sb.append("]");
            }
        }
        return sb.toString();
    }
}
