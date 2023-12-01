package com.tencent.bugly.idasc.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/d.class */
public class d extends c {
    protected HashMap<String, byte[]> e = null;
    private HashMap<String, Object> g = new HashMap<>();
    k f = new k();

    private void c(String str, Object obj) {
        this.g.put(str, obj);
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public <T> void a(String str, T t) {
        if (this.e == null) {
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
            l lVar = new l();
            lVar.a(this.f21627c);
            lVar.a(t, 0);
            this.e.put(str, n.a(lVar.f21634a));
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception e) {
            this.f.a(bArr);
            this.f.a(this.f21627c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.e = this.f.a((Map) hashMap, 0, false);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public byte[] a() {
        if (this.e != null) {
            l lVar = new l(0);
            lVar.a(this.f21627c);
            lVar.a((Map) this.e, 0);
            return n.a(lVar.f21634a);
        }
        return super.a();
    }

    public final <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (!this.g.containsKey(str)) {
                try {
                    this.f.a(this.e.get(str));
                    this.f.a(this.f21627c);
                    T t2 = (T) this.f.a((k) t, 0, true);
                    if (t2 != null) {
                        c(str, t2);
                    }
                    return t2;
                } catch (Exception e) {
                    throw new b(e);
                }
            }
        } else if (!this.f21626a.containsKey(str)) {
            return null;
        } else {
            if (!this.g.containsKey(str)) {
                byte[] bArr = new byte[0];
                Iterator<Map.Entry<String, byte[]>> it = this.f21626a.get(str).entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<String, byte[]> next = it.next();
                    next.getKey();
                    bArr = next.getValue();
                }
                try {
                    this.f.a(bArr);
                    this.f.a(this.f21627c);
                    T t3 = (T) this.f.a((k) t, 0, true);
                    c(str, t3);
                    return t3;
                } catch (Exception e2) {
                    throw new b(e2);
                }
            }
        }
        return (T) this.g.get(str);
    }

    public void b() {
        this.e = new HashMap<>();
    }
}
