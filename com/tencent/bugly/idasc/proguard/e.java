package com.tencent.bugly.idasc.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/e.class */
public final class e extends d {
    static HashMap<String, byte[]> h;
    static HashMap<String, HashMap<String, byte[]>> i;
    protected g g;
    private int j;

    public e() {
        g gVar = new g();
        this.g = gVar;
        this.j = 0;
        gVar.f35320a = (short) 2;
    }

    @Override // com.tencent.bugly.idasc.proguard.d, com.tencent.bugly.idasc.proguard.c
    public final <T> void a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(str)));
        }
        super.a(str, (String) t);
    }

    @Override // com.tencent.bugly.idasc.proguard.d, com.tencent.bugly.idasc.proguard.c
    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            k kVar = new k(bArr, (byte) 0);
            kVar.a(this.f35318c);
            this.g.a(kVar);
            if (this.g.f35320a == 3) {
                k kVar2 = new k(this.g.g);
                kVar2.a(this.f35318c);
                if (h == null) {
                    HashMap<String, byte[]> hashMap = new HashMap<>();
                    h = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.e = kVar2.a((Map) h, 0, false);
                return;
            }
            k kVar3 = new k(this.g.g);
            kVar3.a(this.f35318c);
            if (i == null) {
                i = new HashMap<>();
                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                hashMap2.put("", new byte[0]);
                i.put("", hashMap2);
            }
            this.f35317a = kVar3.a((Map) i, 0, false);
            this.b = new HashMap<>();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.bugly.idasc.proguard.d, com.tencent.bugly.idasc.proguard.c
    public final byte[] a() {
        if (this.g.f35320a != 2) {
            if (this.g.e == null) {
                this.g.e = "";
            }
            if (this.g.f == null) {
                this.g.f = "";
            }
        } else if (this.g.e.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else {
            if (this.g.f.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        }
        l lVar = new l(0);
        lVar.a(this.f35318c);
        lVar.a((Map) (this.g.f35320a == 2 ? this.f35317a : this.e), 0);
        this.g.g = n.a(lVar.f35325a);
        l lVar2 = new l(0);
        lVar2.a(this.f35318c);
        this.g.a(lVar2);
        byte[] a2 = n.a(lVar2.f35325a);
        int length = a2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a2).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.idasc.proguard.d
    public final void b() {
        super.b();
        this.g.f35320a = (short) 3;
    }

    public final void b(String str) {
        this.g.e = str;
    }

    public final void c() {
        this.g.d = 1;
    }

    public final void c(String str) {
        this.g.f = str;
    }
}
