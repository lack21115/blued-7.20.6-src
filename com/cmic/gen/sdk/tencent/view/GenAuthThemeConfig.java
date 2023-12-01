package com.cmic.gen.sdk.tencent.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.util.regex.Pattern;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/GenAuthThemeConfig.class */
public class GenAuthThemeConfig {
    public static final String PLACEHOLDER = "$$运营商条款$$";
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private String F;
    private boolean G;
    private GenBackPressedListener H;
    private GenLoginClickListener I;
    private GenCheckBoxListener J;
    private GenCheckedChangeListener K;
    private String L;
    private String M;
    private int N;
    private int O;
    private boolean P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    private int f21679a;
    private boolean aa;
    private int ab;
    private int ac;
    private boolean ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private boolean aj;
    private String ak;
    private String al;
    private String am;
    private String an;
    private int ao;
    private int ap;
    private int aq;

    /* renamed from: ar  reason: collision with root package name */
    private int f21680ar;
    private int as;
    private int at;
    private int au;
    private boolean av;
    private boolean aw;
    private String ax;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private View f21681c;
    private int d;
    private int e;
    private String f;
    private int g;
    private int h;
    private int i;
    private String j;
    private int k;
    private int l;
    private ImageView.ScaleType m;
    private int n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private String t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private String y;
    private int z;

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/GenAuthThemeConfig$Builder.class */
    public static class Builder {
        private String F;
        private boolean G;
        private GenBackPressedListener H;
        private GenLoginClickListener I;
        private GenCheckBoxListener J;
        private GenCheckedChangeListener K;
        private int aj;
        private String ak;
        private String al;
        private String am;
        private String an;
        private int ao;
        private int ap;
        private int aq;

        /* renamed from: ar  reason: collision with root package name */
        private int f21683ar;
        private String ax;
        private String f;

        /* renamed from: a  reason: collision with root package name */
        private int f21682a = 0;
        private boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private View f21684c = null;
        private int d = -1;
        private int e = -1;
        private int g = 17;
        private int h = -1;
        private int i = -16742704;
        private String j = "return_bg";
        private int k = -2;
        private int l = -2;
        private ImageView.ScaleType m = ImageView.ScaleType.CENTER;
        private int n = 18;
        private boolean o = false;
        private int p = -16742704;
        private int q = 0;
        private int r = 184;
        private int s = 0;
        private String t = "本机号码一键登录";
        private boolean u = true;
        private int v = 15;
        private boolean w = false;
        private int x = -1;
        private String y = "umcsdk_login_btn_bg";
        private int z = -1;
        private int A = 36;
        private int B = 46;
        private int C = 46;
        private int D = 254;
        private int E = 0;
        private String L = "umcsdk_check_image";
        private String M = "umcsdk_uncheck_image";
        private int N = 9;
        private int O = 9;
        private boolean P = false;
        private String Q = "登录即同意$$运营商条款$$并使用本机号码登录";
        private String R = null;
        private String S = null;
        private String T = null;
        private String U = null;
        private String V = null;
        private String W = null;
        private String X = null;
        private String Y = null;
        private int Z = 10;
        private boolean aa = false;
        private int ab = -10066330;
        private int ac = -16007674;
        private boolean ad = false;
        private int ae = 52;
        private int af = 52;
        private int ag = 0;
        private int ah = 30;
        private boolean ai = true;
        private int as = 0;
        private int at = -1;
        private int au = 0;
        private boolean av = true;
        private boolean aw = true;

        public GenAuthThemeConfig build() {
            return new GenAuthThemeConfig(this);
        }

        public Builder setAppLanguageType(int i) {
            this.au = i;
            return this;
        }

        public Builder setAuthContentView(View view) {
            this.f21684c = view;
            this.d = -1;
            return this;
        }

        public Builder setAuthLayoutResID(int i) {
            this.d = i;
            this.f21684c = null;
            return this;
        }

        public Builder setAuthPageActIn(String str, String str2) {
            this.ak = str;
            this.al = str2;
            return this;
        }

        public Builder setAuthPageActOut(String str, String str2) {
            this.am = str2;
            this.an = str;
            return this;
        }

