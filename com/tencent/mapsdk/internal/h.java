package com.tencent.mapsdk.internal;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h.class */
public final class h extends p {

    /* renamed from: c  reason: collision with root package name */
    public short f37496c;
    public byte d;
    public int e;
    public int f;
    public String g;
    public String h;
    public byte[] i;
    public int j;
    public Map<String, String> k;
    public Map<String, String> l;
    public static final /* synthetic */ boolean o = !h.class.desiredAssertionStatus();
    public static byte[] m = null;
    public static Map<String, String> n = null;

    public h() {
        this.f37496c = (short) 0;
        this.d = (byte) 0;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.j = 0;
    }

    public h(short s, byte b, int i, int i2, String str, String str2, byte[] bArr, int i3, Map<String, String> map, Map<String, String> map2) {
        this.f37496c = (short) 0;
        this.d = (byte) 0;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.j = 0;
        this.f37496c = s;
        this.d = b;
        this.e = i;
        this.f = i2;
        this.g = str;
        this.h = str2;
        this.i = bArr;
        this.j = i3;
        this.k = map;
        this.l = map2;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void display(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a(this.f37496c, "iVersion");
        kVar.a(this.d, "cPacketType");
        kVar.a(this.e, "iMessageType");
        kVar.a(this.f, "iRequestId");
        kVar.a(this.g, "sServantName");
        kVar.a(this.h, "sFuncName");
        kVar.a(this.i, "sBuffer");
        kVar.a(this.j, "iTimeout");
        kVar.a((Map) this.k, "context");
        kVar.a((Map) this.l, "status");
    }

    public boolean equals(Object obj) {
        h hVar = (h) obj;
        return q.b(1, (int) hVar.f37496c) && q.b(1, (int) hVar.d) && q.b(1, hVar.e) && q.b(1, hVar.f) && q.a((Object) 1, (Object) hVar.g) && q.a((Object) 1, (Object) hVar.h) && q.a((Object) 1, (Object) hVar.i) && q.b(1, hVar.j) && q.a((Object) 1, (Object) hVar.k) && q.a((Object) 1, (Object) hVar.l);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        try {
            this.f37496c = mVar.a(this.f37496c, 1, true);
            this.d = mVar.a(this.d, 2, true);
            this.e = mVar.a(this.e, 3, true);
            this.f = mVar.a(this.f, 4, true);
            this.g = mVar.b(5, true);
            this.h = mVar.b(6, true);
            if (m == null) {
                m = new byte[]{0};
            }
            this.i = mVar.a(m, 7, true);
            this.j = mVar.a(this.j, 8, true);
            if (n == null) {
                HashMap hashMap = new HashMap();
                n = hashMap;
                hashMap.put("", "");
            }
            this.k = (Map) mVar.a((m) n, 9, true);
            if (n == null) {
                HashMap hashMap2 = new HashMap();
                n = hashMap2;
                hashMap2.put("", "");
            }
            this.l = (Map) mVar.a((m) n, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + i.a(this.i));
            throw new RuntimeException(e);
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.f37496c, 1);
        nVar.a(this.d, 2);
        nVar.a(this.e, 3);
        nVar.a(this.f, 4);
        nVar.a(this.g, 5);
        nVar.a(this.h, 6);
        nVar.a(this.i, 7);
        nVar.a(this.j, 8);
        nVar.a((Map) this.k, 9);
        nVar.a((Map) this.l, 10);
    }
}
