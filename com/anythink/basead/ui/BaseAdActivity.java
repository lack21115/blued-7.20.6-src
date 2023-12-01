package com.anythink.basead.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.basead.e.b;
import com.anythink.core.api.BaseAd;
import com.anythink.core.basead.a;
import com.anythink.core.common.b;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.y;
import com.anythink.core.common.k.h;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseAdActivity.class */
public class BaseAdActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6044a = BaseAdActivity.class.getSimpleName();
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    y f6045c;
    long d = 0;
    long e = 0;
    float f = 0.0f;
    boolean g = false;
    b.a h = new b.a() { // from class: com.anythink.basead.ui.BaseAdActivity.1
        @Override // com.anythink.core.common.b.a
        public final void a(Object obj) {
            if (!(obj instanceof y) || BaseAdActivity.this.k == null) {
                return;
            }
            y yVar = (y) obj;
            if (yVar.a().B().equals(BaseAdActivity.this.k.B())) {
                if (BaseAdActivity.this.b) {
                    yVar.a(BaseAdActivity.this);
                } else {
                    BaseAdActivity.this.f6045c = yVar;
                }
            }
        }
    };
    private BaseScreenAdView i;
    private j j;
    private i k;
    private String l;
    private b.InterfaceC0079b m;
    private String n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private BaseAd v;

    /* renamed from: com.anythink.basead.ui.BaseAdActivity$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseAdActivity$2.class */
    final class AnonymousClass2 implements b.InterfaceC0079b {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a() {
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.a();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a(int i) {
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.a(i);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a(e eVar) {
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.a(eVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a(boolean z) {
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.a(z);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void b() {
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.b();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void c() {
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.c();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void d() {
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.d();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void e() {
            BaseAdActivity.this.finish();
            if (BaseAdActivity.this.u) {
                BaseAdActivity.this.overridePendingTransition(0, 0);
            }
            if (BaseAdActivity.this.m != null) {
                BaseAdActivity.this.m.e();
            }
        }
    }

    private void a() {
        Intent intent = getIntent();
        try {
            if (intent == null) {
                Log.e("anythink", f6044a + " Intent is null.");
                return;
            }
            this.n = intent.getStringExtra("extra_scenario");
            this.o = intent.getIntExtra(a.C0092a.b, 1);
            this.k = (i) intent.getSerializableExtra(a.C0092a.f6391c);
            this.j = (j) intent.getSerializableExtra(a.C0092a.e);
            this.l = intent.getStringExtra(a.C0092a.d);
            this.u = a(this.o, this.j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Activity activity, com.anythink.core.basead.b.a aVar) {
        Intent intent = new Intent();
        Context g = n.a().g();
        if (activity == null || activity.isFinishing()) {
            Log.i("anythink_BaseAdActivity", "Activity is null");
            activity = g;
        }
        boolean a2 = a(aVar.f6394a, aVar.h);
        if (aVar.e == 2) {
            if (a2) {
                intent.setClass(activity, AdLandscapeTranslucentActivity.class);
            } else {
                intent.setClass(activity, AdLandscapeActivity.class);
            }
        } else if (a2) {
            intent.setClass(activity, AdPortraitTranslucentActivity.class);
        } else {
            intent.setClass(activity, AdPortraitActivity.class);
        }
        intent.putExtra("extra_scenario", aVar.b);
        intent.putExtra(a.C0092a.b, aVar.f6394a);
        intent.putExtra(a.C0092a.f6391c, aVar.f6395c);
        intent.putExtra(a.C0092a.d, aVar.d);
        intent.putExtra(a.C0092a.e, aVar.h);
        if (!(activity instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            activity.startActivity(intent);
        } catch (Throwable th) {
            b.InterfaceC0079b a3 = com.anythink.basead.e.b.a().a(aVar.d);
            if (a3 != null) {
                a3.a(f.a("10000", th.getMessage()));
            }
        }
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.q = bundle.getBoolean(a.C0092a.f);
            this.r = bundle.getBoolean(a.C0092a.g);
            this.s = bundle.getBoolean(a.C0092a.h);
            this.t = bundle.getBoolean(a.C0092a.k);
            this.d = bundle.getLong(a.C0092a.m);
            this.e = bundle.getLong(a.C0092a.n);
            this.f = bundle.getFloat(a.C0092a.o);
            this.g = bundle.getBoolean(a.C0092a.i);
        }
    }

    private static boolean a(int i, j jVar) {
        if (jVar == null || jVar.m == null || i != 3) {
            return false;
        }
        return TextUtils.equals("2", jVar.m.E());
    }

    private BaseScreenAdView b() {
        return this.o != 3 ? new FullScreenAdView(this, this.j, this.k, this.n, this.o, this.p) : this.v != null ? new ThirdPartyFullScreenAdView(this, this.j, this.k, this.n, this.o, this.p, this.v) : this.u ? new HalfScreenAdView(this, this.j, this.k, this.n, this.o, this.p) : new FullScreenAdView(this, this.j, this.k, this.n, this.o, this.p);
    }

    private void b(Bundle bundle) {
        this.i.setListener(new AnonymousClass2());
        if (bundle != null) {
            this.q = bundle.getBoolean(a.C0092a.f);
            this.r = bundle.getBoolean(a.C0092a.g);
            this.s = bundle.getBoolean(a.C0092a.h);
            this.t = bundle.getBoolean(a.C0092a.k);
            this.d = bundle.getLong(a.C0092a.m);
            this.e = bundle.getLong(a.C0092a.n);
            this.f = bundle.getFloat(a.C0092a.o);
            this.g = bundle.getBoolean(a.C0092a.i);
        }
        this.i.setIsShowEndCard(this.q);
        this.i.setHideFeedbackButton(this.r);
        this.i.setHasReward(this.t);
        if (bundle != null) {
            this.i.setVideoMute(this.s);
            this.i.setShowBannerTime(this.d);
            this.i.setHideBannerTime(this.e);
            this.i.setCloseButtonScaleFactor(this.f);
            this.i.setHasPerformClick(this.g);
        }
        try {
            this.i.init();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                if (this.m != null) {
                    this.m.a(f.a(f.k, h.a(th.getStackTrace())));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (n.a().g() == null) {
            n.a().a(getApplicationContext());
        }
        if (this instanceof AdLandscapeActivity) {
            this.p = 2;
        } else {
            this.p = 1;
        }
        Intent intent = getIntent();
        try {
            if (intent != null) {
                this.n = intent.getStringExtra("extra_scenario");
                this.o = intent.getIntExtra(a.C0092a.b, 1);
                this.k = (i) intent.getSerializableExtra(a.C0092a.f6391c);
                this.j = (j) intent.getSerializableExtra(a.C0092a.e);
                this.l = intent.getStringExtra(a.C0092a.d);
                this.u = a(this.o, this.j);
            } else {
                Log.e("anythink", f6044a + " Intent is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.m = com.anythink.basead.e.b.a().a(this.l);
        this.v = com.anythink.basead.d.i.a().a(this.l);
        j jVar = this.j;
        if (jVar == null || jVar.m == null) {
            Log.e("anythink", f6044a + "Start Screen Ad Error.");
            try {
                if (this.m != null) {
                    b.InterfaceC0079b interfaceC0079b = this.m;
                    interfaceC0079b.a(f.a(f.k, f6044a + "Start FullScreen Ad Error."));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            finish();
        } else if (this.k == null) {
            Log.e("anythink", f6044a + " onCreate: OfferAd = null");
            try {
                if (this.m != null) {
                    b.InterfaceC0079b interfaceC0079b2 = this.m;
                    interfaceC0079b2.a(f.a(f.k, f6044a + " onCreate: OfferAd = null"));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            finish();
        } else {
            com.anythink.core.common.b.a().a("1", this.h);
            this.i = this.o != 3 ? new FullScreenAdView(this, this.j, this.k, this.n, this.o, this.p) : this.v != null ? new ThirdPartyFullScreenAdView(this, this.j, this.k, this.n, this.o, this.p, this.v) : this.u ? new HalfScreenAdView(this, this.j, this.k, this.n, this.o, this.p) : new FullScreenAdView(this, this.j, this.k, this.n, this.o, this.p);
            BaseAd baseAd = this.v;
            if (baseAd == null || baseAd.getCustomAdContainer() == null) {
                setContentView(this.i);
            } else {
                ViewGroup customAdContainer = this.v.getCustomAdContainer();
                customAdContainer.addView(this.i);
                setContentView(customAdContainer);
            }
            this.i.setListener(new AnonymousClass2());
            if (bundle != null) {
                this.q = bundle.getBoolean(a.C0092a.f);
                this.r = bundle.getBoolean(a.C0092a.g);
                this.s = bundle.getBoolean(a.C0092a.h);
                this.t = bundle.getBoolean(a.C0092a.k);
                this.d = bundle.getLong(a.C0092a.m);
                this.e = bundle.getLong(a.C0092a.n);
                this.f = bundle.getFloat(a.C0092a.o);
                this.g = bundle.getBoolean(a.C0092a.i);
            }
            this.i.setIsShowEndCard(this.q);
            this.i.setHideFeedbackButton(this.r);
            this.i.setHasReward(this.t);
            if (bundle != null) {
                this.i.setVideoMute(this.s);
                this.i.setShowBannerTime(this.d);
                this.i.setHideBannerTime(this.e);
                this.i.setCloseButtonScaleFactor(this.f);
                this.i.setHasPerformClick(this.g);
            }
            try {
                this.i.init();
            } catch (Throwable th3) {
                th3.printStackTrace();
                try {
                    if (this.m != null) {
                        this.m.a(f.a(f.k, h.a(th3.getStackTrace())));
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f6045c = null;
        com.anythink.core.common.b.a().b("1", this.h);
        BaseScreenAdView baseScreenAdView = this.i;
        if (baseScreenAdView != null) {
            baseScreenAdView.t();
        }
        i iVar = this.k;
        if (iVar != null && iVar.E() && !this.k.L()) {
            com.anythink.core.common.a.j.a().b();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.b = false;
        BaseScreenAdView baseScreenAdView = this.i;
        if (baseScreenAdView != null) {
            baseScreenAdView.s();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.b = true;
        BaseScreenAdView baseScreenAdView = this.i;
        if (baseScreenAdView != null) {
            baseScreenAdView.r();
        }
        y yVar = this.f6045c;
        if (yVar != null) {
            yVar.a(this);
            this.f6045c = null;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BaseScreenAdView baseScreenAdView = this.i;
        if (baseScreenAdView != null) {
            if (baseScreenAdView.isShowEndCard()) {
                bundle.putBoolean(a.C0092a.f, true);
            }
            bundle.putBoolean(a.C0092a.g, this.i.needHideFeedbackButton());
            bundle.putBoolean(a.C0092a.h, this.i.isVideoMute());
            bundle.putBoolean(a.C0092a.k, this.i.hasReward());
            bundle.putLong(a.C0092a.m, this.i.getShowBannerTime());
            bundle.putLong(a.C0092a.n, this.i.getHideBannerTime());
            bundle.putFloat(a.C0092a.o, this.i.getCloseButtonScaleFactor());
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (Build.VERSION.SDK_INT == 26) {
            super.setTheme(h.a(this, "myoffer_half_screen_fit_by_o", "style"));
        } else {
            super.setTheme(i);
        }
    }
}
