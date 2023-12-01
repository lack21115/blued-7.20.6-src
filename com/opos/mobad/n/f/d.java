package com.opos.mobad.n.f;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/d.class */
public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.n.c.f f26679a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26680c;
    private FrameLayout d;
    private TextView e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private int l;

    public d(Context context, int i) {
        super(context);
        this.l = 1;
        this.l = i;
        c();
    }

    public static d a(Context context) {
        return new d(context, 1);
    }

    public static d b(Context context) {
        return new d(context, 0);
    }

    private void c() {
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        this.f26679a = fVar;
        fVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 60.0f), com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        layoutParams.addRule(this.l == 1 ? 14 : 15);
        addView(this.f26679a, layoutParams);
        e();
        d();
    }

    private void d() {
        TextView textView;
        float f;
        int a2;
        int a3;
        float f2;
        RelativeLayout.LayoutParams layoutParams;
        this.d = new FrameLayout(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 36.0f));
        this.d.setBackground(gradientDrawable);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TextView textView2 = new TextView(getContext());
        this.f26680c = textView2;
        textView2.setId(View.generateViewId());
        this.f26680c.setTextColor(-1);
        if (this.l == 1) {
            textView = this.f26680c;
            f = 14.0f;
        } else {
            textView = this.f26680c;
            f = 10.0f;
        }
        textView.setTextSize(1, f);
        this.f26680c.setGravity(17);
        this.f26680c.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        relativeLayout.addView(this.f26680c, layoutParams2);
        TextView textView3 = new TextView(getContext());
        this.j = textView3;
        textView3.setId(View.generateViewId());
        this.j.setBackgroundResource(R.drawable.opos_mobad_bn_white_vector);
        if (this.l == 1) {
            a2 = com.opos.cmn.an.h.f.a.a(getContext(), 5.9f);
            a3 = com.opos.cmn.an.h.f.a.a(getContext(), 10.5f);
            f2 = 7.04f;
        } else {
            a2 = com.opos.cmn.an.h.f.a.a(getContext(), 3.56f);
            a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.36f);
            f2 = 1.62f;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams3.addRule(1, this.f26680c.getId());
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), f2);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.j, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.k = textView4;
        textView4.setId(View.generateViewId());
        this.k.setBackgroundResource(R.drawable.opos_mobad_bn_white_vector);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.l == 1 ? 2.07f : 0.44f);
        layoutParams4.addRule(1, this.j.getId());
        layoutParams4.addRule(15);
        relativeLayout.addView(this.k, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        this.d.addView(relativeLayout, layoutParams5);
        if (this.l == 1) {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
            layoutParams.addRule(14);
            layoutParams.addRule(3, this.b.getId());
        } else {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 68.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
            layoutParams.addRule(15);
            layoutParams.addRule(11);
        }
        addView(this.d, layoutParams);
    }

    private void e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.b.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setTypeface(Typeface.defaultFromStyle(1));
        this.e.setTextColor(-16777216);
        this.e.setTextSize(1, 14.0f);
        this.e.setGravity(17);
        this.e.setMaxEms(6);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.l == 1) {
            layoutParams.gravity = 1;
        } else {
            layoutParams.gravity = 3;
        }
        this.b.addView(this.e, layoutParams);
        f();
        TextView textView2 = new TextView(getContext());
        this.g = textView2;
        textView2.setTextColor(Color.parseColor("#8C000000"));
        this.g.setTextSize(1, 12.0f);
        this.g.setGravity(17);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        if (this.l == 1) {
            this.g.setMaxEms(13);
            layoutParams2.gravity = 1;
        } else {
            this.g.setMaxEms(7);
            layoutParams2.gravity = 3;
        }
        this.b.addView(this.g, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        if (this.l == 1) {
            layoutParams3.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            layoutParams3.addRule(3, this.f26679a.getId());
            layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        } else {
            layoutParams3.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(1, this.f26679a.getId());
        }
        addView(this.b, layoutParams3);
    }

    private void f() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f = linearLayout;
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        textView.setBackgroundResource(R.drawable.opos_mobad_download_vector);
        layoutParams.gravity = 16;
        this.f.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.h = textView2;
        textView2.setTextColor(Color.parseColor("#8C000000"));
        this.h.setTextSize(1, 10.0f);
        this.h.setGravity(17);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 16;
        this.f.addView(this.h, layoutParams2);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(-1946157056);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(2, -1);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 2.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 2.0f));
        this.f.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.i = textView4;
        textView4.setTextColor(Color.parseColor("#8C000000"));
        this.i.setTextSize(1, 10.0f);
        this.i.setGravity(17);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setSingleLine();
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.gravity = 16;
        this.f.addView(this.i, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        if (this.l == 1) {
            layoutParams5.gravity = 1;
        } else {
            layoutParams5.gravity = 3;
        }
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.b.addView(this.f, layoutParams5);
    }

    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.j, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.k, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        ofFloat2.setStartDelay(170L);
        animatorSet.setDuration(1400L);
        animatorSet.start();
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f26679a.setImageBitmap(bitmap);
    }

    public void a(com.opos.mobad.n.c.g gVar) {
        this.d.setOnClickListener(gVar);
        this.d.setOnTouchListener(gVar);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            this.b.setVisibility(8);
        }
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(str2);
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            this.f.setVisibility(8);
        } else {
            this.i.setText(str4);
            this.h.setText(str3);
        }
        this.f26680c.setText(str5);
    }

    public void b() {
        this.f26679a.setVisibility(8);
    }
}
