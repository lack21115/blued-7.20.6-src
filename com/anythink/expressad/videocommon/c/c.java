package com.anythink.expressad.videocommon.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f8763a;
    private int b;

    public c(String str, int i) {
        this.f8763a = str;
        this.b = i;
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("name");
                int optInt = jSONObject.optInt("amount");
                jSONObject.optString("id");
                return new c(optString, optInt);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return hashMap;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                hashMap.put(optJSONObject.optString("id"), new c(optJSONObject.optString("name"), optJSONObject.optInt("amount")));
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.videocommon.c.c b(java.lang.String r3) {
        /*
            r0 = 0
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r7
            r5 = r0
            com.anythink.expressad.videocommon.e.c r0 = com.anythink.expressad.videocommon.e.c.a()     // Catch: java.lang.Exception -> L5b
            com.anythink.expressad.videocommon.e.a r0 = r0.b()     // Catch: java.lang.Exception -> L5b
            r8 = r0
            r0 = r7
            r5 = r0
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L5b
            if (r0 == 0) goto L24
            r0 = r7
            r5 = r0
            com.anythink.expressad.videocommon.c.c r0 = c()     // Catch: java.lang.Exception -> L5b
            r3 = r0
            goto L62
        L24:
            r0 = r6
            r4 = r0
            r0 = r8
            if (r0 == 0) goto L4d
            r0 = r6
            r4 = r0
            r0 = r7
            r5 = r0
            r0 = r8
            java.util.Map r0 = r0.j()     // Catch: java.lang.Exception -> L5b
            if (r0 == 0) goto L4d
            r0 = r7
            r5 = r0
            r0 = r8
            java.util.Map r0 = r0.j()     // Catch: java.lang.Exception -> L5b
            r1 = r3
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L5b
            com.anythink.expressad.videocommon.c.c r0 = (com.anythink.expressad.videocommon.c.c) r0     // Catch: java.lang.Exception -> L5b
            r3 = r0
            goto L62
        L4d:
            r0 = r4
            r5 = r0
            r0 = r4
            if (r0 != 0) goto L60
            r0 = r4
            r5 = r0
            com.anythink.expressad.videocommon.c.c r0 = c()     // Catch: java.lang.Exception -> L5b
            r3 = r0
            r0 = r3
            return r0
        L5b:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
        L60:
            r0 = r5
            return r0
        L62:
            r0 = r3
            r4 = r0
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.c.c.b(java.lang.String):com.anythink.expressad.videocommon.c.c");
    }

    private static c c() {
        return new c("Virtual Item", 1);
    }

    public final String a() {
        return this.f8763a;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(String str) {
        this.f8763a = str;
    }

    public final int b() {
        return this.b;
    }

    public String toString() {
        return "Reward{name='" + this.f8763a + "', amount=" + this.b + '}';
    }
}
