package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/b.class */
public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f12803a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f12804c;
    private a.InterfaceC0538a d;

    public b(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f12803a = linearLayout;
        linearLayout.setOrientation(0);
        this.f12803a.setId(View.generateViewId());
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 9.0f);
        textView.setTextColor(Color.parseColor("#2F80ED"));
        textView.setText("隐私政策");
        textView.setGravity(17);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.b.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.d != null) {
                    b.this.d.b(view, iArr);
                }
            }
        };
        textView.setOnTouchListener(gVar);
        textView.setOnClickListener(gVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f));
        layoutParams.gravity = 16;
        this.f12803a.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundColor(872415231);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, com.opos.cmn.an.h.f.a.a(getContext(), 7.0f));
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f12803a.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(getContext());
        textView3.setTextSize(1, 9.0f);
        textView3.setTextColor(Color.parseColor("#2F80ED"));
        textView3.setGravity(17);
        textView3.setText("应用权限");
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.b.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.d != null) {
                    b.this.d.c(view, iArr);
                }
            }
        };
        textView3.setOnTouchListener(gVar2);
        textView3.setOnClickListener(gVar2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f));
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f12803a.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.f12804c = textView4;
        textView4.setId(View.generateViewId());
        this.f12804c.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f12804c.setTextSize(1, 9.0f);
        this.f12804c.setSingleLine();
        this.f12804c.setMaxEms(21);
        this.f12804c.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView5 = new TextView(getContext());
        this.b = textView5;
        textView5.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.b.setTextSize(1, 9.0f);
        this.b.setSingleLine();
        this.b.setMaxEms(21);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
    }

    private void a(int i) {
        int i2;
        int i3;
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 13.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, a2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, a2);
        if (i == 0) {
            layoutParams.addRule(10);
            i2 = 14;
            layoutParams.addRule(14);
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
            i3 = 3;
            layoutParams2.addRule(3, this.f12803a.getId());
            layoutParams2.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        } else {
            layoutParams.addRule(9);
            i2 = 15;
            layoutParams.addRule(15);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
            i3 = 1;
            layoutParams2.addRule(1, this.f12803a.getId());
            layoutParams2.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
        }
        layoutParams3.addRule(i3, this.f12804c.getId());
        layoutParams3.addRule(i2);
        addView(this.f12803a, layoutParams);
        addView(this.f12804c, layoutParams2);
        addView(this.b, layoutParams3);
    }

    public void a(int i, String str, String str2) {
        a(i);
        this.f12804c.setText("版本号：" + str);
        this.b.setText("开发者：" + str2);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.d = interfaceC0538a;
    }
}
