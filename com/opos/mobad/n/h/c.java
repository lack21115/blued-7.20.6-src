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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/c.class */
public class c extends TextView {

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.n.c.g f26955a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private a.InterfaceC0708a f26956c;

    public c(Context context, String str, int i, int i2, int i3) {
        super(context);
        this.b = "立即安装";
        this.f26955a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.c.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardClickButton", "onBtnClick");
                if (c.this.f26956c != null) {
                    c.this.f26956c.f(view, iArr);
                }
            }
        };
        this.b = TextUtils.isEmpty(str) ? this.b : str;
        a(i, i2, i3);
    }

    public static c a(Context context, String str) {
        return new c(context, str, R.drawable.opos_mobad_drawable_reward_block_click_btn, 12, 28);
    }

    private void a(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), i3));
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
        setOnClickListener(this.f26955a);
        setOnTouchListener(this.f26955a);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("RewardClickButton", "setListener " + interfaceC0708a);
        this.f26956c = interfaceC0708a;
    }
}
