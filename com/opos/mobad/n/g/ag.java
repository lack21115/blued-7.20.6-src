package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ag.class */
public class ag extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f13093a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f13094c;
    private View d;
    private int e;
    private View f;
    private ProgressBar g;
    private View h;
    private com.opos.mobad.c.c.a i;
    private String j;
    private boolean k;
    private com.opos.mobad.c.c.b l;
    private a.InterfaceC0538a m;
    private a n;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ag$a.class */
    public interface a {
        void a();

        void b();
    }

    private ag(Context context, int i, int i2, com.opos.mobad.c.c.a aVar) {
        super(context);
        this.j = "#4DFFFFFF";
        this.k = false;
        this.l = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.g.ag.2
            @Override // com.opos.mobad.c.c.b
            public void a(int i3, String str) {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onError:" + i3 + "," + str);
                if (ag.this.m != null) {
                    ag.this.m.a(i3, str);
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void c() {
                com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
                if (ag.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onPrepare mPlayer is null");
                } else if (ag.this.m != null) {
                    ag.this.m.d(0L, ag.this.i.c());
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void d() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onStart");
                if (ag.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onStart mPlayer is null");
                    return;
                }
                if (ag.this.n != null) {
                    ag.this.n.a();
                }
                ag.this.m.d(ag.this.i.d(), ag.this.i.c());
                ag.this.g.setProgress(0);
                ag.this.h.setVisibility(4);
                ag.this.k();
            }

            @Override // com.opos.mobad.c.c.b
            public void e() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete");
                if (ag.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete mPlayer is null");
                    return;
                }
                ag.this.h.setVisibility(0);
                if (ag.this.m != null) {
                    ag.this.m.a(ag.this.i.d(), ag.this.i.c());
                }
                if (ag.this.n != null) {
                    ag.this.n.b();
                }
                if (ag.this.g != null) {
                    ag.this.g.setProgress(100);
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void f() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onResume");
                if (ag.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onResume mPlayer is null");
                    return;
                }
                ag.this.h.setVisibility(4);
                ag.this.k = false;
                ag.this.k();
                if (ag.this.m != null) {
                    ag.this.m.b(ag.this.i.d(), ag.this.i.c());
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void g() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onPause");
                if (ag.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onPause mPlayer is null");
                    return;
                }
                ag.this.h.setVisibility(0);
                if (ag.this.m == null || ag.this.i == null) {
                    return;
                }
                ag.this.m.c(ag.this.i.d(), ag.this.i.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void h() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingStart");
                ag.this.l();
            }

            @Override // com.opos.mobad.c.c.b
            public void i() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingEnd");
                ag.this.k();
            }

            @Override // com.opos.mobad.c.c.b
            public void j() {
            }
        };
        this.f13093a = i == 0 ? 256 : i;
        this.b = i2 == 0 ? 144 : i2;
        this.i = aVar;
        aVar.a(this.l);
        a(context);
    }

    public static ag a(Context context, int i, int i2, com.opos.mobad.c.c.a aVar) {
        return new ag(context, i, i2, aVar);
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(this.f13093a, this.b));
        this.e = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f13094c = relativeLayout;
        relativeLayout.setId(this.e);
        addView(this.f13094c, new RelativeLayout.LayoutParams(this.f13093a, this.b));
        this.f13094c.setBackgroundColor(-16777216);
        this.d = this.i.b();
        this.i.d(-16777216);
        this.d.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f13093a, this.b);
        layoutParams.addRule(13);
        this.f13094c.addView(this.d, layoutParams);
        View view = new View(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.e);
        layoutParams2.addRule(5, this.e);
        layoutParams2.addRule(6, this.e);
        layoutParams2.addRule(8, this.e);
        this.f13094c.addView(view, layoutParams2);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ag.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (ag.this.m != null) {
                    ag.this.m.e(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(gVar);
        view.setOnClickListener(gVar);
        this.f = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 20.0f), com.opos.cmn.an.h.f.a.a(context, 29.0f));
        layoutParams3.addRule(13);
        this.f.setVisibility(0);
        this.f13094c.addView(this.f, layoutParams3);
        View view2 = new View(context);
        this.h = view2;
        view2.setBackground(context.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 42.0f), com.opos.cmn.an.h.f.a.a(context, 42.0f));
        layoutParams4.addRule(13);
        this.h.setVisibility(4);
        this.f13094c.addView(this.h, layoutParams4);
        ProgressBar progressBar = new ProgressBar(context);
        this.g = progressBar;
        progressBar.setId(View.generateViewId());
        com.opos.mobad.n.c.m.a(this.g, "mOnlyIndeterminate", new Boolean(false));
        this.g.setIndeterminate(false);
        this.g.setProgressDrawable(new ClipDrawable(new ColorDrawable(getResources().getColor(R.color.opos_mobad_video_progress_color)), 3, 1));
        this.g.setBackgroundColor(Color.parseColor(this.j));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(this.f13093a, com.opos.cmn.an.h.f.a.a(context, 2.0f));
        layoutParams5.addRule(12);
        this.g.setVisibility(0);
        this.f13094c.addView(this.g, layoutParams5);
    }

    private void j() {
        if (this.i == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "mPlayer is null");
            return;
        }
        this.h.setVisibility(4);
        this.i.a(0L);
        this.i.e();
        a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f.setVisibility(0);
    }

    public void a() {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "stop mPlayer is null");
            return;
        }
        this.k = true;
        int i = aVar.i();
        com.opos.mobad.c.c.a aVar2 = this.i;
        if (i == 2) {
            aVar2.f();
        }
    }

    public void a(int i) {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.a(i == 1 ? 1.0f : 0.0f);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("BlockVideoView", "setListener " + interfaceC0538a);
        this.m = interfaceC0538a;
    }

    public void a(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "mPlayer is null");
            return;
        }
        aVar.a(eVar.f12942a.f12945a, false);
        a(eVar.B);
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public void b() {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "stop mPlayer is null");
            return;
        }
        try {
            int i = aVar.i();
            if (i == 3) {
                this.i.g();
            } else if (i == 5) {
                j();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("BlockVideoView", "", (Throwable) e);
        }
    }

    public void c() {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar != null) {
            aVar.f();
            this.i.h();
            this.i = null;
        }
    }

    public void d() {
        String str;
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null) {
            str = "mPlayer is null";
        } else if (aVar.i() == 5) {
            return;
        } else {
            if (this.i.i() != 3 || !this.k) {
                this.i.g();
                return;
            }
            str = "resume but user pause";
        }
        com.opos.cmn.an.f.a.b("BlockVideoView", str);
    }

    public void e() {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void f() {
        ProgressBar progressBar;
        if (this.i == null || (progressBar = this.g) == null) {
            return;
        }
        progressBar.setProgress(i());
        com.opos.cmn.an.f.a.b("BlockVideoView", "on progress" + this.g.getProgress());
    }

    public int g() {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null) {
            return 0;
        }
        return (int) aVar.d();
    }

    public int h() {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null) {
            return 0;
        }
        return (int) aVar.c();
    }

    public int i() {
        com.opos.mobad.c.c.a aVar = this.i;
        if (aVar == null || 0 == aVar.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.i.d() * 100) / this.i.c()));
    }
}
