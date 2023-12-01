package com.tencent.mapsdk.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/e.class */
public class e extends c {
    public HashMap<String, byte[]> f = null;
    private HashMap<String, Object> g = new HashMap<>();
    public m h = new m();

    private Object a(byte[] bArr, Object obj) {
        this.h.b(bArr);
        this.h.a(this.d);
        return this.h.a((m) obj, 0, true);
    }

    private void b(String str, Object obj) {
        this.g.put(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, T t, Object obj) {
        return !this.f.containsKey(str) ? obj : (T) d(str, t);
    }

    @Override // com.tencent.mapsdk.internal.c
    public <T> T a(String str, Object obj, boolean z, ClassLoader classLoader) {
        if (this.f == null) {
            return (T) super.a(str, obj, z, classLoader);
        }
        throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy, Object defaultValue)");
    }

    @Override // com.tencent.mapsdk.internal.c
    public <T> T a(String str, boolean z, ClassLoader classLoader) throws b {
        if (this.f == null) {
            return (T) super.a(str, z, classLoader);
        }
        throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
    }

    @Override // com.tencent.mapsdk.internal.c
    public /* bridge */ /* synthetic */ String a(Object obj) {
        return super.a((e) obj);
    }

    @Override // com.tencent.mapsdk.internal.c
    public void a() {
        this.g.clear();
    }

    @Override // com.tencent.mapsdk.internal.c
    public <T> void a(String str, T t) {
        if (this.f == null) {
            super.a(str, (String) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t == null) {
                throw new IllegalArgumentException("put value can not is null");
            }
            if (t instanceof Set) {
                throw new IllegalArgumentException("can not support Set");
            }
            n nVar = new n();
            nVar.a(this.d);
            nVar.a(t, 0);
            this.f.put(str, q.b(nVar.a()));
        }
    }

    @Override // com.tencent.mapsdk.internal.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception e) {
            this.h.b(bArr);
            this.h.a(this.d);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f = this.h.a((Map) hashMap, 0, false);
        }
    }

    @Override // com.tencent.mapsdk.internal.c
    public boolean a(String str) {
        HashMap<String, byte[]> hashMap = this.f;
        return hashMap != null ? hashMap.containsKey(str) : this.f37334a.containsKey(str);
    }

    public <T> T b(String str, T t, T t2) throws b {
        HashMap<String, byte[]> hashMap = this.f;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.g.containsKey(str)) {
                    return (T) this.g.get(str);
                }
                try {
                    T t3 = (T) a(this.f.get(str), t);
                    if (t3 != null) {
                        b(str, t3);
                    }
                    return t3;
                } catch (Exception e) {
                    throw new b(e);
                }
            }
            return t2;
        } else if (this.f37334a.containsKey(str)) {
            if (this.g.containsKey(str)) {
                return (T) this.g.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f37334a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.h.b(bArr);
                this.h.a(this.d);
                T t4 = (T) this.h.a((m) t, 0, true);
                b(str, t4);
                return t4;
            } catch (Exception e2) {
                throw new b(e2);
            }
        } else {
            return t2;
        }
    }

    @Override // com.tencent.mapsdk.internal.c
    public /* bridge */ /* synthetic */ void b(String str) {
        super.b(str);
    }

    public void b(byte[] bArr) {
        super.a(bArr);
    }

    @Override // com.tencent.mapsdk.internal.c
    public byte[] b() {
        if (this.f != null) {
            n nVar = new n(0);
            nVar.a(this.d);
            nVar.a((Map) this.f, 0);
            return q.b(nVar.a());
        }
        return super.b();
    }

    public <T> T c(String str) throws b {
        return (T) a(str, true, (ClassLoader) null);
    }

    public <T> T c(String str, Object obj) {
        return (T) a(str, obj, true, null);
    }

    @Override // com.tencent.mapsdk.internal.c
    public <T> T c(String str, boolean z, ClassLoader classLoader) throws b {
        if (this.f == null) {
            return (T) super.c(str, z, classLoader);
        }
        throw new RuntimeException("data is encoded by new version, please use getJceStruct(String name,T proxy)");
    }

    @Override // com.tencent.mapsdk.internal.c
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    public void c(byte[] bArr) {
        this.h.b(bArr);
        this.h.a(this.d);
        HashMap hashMap = new HashMap(1);
        hashMap.put("", new byte[0]);
        this.f = this.h.a((Map) hashMap, 0, false);
    }

    public <T> T d(String str) throws b {
        return (T) c(str, true, null);
    }

    public <T> T d(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.f;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.g.containsKey(str)) {
                    return (T) this.g.get(str);
                }
                try {
                    T t2 = (T) a(this.f.get(str), t);
                    if (t2 != null) {
                        b(str, t2);
                    }
                    return t2;
                } catch (Exception e) {
                    throw new b(e);
                }
            }
            return null;
        } else if (this.f37334a.containsKey(str)) {
            if (this.g.containsKey(str)) {
                return (T) this.g.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f37334a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.h.b(bArr);
                this.h.a(this.d);
                T t3 = (T) this.h.a((m) t, 0, true);
                b(str, t3);
                return t3;
            } catch (Exception e2) {
                throw new b(e2);
            }
        } else {
            return null;
        }
    }

    @Override // com.tencent.mapsdk.internal.c
    public <T> T d(String str, boolean z, ClassLoader classLoader) throws b {
        HashMap<String, byte[]> hashMap = this.f;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                this.f.remove(str);
                return null;
            }
            return null;
        }
        return (T) super.d(str, z, classLoader);
    }

    @Override // com.tencent.mapsdk.internal.c
    public Set<String> d() {
        HashMap<String, byte[]> hashMap = this.f;
        return hashMap != null ? Collections.unmodifiableSet(hashMap.keySet()) : Collections.unmodifiableSet(this.f37334a.keySet());
    }

    public <T> T e(String str) throws b {
        return (T) d(str, true, null);
    }

    public <T> T e(String str, T t) throws b {
        if (this.f.containsKey(str)) {
            if (this.g.containsKey(str)) {
                return (T) this.g.get(str);
            }
            try {
                T t2 = (T) a(this.f.get(str), t);
                if (t2 != null) {
                    b(str, t2);
                }
                return t2;
            } catch (Exception e) {
                throw new b(e);
            }
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.c
    public boolean e() {
        HashMap<String, byte[]> hashMap = this.f;
        return hashMap != null ? hashMap.isEmpty() : this.f37334a.isEmpty();
    }

    @Override // com.tencent.mapsdk.internal.c
    public int f() {
        HashMap<String, byte[]> hashMap = this.f;
        return hashMap != null ? hashMap.size() : this.f37334a.size();
    }

    public <T> T f(String str, T t) throws b {
        if (this.f.containsKey(str)) {
            if (t != null) {
                return (T) a(this.f.remove(str), t);
            }
            this.f.remove(str);
            return null;
        }
        return null;
    }

    public void g() {
        this.f = new HashMap<>();
    }
}
