package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.api.ATRewardInfo;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/e.class */
public class e extends ah implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6655a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6656c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    int A;
    int B;
    public String C;
    protected int D;
    protected int E;
    protected int F;
    protected int G;
    protected double H;
    boolean I;
    int J;
    String K;
    long L;
    long M;
    String N;
    private int aA;
    private String aB;
    private int aC;
    private int aE;
    private int aF;
    private boolean aG;
    private long aH;
    private long aI;
    private String aJ;
    private String aK;
    private String aL;
    private int aM;
    private String aO;
    private String aP;
    private double aQ;
    private String aR;
    private double aS;
    private double aT;
    private ATRewardInfo aU;
    private Map<String, ATRewardInfo> aV;
    private Map<String, Object> aW;
    private String aX;
    private long aY;
    private String aZ;
    private int aw;
    private String ax;
    private String ay;
    private int az;
    private String ba;
    private int bb;
    private int bc;
    private String bd;
    private long be;
    private int bf;
    private int bg;
    private int bh;
    private int bi;
    private long bj;
    private int bl;
    private int bm;
    private int bo;
    private String bp;
    private Map<String, Object> bq;
    protected int o;
    public int t;
    public String u;
    public String v;
    int w;
    protected double x;
    String y;
    public int z;
    private int aD = -1;
    public String p = "";
    public int q = 0;
    public int r = 0;
    public int s = 0;
    private String aN = "unknow";
    private int bk = -1;
    private int bn = 1;

    private void A(String str) {
        this.C = str;
    }

    private void B(String str) {
        this.u = str;
    }

    private void C(String str) {
        this.v = str;
    }

    private void F(int i2) {
        this.q = i2;
    }

    private void G(int i2) {
        this.r = i2;
    }

    private void H(int i2) {
        this.s = i2;
    }

    private void I(int i2) {
        this.t = i2;
    }

    private JSONObject J(int i2) {
        return super.A(i2);
    }

    private void a(int i2, JSONObject jSONObject) {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 13) {
            jSONObject.put("extra", this.aZ);
        }
    }

    private double aa() {
        return this.H;
    }

    private int ab() {
        return this.bh;
    }

    private int ac() {
        return this.bg;
    }

    private String ad() {
        return this.C;
    }

    private int ae() {
        return this.z;
    }

    private void af() {
        this.z = 1;
    }

    private String ag() {
        return this.u;
    }

    private boolean ah() {
        return this.bi == 9;
    }

    private String ai() {
        return this.ax;
    }

    private String aj() {
        return this.p;
    }

    private int ak() {
        return this.q;
    }

    private int al() {
        return this.r;
    }

    private int am() {
        return this.t;
    }

    private boolean an() {
        return this.I;
    }

    private int ao() {
        return this.J;
    }

    private String ap() {
        return this.K;
    }

    private long aq() {
        return this.L;
    }

    private long ar() {
        return this.M;
    }

    private String as() {
        return this.N;
    }

    private void b(boolean z) {
        this.aG = z;
    }

    public final int A() {
        return this.aF;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0531 A[Catch: Exception -> 0x0635, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0635, blocks: (B:3:0x0006, B:5:0x0019, B:7:0x0025, B:9:0x002e, B:11:0x003b, B:13:0x0045, B:14:0x0053, B:19:0x00be, B:21:0x00ca, B:23:0x00ed, B:24:0x00fc, B:30:0x0126, B:28:0x0119, B:32:0x0130, B:38:0x019a, B:40:0x01c3, B:42:0x01ca, B:44:0x01d4, B:46:0x01da, B:48:0x01e1, B:50:0x01ef, B:54:0x0211, B:56:0x0226, B:58:0x0233, B:51:0x01fb, B:52:0x0207, B:36:0x018d, B:60:0x0264, B:68:0x029c, B:66:0x028f, B:70:0x02b5, B:76:0x0303, B:74:0x02f6, B:79:0x030f, B:83:0x0318, B:85:0x0353, B:87:0x03b2, B:89:0x03c0, B:91:0x0423, B:93:0x0469, B:104:0x053f, B:106:0x05d2, B:95:0x0476, B:97:0x04ef, B:99:0x04fc, B:102:0x0531), top: B:124:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018d A[Catch: Exception -> 0x0635, TRY_ENTER, TryCatch #0 {Exception -> 0x0635, blocks: (B:3:0x0006, B:5:0x0019, B:7:0x0025, B:9:0x002e, B:11:0x003b, B:13:0x0045, B:14:0x0053, B:19:0x00be, B:21:0x00ca, B:23:0x00ed, B:24:0x00fc, B:30:0x0126, B:28:0x0119, B:32:0x0130, B:38:0x019a, B:40:0x01c3, B:42:0x01ca, B:44:0x01d4, B:46:0x01da, B:48:0x01e1, B:50:0x01ef, B:54:0x0211, B:56:0x0226, B:58:0x0233, B:51:0x01fb, B:52:0x0207, B:36:0x018d, B:60:0x0264, B:68:0x029c, B:66:0x028f, B:70:0x02b5, B:76:0x0303, B:74:0x02f6, B:79:0x030f, B:83:0x0318, B:85:0x0353, B:87:0x03b2, B:89:0x03c0, B:91:0x0423, B:93:0x0469, B:104:0x053f, B:106:0x05d2, B:95:0x0476, B:97:0x04ef, B:99:0x04fc, B:102:0x0531), top: B:124:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0226 A[Catch: Exception -> 0x0635, TryCatch #0 {Exception -> 0x0635, blocks: (B:3:0x0006, B:5:0x0019, B:7:0x0025, B:9:0x002e, B:11:0x003b, B:13:0x0045, B:14:0x0053, B:19:0x00be, B:21:0x00ca, B:23:0x00ed, B:24:0x00fc, B:30:0x0126, B:28:0x0119, B:32:0x0130, B:38:0x019a, B:40:0x01c3, B:42:0x01ca, B:44:0x01d4, B:46:0x01da, B:48:0x01e1, B:50:0x01ef, B:54:0x0211, B:56:0x0226, B:58:0x0233, B:51:0x01fb, B:52:0x0207, B:36:0x018d, B:60:0x0264, B:68:0x029c, B:66:0x028f, B:70:0x02b5, B:76:0x0303, B:74:0x02f6, B:79:0x030f, B:83:0x0318, B:85:0x0353, B:87:0x03b2, B:89:0x03c0, B:91:0x0423, B:93:0x0469, B:104:0x053f, B:106:0x05d2, B:95:0x0476, B:97:0x04ef, B:99:0x04fc, B:102:0x0531), top: B:124:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x04ef A[Catch: Exception -> 0x0635, TryCatch #0 {Exception -> 0x0635, blocks: (B:3:0x0006, B:5:0x0019, B:7:0x0025, B:9:0x002e, B:11:0x003b, B:13:0x0045, B:14:0x0053, B:19:0x00be, B:21:0x00ca, B:23:0x00ed, B:24:0x00fc, B:30:0x0126, B:28:0x0119, B:32:0x0130, B:38:0x019a, B:40:0x01c3, B:42:0x01ca, B:44:0x01d4, B:46:0x01da, B:48:0x01e1, B:50:0x01ef, B:54:0x0211, B:56:0x0226, B:58:0x0233, B:51:0x01fb, B:52:0x0207, B:36:0x018d, B:60:0x0264, B:68:0x029c, B:66:0x028f, B:70:0x02b5, B:76:0x0303, B:74:0x02f6, B:79:0x030f, B:83:0x0318, B:85:0x0353, B:87:0x03b2, B:89:0x03c0, B:91:0x0423, B:93:0x0469, B:104:0x053f, B:106:0x05d2, B:95:0x0476, B:97:0x04ef, B:99:0x04fc, B:102:0x0531), top: B:124:0x0006 }] */
    @Override // com.anythink.core.common.e.ah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A(int r6) {
        /*
            Method dump skipped, instructions count: 1629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.e.A(int):org.json.JSONObject");
    }

    public final int B() {
        return this.az;
    }

    public final int C() {
        return this.aA;
    }

    public final String D() {
        return this.aB;
    }

    public final int E() {
        return this.aC;
    }

    public final int F() {
        return this.aD;
    }

    public final String G() {
        return this.ay;
    }

    public final int H() {
        return this.o;
    }

    public final int I() {
        return this.aw;
    }

    public final long J() {
        return this.aH;
    }

    public final long K() {
        return this.aI;
    }

    public final int L() {
        return this.bk;
    }

    public final int M() {
        return this.bo;
    }

    public final e N() {
        try {
            e eVar = (e) super.clone();
            eVar.aU = this.aU;
            eVar.bq = this.bq;
            eVar.aV = this.aV;
            eVar.aW = this.aW;
            return eVar;
        } catch (Throwable th) {
            return this;
        }
    }

    public final Map<String, Object> a() {
        return this.bq;
    }

    public final void a(double d2) {
        this.H = d2;
    }

    public final void a(int i2) {
        this.bl = i2;
    }

    public final void a(long j2) {
        this.bj = j2;
    }

    public final void a(ATRewardInfo aTRewardInfo) {
        this.aU = aTRewardInfo;
    }

    public final void a(String str) {
        this.bp = str;
    }

    public final void a(Map<String, Object> map) {
        this.bq = map;
    }

    public final void a(boolean z) {
        this.I = z;
    }

    public final int b() {
        return this.bf;
    }

    public final void b(double d2) {
        this.aT = d2;
    }

    public final void b(int i2) {
        this.bm = i2;
    }

    public final void b(long j2) {
        this.be = j2;
    }

    public final void b(String str) {
        this.bd = str;
    }

    public final void b(Map<String, ATRewardInfo> map) {
        this.aV = map;
    }

    public final void c() {
        this.bc = 1;
    }

    public final void c(double d2) {
        this.aQ = d2;
    }

    public final void c(int i2) {
        this.bi = i2;
    }

    public final void c(long j2) {
        this.aH = j2;
    }

    public final void c(String str) {
        this.ba = str;
    }

    public final void c(Map<String, Object> map) {
        this.aW = map;
    }

    public final void d() {
        if (this.bc != 1) {
            this.bb = 1;
        }
    }

    public final void d(double d2) {
        this.x = d2;
    }

    public final void d(int i2) {
        this.bh = i2;
    }

    public final void d(long j2) {
        this.aI = j2;
    }

    public final void d(String str) {
        this.aR = str;
    }

    public final String e() {
        return this.ba;
    }

    public final void e(int i2) {
        this.bg = i2;
    }

    public final void e(long j2) {
        this.L = j2;
    }

    public final void e(String str) {
        this.aX = str;
    }

    public final double f() {
        return this.aT;
    }

    public final void f(int i2) {
        this.bf = i2;
    }

    public final void f(long j2) {
        this.M = j2;
    }

    public final void f(String str) {
        this.y = str;
    }

    public final double g() {
        return this.aQ;
    }

    public final void g(int i2) {
        this.D = i2;
    }

    public final void g(String str) {
        this.aK = str;
    }

    public final String h() {
        return this.aR;
    }

    public final void h(int i2) {
        this.E = i2;
    }

    public final void h(String str) {
        this.aL = str;
    }

    public final String i() {
        return this.aX;
    }

    public final void i(int i2) {
        this.F = i2;
    }

    public final void i(String str) {
        this.aN = str;
    }

    public final String j() {
        return this.y;
    }

    public final void j(int i2) {
        this.G = i2;
    }

    public final void j(String str) {
        this.aO = str;
    }

    public final String k() {
        return this.aK;
    }

    public final void k(int i2) {
        this.aM = i2;
    }

    public final void k(String str) {
        this.aP = str;
    }

    public final String l() {
        return this.aL;
    }

    public final void l(int i2) {
        this.A = i2;
    }

    public final void l(String str) {
        this.aJ = str;
    }

    public final int m() {
        return this.aM;
    }

    public final void m(int i2) {
        this.B = i2;
    }

    public final void m(String str) {
        this.aB = str;
    }

    public final String n() {
        return this.aN;
    }

    public final void n(int i2) {
        this.w = i2;
    }

    public final void n(String str) {
        this.ay = str;
    }

    public final String o() {
        return this.aO;
    }

    public final void o(int i2) {
        this.aE = i2;
    }

    public final void o(String str) {
        this.ax = str;
    }

    public final String p() {
        return this.aP;
    }

    public final void p(int i2) {
        this.aF = i2;
    }

    public final void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.p = str;
    }

    public final Map<String, ATRewardInfo> q() {
        return this.aV;
    }

    public final void q(int i2) {
        this.az = i2;
    }

    public final void q(String str) {
        this.aZ = str;
    }

    public final ATRewardInfo r() {
        return this.aU;
    }

    public final void r(int i2) {
        this.aA = i2;
    }

    public final void r(String str) {
        this.K = str;
    }

    public final Map<String, Object> s() {
        return this.aW;
    }

    public final void s(int i2) {
        this.aC = i2;
    }

    public final void s(String str) {
        this.N = str;
    }

    public final int t() {
        return this.A;
    }

    public final void t(int i2) {
        this.aD = i2;
    }

    public final int u() {
        return this.B;
    }

    public final void u(int i2) {
        this.o = i2;
    }

    public final int v() {
        return this.w;
    }

    public final void v(int i2) {
        this.aw = i2;
    }

    public final double w() {
        return this.x;
    }

    public final void w(int i2) {
        this.bk = i2;
    }

    public final String x() {
        return this.aJ;
    }

    public final void x(int i2) {
        this.bn = i2;
    }

    public final int y() {
        int i2 = this.bi;
        if (i2 != 8) {
            return i2 != 9 ? 0 : 1;
        }
        return 2;
    }

    public final void y(int i2) {
        this.bo = i2;
    }

    public final int z() {
        return this.aE;
    }

    public final void z(int i2) {
        this.J = i2;
    }
}
