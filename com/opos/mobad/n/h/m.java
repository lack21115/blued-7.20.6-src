package com.opos.mobad.n.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/m.class */
public class m extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f13307a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private int f13308c;
    private View d;
    private com.opos.mobad.c.c.a e;
    private boolean f;
    private com.opos.mobad.c.c.b g;
    private a h;

    private m(Context context, com.opos.mobad.c.c.a aVar) {
        super(context);
        this.f = false;
        com.opos.mobad.c.c.b bVar = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.h.m.2
            @Override // com.opos.mobad.c.c.b
            public void a(int i, String str) {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onError:" + i + "," + str);
                if (m.this.h != null) {
                    m.this.h.a(i, str);
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void c() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPrepare");
                if (m.this.h != null) {
                    m.this.h.e();
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void d() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onStart");
                if (m.this.h != null) {
                    m.this.h.d(0L, m.this.e != null ? m.this.e.c() : 0L);
                }
                m.this.h();
            }

            @Override // com.opos.mobad.c.c.b
            public void e() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onComplete");
                if (m.this.e == null || m.this.h == null) {
                    return;
                }
                m.this.h.a(m.this.e.c(), m.this.e.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void f() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onResume");
                m.this.h();
                if (m.this.h == null || m.this.e == null) {
                    return;
                }
                m.this.h.b(m.this.e.d(), m.this.e.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void g() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPause");
                if (m.this.h == null || m.this.e == null) {
                    return;
                }
                m.this.h.c(m.this.e.d(), m.this.e.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void h() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingStart");
                m.this.i();
            }

            @Override // com.opos.mobad.c.c.b
            public void i() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingEnd");
                m.this.h();
            }

            @Override // com.opos.mobad.c.c.b
            public void j() {
                if (m.this.h != null) {
                    m.this.h.a();
                }
            }
        };
        this.g = bVar;
        this.e = aVar;
        aVar.a(bVar);
        a(context);
    }

    public static m a(Context context, com.opos.mobad.c.c.a aVar) {
        return new m(context, aVar);
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f13308c = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f13307a = relativeLayout;
        relativeLayout.setId(this.f13308c);
        addView(this.f13307a, new RelativeLayout.LayoutParams(-1, -1));
        this.b = this.e.b();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f13307a.addView(this.b, layoutParams);
        View view = new View(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.f13308c);
        layoutParams2.addRule(5, this.f13308c);
        layoutParams2.addRule(6, this.f13308c);
        layoutParams2.addRule(8, this.f13308c);
        this.f13307a.addView(view, layoutParams2);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.m.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (m.this.h != null) {
                    m.this.h.e(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(gVar);
        view.setOnClickListener(gVar);
        this.d = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 20.0f), com.opos.cmn.an.h.f.a.a(context, 29.0f));
        layoutParams3.addRule(13);
        this.d.setVisibility(0);
        this.f13307a.addView(this.d, layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.d.setVisibility(0);
    }

    public void a() {
        com.opos.mobad.c.c.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
            return;
        }
        this.f = true;
        int i = aVar.i();
        com.opos.mobad.c.c.a aVar2 = this.e;
        if (i == 2) {
            aVar2.f();
        }
    }

    public void a(int i) {
        com.opos.mobad.c.c.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(i == 1 ? 1.0f : 0.0f);
    }

    public void a(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.c.c.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
            return;
        }
        aVar.a(eVar.f12942a.f12945a, false);
        a(eVar.B);
    }

    public void a(a aVar) {
        com.opos.cmn.an.f.a.b("RewardVideoView", "setListener " + aVar);
        this.h = aVar;
    }

    public com.opos.mobad.c.c.a b() {
        return this.e;
    }

    public void c() {
        if (this.e == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
        } else {
            e();
        }
    }

    public void d() {
        com.opos.mobad.c.c.a aVar = this.e;
        if (aVar != null) {
            aVar.f();
            this.e.h();
            this.e = null;
        }
    }

    public void e() {
        com.opos.mobad.c.c.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
        } else if (aVar.i() != 5) {
            this.e.g();
        }
    }

    public int f() {
        com.opos.mobad.c.c.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        try {
            return (int) aVar.d();
        } catch (Exception e) {
            return 0;
        }
    }

    public int g() {
        com.opos.mobad.c.c.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        try {
            return (int) aVar.c();
        } catch (Exception e) {
            return 0;
        }
    }
}
