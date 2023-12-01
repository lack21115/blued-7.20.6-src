package com.opos.mobad.n.a;

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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/k.class */
public class k extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.n.c.g f12840a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private View f12841c;
    private TextView d;
    private TextView e;
    private FrameLayout f;
    private a.InterfaceC0538a g;
    private a h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/k$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f12843a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12844c;
        public final int d;
        public final int e;
        public final int f;
        public final float g;
        public final int h;
        public final boolean i;
        public final int j;
        public final float k;
        public final float l;

        public a(int i, int i2, int i3, int i4, int i5, int i6, float f, int i7, boolean z, int i8, float f2, float f3) {
            this.f12843a = i;
            this.d = i4;
            this.b = i2;
            this.f12844c = i3;
            this.e = i5;
            this.f = i6;
            this.g = f;
            this.h = i7;
            this.i = z;
            this.j = i8;
            this.k = f2;
            this.l = f3;
        }
    }

    public k(Context context, a aVar) {
        super(context);
        this.f12840a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.k.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("LogoTipBar", "onFeedBackClick");
                if (k.this.g != null) {
                    k.this.g.a(view, iArr);
                }
            }
        };
        this.h = aVar;
        a();
    }

    public static k a(Context context) {
        return new k(context, new a(14, 28, 43, 20, 10, 10, 14.0f, 637534208, true, 14, 7.42f, 4.15f));
    }

    private void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.h.h);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.h.g));
        com.opos.mobad.n.e.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.h.e), 0, com.opos.cmn.an.h.f.a.a(getContext(), this.h.f), 0);
        setOrientation(0);
        TextView textView = new TextView(getContext());
        this.d = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.d.setTextSize(1, this.h.f12843a);
        this.d.setGravity(17);
        this.d.setMaxEms(6);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setSingleLine();
        this.d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.d, layoutParams);
        this.f = new FrameLayout(getContext());
        TextView textView2 = new TextView(getContext());
        this.e = textView2;
        textView2.setBackgroundResource(R.drawable.opos_mobad_feedback_down_vector);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.h.k), com.opos.cmn.an.h.f.a.a(getContext(), this.h.l));
        layoutParams2.gravity = 17;
        this.f.addView(this.e, layoutParams2);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.h.j);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(a2, a2);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
        layoutParams3.gravity = 16;
        addView(this.f, layoutParams3);
        if (this.h.i) {
            TextView textView3 = new TextView(getContext());
            this.f12841c = textView3;
            textView3.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
            layoutParams4.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
            layoutParams4.gravity = 16;
            addView(this.f12841c, layoutParams4);
            TextView textView4 = new TextView(getContext());
            this.b = textView4;
            textView4.setTextSize(1, this.h.f12843a);
            this.b.setTextColor(-1);
            this.b.setGravity(17);
            this.b.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
            layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            layoutParams5.gravity = 16;
            addView(this.b, layoutParams5);
        }
    }

    public static k b(Context context) {
        return new k(context, new a(10, 21, 30, 14, 4, 0, 3.0f, -1308622848, false, 12, 6.36f, 3.56f));
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("LogoTipBar", "setListener " + interfaceC0538a);
        this.g = interfaceC0538a;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        if (this.b != null) {
            if (TextUtils.isEmpty(str)) {
                this.b.setVisibility(8);
                this.f12841c.setVisibility(8);
            } else {
                this.b.setText(str);
                this.b.setVisibility(0);
                if (!TextUtils.isEmpty(str)) {
                    this.f12841c.setVisibility(0);
                }
            }
        }
        a(z, z2, gVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.n.d.g gVar, String str) {
        int i;
        if (z) {
            this.f.setVisibility(0);
            this.f.setOnClickListener(this.f12840a);
            this.f.setOnTouchListener(this.f12840a);
            this.d.setOnClickListener(this.f12840a);
            this.d.setOnTouchListener(this.f12840a);
        } else {
            if (this.h.f == 0) {
                setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.h.e), 0, com.opos.cmn.an.h.f.a.a(getContext(), this.h.e), 0);
            }
            this.f.setVisibility(8);
            this.d.setOnClickListener(null);
            this.d.setOnTouchListener(null);
        }
        if (!z2 || this.d.getVisibility() == 0) {
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
        com.opos.cmn.an.f.a.b("LogoTipBar", sb.toString());
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        TextView textView = this.d;
        if (drawable != null) {
            com.opos.mobad.n.e.a(textView, drawable);
            i = com.opos.cmn.an.h.f.a.a(getContext(), this.h.f12844c);
        } else {
            textView.setText(str);
            this.d.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), this.h.b));
            i = -2;
        }
        layoutParams.width = i;
        layoutParams.height = com.opos.cmn.an.h.f.a.a(getContext(), this.h.d);
        this.d.setVisibility(0);
    }
}
