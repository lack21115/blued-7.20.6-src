package com.umeng.commonsdk.statistics.proto;

import android.net.wifi.WifiEnterpriseConfig;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cx;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/b.class */
public class b implements bq<b, e>, Serializable, Cloneable {
    public static final Map<e, cc> d;
    private static final long e = -6496538196005191531L;
    private static final cu f = new cu("IdSnapshot");
    private static final ck g = new ck(WifiEnterpriseConfig.IDENTITY_KEY, (byte) 11, 1);
    private static final ck h = new ck("ts", (byte) 10, 2);
    private static final ck i = new ck("version", (byte) 8, 3);
    private static final Map<Class<? extends cx>, cy> j;
    private static final int k = 0;
    private static final int l = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f27252a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public int f27253c;
    private byte m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/b$a.class */
    public static class a extends cz<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, b bVar) throws bw {
            cpVar.j();
            while (true) {
                ck l = cpVar.l();
                if (l.b == 0) {
                    break;
                }
                short s = l.f27009c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, l.b);
                        } else if (l.b == 8) {
                            bVar.f27253c = cpVar.w();
                            bVar.c(true);
                        } else {
                            cs.a(cpVar, l.b);
                        }
                    } else if (l.b == 10) {
                        bVar.b = cpVar.x();
                        bVar.b(true);
                    } else {
                        cs.a(cpVar, l.b);
                    }
                } else if (l.b == 11) {
                    bVar.f27252a = cpVar.z();
                    bVar.a(true);
                } else {
                    cs.a(cpVar, l.b);
                }
                cpVar.m();
            }
            cpVar.k();
            if (!bVar.g()) {
                throw new cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
            } else if (bVar.j()) {
                bVar.k();
            } else {
                throw new cq("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, b bVar) throws bw {
            bVar.k();
            cpVar.a(b.f);
            if (bVar.f27252a != null) {
                cpVar.a(b.g);
                cpVar.a(bVar.f27252a);
                cpVar.c();
            }
            cpVar.a(b.h);
            cpVar.a(bVar.b);
            cpVar.c();
            cpVar.a(b.i);
            cpVar.a(bVar.f27253c);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/b$b.class */
    static class C0916b implements cy {
        private C0916b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/b$c.class */
    public static class c extends da<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, b bVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(bVar.f27252a);
            cvVar.a(bVar.b);
            cvVar.a(bVar.f27253c);
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, b bVar) throws bw {
            cv cvVar = (cv) cpVar;
            bVar.f27252a = cvVar.z();
            bVar.a(true);
            bVar.b = cvVar.x();
            bVar.b(true);
            bVar.f27253c = cvVar.w();
            bVar.c(true);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/b$d.class */
    static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/b$e.class */
    public enum e implements bx {
        IDENTITY(1, WifiEnterpriseConfig.IDENTITY_KEY),
        TS(2, "ts"),
        VERSION(3, "version");
        
        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return VERSION;
                }
                return TS;
            }
            return IDENTITY;
        }

        public static e a(String str) {
            return d.get(str);
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cz.class, new C0916b());
        j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new cc(WifiEnterpriseConfig.IDENTITY_KEY, (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cc("ts", (byte) 1, new cd((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new cc("version", (byte) 1, new cd((byte) 8)));
        Map<e, cc> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        cc.a(b.class, unmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f27252a = bVar.f27252a;
        }
        this.b = bVar.b;
        this.f27253c = bVar.f27253c;
    }

    public b(String str, long j2, int i2) {
        this();
        this.f27252a = str;
        this.b = j2;
        b(true);
        this.f27253c = i2;
        c(true);
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public b a(int i2) {
        this.f27253c = i2;
        c(true);
        return this;
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public b a(String str) {
        this.f27252a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f27252a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public String b() {
        return this.f27252a;
    }

    public void b(boolean z) {
        this.m = bn.a(this.m, 0, z);
    }

    public void c() {
        this.f27252a = null;
    }

    public void c(boolean z) {
        this.m = bn.a(this.m, 1, z);
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f27252a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.f27253c = 0;
    }

    public boolean d() {
        return this.f27252a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.m = bn.b(this.m, 0);
    }

    public boolean g() {
        return bn.a(this.m, 0);
    }

    public int h() {
        return this.f27253c;
    }

    public void i() {
        this.m = bn.b(this.m, 1);
    }

    public boolean j() {
        return bn.a(this.m, 1);
    }

    public void k() throws bw {
        if (this.f27252a != null) {
            return;
        }
        throw new cq("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f27252a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f27253c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        j.get(cpVar.D()).b().a(cpVar, this);
    }
}
