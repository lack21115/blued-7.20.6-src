package com.opos.cmn.e.a.b.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/b/c.class */
public class c extends a {
    protected ImageView g;
    private TextView h;
    private TextView i;
    private int[] j;

    public c(Context context) {
        super(context);
        this.j = new int[4];
    }

    public c(Context context, float f) {
        super(context, f);
        this.j = new int[4];
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11070a, 129.0f), com.opos.cmn.an.h.f.a.a(this.f11070a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        this.d.addView(this.h, layoutParams);
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11070a, 129.0f), com.opos.cmn.an.h.f.a.a(this.f11070a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.d.addView(this.i, layoutParams);
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11070a, 1.0f), com.opos.cmn.an.h.f.a.a(this.f11070a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.d.addView(this.g, layoutParams);
    }

    @Override // com.opos.cmn.e.a.b.b.a
    protected void a() {
        TextView textView = new TextView(this.f11070a);
        this.h = textView;
        textView.setGravity(17);
        this.h.setSingleLine();
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setTextColor(Color.parseColor("#767575"));
        this.h.setTextSize(1, 13.0f);
        TextView textView2 = new TextView(this.f11070a);
        this.i = textView2;
        textView2.setGravity(17);
        this.i.setSingleLine();
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setTextColor(Color.parseColor("#d95955"));
        this.i.setTextSize(1, 13.0f);
        ImageView imageView = new ImageView(this.f11070a);
        this.g = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.g.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        e();
        c();
        d();
    }

    public void a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.i.setText(str);
        this.i.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.j));
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.b.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                c.this.b.b(view, c.this.j);
            }
        });
    }

    public void b(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.h.setText(str);
        this.h.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.j));
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.b.b.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                c.this.b.a(view, c.this.j);
            }
        });
    }
}
