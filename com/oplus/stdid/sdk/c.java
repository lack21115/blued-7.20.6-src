package com.oplus.stdid.sdk;

import android.content.Context;
import com.oplus.stdid.sdk.d;
import java.util.HashMap;
import s_a.s_a.s_a.a.e;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f24435a;
    public HashMap<String, e> b;

    public c() {
        this.b = null;
        this.b = new HashMap<>();
    }

    public static c a() {
        if (f24435a == null) {
            synchronized (c.class) {
                try {
                    if (f24435a == null) {
                        f24435a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f24435a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r0 == "") goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.stdid.sdk.c.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public void b(Context context, String str) {
        if (this.b.containsKey(str)) {
            e eVar = this.b.get(str);
            if (eVar.a(str)) {
                return;
            }
            String a2 = d.b.f24439a.a(context, str);
            long currentTimeMillis = System.currentTimeMillis();
            long b = s_a.s_a.s_a.a.a.b(str);
            if (a2.equals("") || a2 == "") {
                return;
            }
            eVar.f44182a = a2;
            eVar.b = currentTimeMillis + b;
            s_a.s_a.s_a.a.a.a(context, eVar, str);
        } else if (str.equals("OUID") || str.equals("OUID_STATUS") || str == "OUID" || str == "OUID_STATUS") {
            String a3 = d.b.f24439a.a(context, str);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a3.equals("") || a3 == "") {
                return;
            }
            this.b.put(str, new e(a3, currentTimeMillis2 + 7200000));
        }
    }
}
