package com.anythink.expressad.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.n;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.shake.MBShakeView;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView.class */
public class ATSplashNativeView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8248a = "MBSplashNativeView";
    private int A;
    private int B;
    private float C;
    private float D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private String J;
    private String K;
    private ATSplashView L;
    private c M;
    private MBShakeView N;
    private String O;
    private String P;
    private String Q;
    private com.anythink.expressad.shake.b R;
    private MBNoRecycledCrashImageView b;

    /* renamed from: c  reason: collision with root package name */
    private MBNoRecycledCrashImageView f8249c;
    private RelativeLayout d;
    private ImageView e;
    private FeedBackButton f;
    private TextView g;
    private RelativeLayout h;
    private MBNoRecycledCrashImageView i;
    private TextView j;
    private MBNoRecycledCrashImageView k;
    private TextView l;
    private TextView m;
    private RelativeLayout n;
    private TextView o;
    private TextView p;
    private TextView q;
    private MBSplashClickView r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$1.class */
    final class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (bitmap.getWidth() < bitmap.getHeight()) {
                        ATSplashNativeView.a(ATSplashNativeView.this);
                        ATSplashNativeView.this.h.setVisibility(4);
                        ATSplashNativeView.this.f8249c.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        ATSplashNativeView.this.f8249c.setImageBitmap(bitmap);
                    } else if (ATSplashNativeView.this.A == 1) {
                        ATSplashNativeView.this.h.setVisibility(0);
                        Bitmap a2 = n.a(bitmap, t.b(com.anythink.core.common.b.n.a().g(), 10.0f));
                        if (a2 != null && !a2.isRecycled()) {
                            ATSplashNativeView.this.k.setScaleType(ImageView.ScaleType.FIT_XY);
                            ATSplashNativeView.this.k.setImageBitmap(a2);
                        }
                        ATSplashNativeView.this.j.setText(ATSplashNativeView.this.M.bb());
                        ATSplashNativeView.h(ATSplashNativeView.this);
                        Bitmap b = n.b(bitmap);
                        if (b != null && !b.isRecycled()) {
                            ATSplashNativeView.this.f8249c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            ATSplashNativeView.this.f8249c.setImageBitmap(b);
                        }
                    } else {
                        ATSplashNativeView.this.h.setVisibility(4);
                        ATSplashNativeView.this.f8249c.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        ATSplashNativeView.this.f8249c.setImageBitmap(bitmap);
                    }
                    Bitmap b2 = n.b(bitmap);
                    if (b2 == null || b2.isRecycled()) {
                        return;
                    }
                    ATSplashNativeView.this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ATSplashNativeView.this.b.setImageBitmap(b2);
                } catch (Throwable th) {
                    o.d(ATSplashNativeView.f8248a, th.getMessage());
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$10  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$10.class */
    final class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (ATSplashNativeView.this.G) {
                if (ATSplashNativeView.this.L.getSplashJSBridgeImpl() != null && ATSplashNativeView.this.L.getSplashJSBridgeImpl().getSplashBridgeListener() != null) {
                    ATSplashNativeView.this.L.getSplashJSBridgeImpl().getSplashBridgeListener().c();
                }
                ATSplashNativeView.this.g.setVisibility(4);
                ATSplashNativeView.this.g.setEnabled(false);
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$11  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$11.class */
    final class AnonymousClass11 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass11() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            ATSplashNativeView.this.I = true;
            ATSplashNativeView.b(ATSplashNativeView.this, false);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            ATSplashNativeView.this.I = false;
            ATSplashNativeView.b(ATSplashNativeView.this, true);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            ATSplashNativeView.this.I = false;
            ATSplashNativeView.b(ATSplashNativeView.this, true);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$2.class */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            ATSplashNativeView.a(ATSplashNativeView.this, 0);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$3.class */
    final class AnonymousClass3 extends com.anythink.expressad.shake.b {
        AnonymousClass3(int i, int i2) {
            super(i, i2);
        }

        @Override // com.anythink.expressad.shake.b
        public final void a() {
            if (ATSplashNativeView.this.I || ATSplashNativeView.this.H) {
                return;
            }
            ATSplashNativeView.a(ATSplashNativeView.this, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$4.class */
    public final class AnonymousClass4 implements com.anythink.expressad.foundation.g.d.c {
        AnonymousClass4() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            Bitmap a2;
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled() || ATSplashNativeView.this.i == null || (a2 = n.a(bitmap, t.b(com.anythink.core.common.b.n.a().g(), 40.0f))) == null || a2.isRecycled()) {
                        return;
                    }
                    ATSplashNativeView.this.i.setImageBitmap(a2);
                } catch (Throwable th) {
                    o.d(ATSplashNativeView.f8248a, th.getMessage());
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            ATSplashNativeView.this.i.setVisibility(4);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$6.class */
    final class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            ATSplashNativeView.a(ATSplashNativeView.this, 1);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$7  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$7.class */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            ATSplashNativeView.a(ATSplashNativeView.this, 0);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$8  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$8.class */
    final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (ATSplashNativeView.this.M.aG() != null) {
                String c2 = ATSplashNativeView.this.M.aG().c();
                if (TextUtils.isEmpty(c2)) {
                    return;
                }
                l.b(ATSplashNativeView.this.getContext(), c2);
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$9  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashNativeView$9.class */
    final class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            com.anythink.expressad.foundation.d.a aG = ATSplashNativeView.this.M.aG();
            if (aG != null) {
                l.b(com.anythink.core.common.b.n.a().g(), aG.a());
            }
        }
    }

    public ATSplashNativeView(Context context) {
        super(context);
        this.H = false;
        this.I = false;
    }

    public ATSplashNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATSplashNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.H = false;
        this.I = false;
    }

    public ATSplashNativeView(Context context, ATSplashView aTSplashView, com.anythink.expressad.splash.a.b bVar) {
        super(context);
        this.H = false;
        this.I = false;
        if (bVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.J = bVar.b();
        this.K = bVar.a();
        this.M = bVar.c();
        this.L = aTSplashView;
        this.s = bVar.e();
        this.v = bVar.f();
        this.u = bVar.g();
        this.w = bVar.h();
        this.x = bVar.i();
        this.y = bVar.j();
        this.z = bVar.k();
        this.A = bVar.l();
        this.G = bVar.d();
        this.B = bVar.m();
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(this.A == 1 ? i.a(getContext().getApplicationContext(), "anythink_splash_portrait", "layout") : i.a(getContext().getApplicationContext(), "anythink_splash_landscape", "layout"), (ViewGroup) null);
            addView(inflate);
            this.b = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image_bg", "id"));
            this.f8249c = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image", "id"));
            this.d = (RelativeLayout) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_topcontroller", "id"));
            this.e = (ImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_link", "id"));
            this.f = (FeedBackButton) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_feedback", "id"));
            this.g = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_skip", "id"));
            this.h = (RelativeLayout) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_landscape_foreground", "id"));
            this.i = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_icon", "id"));
            this.j = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_title", "id"));
            this.k = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_foregroundimage", "id"));
            this.l = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adrect", "id"));
            this.n = (RelativeLayout) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_layout_appinfo", "id"));
            this.o = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_appinfo", "id"));
            this.p = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_privacy", "id"));
            this.q = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_permission", "id"));
            this.r = (MBSplashClickView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_click", "id"));
            this.m = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adcircle", "id"));
            int a2 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip", "string");
            int a3 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_not", "string");
            int a4 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_s", "string");
            this.P = getContext().getResources().getString(a2);
            this.Q = getContext().getResources().getString(a3);
            this.O = getContext().getResources().getString(a4);
        } catch (Throwable th) {
            o.d(f8248a, th.getMessage());
        }
        try {
            this.E = getContext().getResources().getConfiguration().locale.getLanguage().contains("en");
        } catch (Throwable th2) {
            o.d(f8248a, th2.getMessage());
        }
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
        } else {
            FeedBackButton feedBackButton = this.f;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(this.M.be())) {
            this.f8249c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.be(), new AnonymousClass1());
        }
        e();
        if (this.M.aG() == null || this.w != 0) {
            this.n.setVisibility(8);
        } else {
            com.anythink.expressad.foundation.d.a aG = this.M.aG();
            StringBuilder sb = new StringBuilder();
            sb.append("应用名称：");
            sb.append(aG.b());
            sb.append("\n版本：");
            sb.append(aG.e());
            sb.append("\n开发者：");
            sb.append(aG.f());
            sb.append("\n更新时间：");
            sb.append(aG.d());
            this.o.setText(sb);
        }
        if (this.v == 1) {
            this.r.setVisibility(8);
        } else if (this.x == 1) {
            this.r.setVisibility(8);
        } else {
            this.r.initView(this.M.cU);
        }
        if (this.u == 1) {
            setOnClickListener(new AnonymousClass6());
        } else {
            this.r.setOnClickListener(new AnonymousClass7());
        }
        this.p.setOnClickListener(new AnonymousClass8());
        this.q.setOnClickListener(new AnonymousClass9());
        this.g.setOnClickListener(new AnonymousClass10());
        if (this.x == 1) {
            MBShakeView mBShakeView = new MBShakeView(getContext());
            this.N = mBShakeView;
            mBShakeView.initView(this.M.cU);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.r.setVisibility(4);
            this.r.setEnabled(false);
            this.N.setOnClickListener(new AnonymousClass2());
            this.R = new AnonymousClass3(this.y, this.z * 1000);
        }
        updateCountDown(this.s);
    }

    private void a() {
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(this.A == 1 ? i.a(getContext().getApplicationContext(), "anythink_splash_portrait", "layout") : i.a(getContext().getApplicationContext(), "anythink_splash_landscape", "layout"), (ViewGroup) null);
            addView(inflate);
            this.b = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image_bg", "id"));
            this.f8249c = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image", "id"));
            this.d = (RelativeLayout) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_topcontroller", "id"));
            this.e = (ImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_link", "id"));
            this.f = (FeedBackButton) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_feedback", "id"));
            this.g = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_skip", "id"));
            this.h = (RelativeLayout) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_landscape_foreground", "id"));
            this.i = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_icon", "id"));
            this.j = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_title", "id"));
            this.k = (MBNoRecycledCrashImageView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_foregroundimage", "id"));
            this.l = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adrect", "id"));
            this.n = (RelativeLayout) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_layout_appinfo", "id"));
            this.o = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_appinfo", "id"));
            this.p = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_privacy", "id"));
            this.q = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_permission", "id"));
            this.r = (MBSplashClickView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_click", "id"));
            this.m = (TextView) inflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adcircle", "id"));
            int a2 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip", "string");
            int a3 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_not", "string");
            int a4 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_s", "string");
            this.P = getContext().getResources().getString(a2);
            this.Q = getContext().getResources().getString(a3);
            this.O = getContext().getResources().getString(a4);
        } catch (Throwable th) {
            o.d(f8248a, th.getMessage());
        }
    }

    private void a(int i) {
        if (this.L.getSplashJSBridgeImpl() == null || this.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        try {
            this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(com.anythink.expressad.splash.a.a.a.a(com.anythink.expressad.splash.a.a.a.a(i, this.C, this.D), this.M));
        } catch (Throwable th) {
            o.d(f8248a, th.getMessage());
            this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(this.M);
        }
    }

    static /* synthetic */ void a(ATSplashNativeView aTSplashNativeView, int i) {
        if (aTSplashNativeView.L.getSplashJSBridgeImpl() == null || aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        try {
            aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(com.anythink.expressad.splash.a.a.a.a(com.anythink.expressad.splash.a.a.a.a(i, aTSplashNativeView.C, aTSplashNativeView.D), aTSplashNativeView.M));
        } catch (Throwable th) {
            o.d(f8248a, th.getMessage());
            aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(aTSplashNativeView.M);
        }
    }

    private void a(boolean z) {
        if (this.L.getSplashJSBridgeImpl() == null || this.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(z ? 2 : 1, this.t);
    }

    static /* synthetic */ boolean a(ATSplashNativeView aTSplashNativeView) {
        aTSplashNativeView.F = true;
        return true;
    }

    private void b() {
        try {
            this.E = getContext().getResources().getConfiguration().locale.getLanguage().contains("en");
        } catch (Throwable th) {
            o.d(f8248a, th.getMessage());
        }
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
        } else {
            FeedBackButton feedBackButton = this.f;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(this.M.be())) {
            this.f8249c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.be(), new AnonymousClass1());
        }
        e();
        if (this.M.aG() == null || this.w != 0) {
            this.n.setVisibility(8);
        } else {
            com.anythink.expressad.foundation.d.a aG = this.M.aG();
            StringBuilder sb = new StringBuilder();
            sb.append("应用名称：");
            sb.append(aG.b());
            sb.append("\n版本：");
            sb.append(aG.e());
            sb.append("\n开发者：");
            sb.append(aG.f());
            sb.append("\n更新时间：");
            sb.append(aG.d());
            this.o.setText(sb);
        }
        if (this.v == 1) {
            this.r.setVisibility(8);
        } else if (this.x == 1) {
            this.r.setVisibility(8);
        } else {
            this.r.initView(this.M.cU);
        }
        if (this.u == 1) {
            setOnClickListener(new AnonymousClass6());
        } else {
            this.r.setOnClickListener(new AnonymousClass7());
        }
        this.p.setOnClickListener(new AnonymousClass8());
        this.q.setOnClickListener(new AnonymousClass9());
        this.g.setOnClickListener(new AnonymousClass10());
        if (this.x == 1) {
            MBShakeView mBShakeView = new MBShakeView(getContext());
            this.N = mBShakeView;
            mBShakeView.initView(this.M.cU);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.r.setVisibility(4);
            this.r.setEnabled(false);
            this.N.setOnClickListener(new AnonymousClass2());
            this.R = new AnonymousClass3(this.y, this.z * 1000);
        }
        updateCountDown(this.s);
    }

    static /* synthetic */ void b(ATSplashNativeView aTSplashNativeView, boolean z) {
        if (aTSplashNativeView.L.getSplashJSBridgeImpl() == null || aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(z ? 2 : 1, aTSplashNativeView.t);
    }

    private void c() {
        if (TextUtils.isEmpty(this.M.be())) {
            this.f8249c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.be(), new AnonymousClass1());
        }
    }

    private void d() {
        if (TextUtils.isEmpty(this.M.bd())) {
            this.i.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.bd(), new AnonymousClass4());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.view.ATSplashNativeView.e():void");
    }

    private void f() {
        if (this.M.aG() == null || this.w != 0) {
            this.n.setVisibility(8);
            return;
        }
        com.anythink.expressad.foundation.d.a aG = this.M.aG();
        StringBuilder sb = new StringBuilder();
        sb.append("应用名称：");
        sb.append(aG.b());
        sb.append("\n版本：");
        sb.append(aG.e());
        sb.append("\n开发者：");
        sb.append(aG.f());
        sb.append("\n更新时间：");
        sb.append(aG.d());
        this.o.setText(sb);
    }

    private void g() {
        if (this.v == 1) {
            this.r.setVisibility(8);
        } else if (this.x == 1) {
            this.r.setVisibility(8);
        } else {
            this.r.initView(this.M.cU);
        }
    }

    private void h() {
        if (this.u == 1) {
            setOnClickListener(new AnonymousClass6());
        } else {
            this.r.setOnClickListener(new AnonymousClass7());
        }
        this.p.setOnClickListener(new AnonymousClass8());
        this.q.setOnClickListener(new AnonymousClass9());
        this.g.setOnClickListener(new AnonymousClass10());
    }

    static /* synthetic */ void h(ATSplashNativeView aTSplashNativeView) {
        if (TextUtils.isEmpty(aTSplashNativeView.M.bd())) {
            aTSplashNativeView.i.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(aTSplashNativeView.M.bd(), new AnonymousClass4());
        }
    }

    private void i() {
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
            return;
        }
        FeedBackButton feedBackButton = this.f;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    private void j() {
        if (this.x == 1) {
            MBShakeView mBShakeView = new MBShakeView(getContext());
            this.N = mBShakeView;
            mBShakeView.initView(this.M.cU);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.r.setVisibility(4);
            this.r.setEnabled(false);
            this.N.setOnClickListener(new AnonymousClass2());
            this.R = new AnonymousClass3(this.y, this.z * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.x != 1 || this.N == null || this.R == null) {
                return;
            }
            com.anythink.expressad.shake.a.a().a(this.R);
        } catch (Throwable th) {
            o.d(f8248a, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.C = motionEvent.getRawX();
        this.D = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void release() {
        try {
            if (this.R != null) {
                com.anythink.expressad.shake.a.a().b(this.R);
                this.R = null;
            }
            com.anythink.expressad.foundation.f.b.a().c(this.J);
            detachAllViewsFromParent();
        } catch (Exception e) {
            o.d(f8248a, e.getMessage());
        }
    }

    public void setIsPause(boolean z) {
        this.H = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        this.d.setPadding(i, i3, i2, i4);
    }

    public void updateCountDown(int i) {
        String str;
        if (this.g != null) {
            this.t = i;
            if (this.G) {
                str = this.P + " " + i + this.O;
            } else {
                str = i + this.O + " " + this.Q;
            }
            this.g.setText(str);
        }
    }
}
