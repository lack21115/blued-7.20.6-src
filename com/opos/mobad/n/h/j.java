package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/j.class */
public class j extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f13290a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13291c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private String h;
    private a.InterfaceC0538a i;

    public j(Context context) {
        super(context);
        this.h = "#2F80ED";
        a();
    }

    public static j a(Context context) {
        return new j(context);
    }

    private void a() {
        TextView textView = new TextView(getContext());
        this.f13290a = textView;
        textView.setId(View.generateViewId());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(16);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 0.67f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        this.f13290a.setTextSize(1, 10.0f);
        this.f13290a.setTextColor(Color.parseColor("#8CFFFFFF"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.f13290a.setSingleLine(true);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.f13290a, layoutParams3);
        TextView textView2 = new TextView(getContext());
        this.b = textView2;
        textView2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams4.addRule(1, this.f13290a.getId());
        layoutParams4.addRule(15);
        relativeLayout.addView(this.b, layoutParams4);
        TextView textView3 = new TextView(getContext());
        this.f13291c = textView3;
        textView3.setId(View.generateViewId());
        this.f13291c.setTextSize(1, 10.0f);
        this.f13291c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f13291c.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, this.b.getId());
        relativeLayout.addView(this.f13291c, layoutParams5);
        linearLayout.addView(relativeLayout, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        ViewGroup.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView4 = new TextView(getContext());
        this.d = textView4;
        textView4.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams7.addRule(15);
        relativeLayout2.addView(this.d, layoutParams7);
        TextView textView5 = new TextView(getContext());
        this.e = textView5;
        textView5.setId(View.generateViewId());
        this.e.setTextColor(Color.parseColor(this.h));
        this.e.setTextSize(1, 10.0f);
        this.e.setText("隐私");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams8.addRule(15);
        layoutParams8.addRule(1, this.d.getId());
        relativeLayout2.addView(this.e, layoutParams8);
        TextView textView6 = new TextView(getContext());
        this.f = textView6;
        textView6.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams9.addRule(1, this.e.getId());
        layoutParams9.addRule(15);
        relativeLayout2.addView(this.f, layoutParams9);
        TextView textView7 = new TextView(getContext());
        this.g = textView7;
        textView7.setId(View.generateViewId());
        this.g.setTextColor(Color.parseColor(this.h));
        this.g.setTextSize(1, 10.0f);
        this.g.setText("权限");
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams10.addRule(15);
        layoutParams10.addRule(1, this.f.getId());
        relativeLayout2.addView(this.g, layoutParams10);
        linearLayout.addView(relativeLayout2, layoutParams6);
        this.f13291c.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.b.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        this.d.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        this.f.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        addView(linearLayout, layoutParams);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.j.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.i != null) {
                    j.this.i.c(view, iArr);
                }
            }
        };
        this.g.setOnClickListener(gVar);
        this.g.setOnTouchListener(gVar);
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.j.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.i != null) {
                    j.this.i.b(view, iArr);
                }
            }
        };
        this.e.setOnClickListener(gVar2);
        this.e.setOnTouchListener(gVar2);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("RewardPrivacyView", "setListener " + interfaceC0538a);
        this.i = interfaceC0538a;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f13290a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f13291c.setText(str2);
    }
}
