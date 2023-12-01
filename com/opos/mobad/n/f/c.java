package com.opos.mobad.n.f;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/c.class */
public class c extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    k f12986a;
    ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private int f12987c;
    private a.InterfaceC0538a d;

    public c(Context context, int i) {
        super(context);
        setVisibility(4);
        setBackgroundColor(0);
        this.f12987c = i;
        a();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.c.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (c.this.d != null) {
                    c.this.d.j(view, iArr);
                }
            }
        };
        setOnClickListener(gVar);
        setOnTouchListener(gVar);
    }

    public static c a(Context context) {
        return new c(context, 2);
    }

    private void a() {
        ImageView imageView = new ImageView(getContext());
        this.b = imageView;
        imageView.setId(View.generateViewId());
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        b();
        c();
    }

    public static c b(Context context) {
        return new c(context, 3);
    }

    private void b() {
        int i = this.f12987c;
        this.f12986a = i != 0 ? i != 1 ? i != 2 ? i != 3 ? k.f(getContext(), 64, 18, 14, -1275068416) : k.b(getContext(), 64, 18, 14, -1) : k.b(getContext(), 64, 18, 14, -1275068416) : k.d(getContext(), 67, 24, 14, -1) : k.d(getContext(), 64, 18, 14, -1275068416);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.c.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (c.this.d != null) {
                    c.this.d.k(view, iArr);
                }
            }
        };
        this.f12986a.c().setOnClickListener(gVar);
        this.f12986a.c().setOnTouchListener(gVar);
    }

    public static c c(Context context) {
        return new c(context, 0);
    }

    private void c() {
        int i = this.f12987c;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4 && i != 5) {
                            return;
                        }
                    }
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 155.0f));
            layoutParams.addRule(10);
            addView(this.b, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, this.b.getId());
            addView(this.f12986a, layoutParams2);
            return;
        }
        addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f12986a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public static c d(Context context) {
        return new c(context, 1);
    }

    private void d() {
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(180L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.setVisibility(0);
                ofFloat.start();
            }
        });
    }

    public static c e(Context context) {
        return new c(context, 4);
    }

    public static c f(Context context) {
        return new c(context, 5);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f12986a.a(bitmap);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.d = interfaceC0538a;
    }

    public void a(String str, String str2, String str3) {
        this.f12986a.a(str, str2, str3, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }
}
