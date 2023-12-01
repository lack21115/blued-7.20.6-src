package com.opos.mobad.model.b;

import com.opos.mobad.b.a.d;
import com.opos.mobad.b.a.t;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b/d.class */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26391a = com.opos.cmn.an.a.b.a("b3Bwb19hZHg=");
    public static final String b = com.opos.cmn.an.a.b.a("b3Bwb19mZWVk");

    /* renamed from: c  reason: collision with root package name */
    public static final String f26392c = com.opos.cmn.an.a.b.a("b3Bwb19jcGQ=");
    private int d;
    private String e;
    private List<com.opos.mobad.b.a.b> f;
    private long g;
    private String h;
    private t i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private com.opos.mobad.b.a.d p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private String u;
    private String v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.model.b.d$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b/d$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26393a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[d.b.values().length];
            f26393a = iArr;
            try {
                iArr[d.b.NO_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f26393a[d.b.GAME_BOX_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f26393a[d.b.GAME_BOX_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public d() {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
    }

    public d(com.opos.mobad.b.a.d dVar) {
        this(dVar, null, 0L);
    }

    public d(com.opos.mobad.b.a.d dVar, List<com.opos.mobad.b.a.b> list, long j) {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        if (dVar == null) {
            return;
        }
        this.d = dVar.p != null ? dVar.p.intValue() : -1;
        this.e = dVar.q != null ? dVar.q : "";
        long j2 = j;
        if (j <= 0) {
            int intValue = (dVar.y != null ? dVar.y : com.opos.mobad.b.a.d.h).intValue();
            j2 = intValue <= 0 ? dVar.t != null ? dVar.t.longValue() : System.currentTimeMillis() : intValue + System.currentTimeMillis();
        }
        this.g = j2;
        this.j = dVar.w.intValue();
        this.k = (dVar.x != null ? dVar.x : com.opos.mobad.b.a.d.g).intValue();
        if (list == null) {
            this.f = dVar.s;
            this.q = false;
        } else {
            this.f = list;
            this.q = true;
        }
        this.r = (dVar.A != null ? dVar.A : com.opos.mobad.b.a.d.j).intValue();
        this.h = dVar.u != null ? dVar.u : "";
        this.i = dVar.v;
        d.b bVar = dVar.z != null ? dVar.z : com.opos.mobad.b.a.d.i;
        this.m = (dVar.B != null ? dVar.B : com.opos.mobad.b.a.d.k).booleanValue();
        this.l = a(bVar);
        this.n = (dVar.C != null ? dVar.C : com.opos.mobad.b.a.d.l).intValue();
        this.o = (dVar.D != null ? dVar.D : com.opos.mobad.b.a.b.p).booleanValue();
        this.p = dVar;
        this.s = (dVar.E != null ? dVar.E : com.opos.mobad.b.a.d.n).intValue();
        this.t = (dVar.F != null ? dVar.F : com.opos.mobad.b.a.d.o).intValue();
        this.u = dVar.G;
        this.v = dVar != null ? dVar.H : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(com.opos.mobad.b.a.d.b r4) {
        /*
            r3 = this;
            r0 = 2
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.b.d.AnonymousClass1.f26393a
            r1 = r4
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r6 = r0
            r0 = r6
            r1 = 2
            if (r0 == r1) goto L1c
            r0 = r6
            r1 = 3
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r5 = r0
        L20:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.b.d.a(com.opos.mobad.b.a.d$b):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.e = str;
    }

    public boolean a() {
        return this.q;
    }

    public int b() {
        return this.r;
    }

    public com.opos.mobad.b.a.d c() {
        return this.p;
    }

    public boolean d() {
        return this.o;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public List<com.opos.mobad.b.a.b> h() {
        return this.f;
    }

    public long i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public t k() {
        return this.i;
    }

    public int l() {
        return this.j;
    }

    public int m() {
        return this.k;
    }

    public int n() {
        return this.l;
    }

    public boolean o() {
        return this.m;
    }

    public boolean p() {
        return (this.s & 1) == 1;
    }

    public boolean q() {
        return this.t == 1;
    }

    public String r() {
        return this.u;
    }

    public String s() {
        return this.v;
    }

    public String toString() {
        return "FetchAdResponse{code=" + this.d + ", msg='" + this.e + "', requestInterval='" + this.j + "', adEntityList=" + this.f + ", expireTime=" + this.g + ", respId='" + this.h + "', instantIdsEntity=" + this.i + ", dispatchMode=" + this.k + ", gameBoxType=" + this.l + "', customSkip=" + this.m + "', cacheNum=" + this.r + "', recordShowEvent=" + this.o + "', cmType=" + this.s + "', strategyState=" + this.t + "'}";
    }
}
