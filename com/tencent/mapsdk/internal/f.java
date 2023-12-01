package com.tencent.mapsdk.internal;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f.class */
public class f extends e {
    public static final int l = 4;
    public static HashMap<String, byte[]> m;
    public static HashMap<String, HashMap<String, byte[]>> n;
    public h i;
    private int j;
    private int k;

    public f() {
        h hVar = new h();
        this.i = hVar;
        this.j = 0;
        this.k = 0;
        hVar.f23805c = (short) 2;
    }

    public f(boolean z) {
        h hVar = new h();
        this.i = hVar;
        this.j = 0;
        this.k = 0;
        if (z) {
            g();
        } else {
            hVar.f23805c = (short) 2;
        }
    }

    private void p() {
        m mVar = new m(this.i.i);
        mVar.a(this.d);
        if (n == null) {
            n = new HashMap<>();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put("", new byte[0]);
            n.put("", hashMap);
        }
        this.f23643a = mVar.a((Map) n, 0, false);
        this.b = new HashMap<>();
    }

    private void q() {
        m mVar = new m(this.i.i);
        mVar.a(this.d);
        if (m == null) {
            HashMap<String, byte[]> hashMap = new HashMap<>();
            m = hashMap;
            hashMap.put("", new byte[0]);
        }
        this.f = mVar.a((Map) m, 0, false);
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(m mVar) {
        this.i.readFrom(mVar);
    }

    public void a(n nVar) {
        this.i.writeTo(nVar);
    }

    @Override // com.tencent.mapsdk.internal.e, com.tencent.mapsdk.internal.c
    public <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public void a(StringBuilder sb, int i) {
        this.i.display(sb, i);
    }

    @Override // com.tencent.mapsdk.internal.e, com.tencent.mapsdk.internal.c
    public void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        allocate.put(bArr2).flip();
        this.j = allocate.getInt();
        try {
            m mVar = new m(bArr, 4);
            mVar.a(this.d);
            this.i.readFrom(mVar);
            if (this.i.f23805c == 3) {
                q();
                return;
            }
            this.f = null;
            p();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void b(int i) {
        this.i.f = i;
    }

    @Override // com.tencent.mapsdk.internal.e
    public void b(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        allocate.put(bArr2).flip();
        this.j = allocate.getInt();
        try {
            m mVar = new m(bArr, 4);
            mVar.a(this.d);
            this.i.readFrom(mVar);
            p();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.tencent.mapsdk.internal.e, com.tencent.mapsdk.internal.c
    public byte[] b() {
        h hVar = this.i;
        if (hVar.f23805c == 2) {
            String str = hVar.g;
            if (str == null || str.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            String str2 = this.i.h;
            if (str2 == null || str2.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        } else {
            if (hVar.g == null) {
                hVar.g = "";
            }
            if (hVar.h == null) {
                hVar.h = "";
            }
        }
        n nVar = new n(0);
        nVar.a(this.d);
        short s = this.i.f23805c;
        if (s == 2 || s == 1) {
            nVar.a((Map) this.f23643a, 0);
        } else {
            nVar.a((Map) this.f, 0);
        }
        this.i.i = q.b(nVar.a());
        n nVar2 = new n(0);
        nVar2.a(this.d);
        this.i.writeTo(nVar2);
        byte[] b = q.b(nVar2.a());
        int length = b.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(b).flip();
        return allocate.array();
    }

    @Override // com.tencent.mapsdk.internal.e
    public void c(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            m mVar = new m(bArr, 4);
            mVar.a(this.d);
            this.i.readFrom(mVar);
            q();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void f(String str) {
        this.i.h = str;
    }

    @Override // com.tencent.mapsdk.internal.e
    public void g() {
        super.g();
        this.i.f23805c = (short) 3;
    }

    public void g(String str) {
        this.i.g = str;
    }

    public byte[] h() {
        n nVar = new n(0);
        nVar.a(this.d);
        nVar.a((Map) this.f23643a, 0);
        byte[] b = q.b(nVar.a());
        n nVar2 = new n(0);
        nVar2.a(this.d);
        nVar2.a(this.i.f23805c, 1);
        nVar2.a(this.i.d, 2);
        nVar2.a(this.i.f, 3);
        nVar2.a(this.i.e, 4);
        nVar2.a(this.k, 5);
        nVar2.a(b, 6);
        nVar2.a((Map) this.i.l, 7);
        return q.b(nVar2.a());
    }

    public f i() {
        f fVar = new f();
        fVar.b(n());
        fVar.g(o());
        fVar.f(j());
        fVar.b(this.d);
        fVar.i.f23805c = this.i.f23805c;
        return fVar;
    }

    public String j() {
        return this.i.h;
    }

    public int k() {
        return this.k;
    }

    public int l() {
        return this.i.f23805c;
    }

    public int m() {
        return this.j;
    }

    public int n() {
        return this.i.f;
    }

    public String o() {
        return this.i.g;
    }
}
