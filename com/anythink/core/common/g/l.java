package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/l.class */
public final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    o f6732a;
    boolean b = true;

    public l(o oVar) {
        this.f6732a = oVar;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return this.f6732a.b;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        return this.f6732a.d;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        String str = this.f6732a.f6672c;
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    @Override // com.anythink.core.common.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final byte[] d() {
        /*
            r4 = this;
            r0 = r4
            com.anythink.core.common.e.o r0 = r0.f6732a
            java.lang.String r0 = r0.f6672c
            if (r0 == 0) goto L1e
            r0 = r4
            com.anythink.core.common.e.o r0 = r0.f6732a
            java.lang.String r0 = r0.f6672c
            java.lang.String r1 = "gzip"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L1e
            r0 = 1
            r5 = r0
            goto L20
        L1e:
            r0 = 0
            r5 = r0
        L20:
            r0 = 0
            r7 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L4b
            r1 = r0
            r2 = r4
            com.anythink.core.common.e.o r2 = r2.f6732a     // Catch: java.lang.Exception -> L4b
            java.lang.String r2 = r2.e     // Catch: java.lang.Exception -> L4b
            r1.<init>(r2)     // Catch: java.lang.Exception -> L4b
            r6 = r0
            r0 = r6
            r7 = r0
            r0 = r4
            boolean r0 = r0.b     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L58
            r0 = r6
            java.lang.String r1 = "ofl"
            r2 = 1
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Exception -> L47
            r0 = r6
            r7 = r0
            goto L58
        L47:
            r7 = move-exception
            goto L52
        L4b:
            r8 = move-exception
            r0 = r7
            r6 = r0
            r0 = r8
            r7 = r0
        L52:
            r0 = r7
            r0.printStackTrace()
            r0 = r6
            r7 = r0
        L58:
            r0 = r5
            if (r0 == 0) goto L6c
            r0 = r7
            if (r0 == 0) goto L68
            r0 = r7
            java.lang.String r0 = r0.toString()
            byte[] r0 = c(r0)
            return r0
        L68:
            r0 = 0
            byte[] r0 = new byte[r0]
            return r0
        L6c:
            r0 = r7
            if (r0 == 0) goto L78
            r0 = r7
            java.lang.String r0 = r0.toString()
            byte[] r0 = r0.getBytes()
            return r0
        L78:
            r0 = 0
            byte[] r0 = new byte[r0]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.g.l.d():byte[]");
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean o() {
        return true;
    }

    public final void p() {
        this.b = false;
    }

    public final o q() {
        return this.f6732a;
    }
}
