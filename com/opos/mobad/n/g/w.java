package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/w.class */
public class w extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private v f26932a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26933c;
    private TextView d;

    public w(Context context) {
        super(context);
        b(context);
    }

    public static w a(Context context) {
        return new w(context);
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setGravity(3);
        com.opos.mobad.n.c.l lVar = new com.opos.mobad.n.c.l(getContext());
        lVar.setId(View.generateViewId());
        lVar.setTextColor(getResources().getColor(R.color.opos_mobad_button_txt_white_color));
        lVar.setTextSize(1, 10.0f);
        lVar.setLetterSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 0.67f));
        lVar.setText("广告");
        lVar.setBackgroundResource(R.drawable.opos_mobad_drawable_circlr_block_ad_txt);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        lVar.setPadding(a2, 0, a2, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 27.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        TextView textView = new TextView(getContext());
        this.f26933c = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_title_color));
        this.f26933c.setTextSize(1, 14.0f);
        this.f26933c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f26933c.setSingleLine(true);
        TextPaint paint = this.f26933c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(0, lVar.getId());
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        TextView textView2 = new TextView(getContext());
        this.d = textView2;
        textView2.setTextColor(getResources().getColor(R.color.opos_mobad_des_color));
        this.d.setTextSize(1, 12.0f);
        this.d.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.d.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        relativeLayout.addView(lVar, layoutParams2);
        relativeLayout.addView(this.f26933c, layoutParams3);
        this.b.addView(relativeLayout, layoutParams);
        this.b.addView(this.d, layoutParams4);
    }

    private void b(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f)));
        v a2 = v.a(context, "");
        this.f26932a = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        a();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams2.addRule(0, this.f26932a.getId());
        addView(this.f26932a, layoutParams);
        addView(this.b, layoutParams2);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BlockFusionRightAreaView", "setListener " + interfaceC0708a);
        this.f26932a.a(interfaceC0708a);
    }

    public void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.f26932a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f26933c.setText(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.d.setText(str3);
    }
}
