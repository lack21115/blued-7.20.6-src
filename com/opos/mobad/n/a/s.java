package com.opos.mobad.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/s.class */
public class s extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f26556a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26557c;
    private LinearLayout d;
    private LinearLayout e;
    private a.InterfaceC0708a f;

    public s(Context context) {
        super(context);
        b();
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        this.f26557c = textView;
        textView.setTextSize(1, 13.0f);
        this.f26557c.setTextColor(-1);
        this.f26557c.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f));
        linearLayout.addView(this.f26557c, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.b = textView2;
        textView2.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, -1);
        layoutParams2.setMargins(0, com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 6.0f));
        linearLayout.addView(this.b, layoutParams2);
        TextView textView3 = new TextView(getContext());
        this.f26556a = textView3;
        textView3.setTextSize(1, 13.0f);
        this.f26556a.setTextColor(-17650);
        this.f26556a.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f));
        linearLayout.addView(this.f26556a, layoutParams);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.s.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (s.this.f != null) {
                    s.this.f.i(view, iArr);
                }
            }
        };
        this.f26556a.setOnClickListener(gVar);
        this.f26556a.setOnTouchListener(gVar);
        linearLayout.setVisibility(8);
        this.d = linearLayout;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10);
        layoutParams3.addRule(9);
        linearLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_rectangle_btn_background);
        addView(linearLayout, layoutParams3);
        this.e = new LinearLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_close);
        this.e.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 32.0f), com.opos.cmn.an.h.f.a.a(getContext(), 32.0f)));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(10);
        layoutParams4.addRule(11);
        this.e.setBackgroundResource(R.drawable.opos_mobad_drawable_circlr_btn);
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.s.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (s.this.f != null) {
                    s.this.f.d(view, iArr);
                }
            }
        };
        this.e.setOnTouchListener(gVar2);
        this.e.setOnClickListener(gVar2);
        addView(this.e, layoutParams4);
        this.e.setVisibility(8);
    }

    public void a() {
        this.e.setVisibility(0);
    }

    public void a(int i, String str) {
        TextView textView;
        CharSequence charSequence;
        if (i == 0 && TextUtils.isEmpty(str)) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.f26557c.setText(str);
        this.b.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.f26557c.setVisibility(8);
            this.b.setVisibility(8);
        } else {
            this.f26557c.setVisibility(0);
        }
        if (i == 1) {
            textView = this.f26556a;
            charSequence = "跳过广告";
        } else if (i != 2) {
            this.f26556a.setVisibility(8);
            this.b.setVisibility(8);
            return;
        } else {
            textView = this.f26556a;
            charSequence = "VIP免广告";
        }
        textView.setText(charSequence);
        this.f26556a.setVisibility(0);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.f = interfaceC0708a;
    }
}
