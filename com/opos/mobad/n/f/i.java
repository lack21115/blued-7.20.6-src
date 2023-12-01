package com.opos.mobad.n.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/i.class */
public class i extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.n.a.k f13043a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13044c;
    private int d;
    private a.InterfaceC0538a e;

    public i(Context context) {
        super(context);
        this.d = 0;
        a();
    }

    private void a() {
        setAlpha(0.7f);
        this.f13043a = com.opos.mobad.n.a.k.a(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams.addRule(9);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        addView(this.f13043a, layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        TextView textView = new TextView(getContext());
        this.b = textView;
        textView.setId(View.generateViewId());
        this.b.setBackground(gradientDrawable);
        this.b.setTextColor(-1);
        this.b.setTextSize(1, 14.0f);
        this.b.setGravity(17);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.b.setSingleLine();
        this.b.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.b.setPadding(a2, 0, a2, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        addView(this.b, layoutParams2);
        this.f13044c = new TextView(getContext());
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.i.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (i.this.e != null) {
                    a.InterfaceC0538a interfaceC0538a = i.this.e;
                    boolean z = true;
                    if (i.this.d != 1) {
                        z = false;
                    }
                    interfaceC0538a.a(view, iArr, z);
                }
            }
        };
        this.f13044c.setOnClickListener(gVar);
        this.f13044c.setOnTouchListener(gVar);
        this.f13044c.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 15.7f), com.opos.cmn.an.h.f.a.a(getContext(), 13.68f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, this.b.getId());
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        addView(this.f13044c, layoutParams3);
    }

    private void a(int i) {
        TextView textView;
        Resources resources;
        int i2;
        if (this.d != i) {
            this.d = i;
            if (i == 0) {
                textView = this.f13044c;
                resources = getContext().getResources();
                i2 = R.drawable.opos_mobad_drawable_sound_off;
            } else if (i == 2) {
                this.f13044c.setVisibility(8);
                return;
            } else {
                textView = this.f13044c;
                resources = getContext().getResources();
                i2 = R.drawable.opos_mobad_drawable_sound_on;
            }
            textView.setBackground(resources.getDrawable(i2));
        }
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.e = interfaceC0538a;
        this.f13043a.a(interfaceC0538a);
    }

    public void a(boolean z, int i, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        this.f13043a.a(z, str, z2, gVar, str2);
        this.b.setText(m.a(getContext()));
        a(i);
    }
}
