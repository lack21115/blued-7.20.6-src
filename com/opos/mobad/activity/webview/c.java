package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.applog.tracker.Tracker;
import com.opos.cmn.biz.web.b.a.b;
import com.opos.cmn.j.a;
import com.opos.cmn.j.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/c.class */
public class c implements com.opos.mobad.activity.webview.b.a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.activity.webview.c.a f11957a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f11958c;
    private View d;
    private View e;
    private View f;
    private Context g;
    private int h;
    private boolean i;
    private com.opos.cmn.j.b j;
    private com.opos.cmn.biz.web.b.a.a k;
    private boolean l = false;
    private b.a m = new b.a() { // from class: com.opos.mobad.activity.webview.c.5
        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            a aVar;
            boolean z2;
            com.opos.cmn.an.f.a.b("WebViewEngine", "onViewVisibile = " + z + "," + c.this.j);
            if (c.this.b != null) {
                if (!z) {
                    aVar = c.this.b;
                    z2 = false;
                } else if (c.this.j == null || c.this.j.getVisibility() != 0) {
                    return;
                } else {
                    aVar = c.this.b;
                    z2 = true;
                }
                aVar.a(z2);
            }
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/c$a.class */
    public interface a {
        void a();

        void a(boolean z);

        void b();

        void c();
    }

    public c(final Activity activity, d dVar) {
        if (activity == null || dVar == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        this.g = applicationContext;
        this.k = new com.opos.cmn.biz.web.b.a.a(com.opos.mobad.service.b.a(applicationContext), new b.a().a(new com.opos.cmn.biz.web.b.a.a.b() { // from class: com.opos.mobad.activity.webview.c.2
            @Override // com.opos.cmn.biz.web.b.a.a.b
            public void c() {
                if (c.this.b != null) {
                    c.this.b.a();
                }
            }
        }).a(dVar.f11970a).a(false).a(new com.opos.cmn.biz.web.b.a.a.a() { // from class: com.opos.mobad.activity.webview.c.1
            @Override // com.opos.cmn.biz.web.b.a.a.a
            public void a(final SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("SSL证书验证错误，是否继续？");
                    builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            sslErrorHandler.proceed();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            sslErrorHandler.cancel();
                            c.this.k();
                        }
                    });
                    AlertDialog create = builder.create();
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("WebViewEngine", "", e);
                }
            }
        }).a());
        if (dVar.f11971c) {
            this.f11957a = new com.opos.mobad.activity.webview.c.a(activity.getApplicationContext(), this);
        }
        this.h = dVar.b;
        this.i = dVar.d;
        f();
    }

    private void f() {
        if (this.g != null) {
            LinearLayout linearLayout = new LinearLayout(this.g);
            this.f11958c = linearLayout;
            linearLayout.setOrientation(1);
            this.f11958c.setFitsSystemWindows(this.i);
            this.f11958c.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.activity.webview.c.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.activity.webview.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.b != null) {
                                c.this.b.c();
                            }
                        }
                    });
                }
            });
            g();
            h();
            i();
            final com.opos.cmn.j.a aVar = new com.opos.cmn.j.a(this.g);
            aVar.a(new a.InterfaceC0476a() { // from class: com.opos.mobad.activity.webview.c.4
                @Override // com.opos.cmn.j.a.InterfaceC0476a
                public void a() {
                    com.opos.cmn.an.f.a.b("WebViewEngine", "view detach ");
                }

                @Override // com.opos.cmn.j.a.InterfaceC0476a
                public void b() {
                    if (c.this.l || c.this.b == null) {
                        return;
                    }
                    com.opos.cmn.j.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(null);
                    }
                    c.this.b.b();
                    c.this.l = true;
                }
            });
            this.f11958c.addView(aVar, 0, 0);
        }
    }

    private void g() {
        com.opos.mobad.activity.webview.c.a aVar = this.f11957a;
        if (aVar != null) {
            View a2 = aVar.a();
            this.e = a2;
            if (a2 == null || this.f11958c == null) {
                return;
            }
            this.f11958c.addView(this.e, new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 43.33f)));
        }
    }

    private void h() {
        if (this.h == 2) {
            com.opos.cmn.j.b bVar = new com.opos.cmn.j.b(this.g);
            this.j = bVar;
            bVar.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (com.opos.cmn.an.h.f.a.b(this.g) * 9) / 16);
            this.j.a(this.m);
            this.f11958c.addView(this.j, layoutParams);
        }
    }

    private void i() {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar != null) {
            View b = aVar.b();
            this.d = b;
            if (b == null || this.f11958c == null) {
                return;
            }
            b.setFitsSystemWindows(this.i);
            this.f11958c.addView(this.d, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    private void j() {
        LinearLayout linearLayout;
        View view = this.d;
        if (view == null || (linearLayout = this.f11958c) == null) {
            return;
        }
        linearLayout.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void l() {
        a(this.f);
    }

    private void m() {
        com.opos.cmn.j.b bVar = this.j;
        if (bVar == null || bVar.getVisibility() != 0) {
            return;
        }
        this.j.setVisibility(8);
    }

    public void a() {
        LinearLayout linearLayout = this.f11958c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            com.opos.cmn.j.b bVar = this.j;
            if (bVar != null) {
                bVar.removeAllViews();
            }
            com.opos.cmn.biz.web.b.a.a aVar = this.k;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a(View view) {
        if (this.h == 2) {
            this.f = view;
            if (com.opos.cmn.an.h.f.a.d(this.g)) {
                View view2 = this.f;
                if (view2 != null && this.j.indexOfChild(view2) < 0) {
                    this.j.removeAllViews();
                    this.j.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
                }
                this.j.setVisibility(0);
            }
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(String str) {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar != null) {
            aVar.a(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("showWebPageWithString url=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("WebViewEngine", sb.toString());
    }

    public void b() {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar == null) {
            return;
        }
        if (!aVar.c() && this.k.d()) {
            return;
        }
        k();
    }

    @Override // com.opos.mobad.activity.webview.b.a
    public void c() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public View d() {
        return this.f11958c;
    }

    public void e() {
        com.opos.cmn.an.f.a.b("WebViewEngine", "refresh for rotation");
        if (this.h == 2) {
            if (com.opos.cmn.an.h.f.a.d(this.g)) {
                j();
                l();
            } else {
                m();
                j();
            }
            i();
        }
    }
}
