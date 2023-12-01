package com.opos.mobad.o.a.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.o.a.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f27033a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f27034c;
    private RelativeLayout d;
    private final int e = g.a();
    private final int f = g.a();
    private final int g = g.a();
    private d h;
    private d i;
    private e j;
    private e k;

    public b(Context context, c cVar) {
        this.f27033a = context;
        this.b = cVar;
        c();
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.a.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    b.this.b.a();
                }
            });
        }
    }

    private void c() {
        FrameLayout frameLayout = new FrameLayout(this.f27033a);
        this.f27034c = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#55000000"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27033a, 320.0f), -2);
        layoutParams.gravity = 17;
        RelativeLayout relativeLayout = new RelativeLayout(this.f27033a);
        this.d = relativeLayout;
        relativeLayout.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f27033a, 18.0f));
        this.d.setBackground(gradientDrawable);
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27033a, 320.0f), com.opos.cmn.an.h.f.a.a(this.f27033a, 320.0f)));
        this.f27034c.addView(this.d, layoutParams);
        a(this.f27034c);
        e();
        d();
    }

    private void d() {
        TextView textView = new TextView(this.f27033a);
        textView.setBackground(com.opos.cmn.an.d.a.a.c(this.f27033a, "opos_module_biz_ui_cmn_close_bn_bg_img.png"));
        textView.setGravity(17);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f27033a, 16.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f27033a, 10.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = a3;
        layoutParams.rightMargin = a3;
        this.d.addView(textView, layoutParams);
        a(textView);
    }

    private void e() {
        d dVar = new d(this.f27033a, this.b);
        this.h = dVar;
        dVar.a(new a.C0720a().a("不感兴趣").a(com.opos.mobad.o.a.a.b.TAG_REPEAT_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_LOW_QUALITY_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_LOW_RELATIVE_CONTENT).a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27033a, 288.0f), -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f27033a, 20.0f);
        layoutParams.addRule(14);
        View a2 = this.h.a();
        a2.setId(this.e);
        this.d.addView(a2, layoutParams);
        d dVar2 = new d(this.f27033a, this.b);
        this.i = dVar2;
        dVar2.a(new a.C0720a().a("投诉").a(com.opos.mobad.o.a.a.b.TAG_VULGAR_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_FAKE_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_AFFECT_OPERATION_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_INDUCE_CLICK_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_OTHER_CONTENT).a());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27033a, 288.0f), -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f27033a, 20.0f);
        layoutParams2.addRule(3, this.e);
        layoutParams2.addRule(14);
        View a3 = this.i.a();
        a3.setId(this.f);
        this.d.addView(a3, layoutParams2);
        e eVar = new e(this.f27033a, this.b);
        this.j = eVar;
        eVar.a(new a.C0720a().a(com.opos.mobad.o.a.a.b.TAG_CANNOT_CLOSE).a());
        View a4 = this.j.a();
        a4.setId(this.g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27033a, 288.0f), -2);
        layoutParams3.addRule(3, this.f);
        layoutParams3.addRule(14);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.f27033a, 20.0f);
        this.d.addView(a4, layoutParams3);
        e eVar2 = new e(this.f27033a, this.b);
        this.k = eVar2;
        eVar2.a(new a.C0720a().a(com.opos.mobad.o.a.a.b.TAG_DISPLAY_EXCEPTION).a());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27033a, 288.0f), -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.f27033a, 20.0f);
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f27033a, 20.0f);
        layoutParams4.addRule(3, this.g);
        layoutParams4.addRule(14);
        this.d.addView(this.k.a(), layoutParams4);
    }

    public View a() {
        return this.f27034c;
    }

    public void b() {
        FrameLayout frameLayout = this.f27034c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        d dVar = this.h;
        if (dVar != null) {
            dVar.b();
        }
        d dVar2 = this.i;
        if (dVar2 != null) {
            dVar2.b();
        }
        e eVar = this.j;
        if (eVar != null) {
            eVar.b();
        }
        e eVar2 = this.k;
        if (eVar2 != null) {
            eVar2.b();
        }
    }
}
