package com.bytedance.bdtracker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/l.class */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21245a = new a(null);

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/l$a.class */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends l> T a(JSONObject jSONObject, Class<T> clazz) {
            Intrinsics.d(clazz, "clazz");
            if (jSONObject != null) {
                T newInstance = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.b(newInstance, "clazz.getConstructor().newInstance()");
                T t = newInstance;
                t.a(jSONObject);
                return t;
            }
            return null;
        }
    }

    public abstract JSONObject a();

    public abstract void a(JSONObject jSONObject);

    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        JSONObject a2 = a();
        Iterator<String> keys = a2.keys();
        Intrinsics.b(keys, "keys()");
        while (keys.hasNext()) {
            String key = keys.next();
            Intrinsics.b(key, "key");
            hashMap.put(key, a2.optString(key, null));
        }
        return hashMap;
    }

    public String toString() {
        String jSONObject = a().toString();
        Intrinsics.b(jSONObject, "toJson().toString()");
        return jSONObject;
    }
}
