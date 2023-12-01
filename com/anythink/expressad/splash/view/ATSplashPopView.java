package com.anythink.expressad.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.d.d;
import com.bytedance.applog.tracker.Tracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashPopView.class */
public class ATSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final String f8260c = "ATSplashPopView";
    private static final AtomicInteger d = new AtomicInteger(1);

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f8261a;
    View.OnClickListener b;
    private String e;
    private String f;
    private int g;
    private c h;
    private d i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private int q;
    private Handler r;
    private boolean s;
    private com.anythink.expressad.a.a t;
    private Runnable u;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashPopView$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8268a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private int f8269c;
        private c d;

        public a(String str, String str2, int i, c cVar) {
            this.f8268a = str;
            this.b = str2;
            this.f8269c = i;
            this.d = cVar;
        }

        private void a(int i) {
            this.f8269c = i;
        }

        private void a(c cVar) {
            this.d = cVar;
        }

        private void a(String str) {
            this.f8268a = str;
        }

        private void b(String str) {
            this.b = str;
        }

        public final String a() {
            return this.f8268a;
        }

        public final String b() {
            return this.b;
        }

        public final int c() {
            return this.f8269c;
        }

        public final c d() {
            return this.d;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashPopView$b.class */
    public @interface b {
    }

    public ATSplashPopView(Context context) {
        super(context);
        this.g = 1;
        this.q = -1;
        this.r = new Handler();
        this.s = false;
        this.u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.p != null) {
                    if (ATSplashPopView.this.q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.p.setText(String.valueOf(ATSplashPopView.this.q));
                        ATSplashPopView.this.r.postDelayed(ATSplashPopView.this.u, 1000L);
                        return;
                    }
                    ATSplashPopView.e(ATSplashPopView.this);
                    ATSplashPopView.this.g();
                    ATSplashPopView.this.r.removeCallbacks(ATSplashPopView.this.u);
                    if (ATSplashPopView.this.i != null) {
                        ATSplashPopView.this.i.b();
                    }
                }
            }
        };
        this.f8261a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.q <= 0 && ATSplashPopView.this.i != null) {
                    ATSplashPopView.this.i.b();
                }
            }
        };
        this.g = 1;
        o.b(f8260c, "Please call setPopViewType() to init.");
    }

    public ATSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 1;
        this.q = -1;
        this.r = new Handler();
        this.s = false;
        this.u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.p != null) {
                    if (ATSplashPopView.this.q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.p.setText(String.valueOf(ATSplashPopView.this.q));
                        ATSplashPopView.this.r.postDelayed(ATSplashPopView.this.u, 1000L);
                        return;
                    }
                    ATSplashPopView.e(ATSplashPopView.this);
                    ATSplashPopView.this.g();
                    ATSplashPopView.this.r.removeCallbacks(ATSplashPopView.this.u);
                    if (ATSplashPopView.this.i != null) {
                        ATSplashPopView.this.i.b();
                    }
                }
            }
        };
        this.f8261a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.q <= 0 && ATSplashPopView.this.i != null) {
                    ATSplashPopView.this.i.b();
                }
            }
        };
        this.g = 1;
        o.b(f8260c, "Please call setPopViewType() to init.");
    }

    public ATSplashPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 1;
        this.q = -1;
        this.r = new Handler();
        this.s = false;
        this.u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.p != null) {
                    if (ATSplashPopView.this.q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.p.setText(String.valueOf(ATSplashPopView.this.q));
                        ATSplashPopView.this.r.postDelayed(ATSplashPopView.this.u, 1000L);
                        return;
                    }
                    ATSplashPopView.e(ATSplashPopView.this);
                    ATSplashPopView.this.g();
                    ATSplashPopView.this.r.removeCallbacks(ATSplashPopView.this.u);
                    if (ATSplashPopView.this.i != null) {
                        ATSplashPopView.this.i.b();
                    }
                }
            }
        };
        this.f8261a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.q <= 0 && ATSplashPopView.this.i != null) {
                    ATSplashPopView.this.i.b();
                }
            }
        };
        this.g = 1;
        o.b(f8260c, "Please call setPopViewType() to init.");
    }

    public ATSplashPopView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.g = 1;
        this.q = -1;
        this.r = new Handler();
        this.s = false;
        this.u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.p != null) {
                    if (ATSplashPopView.this.q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.p.setText(String.valueOf(ATSplashPopView.this.q));
                        ATSplashPopView.this.r.postDelayed(ATSplashPopView.this.u, 1000L);
                        return;
                    }
                    ATSplashPopView.e(ATSplashPopView.this);
                    ATSplashPopView.this.g();
                    ATSplashPopView.this.r.removeCallbacks(ATSplashPopView.this.u);
                    if (ATSplashPopView.this.i != null) {
                        ATSplashPopView.this.i.b();
                    }
                }
            }
        };
        this.f8261a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.q <= 0 && ATSplashPopView.this.i != null) {
                    ATSplashPopView.this.i.b();
                }
            }
        };
        this.g = 1;
        o.b(f8260c, "Please call setPopViewType() to init.");
    }

    public ATSplashPopView(Context context, a aVar, d dVar) {
        super(context);
        this.g = 1;
        this.q = -1;
        this.r = new Handler();
        this.s = false;
        this.u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.p != null) {
                    if (ATSplashPopView.this.q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.p.setText(String.valueOf(ATSplashPopView.this.q));
                        ATSplashPopView.this.r.postDelayed(ATSplashPopView.this.u, 1000L);
                        return;
                    }
                    ATSplashPopView.e(ATSplashPopView.this);
                    ATSplashPopView.this.g();
                    ATSplashPopView.this.r.removeCallbacks(ATSplashPopView.this.u);
                    if (ATSplashPopView.this.i != null) {
                        ATSplashPopView.this.i.b();
                    }
                }
            }
        };
        this.f8261a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ATSplashPopView.this.q <= 0 && ATSplashPopView.this.i != null) {
                    ATSplashPopView.this.i.b();
                }
            }
        };
        if (aVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f = aVar.b();
        this.e = aVar.a();
        this.g = aVar.c();
        this.h = aVar.d();
        this.i = dVar;
        a();
    }

    private void a() {
        if (this.h == null) {
            return;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i = this.g;
        if (i == 1) {
            b();
        } else if (i == 2) {
            c();
        } else if (i == 3) {
            d();
        } else if (i != 4) {
        } else {
            e();
        }
    }

    private void a(c cVar) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(cVar);
            this.i.b();
        }
    }

    static /* synthetic */ void a(ATSplashPopView aTSplashPopView, c cVar) {
        d dVar = aTSplashPopView.i;
        if (dVar != null) {
            dVar.a(cVar);
            aTSplashPopView.i.b();
        }
    }

    private void a(String str) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    com.anythink.core.common.k.b.a(n.a().g(), bitmap);
                } catch (Throwable th) {
                    o.d(ATSplashPopView.f8260c, th.getMessage());
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(ATSplashPopView.f8260c, str2);
            }
        });
    }

    private void a(String str, final boolean z) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.1
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    Bitmap a2 = z ? com.anythink.expressad.foundation.h.n.a(bitmap) : com.anythink.expressad.foundation.h.n.a(bitmap, 16);
                    ImageView imageView = ATSplashPopView.this.j;
                    if (a2 != null) {
                        bitmap = a2;
                    }
                    imageView.setImageBitmap(bitmap);
                } catch (Throwable th) {
                    o.d(ATSplashPopView.f8260c, th.getMessage());
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(ATSplashPopView.f8260c, str2);
            }
        });
    }

    private void b() {
        View imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 80.0f), t.b(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = t.b(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("anythink_splash_popview_default", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
        this.j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(t.b(getContext(), 60.0f), t.b(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = t.b(getContext(), 7.0f);
        layoutParams2.leftMargin = t.b(getContext(), 10.0f);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams2);
        this.j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        c cVar = this.h;
        if (cVar != null && !TextUtils.isEmpty(cVar.bd())) {
            a(this.h.bd(), true);
        }
        this.p = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = t.b(getContext(), 62.0f);
        layoutParams3.bottomMargin = t.b(getContext(), 70.0f);
        this.p.setId(generateViewId());
        this.p.setTextSize(10.0f);
        this.p.setTextColor(-1);
        this.p.setGravity(17);
        this.p.setMinWidth(t.b(getContext(), 16.0f));
        this.p.setMaxHeight(t.b(getContext(), 16.0f));
        this.p.setLayoutParams(layoutParams3);
        this.p.setBackgroundResource(getResources().getIdentifier("anythink_cm_circle_50black", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(imageView);
        addView(this.p);
        addView(this.j);
        c cVar2 = this.h;
        if (cVar2 != null && cVar2.u() <= 0) {
            g();
        }
        setOnClickListener(this.f8261a);
        this.p.setOnClickListener(this.b);
    }

    private void b(c cVar) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(cVar);
            this.i.b();
        }
    }

    private void b(String str) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.3
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    ATSplashPopView.this.k.setImageBitmap(com.anythink.expressad.foundation.h.n.a(bitmap, 16));
                } catch (Throwable th) {
                    o.d(ATSplashPopView.f8260c, th.getMessage());
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(ATSplashPopView.f8260c, str2);
            }
        });
    }

    private void c() {
        int b2 = t.b(getContext(), 4.0f);
        this.j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 28.0f), t.b(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams);
        this.j.setPadding(b2, b2, b2, b2);
        this.j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        a(this.h.bd(), false);
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.j.getId());
        layoutParams2.addRule(6, this.j.getId());
        layoutParams2.addRule(8, this.j.getId());
        layoutParams2.leftMargin = t.b(getContext(), 4.0f);
        layoutParams2.rightMargin = t.b(getContext(), 40.0f);
        this.n.setLayoutParams(layoutParams2);
        this.n.setGravity(16);
        this.n.setTextSize(10.0f);
        this.n.setSelected(true);
        this.n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSingleLine(true);
        this.n.setTextColor(-16777216);
        this.n.setText(this.h.bb());
        setBackgroundResource(getResources().getIdentifier("anythink_shape_corners_bg", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.j);
        addView(this.n);
        f();
        setOnClickListener(this.f8261a);
    }

    private void d() {
        int b2 = t.b(getContext(), 4.0f);
        this.j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 50.0f), t.b(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams);
        this.j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.j.setPadding(b2, b2, b2, b2);
        a(this.h.bd(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.j.getId());
        layoutParams2.addRule(6, this.j.getId());
        layoutParams2.addRule(8, this.j.getId());
        layoutParams2.leftMargin = t.b(getContext(), 8.0f);
        layoutParams2.rightMargin = t.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setId(generateViewId());
        this.n.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.n.setGravity(16);
        this.n.setTextSize(12.0f);
        this.n.setSelected(true);
        this.n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSingleLine(true);
        this.n.setTextColor(-16777216);
        this.n.setText(this.h.bb());
        TextView textView2 = new TextView(getContext());
        this.o = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.n.getId());
        layoutParams3.addRule(3, this.n.getId());
        layoutParams3.topMargin = t.b(getContext(), 4.0f);
        layoutParams3.rightMargin = t.b(getContext(), 36.0f);
        this.o.setGravity(16);
        this.o.setLayoutParams(layoutParams3);
        this.o.setTextSize(8.0f);
        this.o.setTextColor(-10066330);
        this.o.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.o.setMarqueeRepeatLimit(-1);
        this.o.setSelected(true);
        this.o.setSingleLine(true);
        this.o.setText(this.h.bc());
        relativeLayout.addView(this.n);
        relativeLayout.addView(this.o);
        setBackgroundResource(getResources().getIdentifier("anythink_shape_corners_bg", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.j);
        addView(relativeLayout);
        f();
        setOnClickListener(this.f8261a);
    }

    static /* synthetic */ int e(ATSplashPopView aTSplashPopView) {
        aTSplashPopView.q = -1;
        return -1;
    }

    private void e() {
        this.l = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, t.b(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        this.l.setId(generateViewId());
        this.l.setLayoutParams(layoutParams);
        a(this.h.be());
        this.k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, t.b(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.k.setId(generateViewId());
        this.k.setLayoutParams(layoutParams2);
        b(this.h.be());
        this.j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(t.b(getContext(), 50.0f), t.b(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.l.getId());
        layoutParams3.topMargin = 20;
        this.j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams3);
        a(this.h.bd(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.j.getId());
        layoutParams4.addRule(6, this.j.getId());
        layoutParams4.addRule(8, this.j.getId());
        layoutParams4.leftMargin = t.b(getContext(), 8.0f);
        layoutParams4.rightMargin = t.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setId(generateViewId());
        this.n.setGravity(16);
        this.n.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.n.setTextSize(12.0f);
        this.n.setTextColor(-16777216);
        this.n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSelected(true);
        this.n.setSingleLine(true);
        this.n.setText(this.h.bb());
        TextView textView2 = new TextView(getContext());
        this.o = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.n.getId());
        layoutParams5.addRule(3, this.n.getId());
        layoutParams5.topMargin = t.b(getContext(), 4.0f);
        layoutParams5.rightMargin = t.b(getContext(), 36.0f);
        this.o.setGravity(16);
        this.o.setLayoutParams(layoutParams5);
        this.o.setTextSize(8.0f);
        this.o.setTextColor(-10066330);
        this.o.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.o.setMarqueeRepeatLimit(-1);
        this.o.setSelected(true);
        this.o.setSingleLine(true);
        this.o.setText(this.h.bc());
        relativeLayout.addView(this.n);
        relativeLayout.addView(this.o);
        addView(this.l);
        addView(this.k);
        addView(this.j);
        addView(relativeLayout);
        f();
        setOnClickListener(this.f8261a);
    }

    private void f() {
        String str;
        this.m = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 32.0f), t.b(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.j.getId());
        this.m.setLayoutParams(layoutParams);
        try {
            str = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th) {
            o.d(f8260c, th.getMessage());
            str = "ZH";
        }
        this.m.setBackgroundResource((str.toUpperCase().equals("CN") || str.toUpperCase().equals("ZH")) ? getResources().getIdentifier("anythink_splash_ad", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()) : getResources().getIdentifier("anythink_splash_ad_en", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView = this.p;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = t.b(getContext(), 16.0f);
            layoutParams.height = t.b(getContext(), 16.0f);
            this.p.setLayoutParams(layoutParams);
            this.p.setText("");
            this.p.setBackgroundResource(getResources().getIdentifier("anythink_splash_popview_close", i.f7952c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    public static int generateViewId() {
        int i;
        int i2;
        do {
            i = d.get();
            int i3 = i + 1;
            i2 = i3;
            if (i3 > 16777215) {
                i2 = 1;
            }
        } while (!d.compareAndSet(i, i2));
        return i;
    }

    static /* synthetic */ int j(ATSplashPopView aTSplashPopView) {
        int i = aTSplashPopView.q;
        aTSplashPopView.q = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i != null) {
            getWidth();
            getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void pauseCountDown() {
        this.s = true;
        if (this.p != null) {
            this.r.removeCallbacks(this.u);
        }
    }

    public void reStartCountDown() {
        if (this.s) {
            this.s = false;
            int i = this.q;
            if (i == -1 || i == 0) {
                g();
                return;
            }
            TextView textView = this.p;
            if (textView != null) {
                textView.setText(String.valueOf(i));
                this.r.postDelayed(this.u, 1000L);
            }
        }
    }

    public void release() {
        try {
            this.r.removeCallbacks(this.u);
            this.u = null;
            detachAllViewsFromParent();
            this.h = null;
            this.i = null;
        } catch (Exception e) {
            o.d(f8260c, e.getMessage());
        }
    }

    public void setPopViewType(a aVar, d dVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f = aVar.b();
        this.e = aVar.a();
        this.g = aVar.c();
        this.h = aVar.d();
        this.i = dVar;
        a();
    }

    public void startCountDown() {
        this.r.removeCallbacks(this.u);
        c cVar = this.h;
        if (cVar == null || this.g != 1) {
            return;
        }
        int u = cVar.u();
        if (u <= 0) {
            g();
            return;
        }
        this.q = u;
        TextView textView = this.p;
        if (textView != null) {
            textView.setText(String.valueOf(u));
            this.r.postDelayed(this.u, 1000L);
        }
    }
}
