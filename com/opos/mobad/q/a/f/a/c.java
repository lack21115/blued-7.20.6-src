package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.i.m;
import com.opos.cmn.j.b;
import com.opos.mobad.e.a.g;
import com.opos.mobad.e.a.h;
import com.opos.mobad.e.a.l;
import com.opos.mobad.e.a.n;
import com.opos.mobad.n.a;
import com.opos.mobad.q.a.i;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a/c.class */
public class c implements com.opos.mobad.n.a {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private a.InterfaceC0538a f13496c;
    private RelativeLayout d;
    private FrameLayout e;
    private g f;
    private String h;
    private int i;
    private com.opos.mobad.n.d.g j;

    /* renamed from: a  reason: collision with root package name */
    private String f13495a = "#c0000000";
    private m g = new m(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.q.a.f.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "render timeout");
        }
    });

    public c(Context context, int i, a.InterfaceC0538a interfaceC0538a) {
        this.b = context;
        this.f13496c = interfaceC0538a;
        this.i = i;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.d = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f13495a));
        com.opos.cmn.j.b bVar = new com.opos.cmn.j.b(this.b);
        bVar.a(new b.a() { // from class: com.opos.mobad.q.a.f.a.c.2
            @Override // com.opos.cmn.j.b.a
            public void a(boolean z) {
                if (c.this.f == null) {
                    return;
                }
                if (z) {
                    c.this.f.c();
                } else {
                    c.this.f.b();
                }
            }
        });
        this.d.addView(bVar, new ViewGroup.LayoutParams(0, 0));
        this.e = new FrameLayout(this.b);
        this.d.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(this.b);
        textView.setGravity(17);
        com.opos.mobad.cmn.a.b.g.a(textView, com.opos.cmn.an.d.a.a.c(this.b, "opos_module_biz_ui_reward_video_float_layer_close_bn.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 30.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 54.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 11.0f);
        layoutParams.addRule(11);
        this.d.addView(textView, layoutParams);
        i iVar = new i() { // from class: com.opos.mobad.q.a.f.a.c.3
            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                if (c.this.f13496c != null) {
                    c.this.f13496c.d(view, (int[]) null);
                }
            }
        };
        textView.setOnTouchListener(iVar);
        textView.setOnClickListener(iVar);
        i iVar2 = new i() { // from class: com.opos.mobad.q.a.f.a.c.4
            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                if (c.this.f13496c != null) {
                    c.this.f13496c.j(view, iArr);
                }
            }
        };
        this.d.setOnTouchListener(iVar2);
        this.d.setOnClickListener(iVar2);
    }

    private void a(com.opos.mobad.n.d.f fVar) {
        if (this.f == null) {
            return;
        }
        String str = (fVar.h == null || fVar.h.size() <= 0 || fVar.h.get(0) == null) ? "" : fVar.h.get(0).f12945a;
        this.f.a(fVar.b);
        this.f.b(fVar.f12944c);
        this.f.c(fVar.d);
        this.f.a((Object) str);
    }

    private void a(final com.opos.mobad.n.d.f fVar, String str) {
        com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "prepare and show");
        n.a(str, com.opos.mobad.cmn.service.b.a.a().a(this.b, str).getAbsolutePath(), new h() { // from class: com.opos.mobad.q.a.f.a.c.5
            @Override // com.opos.mobad.e.a.h
            public void a(boolean z, final String str2) {
                if (z) {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.f.a.c.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.b(fVar, str2);
                        }
                    });
                } else {
                    com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "prepare fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.mobad.n.d.f fVar, String str) {
        com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "show");
        this.g.a(com.anythink.expressad.video.module.a.a.m.ag);
        g a2 = n.a().a(true).a(fVar.b).b(fVar.f12944c).c(fVar.d).a((Object) ((fVar.h == null || fVar.h.size() <= 0 || fVar.h.get(0) == null) ? "" : fVar.h.get(0).f12945a)).a(new com.opos.mobad.e.a.a() { // from class: com.opos.mobad.q.a.f.a.c.7
            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str2, l lVar, int i, String str3, int i2) {
                int[] iArr = {lVar.f12311c, lVar.d, lVar.f, lVar.g};
                if (i == 0) {
                    if (c.this.f13496c != null) {
                        c.this.f13496c.k(c.this.e, iArr);
                    }
                } else if (1 == i) {
                    if (c.this.f13496c != null) {
                        c.this.f13496c.j(c.this.e, iArr);
                    }
                } else {
                    com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "unknown click:" + i);
                }
            }

            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str2, l lVar, String str3, int i) {
            }
        }).a(new com.opos.mobad.e.a.i() { // from class: com.opos.mobad.q.a.f.a.c.6
            @Override // com.opos.mobad.e.a.i
            public void a(Map map) {
                com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "load success");
                c.this.g.a();
            }

            @Override // com.opos.mobad.e.a.i
            public void a(Map map, String str2) {
                com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "load fail :" + str2);
            }
        }).a(this.b, str, fVar.I, fVar.J);
        this.f = a2;
        View a3 = a2.a();
        this.h = str;
        com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "show view :" + a3);
        this.e.removeAllViews();
        this.e.addView(a3, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.f13496c = interfaceC0538a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.f e = hVar.e();
        if (e == null || e.H == null) {
            return;
        }
        com.opos.mobad.n.d.g gVar = e.H;
        com.opos.mobad.n.d.g gVar2 = this.j;
        if (gVar2 != null && gVar2.f12945a.equals(gVar.f12945a)) {
            a(e);
            return;
        }
        this.e.removeAllViews();
        g gVar3 = this.f;
        if (gVar3 != null) {
            gVar3.d();
        }
        this.j = gVar;
        a(e, gVar.f12945a);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        String str = this.h;
        if (!TextUtils.isEmpty(str)) {
            com.opos.mobad.cmn.service.b.a.a().a(str);
        }
        g gVar = this.f;
        if (gVar != null) {
            gVar.d();
        }
        this.f13496c = null;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.i;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: f */
    public RelativeLayout c() {
        return this.d;
    }
}
