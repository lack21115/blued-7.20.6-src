package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/l.class */
public class l extends c implements f {
    private int B;
    private int C;
    private String D;
    private int E;
    private MetaData F;
    private List<Integer> G;
    private boolean H;
    private String J;
    private String K;
    private String L;
    private String Q;
    private boolean R;
    private String S;
    private String T;
    private boolean W;
    private boolean aa;
    private String ab;
    private String ad;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f22972c;
    private String d;
    private String e;
    private int f;
    private int g;
    private String h;
    private boolean i;
    private boolean j;
    private int k;
    private String m;
    private String n;
    private String r;
    private long s;
    private int t;
    private String u;
    private String v;
    private v w;
    private List<String> x;
    private List<String> y;
    private AppInfo z;

    public l(AdContentData adContentData) {
        super(adContentData);
        this.i = false;
        this.j = false;
        this.H = false;
        this.R = false;
        this.W = false;
        this.aa = false;
    }

    public void B(int i) {
        this.t = i;
    }

    public void B(String str) {
        this.h = str;
    }

    public void B(boolean z) {
        this.R = z;
    }

    public v C() {
        return this.w;
    }

    public void C(int i) {
        this.E = i;
    }

    public void C(String str) {
        this.d = str;
    }

    public void Code(int i) {
        this.b = i;
    }

    public void Code(MetaData metaData) {
        this.F = metaData;
    }

    public void Code(AdContentData adContentData) {
        this.Code = adContentData;
    }

    public void Code(AppInfo appInfo) {
        this.z = appInfo;
    }

    public void Code(v vVar) {
        this.w = vVar;
    }

    public void Code(boolean z) {
        this.i = z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String D() {
        return this.S;
    }

    public void D(String str) {
        this.m = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String F() {
        return this.D;
    }

    public void F(int i) {
        this.C = i;
    }

    public void I(int i) {
        this.g = i;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public void I(String str) {
        this.V = str;
    }

    public void I(List<String> list) {
        this.y = list;
    }

    public boolean I() {
        return this.i;
    }

    public void L(String str) {
        this.n = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String N() {
        return this.V;
    }

    public void S(int i) {
        this.B = i;
    }

    public void S(String str) {
        this.e = str;
    }

    public void S(boolean z) {
        this.aa = z;
    }

    public String T() {
        return this.h;
    }

    public void V(int i) {
        this.f = i;
    }

    public void V(long j) {
        this.s = j;
    }

    public void V(List<String> list) {
        this.x = list;
    }

    public void V(boolean z) {
        this.j = z;
    }

    public void Z(int i) {
        this.k = i;
    }

    public void Z(String str) {
        this.f22972c = str;
    }

    public void Z(List<Integer> list) {
        this.G = list;
    }

    public void Z(boolean z) {
        this.H = z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public int a() {
        return this.C;
    }

    public void a(String str) {
        this.r = str;
    }

    public List<AdvertiserInfo> aA() {
        if (this.Code == null) {
            return null;
        }
        return this.Code.aG();
    }

    public String af() {
        return this.u;
    }

    public String ag() {
        return this.v;
    }

    public boolean ak() {
        return this.H;
    }

    public boolean ap() {
        return this.R;
    }

    public boolean av() {
        return this.aa;
    }

    public AdContentData ax() {
        return this.Code;
    }

    public void b(String str) {
        this.u = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String c() {
        return this.L;
    }

    public void c(String str) {
        this.v = str;
    }

    public void e(String str) {
        this.J = str;
    }

    public void f(String str) {
        this.K = str;
    }

    public void i(String str) {
        this.Q = str;
    }

    public void j(String str) {
        this.T = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public MetaData k() {
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String m() {
        return this.Q;
    }

    public void m(String str) {
        this.ab = str;
    }

    public void n(String str) {
        this.S = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String o() {
        return this.ab;
    }

    public void o(String str) {
        this.D = str;
    }

    public void p(String str) {
        this.L = str;
    }

    public void q(String str) {
        this.ad = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public long r() {
        return this.s;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public int s() {
        return this.t;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public AppInfo v() {
        return this.z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String z() {
        return this.K;
    }
}
