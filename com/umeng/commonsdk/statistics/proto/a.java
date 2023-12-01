package com.umeng.commonsdk.statistics.proto;

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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/a.class */
public class a implements bq<a, e>, Serializable, Cloneable {
    public static final Map<e, cc> e;
    private static final long f = 9132678615281394583L;
    private static final cu g = new cu("IdJournal");
    private static final ck h = new ck("domain", (byte) 11, 1);
    private static final ck i = new ck("old_id", (byte) 11, 2);
    private static final ck j = new ck("new_id", (byte) 11, 3);
    private static final ck k = new ck("ts", (byte) 10, 4);
    private static final Map<Class<? extends cx>, cy> l;
    private static final int m = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f40939a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f40940c;
    public long d;
    private byte n;
    private e[] o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/a$a.class */
    public static class C1085a extends cz<a> {
        private C1085a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, a aVar) throws bw {
            cpVar.j();
            while (true) {
                ck l = cpVar.l();
                if (l.b == 0) {
                    break;
                }
                short s = l.f40700c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                cs.a(cpVar, l.b);
                            } else if (l.b == 10) {
                                aVar.d = cpVar.x();
                                aVar.d(true);
                            } else {
                                cs.a(cpVar, l.b);
                            }
                        } else if (l.b == 11) {
                            aVar.f40940c = cpVar.z();
                            aVar.c(true);
                        } else {
                            cs.a(cpVar, l.b);
                        }
                    } else if (l.b == 11) {
                        aVar.b = cpVar.z();
                        aVar.b(true);
                    } else {
                        cs.a(cpVar, l.b);
                    }
                } else if (l.b == 11) {
                    aVar.f40939a = cpVar.z();
                    aVar.a(true);
                } else {
                    cs.a(cpVar, l.b);
                }
                cpVar.m();
            }
            cpVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, a aVar) throws bw {
            aVar.n();
            cpVar.a(a.g);
            if (aVar.f40939a != null) {
                cpVar.a(a.h);
                cpVar.a(aVar.f40939a);
                cpVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                cpVar.a(a.i);
                cpVar.a(aVar.b);
                cpVar.c();
            }
            if (aVar.f40940c != null) {
                cpVar.a(a.j);
                cpVar.a(aVar.f40940c);
                cpVar.c();
            }
            cpVar.a(a.k);
            cpVar.a(aVar.d);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/a$b.class */
    static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public C1085a b() {
            return new C1085a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/a$c.class */
    public static class c extends da<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, a aVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(aVar.f40939a);
            cvVar.a(aVar.f40940c);
            cvVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cvVar.a(bitSet, 1);
            if (aVar.g()) {
                cvVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, a aVar) throws bw {
            cv cvVar = (cv) cpVar;
            aVar.f40939a = cvVar.z();
            aVar.a(true);
            aVar.f40940c = cvVar.z();
            aVar.c(true);
            aVar.d = cvVar.x();
            aVar.d(true);
            if (cvVar.b(1).get(0)) {
                aVar.b = cvVar.z();
                aVar.b(true);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/a$d.class */
    static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/a$e.class */
    public enum e implements bx {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        
        private static final Map<String, e> e = new HashMap();
        private final short f;
        private final String g;

        static {
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public static e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return TS;
                    }
                    return NEW_ID;
                }
                return OLD_ID;
            }
            return DOMAIN;
        }

        public static e a(String str) {
            return e.get(str);
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
            return this.f;
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.g;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        l = hashMap;
        hashMap.put(cz.class, new b());
        l.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new cc("domain", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new cc("old_id", (byte) 2, new cd((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new cc("new_id", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cc("ts", (byte) 1, new cd((byte) 10)));
        Map<e, cc> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        e = unmodifiableMap;
        cc.a(a.class, unmodifiableMap);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f40939a = aVar.f40939a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.f40940c = aVar.f40940c;
        }
        this.d = aVar.d;
    }

    public a(String str, String str2, long j2) {
        this();
        this.f40939a = str;
        this.f40940c = str2;
        this.d = j2;
        d(true);
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
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
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    public a a(long j2) {
        this.d = j2;
        d(true);
        return this;
    }

    public a a(String str) {
        this.f40939a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f40939a = null;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public String b() {
        return this.f40939a;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public a c(String str) {
        this.f40940c = str;
        return this;
    }

    public void c() {
        this.f40939a = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f40940c = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f40939a = null;
        this.b = null;
        this.f40940c = null;
        d(false);
        this.d = 0L;
    }

    public void d(boolean z) {
        this.n = bn.a(this.n, 0, z);
    }

    public boolean d() {
        return this.f40939a != null;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.f40940c;
    }

    public void i() {
        this.f40940c = null;
    }

    public boolean j() {
        return this.f40940c != null;
    }

    public long k() {
        return this.d;
    }

    public void l() {
        this.n = bn.b(this.n, 0);
    }

    public boolean m() {
        return bn.a(this.n, 0);
    }

    public void n() throws bw {
        if (this.f40939a == null) {
            throw new cq("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.f40940c != null) {
        } else {
            throw new cq("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        l.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f40939a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f40940c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        l.get(cpVar.D()).b().a(cpVar, this);
    }
}
