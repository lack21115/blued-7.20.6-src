package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/e.class */
public class e extends TextView {

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.n.c.g f13273a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private a.InterfaceC0538a f13274c;

    public e(Context context, String str, int i, int i2, int i3) {
        super(context);
        this.b = "立即安装";
        this.f13273a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.e.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardEndClickButton", "onBtnClick");
                if (e.this.f13274c != null) {
                    e.this.f13274c.k(view, iArr);
                }
            }
        };
        this.b = TextUtils.isEmpty(str) ? this.b : str;
        a(i, i2, i3);
    }

    public static e a(Context context, String str) {
        return new e(context, str, R.drawable.opos_mobad_drawable_reward_endclick_btn, 14, 44);
    }

    private void a(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), i3));
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        setPadding(a2, a3, a2, a3);
        setLayoutParams(layoutParams);
        setBackgroundResource(i);
        setGravity(17);
        setTextSize(1, i2);
        setTextColor(Color.parseColor("#000000"));
        setText(this.b);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f13273a);
        setOnTouchListener(this.f13273a);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.f13274c = interfaceC0538a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setText(str);
    }
}
