package com.opos.mobad.n.b;

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
import com.opos.mobad.n.g.v;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/b/d.class */
public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private v f26584a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26585c;
    private TextView d;
    private c e;
    private e f;

    public d(Context context, boolean z) {
        super(context);
        a(context, z);
    }

    public static d a(Context context) {
        return new d(context, false);
    }

    private void a(Context context, boolean z) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 60.0f)));
        v a2 = v.a(context, "");
        this.f26584a = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        a(z);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams2.addRule(0, this.f26584a.getId());
        addView(this.f26584a, layoutParams);
        addView(this.b, layoutParams2);
    }

    private void a(RelativeLayout relativeLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 11.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        e a2 = e.a(getContext());
        this.f = a2;
        a2.setId(View.generateViewId());
        relativeLayout.addView(this.f, layoutParams);
    }

    private void a(boolean z) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setGravity(3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            a(relativeLayout);
        }
        TextView textView = new TextView(getContext());
        this.f26585c = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_title_color));
        this.f26585c.setTextSize(1, 14.0f);
        this.f26585c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f26585c.setSingleLine(true);
        TextPaint paint = this.f26585c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        e eVar = this.f;
        if (eVar != null) {
            layoutParams2.addRule(0, eVar.getId());
        }
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        TextView textView2 = new TextView(getContext());
        this.d = textView2;
        textView2.setTextColor(getResources().getColor(R.color.opos_mobad_des_color));
        this.d.setTextSize(1, 12.0f);
        this.d.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.d.setSingleLine(true);
        this.d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        this.e = c.a(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(5);
        this.e.setGravity(3);
        this.e.setVisibility(8);
        relativeLayout2.addView(this.d, layoutParams4);
        relativeLayout2.addView(this.e, layoutParams5);
        relativeLayout.addView(this.f26585c, layoutParams2);
        this.b.addView(relativeLayout, layoutParams);
        this.b.addView(relativeLayout2, layoutParams3);
    }

    public static d b(Context context) {
        return new d(context, true);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BannerRightAreaView", "setListener " + interfaceC0708a);
        this.f26584a.a(interfaceC0708a);
        this.e.a(interfaceC0708a);
        e eVar = this.f;
        if (eVar != null) {
            eVar.a(interfaceC0708a);
        }
    }

    public void a(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f26626a) || TextUtils.isEmpty(aVar.b)) {
            this.d.setVisibility(0);
            return;
        }
        c cVar = this.e;
        if (cVar != null) {
            cVar.setVisibility(0);
            this.e.a(aVar.f26626a, aVar.b);
        }
    }

    public void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.f26584a.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f26585c.setText(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.d.setText(str3);
    }

    public void b(com.opos.mobad.n.d.d dVar) {
        e eVar = this.f;
        if (eVar == null) {
            return;
        }
        eVar.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k);
    }
}
