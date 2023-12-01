package com.opos.mobad.o.a.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.cmn.a.b.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f13348a;
    private RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13349c;
    private GridLayout d;
    private c e;
    private GradientDrawable f;
    private GradientDrawable g;
    private int h;

    public d(Context context, c cVar) {
        this.f13348a = context;
        this.e = cVar;
        c();
    }

    private TextView a(int i, com.opos.mobad.o.a.a.b bVar) {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f13348a, this.f, this.g, Color.parseColor("#8C000000"), Color.parseColor("#FF5A60"));
        aVar.setGravity(17);
        aVar.setTextSize(1, 12.0f);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13348a, 92.0f), com.opos.cmn.an.h.f.a.a(this.f13348a, 31.0f)));
        double d = i;
        double d2 = d / 3.0d;
        if (d % 3.0d != 0.0d) {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f13348a, 6.0f);
        }
        if (d2 >= 1.0d) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f13348a, 6.0f);
        }
        aVar.setText(bVar.b());
        aVar.setLayoutParams(layoutParams);
        a(aVar, bVar.a());
        return aVar;
    }

    private void a(View view, final int i) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.a.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (d.this.e != null) {
                        d.this.e.a(i);
                    }
                }
            });
        }
    }

    private void c() {
        this.b = new RelativeLayout(this.f13348a);
        this.f13349c = new TextView(this.f13348a);
        int a2 = g.a();
        this.h = a2;
        this.f13349c.setId(a2);
        this.f13349c.setTextColor(Color.parseColor("#8C000000"));
        this.f13349c.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f13348a, 17.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.b.addView(this.f13349c, layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#F5F6F7"));
        this.f.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f13348a, 5.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.g = gradientDrawable2;
        gradientDrawable2.setColor(Color.parseColor("#1AFF5A60"));
        this.g.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f13348a, 5.0f));
    }

    public View a() {
        return this.b;
    }

    public void a(com.opos.mobad.o.a.a.a aVar) {
        if (aVar != null) {
            this.f13349c.setText(aVar.f13341a);
            int size = aVar.b.size();
            if (size > 0) {
                this.d = new GridLayout(this.f13348a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13348a, 288.0f), -2);
                layoutParams.addRule(3, this.h);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f13348a, 8.0f);
                this.d.setColumnCount(3);
                this.d.setRowCount((int) Math.ceil(size / 3.0d));
                this.d.setOrientation(0);
                this.d.setUseDefaultMargins(false);
                this.b.addView(this.d, layoutParams);
                for (int i = 0; i < aVar.b.size(); i++) {
                    this.d.addView(a(i, aVar.b.get(i)));
                }
            }
        }
    }

    public void b() {
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (this.e != null) {
            this.e = null;
        }
    }
}
