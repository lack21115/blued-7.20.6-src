package com.tencent.qimei.v;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/h.class */
public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f24736a;
    public final b b;

    public h(String str, b bVar) {
        this.f24736a = str;
        this.b = bVar;
    }

    @Override // com.tencent.qimei.v.b
    public String A() {
        return this.b.A();
    }

    @Override // com.tencent.qimei.v.b
    public boolean B() {
        return com.tencent.qimei.w.a.KEY_DATA_ENABLE_REPORT.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public int C() {
        return com.tencent.qimei.w.b.KEY_DATA_QM_REPORT_RATE.a(this.f24736a).intValue();
    }

    @Override // com.tencent.qimei.v.b
    public String D() {
        return this.b.D();
    }

    @Override // com.tencent.qimei.v.b
    public boolean E() {
        return this.b.E() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_EI.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean F() {
        return this.b.F() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_SI.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean G() {
        return com.tencent.qimei.w.a.KEY_DATA_ENABLE_Q36.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public String a() {
        return this.b.a();
    }

    @Override // com.tencent.qimei.v.b
    public boolean b() {
        return com.tencent.qimei.w.a.KEY_DATA_ENABLE_USERID.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public int c() {
        return com.tencent.qimei.w.b.KEY_DATA_QM_JS_TIME.a(this.f24736a).intValue();
    }

    @Override // com.tencent.qimei.v.b
    public String d() {
        return this.b.d();
    }

    @Override // com.tencent.qimei.v.b
    public String e() {
        return this.b.e();
    }

    @Override // com.tencent.qimei.v.b
    public boolean f() {
        return com.tencent.qimei.w.a.KEY_DATA_ENABLE_OZ.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public String g() {
        return com.tencent.qimei.w.d.KEY_DATA_PEAK_TIME.a(this.f24736a);
    }

    @Override // com.tencent.qimei.v.b
    public boolean h() {
        return this.b.h() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_OD.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean i() {
        return com.tencent.qimei.w.a.KEY_DATA_ENABLE_Q16.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean j() {
        return this.b.j();
    }

    @Override // com.tencent.qimei.v.b
    public int k() {
        return com.tencent.qimei.w.b.KEY_DATA_QM_X5_TIME.a(this.f24736a).intValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean l() {
        return com.tencent.qimei.w.a.KEY_DATA_FORCE_UPDATE_QM.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public String m() {
        return this.b.m();
    }

    @Override // com.tencent.qimei.v.b
    public boolean n() {
        return this.b.n() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_CD.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public String o() {
        return this.b.o();
    }

    @Override // com.tencent.qimei.v.b
    public String p() {
        return this.b.p();
    }

    @Override // com.tencent.qimei.v.b
    public boolean q() {
        return this.b.q() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_MC.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public String r() {
        return com.tencent.qimei.w.d.KEY_DATA_VERSION.a(this.f24736a);
    }

    @Override // com.tencent.qimei.v.b
    public int s() {
        return com.tencent.qimei.w.b.KEY_DATA_QM_ARDT.a(this.f24736a).intValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean t() {
        return com.tencent.qimei.w.a.KEY_DATA_ENABLE_BEACON_ID.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public String u() {
        return com.tencent.qimei.w.d.KEY_DATA_QM_REQUEST_URL.a(this.f24736a);
    }

    @Override // com.tencent.qimei.v.b
    public boolean v() {
        return this.b.v() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_AUDIT.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean w() {
        return com.tencent.qimei.w.a.KEY_DATA_ENABLE_OO.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public int x() {
        return com.tencent.qimei.w.b.KEY_DATA_QM_MIN_HID_RUN.a(this.f24736a).intValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean y() {
        return this.b.y() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_AD.a(this.f24736a).booleanValue();
    }

    @Override // com.tencent.qimei.v.b
    public boolean z() {
        return this.b.z() & com.tencent.qimei.w.a.KEY_DATA_ENABLE_PROCESS_INFO.a(this.f24736a).booleanValue();
    }
}
