package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/g.class */
public class g extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f13282a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13283c;
    private a.InterfaceC0538a d;

    public g(Context context) {
        super(context);
        a();
    }

    public static g a(Context context) {
        return new g(context);
    }

    private void a() {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_title_bg);
        setGravity(16);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(a3, a2, a3, a2);
        TextView textView = new TextView(getContext());
        this.f13282a = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.f13282a.setTextSize(1, 14.0f);
        addView(this.f13282a, new LinearLayout.LayoutParams(-2, -1));
        View view = new View(getContext());
        this.b = view;
        view.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        addView(this.b, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f13283c = textView2;
        textView2.setTextColor(Color.parseColor("#FFBB0E"));
        this.f13283c.setTextSize(1, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        addView(this.f13283c, layoutParams2);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.g.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardLeftBar", "onVIPClick");
                if (g.this.d != null) {
                    g.this.d.i(view2, iArr);
                }
            }
        };
        this.f13283c.setOnClickListener(gVar);
        this.f13283c.setOnTouchListener(gVar);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.d = interfaceC0538a;
    }

    public void a(String str, int i) {
        TextView textView;
        CharSequence charSequence;
        if (this.f13282a != null) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            this.f13282a.setVisibility(0);
            this.f13282a.setText(str);
        }
        if (i != 0) {
            this.b.setVisibility(0);
            this.f13283c.setVisibility(0);
            if (i == 1) {
                textView = this.f13283c;
                charSequence = "跳过广告";
            } else if (i == 2) {
                textView = this.f13283c;
                charSequence = "VIP免广告";
            } else {
                this.f13283c.setVisibility(8);
            }
            textView.setText(charSequence);
            this.f13283c.setVisibility(0);
            return;
        }
        this.b.setVisibility(8);
        this.f13283c.setVisibility(8);
    }
}
