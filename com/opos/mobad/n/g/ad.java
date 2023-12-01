package com.opos.mobad.n.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ad.class */
public class ad extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ae f13081a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13082c;
    private a.InterfaceC0538a d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ad$a.class */
    public interface a {
        void a(int i);
    }

    public ad(Context context, boolean z) {
        super(context);
        a(z);
    }

    public static ad a(Context context) {
        return new ad(context, true);
    }

    private void a(boolean z) {
        ae b = ae.b(getContext());
        this.f13081a = b;
        b.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.f13081a, layoutParams);
        this.b = new LinearLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        this.b.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_small_close);
        this.b.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ad.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ad.this.d != null) {
                    ad.this.d.d(view, iArr);
                }
            }
        };
        this.b.setOnTouchListener(gVar);
        this.b.setOnClickListener(gVar);
        addView(this.b, layoutParams2);
        b(z);
    }

    public static ad b(Context context) {
        return new ad(context, false);
    }

    private void b(boolean z) {
        if (z) {
            TextView textView = new TextView(getContext());
            this.f13082c = textView;
            textView.setTextColor(getResources().getColor(R.color.opos_mobad_small_bar_title_color));
            this.f13082c.setTextSize(1, 12.0f);
            this.f13082c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.f13082c.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
            int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a3;
            layoutParams.addRule(15);
            layoutParams.addRule(1, this.f13081a.getId());
            layoutParams.addRule(0, this.b.getId());
            addView(this.f13082c, layoutParams);
        }
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.d = interfaceC0538a;
        this.f13081a.a(interfaceC0538a);
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2, int i, String str3) {
        TextView textView;
        this.f13081a.a(z, str, z2, gVar, str2);
        if (TextUtils.isEmpty(str3) || (textView = this.f13082c) == null) {
            return;
        }
        textView.setText(str3);
    }
}
