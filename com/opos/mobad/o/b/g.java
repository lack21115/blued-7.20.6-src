package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/g.class */
public class g extends com.opos.cmn.e.a.b.b.b {
    private RelativeLayout e;
    private TextView f;

    public g(Context context) {
        super(context);
    }

    private void f() {
        this.e = new RelativeLayout(this.f24760a);
        g();
        h();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f24761c.addView(this.e, layoutParams);
    }

    private void g() {
        this.d = new ImageView(this.f24760a);
        this.d.setId(1);
        this.d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.d.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f24760a, "opos_module_biz_ui_native_video_loading_img.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f24760a, 24.0f), com.opos.cmn.an.h.f.a.a(this.f24760a, 24.0f));
        layoutParams.addRule(14);
        this.e.addView(this.d, layoutParams);
    }

    private void h() {
        TextView textView = new TextView(this.f24760a);
        this.f = textView;
        textView.setText("加载中...");
        this.f.setTextColor(-1);
        this.f.setTextSize(1, 14.0f);
        this.f.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f24760a, 12.0f);
        layoutParams.addRule(3, 1);
        this.e.addView(this.f, layoutParams);
    }

    @Override // com.opos.cmn.e.a.b.b.b
    public void a() {
        ImageView imageView = new ImageView(this.f24760a);
        imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#000000")));
        imageView.setAlpha(0.4f);
        this.f24761c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.cmn.e.a.b.b.b
    public void b() {
        f();
    }
}
