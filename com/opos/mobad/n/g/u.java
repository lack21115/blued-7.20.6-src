package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/u.class */
public class u extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private v f13239a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13240c;

    public u(Context context) {
        super(context);
        b(context);
    }

    public static u a(Context context) {
        return new u(context);
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f13240c = textView;
        textView.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.f13240c.setTextSize(1, 12.0f);
        this.f13240c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f13240c.setSingleLine(true);
        TextPaint paint = this.f13240c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.addView(this.f13240c, new LinearLayout.LayoutParams(-1, -2));
    }

    private void b(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f)));
        v b = v.b(context, "");
        this.f13239a = b;
        b.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        a();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams2.addRule(0, this.f13239a.getId());
        addView(this.f13239a, layoutParams);
        addView(this.b, layoutParams2);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("BlockButtonInsideTheCardView", "setListener " + interfaceC0538a);
        this.f13239a.a(interfaceC0538a);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f13239a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f13240c.setText(str2);
    }
}
