package com.opos.mobad.n.f;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/k.class */
public class k extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f13055a;
    private com.opos.mobad.n.c.f b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f13056c;
    private TextView d;
    private RelativeLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private boolean j;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/k$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f13059a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13060c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;
        public final int n;
        public final float o;
        public final float p;
        public final float q;
        public final float r;
        public final boolean s;

        public a(int i, int i2, int i3, int i4, int i5, int i6) {
            this(i, i2, i3, i4, i5, i6, true);
        }

        public a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            int i7;
            float f;
            this.f13059a = i;
            this.b = i2;
            this.d = i3;
            this.i = i4;
            this.s = z;
            int i8 = z ? 16 : 8;
            this.j = i8;
            this.k = i8;
            this.n = i5;
            this.l = i6;
            boolean z2 = (16777215 & i6) == 0;
            this.m = z2;
            if (z2) {
                this.f13060c = -1;
                i7 = -1929379841;
            } else {
                this.f13060c = -16777216;
                i7 = -1946157056;
            }
            this.e = i7;
            if (this.n == 1) {
                this.g = 44;
                this.f = z ? 220 : 170;
                this.h = 14;
                this.o = 7.04f;
                this.p = 2.07f;
                this.q = 5.93f;
                f = 10.61f;
            } else {
                this.g = 28;
                this.f = 68;
                this.h = 12;
                this.o = 2.63f;
                this.p = 0.26f;
                this.q = 4.74f;
                f = 8.48f;
            }
            this.r = f;
        }
    }

    public k(Context context, a aVar) {
        super(context);
        this.j = false;
        this.f13055a = aVar;
        setVisibility(4);
        d();
    }

    public static k a(Context context, int i, int i2, int i3, int i4) {
        return new k(context, new a(i, i2, i3, 42, 0, i4, false));
    }

    private void a(int i) {
        if (this.j) {
            return;
        }
        if (i <= 0) {
            setVisibility(0);
            return;
        }
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(180L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.k.2
            @Override // java.lang.Runnable
            public void run() {
                k.this.setVisibility(0);
                ofFloat.start();
            }
        }, i);
        this.j = true;
    }

    public static k b(Context context, int i, int i2, int i3, int i4) {
        return new k(context, new a(i, i2, i3, 42, 1, i4, false));
    }

    public static k c(Context context, int i, int i2, int i3, int i4) {
        return new k(context, new a(i, i2, i3, 42, 0, i4));
    }

    public static k d(Context context, int i, int i2, int i3, int i4) {
        return new k(context, new a(i, i2, i3, 42, 1, i4));
    }

    private void d() {
        int i;
        setBackgroundColor(this.f13055a.l);
        setGravity(17);
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.b = fVar;
        fVar.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.f13059a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        if (this.f13055a.n == 1) {
            i = 14;
        } else {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.j);
            layoutParams.addRule(9);
            i = 15;
        }
        layoutParams.addRule(i);
        addView(this.b, layoutParams);
        e();
        f();
    }

    public static k e(Context context, int i, int i2, int i3, int i4) {
        return new k(context, new a(i, i2, i3, 30, 0, i4));
    }

    private void e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f13056c = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.f13056c.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setTypeface(Typeface.defaultFromStyle(1));
        this.f.setTextColor(this.f13055a.f13060c);
        this.f.setTextSize(1, this.f13055a.b);
        this.f.setGravity(3);
        int i = 6;
        if (this.f13055a.n != 0 || this.f13055a.s) {
            this.f.setMaxEms(6);
        } else {
            this.f.setMaxEms(5);
        }
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f13055a.n == 1) {
            layoutParams.gravity = 1;
        } else {
            layoutParams.gravity = 3;
        }
        this.f13056c.addView(this.f, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.g = textView2;
        textView2.setTextColor(this.f13055a.e);
        this.g.setTextSize(1, this.f13055a.d);
        this.g.setGravity(3);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (this.f13055a.n == 1) {
            this.g.setMaxEms(13);
            layoutParams2.gravity = 1;
        } else {
            TextView textView3 = this.g;
            if (this.f13055a.s) {
                i = 7;
            }
            textView3.setMaxEms(i);
            layoutParams2.gravity = 3;
        }
        this.f13056c.addView(this.g, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f13055a.n == 1) {
            layoutParams3.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(3, this.b.getId());
            layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.i);
        } else {
            layoutParams3.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(1, this.b.getId());
        }
        addView(this.f13056c, layoutParams3);
    }

    public static k f(Context context, int i, int i2, int i3, int i4) {
        return new k(context, new a(i, i2, i3, 30, 1, i4));
    }

    private void f() {
        this.e = new RelativeLayout(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f13055a.m ? -1 : -16777216);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 36.0f));
        this.e.setBackground(gradientDrawable);
        this.e.setGravity(17);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        this.e.setPadding(a2, 0, a2, 0);
        TextView textView = new TextView(getContext());
        this.d = textView;
        textView.setTypeface(Typeface.defaultFromStyle(1));
        this.d.setId(View.generateViewId());
        TextView textView2 = this.d;
        int i = -1;
        if (this.f13055a.m) {
            i = -16777216;
        }
        textView2.setTextColor(i);
        this.d.setTextSize(1, this.f13055a.h);
        this.d.setGravity(17);
        this.d.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.e.addView(this.d, layoutParams);
        TextView textView3 = new TextView(getContext());
        this.h = textView3;
        textView3.setId(View.generateViewId());
        this.h.setBackgroundResource(this.f13055a.m ? R.drawable.opos_mobad_bn_black_vector : R.drawable.opos_mobad_bn_white_vector);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.q);
        int a4 = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.r);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a3, a4);
        layoutParams2.addRule(1, this.d.getId());
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.o);
        layoutParams2.addRule(15);
        this.e.addView(this.h, layoutParams2);
        TextView textView4 = new TextView(getContext());
        this.i = textView4;
        textView4.setId(View.generateViewId());
        this.i.setBackgroundResource(this.f13055a.m ? R.drawable.opos_mobad_bn_black_vector : R.drawable.opos_mobad_bn_white_vector);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a3, a4);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.p);
        layoutParams3.addRule(1, this.h.getId());
        layoutParams3.addRule(15);
        this.e.addView(this.i, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f13055a.n == 0 ? -2 : com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.f), com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.g));
        if (this.f13055a.n == 1) {
            layoutParams4.addRule(14);
            layoutParams4.addRule(3, this.f13056c.getId());
        } else {
            layoutParams4.addRule(15);
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f13055a.k);
        }
        addView(this.e, layoutParams4);
    }

    public void a() {
        this.b.setVisibility(8);
        if (this.f13055a.n == 0) {
            ((RelativeLayout.LayoutParams) this.f13056c.getLayoutParams()).leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.b.setImageBitmap(bitmap);
    }

    public void a(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str)) {
            this.f.setVisibility(8);
        } else {
            this.f.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(str2);
        }
        this.d.setText(str3);
        a(i);
    }

    public void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.i, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        ofFloat2.setStartDelay(170L);
        animatorSet.setDuration(1400L);
        animatorSet.start();
    }

    public View c() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.k.1
            @Override // java.lang.Runnable
            public void run() {
                k.this.b();
            }
        });
    }
}
