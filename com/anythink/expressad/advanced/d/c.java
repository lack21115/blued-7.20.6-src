package com.anythink.expressad.advanced.d;

import android.content.Context;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.c.c;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.y;
import com.anythink.expressad.out.o;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/d/c.class */
public class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4193a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4194c = 3;
    private static String g = "NativeAdvancedProvider";
    private JSONObject C;
    private ATOutNativeAdvancedViewGroup E;
    private boolean F;
    private boolean G;
    private boolean H;
    boolean e;
    com.anythink.expressad.foundation.d.d f;
    private String h;
    private String i;
    private com.anythink.expressad.advanced.c.a j;
    private com.anythink.expressad.advanced.c.b k;
    private b l;
    private o m;
    private d n;
    private ATNativeAdvancedView o;
    private ATNativeAdvancedWebview p;
    private com.anythink.expressad.advanced.view.a q;
    private com.anythink.expressad.d.c r;
    private boolean s;
    private int t = -1;
    private boolean u = false;
    private int v = 0;
    private boolean w = false;
    private int x = 0;
    private boolean y = false;
    private int z = 0;
    private int A = 0;
    private Object B = new Object();
    private boolean D = false;
    private boolean I = true;
    public boolean d = false;
    private ViewTreeObserver.OnScrollChangedListener J = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.anythink.expressad.advanced.d.c.1
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (c.this.I) {
                c.this.I = false;
                if (c.this.E != null) {
                    c.this.E.postDelayed(new Runnable() { // from class: com.anythink.expressad.advanced.d.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.I = true;
                        }
                    }, 1000L);
                }
                try {
                    c.this.j();
                } catch (Throwable th) {
                }
            }
        }
    };

    public c(String str, String str2, Context context) {
        com.anythink.expressad.advanced.view.a aVar;
        this.i = str;
        this.h = str2;
        if (this.k == null) {
            com.anythink.expressad.advanced.c.b bVar = new com.anythink.expressad.advanced.c.b(n.a().g(), this.i, this.h);
            this.k = bVar;
            bVar.a(this);
        }
        if (this.p == null) {
            try {
                this.p = new ATNativeAdvancedWebview(n.a().g());
            } catch (Throwable th) {
            }
            if (this.q == null) {
                try {
                    this.q = new com.anythink.expressad.advanced.view.a(this.h, this.k.b(), this);
                } catch (Throwable th2) {
                }
            }
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview != null && (aVar = this.q) != null) {
                aTNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.o == null) {
            ATNativeAdvancedView aTNativeAdvancedView = new ATNativeAdvancedView(context);
            this.o = aTNativeAdvancedView;
            aTNativeAdvancedView.setAdvancedNativeWebview(this.p);
            ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.p;
            if (aTNativeAdvancedWebview2 != null && aTNativeAdvancedWebview2.getParent() == null) {
                this.o.addView(this.p, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.E == null) {
            this.E = new ATOutNativeAdvancedViewGroup(n.a().g());
            this.E.setLayoutParams((this.z == 0 || this.A == 0) ? new ViewGroup.LayoutParams(-1, -1) : new ViewGroup.LayoutParams(this.z, this.A));
            this.E.setProvider(this);
            this.E.addView(this.o);
            this.E.getViewTreeObserver().addOnScrollChangedListener(this.J);
        }
    }

    private void a(Context context) {
        com.anythink.expressad.advanced.view.a aVar;
        if (this.k == null) {
            com.anythink.expressad.advanced.c.b bVar = new com.anythink.expressad.advanced.c.b(n.a().g(), this.i, this.h);
            this.k = bVar;
            bVar.a(this);
        }
        if (this.p == null) {
            try {
                this.p = new ATNativeAdvancedWebview(n.a().g());
            } catch (Throwable th) {
            }
            if (this.q == null) {
                try {
                    this.q = new com.anythink.expressad.advanced.view.a(this.h, this.k.b(), this);
                } catch (Throwable th2) {
                }
            }
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview != null && (aVar = this.q) != null) {
                aTNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.o == null) {
            ATNativeAdvancedView aTNativeAdvancedView = new ATNativeAdvancedView(context);
            this.o = aTNativeAdvancedView;
            aTNativeAdvancedView.setAdvancedNativeWebview(this.p);
            ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.p;
            if (aTNativeAdvancedWebview2 != null && aTNativeAdvancedWebview2.getParent() == null) {
                this.o.addView(this.p, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.E == null) {
            this.E = new ATOutNativeAdvancedViewGroup(n.a().g());
            this.E.setLayoutParams((this.z == 0 || this.A == 0) ? new ViewGroup.LayoutParams(-1, -1) : new ViewGroup.LayoutParams(this.z, this.A));
            this.E.setProvider(this);
            this.E.addView(this.o);
            this.E.getViewTreeObserver().addOnScrollChangedListener(this.J);
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        this.k.a(this.n);
        com.anythink.expressad.foundation.h.o.d(g, "start show process");
        this.k.a(cVar, this.o, true);
    }

    private void a(JSONObject jSONObject) {
        this.D = true;
        b(jSONObject);
    }

    private void b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.A = i;
        this.z = i2;
        this.E.setLayoutParams(new ViewGroup.LayoutParams(i2, i));
    }

    private void b(JSONObject jSONObject) {
        if (this.D) {
            this.C = jSONObject;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            NativeAdvancedJsUtils.sendThirdToH5(this.p, NativeAdvancedJsUtils.d, "", jSONObject);
        }
    }

    private void f(int i) {
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
        if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
            return;
        }
        try {
            if (this.p != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NativeAdvancedJsUtils.m, i);
                j.a();
                j.a((WebView) this.p, NativeAdvancedJsUtils.l, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.a(g, th.getMessage());
        }
    }

    private void g() {
        final com.anythink.expressad.foundation.d.c[] cVarArr = new com.anythink.expressad.foundation.d.c[1];
        com.anythink.expressad.advanced.c.a aVar = this.j;
        if (aVar != null) {
            cVarArr[0] = aVar.c();
        }
        if (cVarArr[0] != null) {
            if (this.r == null) {
                com.anythink.expressad.d.b.a();
                this.r = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.h);
            }
            this.n = new d(this, this.m, this.r.a(), cVarArr[0]);
            if (this.e) {
                return;
            }
            this.e = true;
            com.anythink.expressad.advanced.c.c.a(this.o, cVarArr[0], this.i, this.h, this.t, new c.a() { // from class: com.anythink.expressad.advanced.d.c.2
                @Override // com.anythink.expressad.advanced.c.c.a
                public final void a() {
                    com.anythink.expressad.foundation.h.o.a(c.g, "show start");
                    c.this.a(cVarArr[0], false);
                }

                @Override // com.anythink.expressad.advanced.c.c.a
                public final void b() {
                    c.this.e = false;
                }
            });
        }
    }

    private void g(int i) {
        if (this.u) {
            this.t = i;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            int i2 = this.t;
            if (i2 == 1) {
                this.k.a(true);
                NativeAdvancedJsUtils.sendThirdToH5(this.p, NativeAdvancedJsUtils.f, "", null);
            } else if (i2 == 0) {
                this.k.a(false);
                NativeAdvancedJsUtils.sendThirdToH5(this.p, NativeAdvancedJsUtils.g, "", null);
            }
        }
    }

    private String h() {
        if (this.d) {
            com.anythink.expressad.advanced.c.b bVar = this.k;
            return bVar != null ? bVar.a() : "";
        }
        com.anythink.expressad.advanced.c.a aVar = this.j;
        return aVar != null ? aVar.a() : "";
    }

    private void h(int i) {
        if (this.w) {
            this.v = i;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            NativeAdvancedJsUtils.sendThirdToH5(this.p, NativeAdvancedJsUtils.h, "mute", Integer.valueOf(i));
        }
    }

    private void i() {
        g(this.t);
        h(this.v);
        i(this.x);
        b(this.C);
        n.a().g();
        f(k.a());
    }

    private void i(int i) {
        if (this.y) {
            this.x = i;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            NativeAdvancedJsUtils.sendThirdToH5(this.p, NativeAdvancedJsUtils.j, NativeAdvancedJsUtils.k, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.F && this.G && this.H && !y.a(this.o.getAdvancedNativeWebview()) && this.E.getAlpha() >= 0.5f && this.E.getVisibility() == 0) {
            com.anythink.expressad.advanced.c.b bVar = this.k;
            if (bVar != null) {
                bVar.d();
            }
            g();
        }
    }

    private void k() {
        com.anythink.expressad.advanced.c.b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final String a(String str) {
        com.anythink.expressad.advanced.c.a aVar = this.j;
        return aVar != null ? aVar.a(str) : "";
    }

    public final void a(int i) {
        this.u = true;
        g(i);
    }

    public final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.A = i;
        this.z = i2;
        this.E.setLayoutParams(new ViewGroup.LayoutParams(i2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
        g(this.t);
        h(this.v);
        i(this.x);
        b(this.C);
        n.a().g();
        f(k.a());
        ATOutNativeAdvancedViewGroup aTOutNativeAdvancedViewGroup = this.E;
        if (aTOutNativeAdvancedViewGroup == null || aTOutNativeAdvancedViewGroup.getParent() == null) {
            return;
        }
        if (cVar != null && z) {
            if (this.r == null) {
                com.anythink.expressad.d.b.a();
                this.r = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.h);
            }
            this.n = new d(this, this.m, this.r.a(), cVar);
        }
        if (this.k == null) {
            com.anythink.expressad.advanced.c.b bVar = new com.anythink.expressad.advanced.c.b(n.a().g(), this.i, this.h);
            this.k = bVar;
            bVar.a(this);
        }
        this.k.a(this.n);
        com.anythink.expressad.foundation.h.o.d(g, "start show process");
        this.k.a(cVar, this.o, true);
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        this.f = dVar;
        this.I = true;
        this.s = true;
        this.o.clearResStateAndRemoveClose();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c d = com.anythink.expressad.d.b.d(com.anythink.expressad.foundation.b.a.b().e(), this.h);
        this.r = d;
        if (d == null) {
            this.r = com.anythink.expressad.d.c.y();
        }
        b bVar = new b(this);
        this.l = bVar;
        bVar.a(this.m);
        if (this.j == null) {
            this.j = new com.anythink.expressad.advanced.c.a(this.i, this.h);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            this.j.a(bVar2);
        }
        this.o.resetLoadState();
        this.j.a(this.o);
        this.j.a(this.r);
        this.j.a(this.z, this.A);
        this.j.a(this.t);
        this.j.a(dVar);
    }

    public final void a(o oVar) {
        this.m = oVar;
    }

    public final boolean a() {
        return this.s;
    }

    public final void b() {
        this.s = false;
    }

    public final void b(int i) {
        this.w = true;
        h(i);
    }

    public final ATOutNativeAdvancedViewGroup c() {
        return this.E;
    }

    public final void c(int i) {
        this.y = true;
        i(i);
    }

    public final int d() {
        return this.t;
    }

    public final void d(int i) {
        if (i == 1) {
            this.F = true;
        } else if (i == 2) {
            this.G = true;
        } else if (i == 3) {
            this.H = true;
        }
        try {
            j();
        } catch (Throwable th) {
        }
    }

    public final void e() {
        if (this.m != null) {
            this.m = null;
        }
        if (this.l != null) {
            this.l = null;
        }
        if (this.n != null) {
            this.n = null;
        }
        com.anythink.expressad.advanced.c.a aVar = this.j;
        if (aVar != null) {
            aVar.a((ATNativeAdvancedView) null);
            this.j.b();
        }
        com.anythink.expressad.advanced.c.b bVar = this.k;
        if (bVar != null) {
            bVar.c();
        }
        ATNativeAdvancedView aTNativeAdvancedView = this.o;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.destroy();
        }
        com.anythink.expressad.advanced.a.a.c(this.f.f());
        com.anythink.expressad.advanced.view.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.a();
        }
        ATOutNativeAdvancedViewGroup aTOutNativeAdvancedViewGroup = this.E;
        if (aTOutNativeAdvancedViewGroup != null) {
            aTOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.J);
            this.E.removeAllViews();
            this.E = null;
        }
    }

    public final void e(int i) {
        if (i == 1) {
            this.F = false;
        } else if (i == 2) {
            this.G = false;
        } else if (i == 3) {
            this.H = false;
        }
        com.anythink.expressad.advanced.c.b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
    }

    public boolean isReady() {
        return false;
    }
}
