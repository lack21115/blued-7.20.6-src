package com.opos.mobad.q.a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.opos.cmn.e.a.b.b.d;
import com.opos.cmn.e.a.b.d.a;
import com.opos.mobad.n.h.d;
import com.opos.mobad.n.h.i;
import com.opos.mobad.o.d.e;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.cmn.e.a.b.f.a f13471a;
    private com.opos.mobad.n.h.d b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.e.a.b.f.a f13472c;
    private com.opos.mobad.n.h.i d;
    private com.opos.cmn.e.a.b.b.d e;
    private Activity f;
    private b g;
    private Dialog h;
    private com.opos.cmn.e.a.b.a i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/d$a.class */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/d$b.class */
    public interface b {
        void a(View view, int[] iArr);

        void b(View view, int[] iArr);
    }

    public d(Activity activity) {
        this.f = activity;
    }

    public static final void a(final Window window) {
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            window.getDecorView().setSystemUiVisibility(5894);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.q.a.d.6
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (2 == (i & 2) && 4 == (i & 4)) {
                        return;
                    }
                    com.opos.cmn.an.f.a.b("DialogTemplate", "reset system ui");
                    window.getDecorView().setSystemUiVisibility(5894);
                }
            });
        }
    }

    public Dialog a(String str, String str2, e.b bVar) {
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
        }
        Dialog a2 = com.opos.mobad.o.d.e.a(this.f, str, str2, bVar);
        this.h = a2;
        a(a2.getWindow());
        return this.h;
    }

    public void a() {
        com.opos.cmn.e.a.b.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(final a aVar) {
        if (aVar != null && this.i == null) {
            com.opos.cmn.e.a.b.a aVar2 = new com.opos.cmn.e.a.b.a(this.f);
            this.i = aVar2;
            aVar2.a("当前为非Wi-Fi环境，\n是否继续下载？", "取消", "下载", new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.q.a.d.1
                @Override // com.opos.cmn.e.a.b.c.a
                public void a(View view, int[] iArr) {
                    aVar.b();
                    d.this.i.a();
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void b(View view, int[] iArr) {
                    aVar.a();
                    d.this.i.a();
                }
            });
        }
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    public void a(CharSequence charSequence) {
        com.opos.cmn.e.a.b.f.a aVar = this.f13472c;
        if (aVar == null || !aVar.isShowing()) {
            if (this.f13471a == null) {
                com.opos.mobad.n.h.d a2 = com.opos.mobad.n.h.d.a(this.f.getApplicationContext());
                this.b = a2;
                a2.a(new d.a() { // from class: com.opos.mobad.q.a.d.4
                    @Override // com.opos.mobad.n.h.d.a
                    public void a(View view, int[] iArr) {
                        d.this.f13471a.dismiss();
                        if (d.this.g != null) {
                            d.this.g.a(view, iArr);
                        }
                    }

                    @Override // com.opos.mobad.n.h.d.a
                    public void b(View view, int[] iArr) {
                        d.this.f13471a.dismiss();
                        if (d.this.g != null) {
                            d.this.g.b(view, iArr);
                        }
                    }
                });
                com.opos.cmn.e.a.b.f.a aVar2 = new com.opos.cmn.e.a.b.f.a(this.f, R.style.Theme_Translucent_NoTitleBar_Fullscreen, new a.C0464a().a(R.style.Theme_Translucent_NoTitleBar).a(false).b(false).a());
                this.f13471a = aVar2;
                aVar2.setContentView(this.b);
                a(this.f13471a.getWindow());
            }
            this.b.a(charSequence);
            this.f13471a.show();
        }
    }

    public void b() {
        com.opos.cmn.e.a.b.f.a aVar = this.f13471a;
        if (aVar != null && aVar.isShowing()) {
            this.f13471a.dismiss();
        }
        if (this.f13472c == null) {
            com.opos.mobad.n.h.i a2 = com.opos.mobad.n.h.i.a(this.f.getApplicationContext());
            this.d = a2;
            a2.a(new i.a() { // from class: com.opos.mobad.q.a.d.5
                @Override // com.opos.mobad.n.h.i.a
                public void a(View view, int[] iArr) {
                    d.this.f13472c.dismiss();
                    if (d.this.g != null) {
                        d.this.g.a(view, iArr);
                    }
                }
            });
            com.opos.cmn.e.a.b.f.a aVar2 = new com.opos.cmn.e.a.b.f.a(this.f, R.style.Theme_Translucent_NoTitleBar_Fullscreen, new a.C0464a().a(R.style.Theme_Translucent_NoTitleBar_Fullscreen).a(false).b(false).a());
            this.f13472c = aVar2;
            aVar2.setContentView(this.d);
            a(this.f13472c.getWindow());
        }
        this.f13472c.show();
    }

    public void b(final a aVar) {
        com.opos.cmn.e.a.b.b.d dVar = this.e;
        if (dVar == null) {
            this.e = new d.a(this.f.getApplicationContext()).a("当前为非WIFI环境,是否使用\n流量观看？").b("关闭视频", new d.b() { // from class: com.opos.mobad.q.a.d.3
                @Override // com.opos.cmn.e.a.b.b.d.b
                public void a(com.opos.cmn.e.a.b.b.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }).a("继续观看", new d.b() { // from class: com.opos.mobad.q.a.d.2
                @Override // com.opos.cmn.e.a.b.b.d.b
                public void a(com.opos.cmn.e.a.b.b.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }).a();
        } else {
            dVar.a("wifi");
        }
        this.e.a(this.f);
    }

    public void c() {
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
        }
        com.opos.cmn.e.a.b.f.a aVar = this.f13471a;
        if (aVar != null && aVar.isShowing()) {
            this.f13471a.dismiss();
        }
        com.opos.cmn.e.a.b.b.d dVar = this.e;
        if (dVar != null && dVar.a()) {
            this.e.b();
        }
        com.opos.cmn.e.a.b.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a();
        }
        com.opos.cmn.e.a.b.f.a aVar3 = this.f13472c;
        if (aVar3 == null || !aVar3.isShowing()) {
            return;
        }
        this.f13472c.dismiss();
    }
}
