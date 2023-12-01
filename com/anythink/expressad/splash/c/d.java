package com.anythink.expressad.splash.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.js.SplashJsUtils;
import com.anythink.expressad.splash.view.ATSplashView;
import com.anythink.expressad.splash.view.ATSplashWebview;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/d.class */
public final class d {
    private com.anythink.expressad.foundation.d.c d;
    private ATSplashView e;
    private com.anythink.expressad.splash.d.d f;
    private com.anythink.expressad.a.a g;
    private boolean h;
    private TextView i;
    private View j;
    private String k;
    private String l;
    private String n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private boolean s;
    private Context u;

    /* renamed from: c  reason: collision with root package name */
    private String f8211c = "SplashShowManager";
    private int m = 5;
    private boolean t = false;
    private View.OnClickListener v = new View.OnClickListener() { // from class: com.anythink.expressad.splash.c.d.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (d.this.h) {
                d.b(d.this);
                d.a(d.this, -1);
            }
        }
    };
    private f.b w = new f.b();

    /* renamed from: a  reason: collision with root package name */
    public Handler f8210a = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.splash.c.d.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i == 2 && d.this.d != null && d.this.d.ay() && d.this.e != null) {
                    d.this.e.getSplashWebview();
                }
            } else if (d.this.t) {
            } else {
                if (!u.a(d.this.e, d.this.w)) {
                    d.this.f8210a.removeMessages(1);
                    sendEmptyMessageDelayed(1, 1000L);
                } else if (d.this.m <= 0) {
                    d.b(d.this);
                } else {
                    d.g(d.this);
                    d dVar = d.this;
                    d.a(dVar, dVar.m);
                    d.this.f8210a.removeMessages(1);
                    sendEmptyMessageDelayed(1, 1000L);
                }
            }
        }
    };
    private com.anythink.expressad.splash.d.a x = new com.anythink.expressad.splash.d.a() { // from class: com.anythink.expressad.splash.c.d.3
        @Override // com.anythink.expressad.splash.d.a
        public final void a() {
            d.b(d.this);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(int i) {
            if (d.this.e != null) {
                d.this.e.changeCloseBtnState(i);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(int i, int i2) {
            if (i == 1) {
                d.this.f8210a.removeMessages(1);
            }
            if (i == 2) {
                d.this.m = i2;
                d.this.f8210a.removeMessages(1);
                d.this.f8210a.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            d.this.a(cVar);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(String str) {
            d.a(d.this, str);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(boolean z) {
            if (z) {
                d.this.f8210a.removeMessages(1);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b() {
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b(int i) {
            o.d(d.this.f8211c, "resetCountdown".concat(String.valueOf(i)));
            d.this.m = i;
            d.this.f8210a.removeMessages(1);
            d.this.f8210a.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b(String str) {
            try {
                if (d.this.f != null) {
                    if (TextUtils.isEmpty(str)) {
                        d.this.f.a(d.this.d);
                        return;
                    }
                    com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(d.this.d));
                    b.p(str);
                    d.this.a(b);
                }
            } catch (Exception e) {
                o.d(d.this.f8211c, e.getMessage());
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void c() {
            d.b(d.this);
        }
    };
    Rect b = new Rect();

    /* renamed from: com.anythink.expressad.splash.c.d$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/d$4.class */
    final class AnonymousClass4 implements View.OnAttachStateChangeListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            n.a().a(new Runnable() { // from class: com.anythink.expressad.splash.c.d.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.a(d.this, d.this.e)) {
                        d.this.g();
                    }
                }
            }, 30L);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.d$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/d$5.class */
    final class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d dVar = d.this;
            if (d.a(dVar, dVar.e)) {
                d.this.g();
            }
        }
    }

    public d(Context context, String str, String str2) {
        this.n = "点击跳过|";
        this.o = "点击跳过|";
        this.p = "秒";
        this.q = "秒后自动关闭";
        this.k = str2;
        this.l = str;
        this.u = context;
        if (this.i == null) {
            TextView textView = new TextView(context);
            this.i = textView;
            textView.setGravity(1);
            this.i.setTextIsSelectable(false);
            this.i.setPadding(t.b(context, 5.0f), t.b(context, 5.0f), t.b(context, 5.0f), t.b(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            this.i.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(t.b(context, 100.0f), t.b(context, 50.0f)) : layoutParams);
            Context g = n.a().g();
            if (g != null) {
                String a2 = com.anythink.expressad.foundation.b.a.b().a();
                int identifier = g.getResources().getIdentifier("anythink_splash_count_time_can_skip", "string", a2);
                int identifier2 = g.getResources().getIdentifier("anythink_splash_count_time_can_skip_not", "string", a2);
                int identifier3 = g.getResources().getIdentifier("anythink_splash_count_time_can_skip_s", "string", a2);
                this.o = g.getResources().getString(identifier);
                String string = g.getResources().getString(identifier2);
                this.q = string;
                this.n = string;
                this.p = g.getResources().getString(identifier3);
                this.i.setBackgroundResource(g.getResources().getIdentifier("anythink_splash_close_bg", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
                this.i.setTextColor(g.getResources().getColor(g.getResources().getIdentifier("anythink_splash_count_time_skip_text_color", "color", a2)));
            }
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        if (cVar != null) {
            try {
                List<String> e = cVar.e();
                if (e == null || e.size() <= 0) {
                    return;
                }
                for (String str2 : e) {
                    com.anythink.expressad.a.a.a(context, cVar, str, str2, true);
                }
            } catch (Throwable th) {
                o.d(this.f8211c, th.getMessage());
            }
        }
    }

    static /* synthetic */ void a(d dVar, int i) {
        ATSplashView aTSplashView = dVar.e;
        if (aTSplashView != null) {
            aTSplashView.updateCountdown(i);
            if (dVar.e.getSplashJSBridgeImpl() != null) {
                dVar.e.getSplashJSBridgeImpl().updateCountDown(i);
            }
        }
        if (i < 0) {
            dVar.m = i;
        } else if (dVar.j == null) {
            dVar.i();
        }
    }

    static /* synthetic */ void a(d dVar, String str) {
        com.anythink.expressad.splash.d.d dVar2 = dVar.f;
        if (dVar2 != null) {
            dVar2.a("web show failed:".concat(String.valueOf(str)));
        }
    }

    private void a(String str) {
        com.anythink.expressad.splash.d.d dVar = this.f;
        if (dVar != null) {
            dVar.a("web show failed:".concat(String.valueOf(str)));
        }
    }

    private boolean a(View view) {
        return view != null && view.getVisibility() == 0 && view.getParent() != null && view.getWindowVisibility() == 0 && view.getGlobalVisibleRect(this.b) && ((long) this.b.height()) * ((long) this.b.width()) > 0;
    }

    static /* synthetic */ boolean a(d dVar, View view) {
        return view != null && view.getVisibility() == 0 && view.getParent() != null && view.getWindowVisibility() == 0 && view.getGlobalVisibleRect(dVar.b) && ((long) dVar.b.height()) * ((long) dVar.b.width()) > 0;
    }

    private void b(int i) {
        ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.updateCountdown(i);
            if (this.e.getSplashJSBridgeImpl() != null) {
                this.e.getSplashJSBridgeImpl().updateCountDown(i);
            }
        }
        if (i < 0) {
            this.m = i;
        } else if (this.j == null) {
            i();
        }
    }

    private void b(View view) {
        if (view != null) {
            view.setOnClickListener(this.v);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        boolean z = true;
        if (cVar.s()) {
            z = false;
        } else {
            c(cVar, n.a().g(), this.k);
            cVar.c(true);
            com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, com.anythink.expressad.foundation.g.a.f.f);
        }
        if (z) {
            b(cVar, n.a().g(), this.k);
            a(cVar, n.a().g(), this.k);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(cVar.ai())) {
                    return;
                }
                com.anythink.expressad.a.a.a(context, cVar, str, cVar.ai(), false, true, com.anythink.expressad.a.a.a.j);
            } catch (Throwable th) {
                o.d(this.f8211c, th.getMessage());
            }
        }
    }

    static /* synthetic */ void b(d dVar) {
        try {
            dVar.t = true;
            if (dVar.f != null) {
                dVar.f.b();
                dVar.f = null;
            }
            dVar.s = false;
            if (dVar.e != null) {
                dVar.e.getSplashWebview();
            }
            if (dVar.f8210a != null) {
                dVar.f8210a.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        b(cVar, n.a().g(), this.k);
        c(cVar, n.a().g(), this.k);
        a(cVar, n.a().g(), this.k);
        cVar.c(true);
        com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, com.anythink.expressad.foundation.g.a.f.f);
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        com.anythink.expressad.foundation.b.a.b().b(context);
        if (!TextUtils.isEmpty(cVar.ag())) {
            com.anythink.expressad.a.a.a(context, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.i);
        }
        if (TextUtils.isEmpty(str) || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, str, cVar.L().o(), false);
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.splash.d.d dVar = this.f;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    private void f() {
        Context g = n.a().g();
        if (g != null) {
            String a2 = com.anythink.expressad.foundation.b.a.b().a();
            int identifier = g.getResources().getIdentifier("anythink_splash_count_time_can_skip", "string", a2);
            int identifier2 = g.getResources().getIdentifier("anythink_splash_count_time_can_skip_not", "string", a2);
            int identifier3 = g.getResources().getIdentifier("anythink_splash_count_time_can_skip_s", "string", a2);
            this.o = g.getResources().getString(identifier);
            String string = g.getResources().getString(identifier2);
            this.q = string;
            this.n = string;
            this.p = g.getResources().getString(identifier3);
            this.i.setBackgroundResource(g.getResources().getIdentifier("anythink_splash_close_bg", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
            this.i.setTextColor(g.getResources().getColor(g.getResources().getIdentifier("anythink_splash_count_time_skip_text_color", "color", a2)));
        }
    }

    static /* synthetic */ int g(d dVar) {
        int i = dVar.m;
        dVar.m = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this) {
            if (this.d != null && !this.s) {
                boolean z = true;
                this.s = true;
                if (this.f != null && this.e != null) {
                    if (this.u != null && (this.u instanceof Activity) && ((Activity) this.u).isFinishing()) {
                        this.f.a("Activity is finishing");
                        return;
                    }
                    this.f.a();
                }
                if (!this.d.V()) {
                    if (!this.e.isDynamicView()) {
                        com.anythink.expressad.foundation.d.c cVar = this.d;
                        if (cVar.s()) {
                            z = false;
                        } else {
                            c(cVar, n.a().g(), this.k);
                            cVar.c(true);
                            com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, com.anythink.expressad.foundation.g.a.f.f);
                        }
                        if (z) {
                            b(cVar, n.a().g(), this.k);
                            a(cVar, n.a().g(), this.k);
                        }
                        return;
                    }
                    com.anythink.expressad.foundation.d.c cVar2 = this.d;
                    b(cVar2, n.a().g(), this.k);
                    c(cVar2, n.a().g(), this.k);
                    a(cVar2, n.a().g(), this.k);
                    cVar2.c(true);
                    com.anythink.expressad.foundation.g.a.f.a(this.k, cVar2, com.anythink.expressad.foundation.g.a.f.f);
                }
            }
        }
    }

    private void h() {
        if (com.anythink.expressad.foundation.f.b.a().b() && !this.e.isDynamicView()) {
            com.anythink.expressad.foundation.f.b.a().a(this.k, new com.anythink.expressad.foundation.f.a() { // from class: com.anythink.expressad.splash.c.d.6
                @Override // com.anythink.expressad.foundation.f.a
                public final void a() {
                    String str;
                    d.this.e();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (n.a().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        o.b(d.this.f8211c, th.getMessage(), th);
                        str = "";
                    }
                    String encodeToString = Base64.encodeToString(str.getBytes(), 2);
                    j.a();
                    j.a((WebView) d.this.e.getSplashWebview(), AbsFeedBackForH5.f7096a, encodeToString);
                }

                @Override // com.anythink.expressad.foundation.f.a
                public final void b() {
                    String str;
                    d.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (n.a().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        o.b(d.this.f8211c, th.getMessage(), th);
                        str = "";
                    }
                    String encodeToString = Base64.encodeToString(str.getBytes(), 2);
                    j.a();
                    j.a((WebView) d.this.e.getSplashWebview(), AbsFeedBackForH5.f7096a, encodeToString);
                }

                @Override // com.anythink.expressad.foundation.f.a
                public final void c() {
                    String str;
                    d.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (n.a().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        o.b(d.this.f8211c, th.getMessage(), th);
                        str = "";
                    }
                    String encodeToString = Base64.encodeToString(str.getBytes(), 2);
                    j.a();
                    j.a((WebView) d.this.e.getSplashWebview(), AbsFeedBackForH5.f7096a, encodeToString);
                }
            });
            FeedBackButton b = com.anythink.expressad.foundation.f.b.a().b(this.k);
            if (b != null) {
                RelativeLayout.LayoutParams layoutParams = null;
                try {
                    layoutParams = (RelativeLayout.LayoutParams) b.getLayoutParams();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                RelativeLayout.LayoutParams layoutParams2 = layoutParams;
                if (layoutParams == null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.f7817a, com.anythink.expressad.foundation.f.b.b);
                }
                layoutParams2.topMargin = t.b(n.a().g(), 10.0f);
                layoutParams2.leftMargin = t.b(n.a().g(), 10.0f);
                ViewGroup viewGroup = (ViewGroup) b.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(b);
                }
                this.e.addView(b, layoutParams2);
            }
            this.d.l(this.k);
            com.anythink.expressad.foundation.f.b.a().a(this.k, this.d);
        }
    }

    private void i() {
        String str;
        if (this.h) {
            str = this.o + this.m + this.p;
        } else {
            str = this.m + this.q;
        }
        this.i.setText(str);
    }

    private void j() {
        try {
            this.t = true;
            if (this.f != null) {
                this.f.b();
                this.f = null;
            }
            this.s = false;
            if (this.e != null) {
                this.e.getSplashWebview();
            }
            if (this.f8210a != null) {
                this.f8210a.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
        }
    }

    private void k() {
        ATSplashWebview splashWebview;
        Handler handler;
        this.r = false;
        if (this.m > 0 && (handler = this.f8210a) != null) {
            handler.removeMessages(1);
            this.f8210a.sendEmptyMessageDelayed(1, 1000L);
        }
        ATSplashView aTSplashView = this.e;
        if (aTSplashView == null || (splashWebview = aTSplashView.getSplashWebview()) == null || splashWebview.isDestroyed()) {
            return;
        }
        SplashJsUtils.sendEventToH5(splashWebview, "onInstallAlertHide", "");
    }

    private void l() {
        ATSplashWebview splashWebview;
        Handler handler;
        this.r = true;
        if (this.m > 0 && (handler = this.f8210a) != null) {
            handler.removeMessages(1);
        }
        ATSplashView aTSplashView = this.e;
        if (aTSplashView == null || (splashWebview = aTSplashView.getSplashWebview()) == null || splashWebview.isDestroyed()) {
            return;
        }
        SplashJsUtils.sendEventToH5(splashWebview, "onInstallAlertShow", "");
    }

    public final com.anythink.expressad.splash.d.a a() {
        return this.x;
    }

    public final void a(int i) {
        this.m = i;
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.v);
        }
        this.j = viewGroup;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                cVar.aA();
            } catch (Throwable th) {
                o.a(this.f8211c, th.getMessage());
            }
        }
        com.anythink.expressad.splash.d.d dVar = this.f;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a(com.anythink.expressad.foundation.d.c cVar, ATSplashView aTSplashView) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void a(com.anythink.expressad.splash.d.d dVar) {
        this.f = dVar;
    }

    public final void a(boolean z) {
        this.h = z;
        if (z) {
            this.n = this.o;
        } else {
            this.n = this.q;
        }
    }

    public final String b() {
        com.anythink.expressad.foundation.d.c cVar = this.d;
        return (cVar == null || cVar.Z() == null) ? "" : this.d.Z();
    }

    public final void c() {
        if (this.f != null) {
            this.f = null;
        }
        if (this.x != null) {
            this.x = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.destroy();
        }
        com.anythink.expressad.foundation.f.b.a().c(this.k);
    }

    public final void d() {
        Handler handler;
        if (this.r || com.anythink.expressad.foundation.f.b.f7818c) {
            return;
        }
        if (this.m > 0 && (handler = this.f8210a) != null) {
            handler.removeMessages(1);
            this.f8210a.sendEmptyMessageDelayed(1, 1000L);
        }
        ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.onResume();
            ATSplashWebview splashWebview = this.e.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestroyed()) {
                return;
            }
            SplashJsUtils.sendEventToH5(splashWebview, SplashJsUtils.b, "");
        }
    }

    public final void e() {
        Handler handler;
        if (this.m > 0 && (handler = this.f8210a) != null) {
            handler.removeMessages(1);
        }
        ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.onPause();
            ATSplashWebview splashWebview = this.e.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestroyed()) {
                return;
            }
            SplashJsUtils.sendEventToH5(splashWebview, SplashJsUtils.f8245a, "");
        }
    }
}