        public Builder setAuthPageWindowMode(int i, int i2) {
            this.ao = i;
            this.ap = i2;
            return this;
        }

        public Builder setAuthPageWindowOffset(int i, int i2) {
            this.aq = i;
            this.f21683ar = i2;
            return this;
        }

        public Builder setBackButton(boolean z) {
            this.aw = z;
            return this;
        }

        public Builder setCheckBoxImgPath(String str, String str2, int i, int i2) {
            this.L = str;
            this.M = str2;
            this.N = i;
            this.O = i2;
            return this;
        }

        public Builder setCheckBoxLocation(int i) {
            this.aj = i;
            return this;
        }

        public Builder setCheckTipText(String str) {
            boolean z = TextUtils.isEmpty(str) || str.length() > 100;
            this.G = z;
            if (z) {
                str = "请勾选同意服务条款";
            }
            this.F = str;
            return this;
        }

        public Builder setCheckedImgPath(String str) {
            this.L = str;
            return this;
        }

        public Builder setClauseColor(int i, int i2) {
            this.ab = i;
            this.ac = i2;
            return this;
        }

        public Builder setClauseLayoutResID(int i, String str) {
            this.e = i;
            this.f = str;
            return this;
        }

        public Builder setFitsSystemWindows(boolean z) {
            this.av = z;
            return this;
        }

        public Builder setGenBackPressedListener(GenBackPressedListener genBackPressedListener) {
            this.H = genBackPressedListener;
            return this;
        }

        public Builder setGenCheckBoxListener(GenCheckBoxListener genCheckBoxListener) {
            this.J = genCheckBoxListener;
            return this;
        }

        public Builder setGenCheckedChangeListener(GenCheckedChangeListener genCheckedChangeListener) {
            this.K = genCheckedChangeListener;
            return this;
        }

        public Builder setLogBtn(int i, int i2) {
            this.z = i;
            this.A = i2;
            return this;
        }

        public Builder setLogBtnClickListener(GenLoginClickListener genLoginClickListener) {
            this.I = genLoginClickListener;
            return this;
        }

        public Builder setLogBtnImgPath(String str) {
            this.y = str;
            return this;
        }

        public Builder setLogBtnMargin(int i, int i2) {
            this.B = i;
            this.C = i2;
            return this;
        }

        public Builder setLogBtnOffsetY(int i) {
            this.D = i;
            this.E = 0;
            return this;
        }

        public Builder setLogBtnOffsetY_B(int i) {
            this.E = i;
            this.D = 0;
            return this;
        }

        public Builder setLogBtnText(String str) {
            if (!TextUtils.isEmpty(str) && !Pattern.compile("^\\s*\\n*$").matcher(str).matches()) {
                this.t = str;
                this.u = false;
            }
            return this;
        }

        public Builder setLogBtnText(String str, int i, int i2, boolean z) {
            if (!TextUtils.isEmpty(str) && !Pattern.compile("^\\s*\\n*$").matcher(str).matches()) {
                this.t = str;
                this.u = false;
            }
            this.x = i;
            this.v = i2;
            this.w = z;
            return this;
        }

        public Builder setLogBtnTextColor(int i) {
            this.x = i;
            return this;
        }

        public Builder setNavColor(int i) {
            this.i = i;
            return this;
        }

        public Builder setNavTextColor(int i) {
            this.h = i;
            return this;
        }

        public Builder setNavTextSize(int i) {
            this.g = i;
            return this;
        }

        public Builder setNumFieldOffsetY(int i) {
            this.r = i;
            this.s = 0;
            return this;
        }

        public Builder setNumFieldOffsetY_B(int i) {
            this.s = i;
            this.r = 0;
            return this;
        }

        public Builder setNumberColor(int i) {
            this.p = i;
            return this;
        }

        public Builder setNumberOffsetX(int i) {
            this.q = i;
            return this;
        }

        public Builder setNumberSize(int i, boolean z) {
            if (i > 8) {
                this.n = i;
                this.o = z;
            }
            return this;
        }

        public Builder setPrivacyAlignment(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            if (str.contains(GenAuthThemeConfig.PLACEHOLDER)) {
                this.Q = str;
                this.R = str2;
                this.S = str3;
                this.T = str4;
                this.U = str5;
                this.V = str6;
                this.W = str7;
                this.X = str8;
                this.Y = str9;
            }
            return this;
        }

