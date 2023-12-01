package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Paint;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/v.class */
public class v extends TextView {

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.n.c.g f26929a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private a.InterfaceC0708a f26930c;

    public v(Context context, String str, int i, int i2, int i3, int i4) {
        super(context);
        this.b = "下载";
        this.f26929a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.v.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BlockClickButton", "onBtnClick");
                if (v.this.f26930c != null) {
                    v.this.f26930c.f(view, iArr);
                }
            }
        };
        this.b = TextUtils.isEmpty(str) ? this.b : str;
        a(i, i2, i3, i4);
    }

    public static v a(Context context, String str) {
        return new v(context, str, R.drawable.opos_mobad_drawable_circlr_block_click_btn, context.getResources().getColor(R.color.opos_mobad_white_color), 12, 28);
    }

    private void a(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), i4));
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        setPadding(a2, a3, a2, a3);
        setLayoutParams(layoutParams);
        setBackgroundResource(i);
        setGravity(17);
        setTextSize(1, i3);
        setTextColor(i2);
        setText(this.b);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f26929a);
        setOnTouchListener(this.f26929a);
    }

    public static v b(Context context, String str) {
        return new v(context, str, R.drawable.opos_mobad_drawable_circlr_block_click_white_btn, context.getResources().getColor(R.color.opos_mobad_button_bg_white_color), 10, 26);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BlockClickButton", "setListener " + interfaceC0708a);
        this.f26930c = interfaceC0708a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setText(str);
    }
}
