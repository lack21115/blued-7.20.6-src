package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/c.class */
public class c implements bq<c, e>, Serializable, Cloneable {
    public static final Map<e, cc> d;
    private static final long e = -5764118265293965743L;
    private static final cu f = new cu("IdTracking");
    private static final ck g = new ck("snapshots", (byte) 13, 1);
    private static final ck h = new ck("journals", (byte) 15, 2);
    private static final ck i = new ck("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cx>, cy> j;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f40947a;
    public List<com.umeng.commonsdk.statistics.proto.a> b;

    /* renamed from: c  reason: collision with root package name */
    public String f40948c;
    private e[] k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/c$a.class */
    public static class a extends cz<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, c cVar) throws bw {
            cpVar.j();
            while (true) {
                ck l = cpVar.l();
                if (l.b == 0) {
                    cpVar.k();
                    cVar.n();
                    return;
                }
                short s = l.f40700c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, l.b);
                        } else if (l.b == 11) {
                            cVar.f40948c = cpVar.z();
                            cVar.c(true);
                        } else {
                            cs.a(cpVar, l.b);
                        }
                    } else if (l.b == 15) {
                        cl p = cpVar.p();
                        cVar.b = new ArrayList(p.b);
                        for (int i = 0; i < p.b; i++) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(cpVar);
                            cVar.b.add(aVar);
                        }
                        cpVar.q();
                        cVar.b(true);
                    } else {
                        cs.a(cpVar, l.b);
                    }
                } else if (l.b == 13) {
                    cm n = cpVar.n();
                    cVar.f40947a = new HashMap(n.f40703c * 2);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= n.f40703c) {
                            break;
                        }
                        String z = cpVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(cpVar);
                        cVar.f40947a.put(z, bVar);
                        i2 = i3 + 1;
                    }
                    cpVar.o();
                    cVar.a(true);
                } else {
                    cs.a(cpVar, l.b);
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, c cVar) throws bw {
            cVar.n();
            cpVar.a(c.f);
            if (cVar.f40947a != null) {
                cpVar.a(c.g);
                cpVar.a(new cm((byte) 11, (byte) 12, cVar.f40947a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f40947a.entrySet()) {
                    cpVar.a(entry.getKey());
                    entry.getValue().write(cpVar);
                }
                cpVar.e();
                cpVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                cpVar.a(c.h);
                cpVar.a(new cl((byte) 12, cVar.b.size()));
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.b) {
                    aVar.write(cpVar);
                }
                cpVar.f();
                cpVar.c();
            }
            if (cVar.f40948c != null && cVar.m()) {
                cpVar.a(c.i);
                cpVar.a(cVar.f40948c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/c$b.class */
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
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/c$c.class */
    public static class C1087c extends da<c> {
        private C1087c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, c cVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(cVar.f40947a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f40947a.entrySet()) {
                cvVar.a(entry.getKey());
                entry.getValue().write(cvVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cvVar.a(bitSet, 2);
            if (cVar.j()) {
                cvVar.a(cVar.b.size());
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.b) {
                    aVar.write(cvVar);
                }
            }
            if (cVar.m()) {
                cvVar.a(cVar.f40948c);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, c cVar) throws bw {
            cv cvVar = (cv) cpVar;
            cm cmVar = new cm((byte) 11, (byte) 12, cvVar.w());
            cVar.f40947a = new HashMap(cmVar.f40703c * 2);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cmVar.f40703c) {
                    break;
                }
                String z = cvVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(cvVar);
                cVar.f40947a.put(z, bVar);
                i = i2 + 1;
            }
            cVar.a(true);
            BitSet b = cvVar.b(2);
            if (b.get(0)) {
                cl clVar = new cl((byte) 12, cvVar.w());
                cVar.b = new ArrayList(clVar.b);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= clVar.b) {
                        break;
                    }
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(cvVar);
                    cVar.b.add(aVar);
                    i3 = i4 + 1;
                }
                cVar.b(true);
            }
            if (b.get(1)) {
                cVar.f40948c = cvVar.z();
                cVar.c(true);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/c$d.class */
    static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public C1087c b() {
            return new C1087c();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/c$e.class */
    public enum e implements bx {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        
        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
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
                return JOURNALS;
            }
            return SNAPSHOTS;
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
        j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new cc("snapshots", (byte) 1, new cf((byte) 13, new cd((byte) 11), new ch((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new cc("journals", (byte) 2, new ce((byte) 15, new ch((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cc("checksum", (byte) 2, new cd((byte) 11)));
        Map<e, cc> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        cc.a(c.class, unmodifiableMap);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f40947a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f40947a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.b) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(aVar));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.f40948c = cVar.f40948c;
        }
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f40947a = map;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
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
    public c deepCopy() {
        return new c(this);
    }

    public c a(String str) {
        this.f40948c = str;
        return this;
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f40947a = map;
        return this;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f40947a == null) {
            this.f40947a = new HashMap();
        }
        this.f40947a.put(str, bVar);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f40947a = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f40947a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f40947a;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f40948c = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f40947a = null;
        this.b = null;
        this.f40948c = null;
    }

    public void d() {
        this.f40947a = null;
    }

    public boolean e() {
        return this.f40947a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public String k() {
        return this.f40948c;
    }

    public void l() {
        this.f40948c = null;
    }

    public boolean m() {
        return this.f40948c != null;
    }

    public void n() throws bw {
        if (this.f40947a != null) {
            return;
        }
        throw new cq("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f40947a;
        if (map == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
            if (list == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f40948c;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        j.get(cpVar.D()).b().a(cpVar, this);
    }
}
