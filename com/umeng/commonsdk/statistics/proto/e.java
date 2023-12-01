package com.umeng.commonsdk.statistics.proto;

import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cp;
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

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/e.class */
public class e implements bq<e, EnumC0919e>, Serializable, Cloneable {
    public static final Map<EnumC0919e, cc> d;
    private static final long e = 7501688097813630241L;
    private static final cu f = new cu("ImprintValue");
    private static final ck g = new ck("value", (byte) 11, 1);
    private static final ck h = new ck("ts", (byte) 10, 2);
    private static final ck i = new ck(TPDownloadProxyEnum.USER_GUID, (byte) 11, 3);
    private static final Map<Class<? extends cx>, cy> j;
    private static final int k = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f27264a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f27265c;
    private byte l;
    private EnumC0919e[] m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/e$a.class */
    public static class a extends cz<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, e eVar) throws bw {
            cpVar.j();
            while (true) {
                ck l = cpVar.l();
                if (l.b == 0) {
                    cpVar.k();
                    eVar.k();
                    return;
                }
                short s = l.f27009c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, l.b);
                        } else if (l.b == 11) {
                            eVar.f27265c = cpVar.z();
                            eVar.c(true);
                        } else {
                            cs.a(cpVar, l.b);
                        }
                    } else if (l.b == 10) {
                        eVar.b = cpVar.x();
                        eVar.b(true);
                    } else {
                        cs.a(cpVar, l.b);
                    }
                } else if (l.b == 11) {
                    eVar.f27264a = cpVar.z();
                    eVar.a(true);
                } else {
                    cs.a(cpVar, l.b);
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, e eVar) throws bw {
            eVar.k();
            cpVar.a(e.f);
            if (eVar.f27264a != null && eVar.d()) {
                cpVar.a(e.g);
                cpVar.a(eVar.f27264a);
                cpVar.c();
            }
            if (eVar.g()) {
                cpVar.a(e.h);
                cpVar.a(eVar.b);
                cpVar.c();
            }
            if (eVar.f27265c != null && eVar.j()) {
                cpVar.a(e.i);
                cpVar.a(eVar.f27265c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/e$b.class */
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
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/e$c.class */
    public static class c extends da<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, e eVar) throws bw {
            cv cvVar = (cv) cpVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            cvVar.a(bitSet, 3);
            if (eVar.d()) {
                cvVar.a(eVar.f27264a);
            }
            if (eVar.g()) {
                cvVar.a(eVar.b);
            }
            if (eVar.j()) {
                cvVar.a(eVar.f27265c);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, e eVar) throws bw {
            cv cvVar = (cv) cpVar;
            BitSet b = cvVar.b(3);
            if (b.get(0)) {
                eVar.f27264a = cvVar.z();
                eVar.a(true);
            }
            if (b.get(1)) {
                eVar.b = cvVar.x();
                eVar.b(true);
            }
            if (b.get(2)) {
                eVar.f27265c = cvVar.z();
                eVar.c(true);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/e$d.class */
    static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/e$e.class */
    public enum EnumC0919e implements bx {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, TPDownloadProxyEnum.USER_GUID);
        
        private static final Map<String, EnumC0919e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(EnumC0919e.class).iterator();
            while (it.hasNext()) {
                EnumC0919e enumC0919e = (EnumC0919e) it.next();
                d.put(enumC0919e.b(), enumC0919e);
            }
        }

        EnumC0919e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static EnumC0919e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return GUID;
                }
                return TS;
            }
            return VALUE;
        }

        public static EnumC0919e a(String str) {
            return d.get(str);
        }

        public static EnumC0919e b(int i) {
            EnumC0919e a2 = a(i);
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
        EnumMap enumMap = new EnumMap(EnumC0919e.class);
        enumMap.put((EnumMap) EnumC0919e.VALUE, (EnumC0919e) new cc("value", (byte) 2, new cd((byte) 11)));
        enumMap.put((EnumMap) EnumC0919e.TS, (EnumC0919e) new cc("ts", (byte) 2, new cd((byte) 10)));
        enumMap.put((EnumMap) EnumC0919e.GUID, (EnumC0919e) new cc(TPDownloadProxyEnum.USER_GUID, (byte) 2, new cd((byte) 11)));
        Map<EnumC0919e, cc> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        cc.a(e.class, unmodifiableMap);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0919e[]{EnumC0919e.VALUE, EnumC0919e.TS, EnumC0919e.GUID};
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.f27265c = str;
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0919e[]{EnumC0919e.VALUE, EnumC0919e.TS, EnumC0919e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f27264a = eVar.f27264a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.f27265c = eVar.f27265c;
        }
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
    public EnumC0919e fieldForId(int i2) {
        return EnumC0919e.a(i2);
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public e a(String str) {
        this.f27264a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f27264a = null;
    }

    public e b(String str) {
        this.f27265c = str;
        return this;
    }

    public String b() {
        return this.f27264a;
    }

    public void b(boolean z) {
        this.l = bn.a(this.l, 0, z);
    }

    public void c() {
        this.f27264a = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f27265c = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f27264a = null;
        b(false);
        this.b = 0L;
        this.f27265c = null;
    }

    public boolean d() {
        return this.f27264a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.l = bn.b(this.l, 0);
    }

    public boolean g() {
        return bn.a(this.l, 0);
    }

    public String h() {
        return this.f27265c;
    }

    public void i() {
        this.f27265c = null;
    }

    public boolean j() {
        return this.f27265c != null;
    }

    public void k() throws bw {
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f27264a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f27265c;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        j.get(cpVar.D()).b().a(cpVar, this);
    }
}
