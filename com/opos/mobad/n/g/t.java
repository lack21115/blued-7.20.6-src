package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/t.class */
public class t extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private v f26923a;
    private com.opos.mobad.n.c.f b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f26924c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private a.InterfaceC0708a g;

    public t(Context context) {
        super(context);
        b(context);
    }

    public static t a(Context context) {
        return new t(context);
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_title_color));
        this.e.setTextSize(1, 14.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        TextPaint paint = this.e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView2 = new TextView(getContext());
        this.f = textView2;
        textView2.setTextColor(getResources().getColor(R.color.opos_mobad_des_color));
        this.f.setTextSize(1, 12.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.d.addView(this.e, layoutParams);
        this.d.addView(this.f, layoutParams2);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, final boolean z) {
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("BlockBottomAreaView", "iconUrl is null");
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 42.0f);
        aVar.a(gVar.f26633a, gVar.b, a2, a2, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.g.t.1
            @Override // com.opos.mobad.c.a.InterfaceC0676a
            public void a(int i, final Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (t.this.g != null) {
                        t.this.g.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && t.this.g != null) {
                    t.this.g.c(i);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.t.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        t.this.b.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    private void b(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f)));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f26924c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.f26924c.setPadding(a2, a2, a2, a2);
        this.f26924c.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 42.0f), com.opos.cmn.an.h.f.a.a(getContext(), 42.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.addRule(15);
        this.f26924c.setVisibility(8);
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.b = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        v a3 = v.a(context, "");
        this.f26923a = a3;
        a3.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        a();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.f26924c.getId());
        layoutParams4.addRule(0, this.f26923a.getId());
        this.f26924c.addView(this.b, layoutParams2);
        addView(this.f26924c, layoutParams);
        addView(this.f26923a, layoutParams3);
        addView(this.d, layoutParams4);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BlockBottomAreaView", "setListener " + interfaceC0708a);
        this.g = interfaceC0708a;
        this.f26923a.a(interfaceC0708a);
    }

    public void a(com.opos.mobad.n.d.g gVar, String str, String str2, String str3, com.opos.mobad.c.a aVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f26923a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.e.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f.setText(str3);
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f26633a)) {
            this.f26924c.setVisibility(0);
            a(gVar, aVar, z);
            return;
        }
        this.f26924c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.width = -1;
        this.d.setLayoutParams(layoutParams);
    }
}
