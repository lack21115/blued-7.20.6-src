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
    private v f26927a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26928c;

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
        this.f26928c = textView;
        textView.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.f26928c.setTextSize(1, 12.0f);
        this.f26928c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f26928c.setSingleLine(true);
        TextPaint paint = this.f26928c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.addView(this.f26928c, new LinearLayout.LayoutParams(-1, -2));
    }

    private void b(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f)));
        v b = v.b(context, "");
        this.f26927a = b;
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
        layoutParams2.addRule(0, this.f26927a.getId());
        addView(this.f26927a, layoutParams);
        addView(this.b, layoutParams2);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BlockButtonInsideTheCardView", "setListener " + interfaceC0708a);
        this.f26927a.a(interfaceC0708a);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f26927a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f26928c.setText(str2);
    }
}
