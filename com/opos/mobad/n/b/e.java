package com.opos.mobad.n.b;

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
import com.opos.mobad.n.c.g;
import com.opos.mobad.n.c.l;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/b/e.class */
public class e extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    g f26586a;
    private l b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26587c;
    private FrameLayout d;
    private a.InterfaceC0708a e;
    private a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/b/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f26589a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26590c;
        public final int d;
        public final float e;
        public final int f;
        public final boolean g;
        public final int h;

        public a(int i, int i2, int i3, int i4, float f, int i5, boolean z, int i6) {
            this.f26589a = i;
            this.f26590c = i3;
            this.b = i2;
            this.d = i4;
            this.e = f;
            this.f = i5;
            this.g = z;
            this.h = i6;
        }
    }

    public e(Context context, a aVar) {
        super(context);
        this.f26586a = new g() { // from class: com.opos.mobad.n.b.e.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BannerTipBar", "onFeedBackClick");
                if (e.this.e != null) {
                    e.this.e.a(view, iArr);
                }
            }
        };
        this.f = aVar;
        a();
    }

    public static e a(Context context) {
        return new e(context, new a(8, 26, 11, 2, 2.0f, 637534208, true, 10));
    }

    private void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f.f);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.f.e));
        com.opos.mobad.n.e.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.f.d), 0, 0, 0);
        setOrientation(0);
        l lVar = new l(getContext());
        this.b = lVar;
        lVar.setTextColor(Color.parseColor("#FFFFFF"));
        this.b.setTextSize(1, this.f.f26589a);
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
        this.f26587c = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_feedback_down_arrow);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.f.h), com.opos.cmn.an.h.f.a.a(getContext(), this.f.h));
        layoutParams2.gravity = 17;
        this.d.addView(this.f26587c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), 0, 0, 0);
        addView(this.d, layoutParams3);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BannerTipBar", "setListener " + interfaceC0708a);
        this.e = interfaceC0708a;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        a(z, z2, gVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.n.d.g gVar, String str) {
        int i;
        FrameLayout frameLayout = this.d;
        if (z) {
            frameLayout.setVisibility(0);
            this.d.setOnClickListener(this.f26586a);
            this.d.setOnTouchListener(this.f26586a);
            this.b.setOnClickListener(this.f26586a);
            this.b.setOnTouchListener(this.f26586a);
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
            if (!TextUtils.isEmpty(gVar.f26633a)) {
                drawable = com.opos.mobad.n.e.a(getContext(), gVar.f26633a);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(drawable != null ? drawable : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("BannerTipBar", sb.toString());
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        l lVar = this.b;
        if (drawable != null) {
            com.opos.mobad.n.e.a(lVar, drawable);
            layoutParams.width = com.opos.cmn.an.h.f.a.a(getContext(), this.f.b);
            i = com.opos.cmn.an.h.f.a.a(getContext(), this.f.f26590c);
        } else {
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            }
            lVar.setText(str2);
            i = -2;
            layoutParams.width = -2;
        }
        layoutParams.height = i;
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f.d);
        setPadding(a2, 0, z ? 0 : a2, 0);
        this.b.setLayoutParams(layoutParams);
        this.b.setVisibility(0);
    }
}
