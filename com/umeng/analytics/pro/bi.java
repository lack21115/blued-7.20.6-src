package com.umeng.analytics.pro;

import com.tencent.open.GameAppOperation;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bi.class */
public class bi implements bq<bi, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, cc> k;
    private static final long l = 420342210744516016L;
    private static final cu m = new cu("UMEnvelope");
    private static final ck n = new ck("version", (byte) 11, 1);
    private static final ck o = new ck("address", (byte) 11, 2);
    private static final ck p = new ck(GameAppOperation.GAME_SIGNATURE, (byte) 11, 3);
    private static final ck q = new ck("serial_num", (byte) 8, 4);
    private static final ck r = new ck("ts_secs", (byte) 8, 5);
    private static final ck s = new ck("length", (byte) 8, 6);
    private static final ck t = new ck("entity", (byte) 11, 7);
    private static final ck u = new ck(TPDownloadProxyEnum.USER_GUID, (byte) 11, 8);
    private static final ck v = new ck("checksum", (byte) 11, 9);
    private static final ck w = new ck("codex", (byte) 8, 10);
    private static final Map<Class<? extends cx>, cy> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a  reason: collision with root package name */
    public String f26966a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f26967c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bi$a.class */
    public static class a extends cz<bi> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, bi biVar) throws bw {
            cpVar.j();
            while (true) {
                ck l = cpVar.l();
                if (l.b == 0) {
                    cpVar.k();
                    if (!biVar.m()) {
                        throw new cq("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!biVar.p()) {
                        throw new cq("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (biVar.s()) {
                        biVar.G();
                        return;
                    } else {
                        throw new cq("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (l.f27009c) {
                    case 1:
                        if (l.b != 11) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.f26966a = cpVar.z();
                            biVar.a(true);
                            break;
                        }
                    case 2:
                        if (l.b != 11) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.b = cpVar.z();
                            biVar.b(true);
                            break;
                        }
                    case 3:
                        if (l.b != 11) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.f26967c = cpVar.z();
                            biVar.c(true);
                            break;
                        }
                    case 4:
                        if (l.b != 8) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.d = cpVar.w();
                            biVar.d(true);
                            break;
                        }
                    case 5:
                        if (l.b != 8) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.e = cpVar.w();
                            biVar.e(true);
                            break;
                        }
                    case 6:
                        if (l.b != 8) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.f = cpVar.w();
                            biVar.f(true);
                            break;
                        }
                    case 7:
                        if (l.b != 11) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.g = cpVar.A();
                            biVar.g(true);
                            break;
                        }
                    case 8:
                        if (l.b != 11) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.h = cpVar.z();
                            biVar.h(true);
                            break;
                        }
                    case 9:
                        if (l.b != 11) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.i = cpVar.z();
                            biVar.i(true);
                            break;
                        }
                    case 10:
                        if (l.b != 8) {
                            cs.a(cpVar, l.b);
                            break;
                        } else {
                            biVar.j = cpVar.w();
                            biVar.j(true);
                            break;
                        }
                    default:
                        cs.a(cpVar, l.b);
                        break;
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, bi biVar) throws bw {
            biVar.G();
            cpVar.a(bi.m);
            if (biVar.f26966a != null) {
                cpVar.a(bi.n);
                cpVar.a(biVar.f26966a);
                cpVar.c();
            }
            if (biVar.b != null) {
                cpVar.a(bi.o);
                cpVar.a(biVar.b);
                cpVar.c();
            }
            if (biVar.f26967c != null) {
                cpVar.a(bi.p);
                cpVar.a(biVar.f26967c);
                cpVar.c();
            }
            cpVar.a(bi.q);
            cpVar.a(biVar.d);
            cpVar.c();
            cpVar.a(bi.r);
            cpVar.a(biVar.e);
            cpVar.c();
            cpVar.a(bi.s);
            cpVar.a(biVar.f);
            cpVar.c();
            if (biVar.g != null) {
                cpVar.a(bi.t);
                cpVar.a(biVar.g);
                cpVar.c();
            }
            if (biVar.h != null) {
                cpVar.a(bi.u);
                cpVar.a(biVar.h);
                cpVar.c();
            }
            if (biVar.i != null) {
                cpVar.a(bi.v);
                cpVar.a(biVar.i);
                cpVar.c();
            }
            if (biVar.F()) {
                cpVar.a(bi.w);
                cpVar.a(biVar.j);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bi$b.class */
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
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bi$c.class */
    public static class c extends da<bi> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, bi biVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(biVar.f26966a);
            cvVar.a(biVar.b);
            cvVar.a(biVar.f26967c);
            cvVar.a(biVar.d);
            cvVar.a(biVar.e);
            cvVar.a(biVar.f);
            cvVar.a(biVar.g);
            cvVar.a(biVar.h);
            cvVar.a(biVar.i);
            BitSet bitSet = new BitSet();
            if (biVar.F()) {
                bitSet.set(0);
            }
            cvVar.a(bitSet, 1);
            if (biVar.F()) {
                cvVar.a(biVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, bi biVar) throws bw {
            cv cvVar = (cv) cpVar;
            biVar.f26966a = cvVar.z();
            biVar.a(true);
            biVar.b = cvVar.z();
            biVar.b(true);
            biVar.f26967c = cvVar.z();
            biVar.c(true);
            biVar.d = cvVar.w();
            biVar.d(true);
            biVar.e = cvVar.w();
            biVar.e(true);
            biVar.f = cvVar.w();
            biVar.f(true);
            biVar.g = cvVar.A();
            biVar.g(true);
            biVar.h = cvVar.z();
            biVar.h(true);
            biVar.i = cvVar.z();
            biVar.i(true);
            if (cvVar.b(1).get(0)) {
                biVar.j = cvVar.w();
                biVar.j(true);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bi$d.class */
    static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bi$e.class */
    public enum e implements bx {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, GameAppOperation.GAME_SIGNATURE),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, TPDownloadProxyEnum.USER_GUID),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        
        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        public static e a(String str) {
            return k.get(str);
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
            return this.l;
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.m;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        x = hashMap;
        hashMap.put(cz.class, new b());
        x.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new cc("version", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new cc("address", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new cc(GameAppOperation.GAME_SIGNATURE, (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new cc("serial_num", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new cc("ts_secs", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new cc("length", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new cc("entity", (byte) 1, new cd((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new cc(TPDownloadProxyEnum.USER_GUID, (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cc("checksum", (byte) 1, new cd((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new cc("codex", (byte) 2, new cd((byte) 8)));
        Map<e, cc> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        k = unmodifiableMap;
        cc.a(bi.class, unmodifiableMap);
    }

    public bi() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public bi(bi biVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = biVar.C;
        if (biVar.d()) {
            this.f26966a = biVar.f26966a;
        }
        if (biVar.g()) {
            this.b = biVar.b;
        }
        if (biVar.j()) {
            this.f26967c = biVar.f26967c;
        }
        this.d = biVar.d;
        this.e = biVar.e;
        this.f = biVar.f;
        if (biVar.w()) {
            this.g = br.d(biVar.g);
        }
        if (biVar.z()) {
            this.h = biVar.h;
        }
        if (biVar.C()) {
            this.i = biVar.i;
        }
        this.j = biVar.j;
    }

    public bi(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f26966a = str;
        this.b = str2;
        this.f26967c = str3;
        this.d = i;
        d(true);
        this.e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.C = (byte) 0;
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

    public String A() {
        return this.i;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public int D() {
        return this.j;
    }

    public void E() {
        this.C = bn.b(this.C, 3);
    }

    public boolean F() {
        return bn.a(this.C, 3);
    }

    public void G() throws bw {
        if (this.f26966a == null) {
            throw new cq("Required field 'version' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new cq("Required field 'address' was not present! Struct: " + toString());
        } else if (this.f26967c == null) {
            throw new cq("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new cq("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new cq("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.i != null) {
        } else {
            throw new cq("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: a */
    public bi deepCopy() {
        return new bi(this);
    }

    public bi a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public bi a(String str) {
        this.f26966a = str;
        return this;
    }

    public bi a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public bi a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f26966a = null;
    }

    public bi b(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public bi b(String str) {
        this.b = str;
        return this;
    }

    public String b() {
        return this.f26966a;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.b = null;
    }

    public bi c(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public bi c(String str) {
        this.f26967c = str;
        return this;
    }

    public void c() {
        this.f26966a = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f26967c = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.f26966a = null;
        this.b = null;
        this.f26967c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public bi d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public bi d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = bn.a(this.C, 0, z2);
    }

    public boolean d() {
        return this.f26966a != null;
    }

    @Override // com.umeng.analytics.pro.bq
    /* renamed from: e */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public bi e(String str) {
        this.i = str;
        return this;
    }

    public String e() {
        return this.b;
    }

    public void e(boolean z2) {
        this.C = bn.a(this.C, 1, z2);
    }

    public void f() {
        this.b = null;
    }

    public void f(boolean z2) {
        this.C = bn.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.g = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.f26967c;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.h = null;
    }

    public void i() {
        this.f26967c = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public void j(boolean z2) {
        this.C = bn.a(this.C, 3, z2);
    }

    public boolean j() {
        return this.f26967c != null;
    }

    public int k() {
        return this.d;
    }

    public void l() {
        this.C = bn.b(this.C, 0);
    }

    public boolean m() {
        return bn.a(this.C, 0);
    }

    public int n() {
        return this.e;
    }

    public void o() {
        this.C = bn.b(this.C, 1);
    }

    public boolean p() {
        return bn.a(this.C, 1);
    }

    public int q() {
        return this.f;
    }

    public void r() {
        this.C = bn.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        x.get(cpVar.D()).b().b(cpVar, this);
    }

    public boolean s() {
        return bn.a(this.C, 2);
    }

    public byte[] t() {
        a(br.c(this.g));
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f26966a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f26967c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            br.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.h;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.g;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        x.get(cpVar.D()).b().a(cpVar, this);
    }

    public String x() {
        return this.h;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }
}