        public Builder setPrivacyAnimation(String str) {
            this.ax = str;
            return this;
        }

        public Builder setPrivacyBookSymbol(boolean z) {
            this.ai = z;
            return this;
        }

        public Builder setPrivacyMargin(int i, int i2) {
            this.ae = i;
            this.af = i2;
            return this;
        }

        public Builder setPrivacyOffsetY(int i) {
            this.ag = i;
            this.ah = 0;
            return this;
        }

        public Builder setPrivacyOffsetY_B(int i) {
            this.ah = i;
            this.ag = 0;
            return this;
        }

        public Builder setPrivacyState(boolean z) {
            this.P = z;
            return this;
        }

        public Builder setPrivacyText(int i, int i2, int i3, boolean z, boolean z2) {
            this.Z = i;
            this.ab = i2;
            this.ac = i3;
            this.ad = z;
            this.aa = z2;
            return this;
        }

        public Builder setStatusBar(int i, boolean z) {
            this.f21682a = i;
            this.b = z;
            return this;
        }

        public Builder setThemeId(int i) {
            this.at = i;
            return this;
        }

        public Builder setUncheckedImgPath(String str) {
            this.M = str;
            return this;
        }

        public Builder setWindowBottom(int i) {
            this.as = i;
            return this;
        }
    }

    private GenAuthThemeConfig(Builder builder) {
        this.u = true;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.f21679a = builder.f21682a;
        this.b = builder.b;
        this.f21681c = builder.f21684c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
        this.w = builder.w;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.A = builder.A;
        this.B = builder.B;
        this.C = builder.C;
        this.D = builder.D;
        this.E = builder.E;
        this.F = builder.F;
        this.G = builder.G;
        this.H = builder.H;
        this.I = builder.I;
        this.J = builder.J;
        this.K = builder.K;
        this.L = builder.L;
        this.M = builder.M;
        this.N = builder.N;
        this.O = builder.O;
        this.P = builder.P;
        this.Q = builder.Q;
        this.R = builder.R;
        this.S = builder.S;
        this.T = builder.T;
        this.U = builder.U;
        this.V = builder.V;
        this.W = builder.W;
        this.X = builder.X;
        this.Y = builder.Y;
        this.Z = builder.Z;
        this.aa = builder.aa;
        this.ab = builder.ab;
        this.ac = builder.ac;
        this.ad = builder.ad;
        this.af = builder.ae;
        this.ag = builder.af;
        this.ah = builder.ag;
        this.ai = builder.ah;
        this.aj = builder.ai;
        this.ae = builder.aj;
        this.ak = builder.ak;
        this.al = builder.al;
        this.am = builder.am;
        this.an = builder.an;
        this.ao = builder.ao;
        this.ap = builder.ap;
        this.aq = builder.aq;
        this.f21680ar = builder.f21683ar;
        this.as = builder.as;
        this.at = builder.at;
        this.au = builder.au;
        this.av = builder.av;
        this.aw = builder.aw;
        this.ax = builder.ax;
    }

    public String getActivityIn() {
        return this.an;
    }

    public String getActivityOut() {
        return this.al;
    }

    public int getAppLanguageType() {
        return this.au;
    }

    public String getAuthPageActIn() {
        return this.ak;
    }

    public String getAuthPageActOut() {
        return this.am;
    }

    public int getCheckBoxLocation() {
        return this.ae;
    }

    public String getCheckTipText() {
        if (this.G) {
            int i = this.au;
            this.F = i == 1 ? "請勾選同意服務條款" : i == 2 ? "Please check to agree to the terms of service" : "请勾选同意服务条款";
        }
        return this.F;
    }

    public int getCheckedImgHeight() {
        return this.O;
    }

    public String getCheckedImgPath() {
        return this.L;
    }

    public int getCheckedImgWidth() {
        return this.N;
    }

    public int getClauseBaseColor() {
        return this.ab;
    }

    public int getClauseColor() {
        return this.ac;
    }

    public int getClauseLayoutResID() {
        return this.e;
    }

