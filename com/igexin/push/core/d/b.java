package com.igexin.push.core.d;

import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d/b.class */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9868a = "GTConfigProxy";
    private static volatile b b;

    /* renamed from: c  reason: collision with root package name */
    private e f9869c = new a();

    private b() {
    }

    private void a(e eVar) {
        this.f9869c = eVar;
    }

    public static b c() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.igexin.push.core.d.e
    public final Map<String, String> a() {
        e eVar = this.f9869c;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean a(Map<String, String> map) {
        e eVar = this.f9869c;
        if (eVar != null) {
            return eVar.a(map);
        }
        return false;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean b() {
        e eVar = this.f9869c;
        if (eVar != null) {
            return eVar.b();
        }
        return false;
    }
}
