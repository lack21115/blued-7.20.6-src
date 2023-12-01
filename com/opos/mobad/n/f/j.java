package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.t;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/j.class */
public class j implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f26734a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private a.InterfaceC0708a f26735c;
    private View d;
    private int e;
    private View f;
    private com.opos.mobad.c.c.a g;
    private View l;
    private com.opos.mobad.n.d.e n;
    private int o;
    private View q;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private Runnable k = new Runnable() { // from class: com.opos.mobad.n.f.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.h) {
                return;
            }
            if (j.this.f26735c != null) {
                j.this.f26735c.d(j.this.g.d(), j.this.g.c());
            }
            j.this.m.postDelayed(this, 1000L);
        }
    };
    private com.opos.mobad.c.c.b p = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.f.j.3
        private boolean b = false;

        @Override // com.opos.mobad.c.c.b
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i + "," + str);
            if (j.this.f26735c != null) {
                j.this.f26735c.a(i, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            if (!this.b) {
                j.this.k();
            }
            if (j.this.f26735c != null) {
                j.this.f26735c.d(0L, j.this.g.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            j.this.m.removeCallbacks(j.this.k);
            j.this.m.postDelayed(j.this.k, 1000L);
            j.this.f26735c.d(j.this.g.d(), j.this.g.c());
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            this.b = true;
            if (j.this.f26735c != null) {
                j.this.f26735c.a(j.this.g.d(), j.this.g.c());
            }
            if (j.this.n == null || j.this.n.f26630a == null) {
                return;
            }
            j.this.g.a(j.this.n.f26630a.f26633a, true);
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            j.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    };
    private Handler m = new Handler(Looper.getMainLooper());

    public j(Context context, int i, t tVar, com.opos.mobad.c.c.a aVar) {
        this.b = context;
        this.o = i;
        this.f26734a = new RelativeLayout(context);
        this.g = aVar;
        aVar.a(this.p);
        a(tVar);
        g();
        b(tVar);
        f();
    }

    public static final com.opos.mobad.n.a a(Context context, int i, com.opos.mobad.c.c.a aVar) {
        return new j(context.getApplicationContext(), i, new t(320, 180, t.a.BELOW), aVar);
    }

    private void a(t tVar) {
        View b = this.g.b();
        this.d = b;
        b.setBackgroundColor(-16777216);
        int generateViewId = View.generateViewId();
        this.e = generateViewId;
        this.d.setId(generateViewId);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                this.d.setOutlineProvider(new ViewOutlineProvider() { // from class: com.opos.mobad.n.f.j.4
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.opos.cmn.an.h.f.a.a(j.this.b, 8.0f));
                    }
                });
                this.d.setClipToOutline(true);
            } catch (Error e) {
                com.opos.cmn.an.f.a.b("InterstitialVideo", "clip radius fail", e);
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, tVar.f26560a), com.opos.cmn.an.h.f.a.a(this.b, tVar.b));
        layoutParams.addRule(13);
        this.f26734a.addView(this.d, layoutParams);
        View view = new View(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.e);
        layoutParams2.addRule(5, this.e);
        layoutParams2.addRule(6, this.e);
        layoutParams2.addRule(8, this.e);
        this.f26734a.addView(view, layoutParams2);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.j.5
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (j.this.f26735c != null) {
                    j.this.f26735c.f(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(gVar);
        view.setOnClickListener(gVar);
        this.f = new ProgressBar(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 39.0f));
        layoutParams3.addRule(13);
        this.f.setVisibility(0);
        this.f26734a.addView(this.f, layoutParams3);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        View view;
        int i;
        if (eVar.r) {
            view = this.q;
            i = 0;
        } else {
            view = this.q;
            i = 8;
        }
        view.setVisibility(i);
    }

    public static final com.opos.mobad.n.a b(Context context, int i, com.opos.mobad.c.c.a aVar) {
        return new j(context.getApplicationContext(), i, new t(168, 298, t.a.RIGHT), aVar);
    }

    private void b(t tVar) {
        ImageView imageView = new ImageView(this.b);
        imageView.setImageResource(R.drawable.opos_mobad_dialog_close);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 42.0f), com.opos.cmn.an.h.f.a.a(this.b, 42.0f));
        if (tVar.f26561c == t.a.BELOW) {
            layoutParams.addRule(3, this.e);
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 30.0f);
        } else {
            layoutParams.addRule(6, this.e);
            layoutParams.addRule(1, this.e);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 8.0f);
        }
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.j.7
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f26735c != null) {
                    j.this.f26735c.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(gVar);
        imageView.setOnClickListener(gVar);
        this.f26734a.addView(imageView, layoutParams);
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        this.g.a(eVar.f26630a.f26633a, false);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        View view = this.l;
        if (view != null) {
            this.f26734a.removeView(view);
        }
        if (eVar.i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(7, this.e);
            layoutParams.addRule(8, this.e);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 10.0f);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 10.0f);
            this.l = com.opos.mobad.n.e.a(eVar, this.f26734a, layoutParams);
        }
    }

    private void f() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.b);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.f.j.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (j.this.n == null) {
                    return;
                }
                if (!z) {
                    j.this.g.f();
                    return;
                }
                j.this.j();
                j.this.g.g();
            }
        });
        this.f26734a.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void g() {
        TextView a2 = com.opos.mobad.n.e.a(this.b);
        a2.setText("反馈");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, this.e);
        layoutParams.addRule(7, this.e);
        int a3 = com.opos.cmn.an.h.f.a.a(this.b, 10.0f);
        layoutParams.rightMargin = a3;
        layoutParams.topMargin = a3;
        this.f26734a.addView(a2, layoutParams);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.j.6
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f26735c != null) {
                    j.this.f26735c.a(view, iArr);
                }
            }
        };
        a2.setOnTouchListener(gVar);
        a2.setOnClickListener(gVar);
        this.q = a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.j || this.i) {
            this.i = true;
            return;
        }
        a.InterfaceC0708a interfaceC0708a = this.f26735c;
        if (interfaceC0708a != null) {
            interfaceC0708a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j = true;
        a.InterfaceC0708a interfaceC0708a = this.f26735c;
        if (interfaceC0708a != null) {
            interfaceC0708a.e();
            if (this.i) {
                this.f26735c.b();
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.f26735c = interfaceC0708a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b = hVar.b();
        if (b == null) {
            com.opos.cmn.an.f.a.d("interVideo", "render with data null");
            a.InterfaceC0708a interfaceC0708a = this.f26735c;
            if (interfaceC0708a != null) {
                interfaceC0708a.b(1);
                return;
            }
            return;
        }
        if (b.f26630a != null && !TextUtils.isEmpty(b.f26630a.f26633a) && this.n == null) {
            b(b);
        }
        c(b);
        a(b);
        this.n = b;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f26734a;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.n = null;
        com.opos.mobad.c.c.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
            this.g.h();
        }
        this.h = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.o;
    }
}