    public String getClauseLayoutReturnID() {
        return this.f;
    }

    public String getClauseName() {
        return this.R;
    }

    public String getClauseName2() {
        return this.T;
    }

    public String getClauseName3() {
        return this.V;
    }

    public String getClauseName4() {
        return this.X;
    }

    public String getClauseUrl() {
        return this.S;
    }

    public String getClauseUrl2() {
        return this.U;
    }

    public String getClauseUrl3() {
        return this.W;
    }

    public String getClauseUrl4() {
        return this.Y;
    }

    public View getContentView() {
        return this.f21681c;
    }

    public GenBackPressedListener getGenBackPressedListener() {
        return this.H;
    }

    public GenCheckBoxListener getGenCheckBoxListener() {
        return this.J;
    }

    public GenCheckedChangeListener getGenCheckedChangeListener() {
        return this.K;
    }

    public GenLoginClickListener getGenLoginClickListener() {
        return this.I;
    }

    public int getLayoutResID() {
        return this.d;
    }

    public String getLogBtnBackgroundPath() {
        return this.y;
    }

    public int getLogBtnHeight() {
        return this.A;
    }

    public int getLogBtnMarginLeft() {
        return this.B;
    }

    public int getLogBtnMarginRight() {
        return this.C;
    }

    public int getLogBtnOffsetY() {
        return this.D;
    }

    public int getLogBtnOffsetY_B() {
        return this.E;
    }

    public String getLogBtnText() {
        if (this.u) {
            int i = this.au;
            this.t = i == 1 ? "本機號碼登錄" : i == 2 ? "Login" : this.t;
        }
        return this.t;
    }

    public int getLogBtnTextColor() {
        return this.x;
    }

    public int getLogBtnTextSize() {
        return this.v;
    }

    public int getLogBtnWidth() {
        return this.z;
    }

    public int getNavColor() {
        return this.i;
    }

    public int getNavReturnImgHeight() {
        return this.l;
    }

    public String getNavReturnImgPath() {
        return this.j;
    }

    public ImageView.ScaleType getNavReturnImgScaleType() {
        return this.m;
    }

    public int getNavReturnImgWidth() {
        return this.k;
    }

    public int getNavTextColor() {
        return this.h;
    }

    public int getNavTextSize() {
        return this.g;
    }

    public int getNumFieldOffsetY() {
        return this.r;
    }

    public int getNumFieldOffsetY_B() {
        return this.s;
    }

    public int getNumberColor() {
        return this.p;
    }

    public int getNumberOffsetX() {
        return this.q;
    }

    public int getNumberSize() {
        return this.n;
    }

    public String getPrivacy() {
        return this.Q;
    }

    public String getPrivacyAnimation() {
        return this.ax;
    }

    public int getPrivacyMarginLeft() {
        return this.af;
    }

    public int getPrivacyMarginRight() {
        return this.ag;
    }

    public int getPrivacyOffsetY() {
        return this.ah;
    }

    public int getPrivacyOffsetY_B() {
        return this.ai;
    }

    public int getPrivacyTextSize() {
        return this.Z;
    }

    public int getStatusBarColor() {
        return this.f21679a;
    }

    public int getThemeId() {
        return this.at;
    }

    public String getUncheckedImgPath() {
        return this.M;
    }

    public int getWindowBottom() {
        return this.as;
    }

    public int getWindowHeight() {
        return this.ap;
    }

    public int getWindowWidth() {
        return this.ao;
    }

    public int getWindowX() {
        return this.aq;
    }

    public int getWindowY() {
        return this.f21680ar;
    }

    public boolean isBackButton() {
        return this.aw;
    }

    public boolean isFitsSystemWindows() {
        return this.av;
    }

    public boolean isLightColor() {
        return this.b;
    }

    public boolean isLogBtnTextBold() {
        return this.w;
    }

    public boolean isNumberBold() {
        return this.o;
    }

    public boolean isPrivacyBookSymbol() {
        return this.aj;
    }

    public boolean isPrivacyState() {
        return this.P;
    }

    public boolean isPrivacyTextBold() {
        return this.aa;
    }

    public boolean isPrivacyTextGravityCenter() {
        return this.ad;
    }
}
