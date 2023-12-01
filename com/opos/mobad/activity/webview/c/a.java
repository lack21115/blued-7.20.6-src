package com.opos.mobad.activity.webview.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f25655a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f25656c = null;
    private com.opos.mobad.activity.webview.b.a d;

    public a(Context context, com.opos.mobad.activity.webview.b.a aVar) {
        this.f25655a = context;
        this.d = aVar;
        b();
    }

    private void b() {
        c();
        d();
    }

    private void c() {
        LinearLayout linearLayout = new LinearLayout(this.f25655a);
        this.b = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f25655a, 43.33f)));
        com.opos.cmn.e.a.d.a.a(this.b, com.opos.cmn.an.d.a.a.c(this.f25655a, "o_cmn_biz_ui_web_title_bar_bg.9.png"));
        this.f25656c = new TextView(this.f25655a);
        Drawable c2 = com.opos.cmn.an.d.a.a.c(this.f25655a, "o_cmn_biz_ui_web_close_bn.png");
        c2.setBounds(0, 0, com.opos.cmn.an.h.f.a.a(this.f25655a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f25655a, 24.0f));
        this.f25656c.setCompoundDrawables(c2, null, null, null);
        this.f25656c.setGravity(17);
        this.f25656c.setTextSize(1, 15.0f);
        this.f25656c.setTextColor(Color.parseColor("#2ac795"));
        this.f25656c.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f25655a, 2.0f));
        this.f25656c.setText("返回");
        this.b.addView(this.f25656c, new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f25655a, 43.33f)));
    }

    private void d() {
        TextView textView = this.f25656c;
        if (textView == null || this.d == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                a.this.d.c();
            }
        });
    }

    public View a() {
        return this.b;
    }
}
