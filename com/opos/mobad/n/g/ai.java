package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ai.class */
public class ai implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.n.c.j f13100a;
    private RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f13101c;
    private TextView d;
    private TextView e;
    private com.opos.mobad.c.d.a f;
    private final int g;
    private final int h;
    private Context i;
    private a.InterfaceC0538a j;
    private com.opos.mobad.n.d.d l;
    private volatile int m = 0;
    private com.opos.mobad.n.c.g n = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ai.5
        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ai.this.j != null) {
                ai.this.j.g(view, iArr);
            }
        }
    };
    private Handler k = new Handler(Looper.getMainLooper());

    public ai(Context context, aj ajVar, int i, int i2, float f) {
        this.g = i2;
        this.i = context;
        this.h = i;
        a(ajVar, f);
        f();
    }

    public static com.opos.mobad.n.a a(Context context, aj ajVar, int i) {
        return new ai(context, ajVar, i, 0, 1.2260536f);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(this.n);
        view.setOnTouchListener(this.n);
    }

    private void a(RelativeLayout relativeLayout, com.opos.mobad.n.d.d dVar) {
        Context context = this.i;
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(context, com.opos.cmn.an.h.f.a.a(context, 6.0f));
        fVar.setId(View.generateViewId());
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        a(fVar);
        int a2 = com.opos.cmn.an.h.f.a.a(this.i, 324.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.i, 182.25f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams.addRule(12);
        relativeLayout.addView(fVar, layoutParams);
        if (dVar.g != null && dVar.g.size() > 0) {
            a(a2, a3, dVar.g.get(0), fVar);
        }
        TextView textView = new TextView(this.i);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.i, 18.0f));
        textView.setTextColor(-671088640);
        textView.setGravity(19);
        textView.setSingleLine();
        textView.setMaxEms(13);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.i, 25.875f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(2, fVar.getId());
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 13.5f);
        relativeLayout.addView(textView, layoutParams2);
        textView.setText(dVar.e);
        a(textView);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        Context context;
        float f;
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        int a2 = com.opos.cmn.an.h.f.a.a(this.i, 324.0f);
        int i = this.g;
        if (i == 0) {
            a(relativeLayout, dVar);
            context = this.i;
            f = 221.625f;
        } else if (i != 2) {
            c(relativeLayout, dVar);
            context = this.i;
            f = 77.625f;
        } else {
            b(relativeLayout, dVar);
            context = this.i;
            f = 105.75f;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, com.opos.cmn.an.h.f.a.a(context, f));
        layoutParams.addRule(2, this.f13101c.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 13.5f);
        this.b.addView(relativeLayout, layoutParams);
    }

    private void a(aj ajVar, float f) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.i);
        }
        com.opos.mobad.n.c.j jVar = new com.opos.mobad.n.c.j(this.i, new j.a(ajVar2.f13109a, ajVar2.b, f));
        this.f13100a = jVar;
        jVar.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f13100a.setForceDarkAllowed(false);
        }
        this.b = new RelativeLayout(this.i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.i, 18.0f));
        gradientDrawable.setColor(-1);
        this.b.setBackground(gradientDrawable);
        this.b.setVisibility(4);
        this.f13100a.addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.f13101c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        TextView textView = new TextView(this.i);
        this.d = textView;
        textView.setId(View.generateViewId());
        this.d.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.i, 15.75f));
        this.d.setTextColor(-1);
        this.d.setGravity(17);
        this.d.setSingleLine();
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.i, 16.0f));
        gradientDrawable2.setColor(Color.parseColor("#28CE43"));
        this.d.setBackground(gradientDrawable2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 90.0f), com.opos.cmn.an.h.f.a.a(this.i, 31.5f));
        layoutParams.addRule(11);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ai.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ai.this.j != null) {
                    ai.this.j.f(view, iArr);
                }
            }
        };
        this.d.setOnClickListener(gVar);
        this.d.setOnTouchListener(gVar);
        this.f13101c.addView(this.d, layoutParams);
        TextView textView2 = new TextView(this.i);
        this.e = textView2;
        textView2.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.i, 13.5f));
        this.e.setTextColor(-1946157056);
        this.e.setGravity(19);
        this.e.setSingleLine();
        this.e.setMaxEms(10);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        a(this.e);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(15);
        this.f13101c.addView(this.e, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 324.0f), com.opos.cmn.an.h.f.a.a(this.i, 31.5f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 13.5f);
        this.b.addView(this.f13101c, layoutParams3);
        TextView textView3 = new TextView(this.i);
        textView3.setBackground(this.i.getResources().getDrawable(R.drawable.opos_mobad_close_bn));
        int a2 = com.opos.cmn.an.h.f.a.a(this.i, 14.32f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.i, 19.845f);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 19.74f);
        layoutParams4.addRule(11);
        this.b.addView(textView3, layoutParams4);
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ai.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ai.this.j != null) {
                    ai.this.j.d(view, iArr);
                }
            }
        };
        textView3.setOnClickListener(gVar2);
        textView3.setOnTouchListener(gVar2);
    }

    public static com.opos.mobad.n.a b(Context context, aj ajVar, int i) {
        return new ai(context, ajVar, i, 2, 2.0253165f);
    }

    private void b(RelativeLayout relativeLayout, com.opos.mobad.n.d.d dVar) {
        LinearLayout linearLayout = new LinearLayout(this.i);
        linearLayout.setId(View.generateViewId());
        a(linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Context context = this.i;
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(context, com.opos.cmn.an.h.f.a.a(context, 6.0f));
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(fVar, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 6.75f);
        Context context2 = this.i;
        com.opos.mobad.n.c.f fVar2 = new com.opos.mobad.n.c.f(context2, com.opos.cmn.an.h.f.a.a(context2, 6.0f));
        fVar2.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(fVar2, layoutParams2);
        Context context3 = this.i;
        com.opos.mobad.n.c.f fVar3 = new com.opos.mobad.n.c.f(context3, com.opos.cmn.an.h.f.a.a(context3, 6.0f));
        fVar3.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(fVar3, layoutParams2);
        int a2 = com.opos.cmn.an.h.f.a.a(this.i, 103.5f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.i, 66.375f);
        if (dVar.g != null && dVar.g.size() >= 3) {
            a(a2, a3, dVar.g.get(0), fVar);
            a(a2, a3, dVar.g.get(1), fVar2);
            a(a2, a3, dVar.g.get(2), fVar3);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 324.0f), com.opos.cmn.an.h.f.a.a(this.i, 66.375f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        relativeLayout.addView(linearLayout, layoutParams3);
        TextView textView = new TextView(this.i);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.i, 18.0f));
        textView.setTextColor(-671088640);
        textView.setMaxEms(13);
        textView.setGravity(19);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.i, 23.0f));
        layoutParams4.addRule(9);
        layoutParams4.addRule(2, linearLayout.getId());
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 13.5f);
        relativeLayout.addView(textView, layoutParams4);
        textView.setText(dVar.e);
        a(textView);
    }

    public static com.opos.mobad.n.a c(Context context, aj ajVar, int i) {
        return new ai(context, ajVar, i, 1, 2.3357663f);
    }

    private void c(RelativeLayout relativeLayout, com.opos.mobad.n.d.d dVar) {
        Context context = this.i;
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(context, com.opos.cmn.an.h.f.a.a(context, 6.0f));
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        fVar.setId(View.generateViewId());
        a(fVar);
        int a2 = com.opos.cmn.an.h.f.a.a(this.i, 119.25f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.i, 77.625f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams.addRule(9);
        relativeLayout.addView(fVar, layoutParams);
        if (dVar.g != null && dVar.g.size() > 0) {
            a(a2, a3, dVar.g.get(0), fVar);
        }
        FrameLayout frameLayout = new FrameLayout(this.i);
        TextView textView = new TextView(this.i);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.i, 18.0f));
        textView.setTextColor(-671088640);
        textView.setGravity(51);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(3);
        textView.setLineSpacing(com.opos.cmn.an.h.f.a.a(this.i, 3.5f), 1.0f);
        textView.setText(dVar.e);
        a(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 51;
        frameLayout.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 168.75f), com.opos.cmn.an.h.f.a.a(this.i, 77.625f));
        layoutParams3.addRule(1, fVar.getId());
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 11.25f);
        relativeLayout.addView(frameLayout, layoutParams3);
    }

    private void f() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.i);
        this.f = aVar;
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.ai.3
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (ai.this.m == 4) {
                    com.opos.cmn.an.f.a.b("NativeTemplateView", "has destroy");
                    return;
                }
                com.opos.cmn.an.f.a.b("NativeTemplateView", "is view visible =" + z);
                if (!z) {
                    ai.this.m = 2;
                } else if (ai.this.m == 0) {
                    ai.this.m = 1;
                    if (ai.this.l != null) {
                        ai.this.g();
                    }
                }
            }
        });
        this.b.addView(this.f, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.m == 1) {
            this.m = 3;
            com.opos.cmn.an.f.a.b("NativeTemplateView", "NT onWindowVisibility");
            a.InterfaceC0538a interfaceC0538a = this.j;
            if (interfaceC0538a != null) {
                interfaceC0538a.b();
            }
            this.f.a((a.InterfaceC0508a) null);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    public void a(final int i, final int i2, final com.opos.mobad.n.d.g gVar, final ImageView imageView) {
        String str;
        if (imageView == null) {
            str = "null imageView";
        } else if (gVar != null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.g.ai.4
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    try {
                        if (ai.this.m == 4) {
                            return;
                        }
                        if (new File(gVar.f12945a).exists()) {
                            final Bitmap a2 = com.opos.cmn.an.d.c.a.a(gVar.f12945a, i, i2);
                            if (a2 != null && !a2.isRecycled()) {
                                ai.this.k.post(new Runnable() { // from class: com.opos.mobad.n.g.ai.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Bitmap bitmap;
                                        if (ai.this.m == 4 || (bitmap = a2) == null || bitmap.isRecycled()) {
                                            return;
                                        }
                                        imageView.setImageBitmap(a2);
                                    }
                                });
                                return;
                            }
                            str2 = "null bitmap or error state" + ai.this.m;
                        } else {
                            str2 = "icon not exit";
                        }
                        com.opos.cmn.an.f.a.b("NativeTemplateView", str2);
                    } catch (Throwable th) {
                        com.opos.cmn.an.f.a.b("NativeTemplateView", "load img fail", th);
                    }
                }
            });
            return;
        } else {
            str = "null file";
        }
        com.opos.cmn.an.f.a.b("NativeTemplateView", str);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.j = interfaceC0538a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null || a2.g == null || a2.g.size() <= 0) {
            this.j.b(1);
        } else if (this.m != 4) {
            if (this.l == null) {
                this.j.e();
            }
            this.l = a2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 46.62f), com.opos.cmn.an.h.f.a.a(this.i, 18.0f));
            layoutParams.addRule(15);
            View a3 = com.opos.mobad.n.e.a(a2, this.f13101c, layoutParams);
            a3.setId(View.generateViewId());
            a(a3);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams2.addRule(1, a3.getId());
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.75f);
            this.d.setText(a2.l);
            this.e.setText(a2.f);
            a(a2);
            this.f13100a.setVisibility(0);
            this.b.setVisibility(0);
            g();
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f13100a;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.f13100a.removeAllViews();
        this.f13100a.setVisibility(8);
        this.m = 4;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.h;
    }
}
