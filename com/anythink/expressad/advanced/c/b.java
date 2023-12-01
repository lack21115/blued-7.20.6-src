package com.anythink.expressad.advanced.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.d.d;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/b.class */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f7019c;
    private ATNativeAdvancedView d;
    private d e;
    private com.anythink.expressad.a.a f;
    private com.anythink.expressad.advanced.d.c g;
    private boolean h;
    private ImageView j;
    private String k;
    private String l;
    private boolean m;
    private String b = "NativeAdvancedShowManager";
    private int i = -1;
    private View.OnClickListener n = new View.OnClickListener() { // from class: com.anythink.expressad.advanced.c.b.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (b.this.h) {
                b.b(b.this);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Handler f7018a = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.advanced.c.b.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 2 && b.this.f7019c != null && b.this.f7019c.ay() && b.this.d != null) {
                b.this.d.getAdvancedNativeWebview();
            }
        }
    };
    private com.anythink.expressad.advanced.d.a o = new com.anythink.expressad.advanced.d.a() { // from class: com.anythink.expressad.advanced.c.b.3
        @Override // com.anythink.expressad.advanced.d.a
        public final void a() {
            if (b.this.d != null) {
                b.this.d.setVisibility(8);
            }
            b.b(b.this);
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(int i) {
            b.this.i = i;
            if (b.this.d != null) {
                b.this.d.changeCloseBtnState(i);
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            b.this.a(cVar);
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(String str) {
            try {
                if (b.this.e != null) {
                    if (TextUtils.isEmpty(str)) {
                        b.this.e.a(b.this.f7019c);
                        d unused = b.this.e;
                        return;
                    }
                    com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(b.this.f7019c));
                    b.p(str);
                    b.this.a(b);
                }
            } catch (Exception e) {
                o.d(b.this.b, e.getMessage());
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(boolean z) {
            if (b.this.e != null) {
                b.this.m = z;
                if (z) {
                    d unused = b.this.e;
                } else {
                    d unused2 = b.this.e;
                }
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void b() {
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void b(int i) {
            o.d(b.this.b, "resetCountdown".concat(String.valueOf(i)));
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void c() {
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void d() {
            b.b(b.this);
        }
    };

    /* renamed from: com.anythink.expressad.advanced.c.b$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/b$4.class */
    final class AnonymousClass4 implements com.anythink.expressad.foundation.f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ATNativeAdvancedView f7023a;

        AnonymousClass4(ATNativeAdvancedView aTNativeAdvancedView) {
            this.f7023a = aTNativeAdvancedView;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            String str;
            b.this.e();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(b.this.b, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) this.f7023a.getAdvancedNativeWebview(), AbsFeedBackForH5.f7096a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            String str;
            b.this.d();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(b.this.b, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) this.f7023a.getAdvancedNativeWebview(), AbsFeedBackForH5.f7096a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            String str;
            b.this.d();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(b.this.b, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) this.f7023a.getAdvancedNativeWebview(), AbsFeedBackForH5.f7096a, encodeToString);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.b$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/b$5.class */
    final class AnonymousClass5 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f7024a;
        final /* synthetic */ ATNativeAdvancedView b;

        AnonymousClass5(com.anythink.expressad.foundation.d.c cVar, ATNativeAdvancedView aTNativeAdvancedView) {
            this.f7024a = cVar;
            this.b = aTNativeAdvancedView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.a(this.f7024a, this.b, false);
        }
    }

    public b(Context context, String str, String str2) {
        this.k = str2;
        this.l = str;
        if (this.j == null) {
            ImageView imageView = new ImageView(context);
            this.j = imageView;
            imageView.setPadding(t.b(context, 2.0f), t.b(context, 2.0f), t.b(context, 2.0f), t.b(context, 2.0f));
            Context g = n.a().g();
            this.j.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            this.j.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(t.b(g, 29.0f), t.b(g, 16.0f)) : layoutParams);
            this.j.setImageResource(g.getResources().getIdentifier("anythink_native_advanced_close_icon", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.n);
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
                o.d(this.b, th.getMessage());
            }
        }
    }

    static /* synthetic */ void b(b bVar) {
        d dVar = bVar.e;
        if (dVar != null) {
            dVar.c();
            bVar.e = null;
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        boolean z = true;
        if (cVar.s()) {
            z = false;
        } else {
            Context g = n.a().g();
            String str = this.k;
            com.anythink.expressad.foundation.b.a.b().b(g);
            if (!TextUtils.isEmpty(cVar.ag())) {
                com.anythink.expressad.a.a.a(g, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.i);
            }
            if (!TextUtils.isEmpty(str) && cVar.L() != null && cVar.L().o() != null) {
                com.anythink.expressad.a.a.a(g, cVar, str, cVar.L().o(), false);
            }
            cVar.c(true);
            f.a(this.k, cVar, f.g);
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
                o.d(this.b, th.getMessage());
            }
        }
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

    private void f() {
        Context g = n.a().g();
        this.j.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(t.b(g, 29.0f), t.b(g, 16.0f));
        }
        this.j.setLayoutParams(layoutParams2);
        this.j.setImageResource(g.getResources().getIdentifier("anythink_native_advanced_close_icon", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
    }

    private void g() {
        if (this.f7019c.V()) {
            return;
        }
        boolean z = true;
        this.f7019c.c(true);
        com.anythink.expressad.foundation.d.c cVar = this.f7019c;
        if (cVar.s()) {
            z = false;
        } else {
            Context g = n.a().g();
            String str = this.k;
            com.anythink.expressad.foundation.b.a.b().b(g);
            if (!TextUtils.isEmpty(cVar.ag())) {
                com.anythink.expressad.a.a.a(g, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.i);
            }
            if (!TextUtils.isEmpty(str) && cVar.L() != null && cVar.L().o() != null) {
                com.anythink.expressad.a.a.a(g, cVar, str, cVar.L().o(), false);
            }
            cVar.c(true);
            f.a(this.k, cVar, f.g);
        }
        if (z) {
            b(cVar, n.a().g(), this.k);
            a(cVar, n.a().g(), this.k);
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.a();
        }
    }

    private static void h() {
    }

    private void i() {
        d dVar = this.e;
        if (dVar != null) {
            dVar.c();
            this.e = null;
        }
    }

    private static /* synthetic */ void j() {
    }

    public final String a() {
        com.anythink.expressad.foundation.d.c cVar = this.f7019c;
        return (cVar == null || cVar.Z() == null) ? "" : this.f7019c.Z();
    }

    public final void a(com.anythink.expressad.advanced.d.c cVar) {
        this.g = cVar;
    }

    public final void a(d dVar) {
        this.e = dVar;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        cVar.l(this.k);
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a(com.anythink.expressad.foundation.d.c cVar, ATNativeAdvancedView aTNativeAdvancedView, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final com.anythink.expressad.advanced.d.a b() {
        return this.o;
    }

    public final void c() {
        if (this.e != null) {
            this.e = null;
        }
        if (this.o != null) {
            this.o = null;
        }
        if (this.n != null) {
            this.n = null;
        }
        ATNativeAdvancedView aTNativeAdvancedView = this.d;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.destroy();
        }
        if (this.g != null) {
            this.g = null;
        }
        com.anythink.expressad.foundation.f.b.a().c(this.k);
    }

    public final void d() {
        ATNativeAdvancedWebview advancedNativeWebview;
        if (this.d == null || com.anythink.expressad.foundation.f.b.f7818c || (advancedNativeWebview = this.d.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestroyed()) {
            return;
        }
        NativeAdvancedJsUtils.sendEventToH5(advancedNativeWebview, NativeAdvancedJsUtils.b, "");
    }

    public final void e() {
        ATNativeAdvancedWebview advancedNativeWebview;
        ATNativeAdvancedView aTNativeAdvancedView = this.d;
        if (aTNativeAdvancedView == null || (advancedNativeWebview = aTNativeAdvancedView.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestroyed()) {
            return;
        }
        j.a();
        j.a((WebView) advancedNativeWebview, NativeAdvancedJsUtils.f7046a, "");
    }
}
