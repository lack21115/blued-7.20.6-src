package com.efs.sdk.net.a;

import java.util.HashMap;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a.class */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f21830c;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, b> f21831a;
    private HashMap<String, c> b;

    private a() {
        b();
    }

    public static a a() {
        if (f21830c == null) {
            f21830c = new a();
        }
        return f21830c;
    }

    private void b() {
        if (this.f21831a == null) {
            this.f21831a = new HashMap<>();
        }
        this.f21831a.clear();
    }

    public final b a(String str) {
        if (this.f21831a == null) {
            b();
        }
        b bVar = this.f21831a.get(str);
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new b();
            bVar2.f21842a = str;
            bVar2.b = System.currentTimeMillis();
            this.f21831a.put(str, bVar2);
        }
        return bVar2;
    }

    public final void b(String str) {
        HashMap<String, b> hashMap = this.f21831a;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.f21831a.remove(str);
    }

    public final c c(String str) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        c cVar = new c();
        cVar.A = str;
        cVar.C = System.currentTimeMillis();
        this.b.put(str, cVar);
        return cVar;
    }

    public final void d(String str) {
        HashMap<String, c> hashMap = this.b;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.b.remove(str);
    }
}
