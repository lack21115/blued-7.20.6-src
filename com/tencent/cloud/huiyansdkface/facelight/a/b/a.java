package com.tencent.cloud.huiyansdkface.facelight.a.b;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/a/b/a.class */
public class a {
    String A;
    String B;
    String C;
    String D;
    String E;
    String F;
    String G;
    String H;
    String I;
    boolean J;
    boolean K;
    String L;
    String M;
    boolean N;
    private boolean Y;

    /* renamed from: a  reason: collision with root package name */
    boolean f21826a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    boolean f21827c;
    boolean d;
    boolean e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    WbCloudFaceVerifySdk.InputData k;
    boolean n;
    boolean o;
    boolean q;
    boolean r;
    float s;
    boolean t;
    boolean u;
    String v;
    boolean x;
    String j = "-1";
    String l = WbCloudFaceContant.LANGUAGE_ZH_CN;
    String m = WbCloudFaceContant.ID_CARD;
    boolean p = true;
    int w = 1;
    String y = WbCloudFaceContant.WHITE;
    int z = 0;
    private String O = "0";
    private String P = "0";
    private String Q = "1";
    private String R = "0";
    private String S = "";
    private String T = "";
    private String U = "";
    private String V = "";
    private String W = "";
    private String X = "";

    public String A() {
        return this.F;
    }

    public String B() {
        return this.G;
    }

    public String C() {
        return this.H;
    }

    public String D() {
        return this.I;
    }

    public boolean E() {
        return this.K;
    }

    public String F() {
        return this.L;
    }

    public String G() {
        return this.M;
    }

    public String H() {
        return this.l;
    }

    public boolean I() {
        return this.u;
    }

    public String J() {
        return this.y;
    }

    public boolean K() {
        return this.x;
    }

    public String L() {
        return this.O;
    }

    public String M() {
        return this.W;
    }

    public String N() {
        return this.V;
    }

    public boolean O() {
        return this.g;
    }

    public boolean P() {
        return this.h;
    }

    public boolean Q() {
        return this.i;
    }

    public String R() {
        return this.X;
    }

    public boolean S() {
        return this.b;
    }

    public boolean T() {
        return this.f21827c;
    }

    public String U() {
        return this.S;
    }

    public String V() {
        return this.T;
    }

    public String W() {
        if (TextUtils.isEmpty(this.U)) {
            return "";
        }
        return "androidiosappIdh5faceId" + this.U;
    }

    public boolean X() {
        return this.e;
    }

    public int Y() {
        return this.f;
    }

    public Properties Z() {
        Properties properties = new Properties();
        properties.setProperty(WbCloudFaceContant.COLOR_MODE, this.y);
        properties.setProperty("isCheckVideo", String.valueOf(this.n));
        properties.setProperty("isUploadVideo", String.valueOf(this.o));
        properties.setProperty("isPlayVoice", String.valueOf(this.u));
        properties.setProperty("camSwitch", String.valueOf(this.x));
        properties.setProperty("blinkSafetyLevel", String.valueOf(this.w));
        properties.setProperty(WbCloudFaceContant.IS_LANDSCAPE, String.valueOf(this.i));
        return properties;
    }

    public String a() {
        return this.P;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.O = str;
    }

    public String b() {
        return this.Q;
    }

    public void b(String str) {
        this.P = (TextUtils.isEmpty(str) || !WbCloudFaceContant.LANGUAGE_ZH_CN.equals(this.l)) ? "0" : "0";
    }

    public String c() {
        return this.R;
    }

    public void c(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "1";
        }
        this.Q = str2;
    }

    public void d(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "0";
        }
        this.R = str2;
    }

    public boolean d() {
        return this.Y;
    }

    public void e(String str) {
        this.V = str;
    }

    public boolean e() {
        return this.f21826a;
    }

    public void f(String str) {
        this.S = str;
    }

    public boolean f() {
        return this.d;
    }

    public void g(String str) {
        this.T = str;
    }

    public boolean g() {
        return this.N;
    }

    public String h() {
        return this.j;
    }

    public void h(String str) {
        this.U = str;
    }

    public WbCloudFaceVerifySdk.InputData i() {
        return this.k;
    }

    public void i(String str) {
        this.Y = "1".equals(str);
    }

    public int j() {
        return this.w;
    }

    public void j(String str) {
        this.W = str;
    }

    public String k() {
        return this.m;
    }

    public void k(String str) {
        this.X = str;
    }

    public boolean l() {
        return this.J;
    }

    public boolean m() {
        return this.o;
    }

    public boolean n() {
        return this.p;
    }

    public boolean o() {
        return this.q;
    }

    public boolean p() {
        return this.r;
    }

    public float q() {
        return this.s;
    }

    public boolean r() {
        return this.t;
    }

    public boolean s() {
        return this.n;
    }

    public String t() {
        return this.v;
    }

    public int u() {
        return this.z;
    }

    public String v() {
        return this.A;
    }

    public String w() {
        return this.B;
    }

    public String x() {
        return this.C;
    }

    public String y() {
        return this.D;
    }

    public String z() {
        return this.E;
    }
}
