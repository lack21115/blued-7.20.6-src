package com.efs.sdk.net.a;

import java.util.HashMap;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a.class */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f8223c;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, b> f8224a;
    private HashMap<String, c> b;

    private a() {
        b();
    }

    public static a a() {
        if (f8223c == null) {
            f8223c = new a();
        }
        return f8223c;
    }

    private void b() {
        if (this.f8224a == null) {
            this.f8224a = new HashMap<>();
        }
        this.f8224a.clear();
    }

    public final b a(String str) {
        if (this.f8224a == null) {
            b();
        }
        b bVar = this.f8224a.get(str);
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new b();
            bVar2.f8235a = str;
            bVar2.b = System.currentTimeMillis();
            this.f8224a.put(str, bVar2);
        }
        return bVar2;
    }

    public final void b(String str) {
        HashMap<String, b> hashMap = this.f8224a;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.f8224a.remove(str);
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
