package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.opos.mobad.n.d;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/d.class */
public class d extends TextView implements com.opos.mobad.n.d {
    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setGravity(17);
        setTextColor(-1);
        setTextSize(1, 14.0f);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int i2 = a2 * 2;
        setPadding(i2, a2, i2, a2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(60.0f);
        gradientDrawable.setColor(1711276032);
        com.opos.mobad.c.b.d.a(this, gradientDrawable);
    }

    @Override // com.opos.mobad.n.d
    public View a() {
        return this;
    }

    @Override // com.opos.mobad.n.d
    public void a(int i) {
        setText(String.format(Locale.getDefault(), "跳过 %1$d", Integer.valueOf(i)));
    }

    @Override // com.opos.mobad.n.d
    public void a(final d.a aVar) {
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.d.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                aVar.a(view, iArr);
            }
        };
        setOnClickListener(gVar);
        setOnTouchListener(gVar);
    }
}
