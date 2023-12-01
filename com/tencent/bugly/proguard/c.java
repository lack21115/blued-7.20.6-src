package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/c.class */
public class c extends a {
    protected HashMap<String, byte[]> d = null;
    private HashMap<String, Object> e = new HashMap<>();
    private i f = new i();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(String str, T t) {
        if (this.d == null) {
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
            j jVar = new j();
            jVar.a(this.b);
            jVar.a(t, 0);
            this.d.put(str, l.a(jVar.a()));
        }
    }

    @Override // com.tencent.bugly.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception e) {
            this.f.a(bArr);
            this.f.a(this.b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.d = this.f.a((Map) hashMap, 0, false);
        }
    }

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.d != null) {
            j jVar = new j(0);
            jVar.a(this.b);
            jVar.a((Map) this.d, 0);
            return l.a(jVar.a());
        }
        return super.a();
    }

    public final <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.d;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.e.containsKey(str)) {
                    return (T) this.e.get(str);
                }
                try {
                    this.f.a(this.d.get(str));
                    this.f.a(this.b);
                    T t2 = (T) this.f.a((i) t, 0, true);
                    if (t2 != null) {
                        this.e.put(str, t2);
                    }
                    return t2;
                } catch (Exception e) {
                    throw new b(e);
                }
            }
            return null;
        } else if (this.f35356a.containsKey(str)) {
            if (this.e.containsKey(str)) {
                return (T) this.e.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f35356a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f.a(bArr);
                this.f.a(this.b);
                T t3 = (T) this.f.a((i) t, 0, true);
                this.e.put(str, t3);
                return t3;
            } catch (Exception e2) {
                throw new b(e2);
            }
        } else {
            return null;
        }
    }

    public void c() {
        this.d = new HashMap<>();
    }
}
