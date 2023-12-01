package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ae.class */
public class ae extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.n.c.g f13084a;
    private com.opos.mobad.n.c.l b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13085c;
    private FrameLayout d;
    private a.InterfaceC0538a e;
    private a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ae$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f13087a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13088c;
        public final int d;
        public final float e;
        public final int f;
        public final boolean g;

        public a(int i, int i2, int i3, int i4, float f, int i5, boolean z) {
            this.f13087a = i;
            this.f13088c = i3;
            this.b = i2;
            this.d = i4;
            this.e = f;
            this.f = i5;
            this.g = z;
        }
    }

    public ae(Context context, a aVar) {
        super(context);
        this.f13084a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ae.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BlockTipBar", "onFeedBackClick");
                if (ae.this.e != null) {
                    ae.this.e.a(view, iArr);
                }
            }
        };
        this.f = aVar;
        a();
    }

    public static ae a(Context context) {
        return new ae(context, new a(10, 33, 14, 3, 3.0f, 637534208, true));
    }

    private void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f.f);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.f.e));
        com.opos.mobad.n.e.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.f.d), 0, 0, 0);
        setOrientation(0);
        com.opos.mobad.n.c.l lVar = new com.opos.mobad.n.c.l(getContext());
        this.b = lVar;
        lVar.setTextColor(Color.parseColor("#FFFFFF"));
        this.b.setTextSize(1, this.f.f13087a);
        this.b.setGravity(17);
        this.b.setMaxEms(6);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.b.setLetterSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 0.67f));
        this.b.setSingleLine();
        this.b.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.b, layoutParams);
        this.d = new FrameLayout(getContext());
        TextView textView = new TextView(getContext());
        this.f13085c = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_feedback_down_arrow);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams2.gravity = 17;
        this.d.addView(this.f13085c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 2.0f), 0, 0, 0);
        addView(this.d, layoutParams3);
    }

    public static ae b(Context context) {
        return new ae(context, new a(10, 33, 14, 3, 3.0f, context.getResources().getColor(R.color.opos_mobad_small_bar_bg_color), true));
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("BlockTipBar", "setListener " + interfaceC0538a);
        this.e = interfaceC0538a;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        a(z, z2, gVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.n.d.g gVar, String str) {
        FrameLayout frameLayout = this.d;
        if (z) {
            frameLayout.setVisibility(0);
            this.d.setOnClickListener(this.f13084a);
            this.d.setOnTouchListener(this.f13084a);
            this.b.setOnClickListener(this.f13084a);
            this.b.setOnTouchListener(this.f13084a);
        } else {
            frameLayout.setVisibility(8);
            this.b.setOnClickListener(null);
            this.b.setOnTouchListener(null);
        }
        if (!z2 || this.b.getVisibility() == 0) {
            return;
        }
        Drawable drawable = null;
        if (gVar != null) {
            drawable = null;
            if (!TextUtils.isEmpty(gVar.f12945a)) {
                drawable = com.opos.mobad.n.e.a(getContext(), gVar.f12945a);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(drawable != null ? drawable : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("BlockTipBar", sb.toString());
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (drawable != null) {
            com.opos.mobad.n.e.a(this.b, drawable);
            layoutParams.width = com.opos.cmn.an.h.f.a.a(getContext(), this.f.b);
            layoutParams.height = com.opos.cmn.an.h.f.a.a(getContext(), this.f.f13088c);
        } else {
            com.opos.mobad.n.c.l lVar = this.b;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            }
            lVar.setText(str2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f.d);
            setPadding(a2, 0, z ? 0 : a2, 0);
        }
        this.b.setLayoutParams(layoutParams);
        this.b.setVisibility(0);
    }
}
