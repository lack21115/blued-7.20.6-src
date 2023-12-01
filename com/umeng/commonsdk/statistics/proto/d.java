package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cm;
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

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/d.class */
public class d implements bq<d, e>, Serializable, Cloneable {
    public static final Map<e, cc> d;
    private static final long e = 2846460275012375038L;
    private static final cu f = new cu("Imprint");
    private static final ck g = new ck("property", (byte) 13, 1);
    private static final ck h = new ck("version", (byte) 8, 2);
    private static final ck i = new ck("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cx>, cy> j;
    private static final int k = 0;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f27260a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f27261c;
    private byte l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/d$a.class */
    public static class a extends cz<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, d dVar) throws bw {
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
                        } else if (l.b == 11) {
                            dVar.f27261c = cpVar.z();
                            dVar.c(true);
                        } else {
                            cs.a(cpVar, l.b);
                        }
                    } else if (l.b == 8) {
                        dVar.b = cpVar.w();
                        dVar.b(true);
                    } else {
                        cs.a(cpVar, l.b);
                    }
                } else if (l.b == 13) {
                    cm n = cpVar.n();
                    dVar.f27260a = new HashMap(n.f27012c * 2);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= n.f27012c) {
                            break;
                        }
                        String z = cpVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(cpVar);
                        dVar.f27260a.put(z, eVar);
                        i = i2 + 1;
                    }
                    cpVar.o();
                    dVar.a(true);
                } else {
                    cs.a(cpVar, l.b);
                }
                cpVar.m();
            }
            cpVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new cq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, d dVar) throws bw {
            dVar.l();
            cpVar.a(d.f);
            if (dVar.f27260a != null) {
                cpVar.a(d.g);
                cpVar.a(new cm((byte) 11, (byte) 12, dVar.f27260a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f27260a.entrySet()) {
                    cpVar.a(entry.getKey());
                    entry.getValue().write(cpVar);
                }
                cpVar.e();
                cpVar.c();
            }
            cpVar.a(d.h);
            cpVar.a(dVar.b);
            cpVar.c();
            if (dVar.f27261c != null) {
                cpVar.a(d.i);
                cpVar.a(dVar.f27261c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/d$b.class */
    static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/d$c.class */
    public static class c extends da<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, d dVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(dVar.f27260a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f27260a.entrySet()) {
                cvVar.a(entry.getKey());
                entry.getValue().write(cvVar);
            }
            cvVar.a(dVar.b);
            cvVar.a(dVar.f27261c);
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, d dVar) throws bw {
            cv cvVar = (cv) cpVar;
            cm cmVar = new cm((byte) 11, (byte) 12, cvVar.w());
            dVar.f27260a = new HashMap(cmVar.f27012c * 2);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cmVar.f27012c) {
                    dVar.a(true);
                    dVar.b = cvVar.w();
                    dVar.b(true);
                    dVar.f27261c = cvVar.z();
                    dVar.c(true);
                    return;
                }
                String z = cvVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(cvVar);
                dVar.f27260a.put(z, eVar);
                i = i2 + 1;
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/d$d.class */
    static class C0918d implements cy {
        private C0918d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/d$e.class */
    public enum e implements bx {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        
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
                    return CHECKSUM;
                }
                return VERSION;
            }
            return PROPERTY;
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
        hashMap.put(cz.class, new b());
        j.put(da.class, new C0918d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new cc("property", (byte) 1, new cf((byte) 13, new cd((byte) 11), new ch((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new cc("version", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cc("checksum", (byte) 1, new cd((byte) 11)));
        Map<e, cc> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        cc.a(d.class, unmodifiableMap);
    }

    public d() {
        this.l = (byte) 0;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f27260a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f27260a = hashMap;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.f27261c = dVar.f27261c;
        }
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f27260a = map;
        this.b = i2;
        b(true);
        this.f27261c = str;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = (byte) 0;
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
    public d deepCopy() {
        return new d(this);
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public d a(String str) {
        this.f27261c = str;
        return this;
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f27260a = map;
        return this;
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f27260a == null) {
            this.f27260a = new HashMap();
        }
        this.f27260a.put(str, eVar);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f27260a = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f27260a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public void b(boolean z) {
        this.l = bn.a(this.l, 0, z);
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f27260a;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f27261c = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f27260a = null;
        b(false);
        this.b = 0;
        this.f27261c = null;
    }

    public void d() {
        this.f27260a = null;
    }

    public boolean e() {
        return this.f27260a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.l = bn.b(this.l, 0);
    }

    public boolean h() {
        return bn.a(this.l, 0);
    }

    public String i() {
        return this.f27261c;
    }

    public void j() {
        this.f27261c = null;
    }

    public boolean k() {
        return this.f27261c != null;
    }

    public void l() throws bw {
        if (this.f27260a == null) {
            throw new cq("Required field 'property' was not present! Struct: " + toString());
        } else if (this.f27261c != null) {
        } else {
            throw new cq("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f27260a;
        if (map == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f27261c;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        j.get(cpVar.D()).b().a(cpVar, this);
    }
}
