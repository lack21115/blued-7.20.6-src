package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/y.class */
public final class y implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Integer> f27458a = new HashMap<>();
    private static final HashMap<String, Long> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, String> f27459c = new HashMap<>();
    private static y d;
    private Context e;
    private d f;
    private boolean g;

    private y(Context context) {
        this.g = false;
        this.e = context;
        this.g = a(context);
        p.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    public static y b(Context context) {
        y yVar;
        synchronized (y.class) {
            try {
                if (d == null) {
                    d = new y(context.getApplicationContext());
                }
                yVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        d dVar;
        String str3 = f27459c.get(str);
        if (str3 == null && (dVar = this.f) != null) {
            return dVar.a(str, str2);
        }
        return str3;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        v vVar = new v();
        this.f = vVar;
        boolean a2 = vVar.a(context);
        boolean z = a2;
        if (!a2) {
            x xVar = new x();
            this.f = xVar;
            z = xVar.a(context);
        }
        if (!z) {
            this.f = null;
        }
        return z;
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        d dVar;
        f27459c.put(str, str2);
        if (!this.g || (dVar = this.f) == null) {
            return;
        }
        dVar.b(str, str2);
    }
}
