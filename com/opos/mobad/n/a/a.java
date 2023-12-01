package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/a.class */
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.n.c.f f26489a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26490c;

    public a(Context context) {
        super(context);
        a();
    }

    private void a() {
        setGravity(1);
        setOrientation(1);
        this.f26489a = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 70.0f), com.opos.cmn.an.h.f.a.a(getContext(), 70.0f));
        this.f26489a.setScaleType(ImageView.ScaleType.FIT_START);
        this.f26489a.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        this.f26490c = textView;
        textView.setTextSize(1, 24.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.c(getContext(), 6.0f);
        this.f26490c.setTextColor(Color.parseColor("#000000"));
        this.f26490c.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.b = textView2;
        textView2.setTextSize(1, 14.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
        this.b.setTextColor(Color.parseColor("#80000000"));
        this.b.setLayoutParams(layoutParams3);
        addView(this.f26489a);
        addView(this.f26490c);
        addView(this.b);
        setVisibility(4);
    }

    private void a(int i) {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        if (i == 0) {
            context = getContext();
            f = 200.0f;
        } else {
            context = getContext();
            f = 50.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, f);
        setLayoutParams(layoutParams);
    }

    public void a(int i, Bitmap bitmap, String str, String str2) {
        this.f26489a.setImageBitmap(bitmap);
        if (!TextUtils.isEmpty(str)) {
            this.f26490c.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setText(str2);
        }
        a(i);
        setVisibility(0);
    }
}
