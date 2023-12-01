package com.opos.mobad.q.a.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.e;
import com.opos.mobad.n.d.h;
import com.opos.mobad.o.c.a;
import com.opos.mobad.q.a.f.b;
import com.opos.mobad.q.a.f.c.d;
import com.opos.mobad.q.a.i;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/c.class */
public class c extends com.opos.mobad.n.i.a {
    private a A;
    private Runnable B;
    private com.opos.mobad.c.d.a C;

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.c.c.b f13512a;
    private RelativeLayout d;
    private b e;
    private d f;
    private Context g;
    private RelativeLayout h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private ImageView m;
    private boolean n;
    private boolean o;
    private int p;
    private com.opos.mobad.o.c.a q;
    private View r;
    private int s;
    private AdItemData t;
    private MaterialData u;
    private com.opos.mobad.c.c.a v;
    private com.opos.mobad.c.b.c w;
    private e x;
    private long y;
    private boolean z;

    /* renamed from: com.opos.mobad.q.a.f.c$7  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/c$7.class */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13520a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f13520a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13520a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13520a[com.opos.mobad.cmn.a.b.a.Video.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/c$a.class */
    public class a implements a.InterfaceC0551a, com.opos.mobad.q.a.c.a, b.a {
        public a() {
        }

        @Override // com.opos.mobad.q.a.c.a
        public void a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
            a.InterfaceC0538a interfaceC0538a = c.this.f13312c;
            if (interfaceC0538a == null) {
                return;
            }
            int i = AnonymousClass7.f13520a[aVar.ordinal()];
            if (i == 1) {
                interfaceC0538a.g(view, iArr);
            } else if (i == 2) {
                interfaceC0538a.f(view, iArr);
            } else if (i != 3) {
            } else {
                interfaceC0538a.e(view, iArr);
            }
        }

        @Override // com.opos.mobad.o.c.a.InterfaceC0551a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0538a interfaceC0538a = c.this.f13312c;
            if (interfaceC0538a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0538a).a_(view, iArr);
            }
        }

        @Override // com.opos.mobad.q.a.f.b.a
        public void b(View view, int[] iArr) {
            a.InterfaceC0538a interfaceC0538a = c.this.f13312c;
            if (interfaceC0538a == null) {
                return;
            }
            interfaceC0538a.i(view, iArr);
        }

        @Override // com.opos.mobad.q.a.f.b.a
        public void c(View view, int[] iArr) {
            a.InterfaceC0538a interfaceC0538a = c.this.f13312c;
            if (interfaceC0538a == null) {
                return;
            }
            interfaceC0538a.d(view, iArr);
        }

        @Override // com.opos.mobad.q.a.f.b.a
        public void d(View view, int[] iArr) {
            a.InterfaceC0538a interfaceC0538a = c.this.f13312c;
            if (interfaceC0538a == null) {
                return;
            }
            interfaceC0538a.a(view, iArr, c.this.z);
        }
    }

    public c(Context context, AdItemData adItemData, int i, com.opos.mobad.c.c.a aVar) {
        super(i);
        this.n = false;
        this.o = false;
        this.p = 0;
        this.z = false;
        this.B = new Runnable() { // from class: com.opos.mobad.q.a.f.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.o() == 8) {
                    return;
                }
                long d = c.this.v.d();
                c cVar = c.this;
                cVar.y = cVar.v.c();
                c cVar2 = c.this;
                cVar2.c(d, cVar2.y);
                if (c.this.o() != 6 || c.this.o() != 7) {
                    c.this.a(d);
                }
                c.this.w.a(1000L);
            }
        };
        this.f13512a = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.q.a.f.c.2
            @Override // com.opos.mobad.c.c.b
            public void a(int i2, String str) {
                if (c.this.o() == 8) {
                    return;
                }
                c.this.w.a();
                c.this.a(i2, str);
            }

            @Override // com.opos.mobad.c.c.b
            public void c() {
                c cVar = c.this;
                cVar.b(cVar.z);
                c.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.q.a.f.c.2.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        c.this.z();
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.c.c.b
            public void d() {
                c cVar = c.this;
                cVar.y = cVar.v.c();
                c.this.w.a(0L);
                c.this.a(0L);
                c cVar2 = c.this;
                cVar2.c(0L, cVar2.y);
                c.this.q();
            }

            @Override // com.opos.mobad.c.c.b
            public void e() {
                c.this.p();
                c.this.w.a();
                c.this.r();
                c.this.s();
                c.this.A();
            }

            @Override // com.opos.mobad.c.c.b
            public void f() {
                if (c.this.o() == 8) {
                    return;
                }
                c cVar = c.this;
                cVar.b(cVar.v.d(), c.this.y);
                c.this.w.a(0L);
                c.this.q();
            }

            @Override // com.opos.mobad.c.c.b
            public void g() {
                if (c.this.o() == 8) {
                    return;
                }
                c cVar = c.this;
                cVar.a(cVar.v.d(), c.this.y);
                c.this.w.a();
            }

            @Override // com.opos.mobad.c.c.b
            public void h() {
                c.this.i();
            }

            @Override // com.opos.mobad.c.c.b
            public void i() {
                c.this.q();
            }

            @Override // com.opos.mobad.c.c.b
            public void j() {
            }
        };
        this.g = context.getApplicationContext();
        this.d = new RelativeLayout(this.g);
        if (Build.VERSION.SDK_INT >= 29) {
            this.d.setForceDarkAllowed(false);
        }
        this.t = adItemData;
        this.u = adItemData.i().get(0);
        this.v = aVar;
        aVar.a(this.f13512a);
        this.w = new com.opos.mobad.c.b.c(com.opos.mobad.service.c.a(), this.B);
        this.A = new a();
        a(this.v.b(), this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.opos.mobad.c.d.a aVar = this.C;
        if (aVar != null) {
            aVar.a((a.InterfaceC0508a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        MaterialData materialData = this.u;
        if (materialData != null && j >= materialData.v() * 1000) {
            r();
        }
    }

    private void a(View view) {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (com.opos.cmn.an.h.f.a.d(this.g)) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 110.0f);
            context = this.g;
            f = 15.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 61.0f);
            context = this.g;
            f = 31.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f);
    }

    private void a(View view, AdItemData adItemData) {
        this.d.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        i iVar = new i() { // from class: com.opos.mobad.q.a.f.c.3
            @Override // com.opos.mobad.q.a.i
            public void a(View view2, int[] iArr) {
                boolean z = false;
                boolean z2 = c.this.i != null;
                if (c.this.i.getVisibility() == 0) {
                    z = true;
                }
                if ((!z2 || !z) || c.this.f13312c == null) {
                    return;
                }
                c.this.f13312c.e(view2, iArr);
            }
        };
        this.d.setOnClickListener(iVar);
        this.d.setOnTouchListener(iVar);
        v();
        c(adItemData);
        d(adItemData);
        u();
        a(adItemData.i().get(0));
        b(!adItemData.D());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.z = z;
        this.v.a(z ? 1.0f : 0.0f);
        this.e.a(z);
    }

    private void c(AdItemData adItemData) {
        LinearLayout linearLayout = new LinearLayout(this.g);
        this.k = linearLayout;
        linearLayout.setVisibility(8);
        this.k.setOrientation(0);
        this.k.setGravity(16);
        this.k.setPadding(com.opos.cmn.an.h.f.a.a(this.g, 3.0f), 0, com.opos.cmn.an.h.f.a.a(this.g, 3.0f), 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(1728053247);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.g, 4.0f));
        this.k.setBackground(gradientDrawable);
        TextView textView = new TextView(this.g);
        textView.setTextSize(1, 10.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setMaxEms(6);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        this.l = textView;
        this.k.addView(this.l, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 33.0f), com.opos.cmn.an.h.f.a.a(this.g, 14.0f)));
        ImageView imageView = new ImageView(this.g);
        this.m = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.m.setImageResource(R.drawable.opos_mobad_feedback_down_vector);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 7.0f), com.opos.cmn.an.h.f.a.a(this.g, 4.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 3.0f);
        this.k.addView(this.m, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 50.0f), com.opos.cmn.an.h.f.a.a(this.g, 14.0f));
        layoutParams2.addRule(11);
        this.d.addView(this.k, layoutParams2);
        a(this.k);
        a(adItemData);
        i iVar = new i() { // from class: com.opos.mobad.q.a.f.c.4
            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                if (!c.this.n || c.this.f13312c == null) {
                    return;
                }
                c.this.f13312c.a(view, iArr);
            }

            @Override // com.opos.mobad.q.a.i, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return super.onTouch(view, motionEvent);
            }
        };
        this.k.setOnClickListener(iVar);
        this.k.setOnTouchListener(iVar);
    }

    private void d(AdItemData adItemData) {
        d dVar = new d(this.g, this.A);
        this.f = dVar;
        dVar.a(adItemData);
        View a2 = this.f.a();
        this.i = a2;
        this.d.addView(a2, e(adItemData));
    }

    private RelativeLayout.LayoutParams e(AdItemData adItemData) {
        RelativeLayout.LayoutParams layoutParams;
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams2;
        boolean d = com.opos.cmn.an.h.f.a.d(this.g);
        boolean f2 = f(adItemData);
        if (d) {
            if (f2) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 85.0f));
                layoutParams2.addRule(12);
                layoutParams2.addRule(14);
                return layoutParams2;
            }
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 92.0f), com.opos.cmn.an.h.f.a.a(this.g, 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            f = 13.0f;
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 13.0f);
            context = this.g;
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(context, f);
            return layoutParams;
        } else if (f2) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 85.0f));
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
            return layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 92.0f), com.opos.cmn.an.h.f.a.a(this.g, 30.0f));
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 17.0f);
            context = this.g;
            f = 15.0f;
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(context, f);
            return layoutParams;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
        if (com.opos.cmn.an.c.a.a(r0.get(0).a()) == false) goto L4;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a4 -> B:29:0x00ae). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean f(com.opos.mobad.model.data.AdItemData r5) {
        /*
            r4 = this;
            r0 = 1
            r7 = r0
            r0 = r5
            if (r0 == 0) goto Lae
            r0 = r5
            java.util.List r0 = r0.i()     // Catch: java.lang.Exception -> La3
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0     // Catch: java.lang.Exception -> La3
            int r0 = r0.G()     // Catch: java.lang.Exception -> La3
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L61
            r0 = r6
            r1 = 1
            if (r0 == r1) goto L23
            goto Lae
        L23:
            r0 = r5
            java.util.List r0 = r0.i()     // Catch: java.lang.Exception -> La3
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0     // Catch: java.lang.Exception -> La3
            java.util.List r0 = r0.j()     // Catch: java.lang.Exception -> La3
            r5 = r0
            r0 = r5
            if (r0 == 0) goto Lae
            r0 = r5
            int r0 = r0.size()     // Catch: java.lang.Exception -> La3
            if (r0 <= 0) goto Lae
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            if (r0 == 0) goto Lae
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialFileData r0 = (com.opos.mobad.model.data.MaterialFileData) r0     // Catch: java.lang.Exception -> La3
            java.lang.String r0 = r0.a()     // Catch: java.lang.Exception -> La3
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> La3
            if (r0 != 0) goto Lae
            goto Lb0
        L61:
            r0 = r5
            java.util.List r0 = r0.i()     // Catch: java.lang.Exception -> La3
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0     // Catch: java.lang.Exception -> La3
            java.util.List r0 = r0.f()     // Catch: java.lang.Exception -> La3
            r5 = r0
            r0 = r5
            if (r0 == 0) goto Lae
            r0 = r5
            int r0 = r0.size()     // Catch: java.lang.Exception -> La3
            if (r0 <= 0) goto Lae
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            if (r0 == 0) goto Lae
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> La3
            com.opos.mobad.model.data.MaterialFileData r0 = (com.opos.mobad.model.data.MaterialFileData) r0     // Catch: java.lang.Exception -> La3
            java.lang.String r0 = r0.a()     // Catch: java.lang.Exception -> La3
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> La3
            r8 = r0
            r0 = r8
            if (r0 != 0) goto Lae
            goto Lb0
        La3:
            r5 = move-exception
            java.lang.String r0 = "VideoTemplate"
            java.lang.String r1 = ""
            r2 = r5
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        Lae:
            r0 = 0
            r7 = r0
        Lb0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "hasTipBarMaterial="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "VideoTemplate"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.f.c.f(com.opos.mobad.model.data.AdItemData):boolean");
    }

    private void u() {
        ProgressBar progressBar;
        this.h = new RelativeLayout(this.g);
        if (Build.VERSION.SDK_INT >= 21) {
            progressBar = new ProgressBar(this.g, null, android.R.attr.progressBarStyle, android.R.style.Widget_Holo_Light_ProgressBar);
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(this.g.getResources().getColor(R.color.opos_mob_primary)));
        } else {
            progressBar = new ProgressBar(this.g);
        }
        progressBar.setIndeterminateDrawable(this.g.getResources().getDrawable(R.drawable.opos_mob_drawable_loading));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 50.0f), com.opos.cmn.an.h.f.a.a(this.g, 50.0f));
        layoutParams.addRule(13);
        this.h.addView(progressBar, layoutParams);
        this.h.setVisibility(8);
        this.d.addView(this.h, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void v() {
        b bVar = new b(this.g);
        this.e = bVar;
        bVar.a(this.A);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        View b = this.e.b();
        this.j = b;
        b.setVisibility(8);
        this.d.addView(this.j, layoutParams);
        w();
    }

    private void w() {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        if (com.opos.cmn.an.h.f.a.d(this.g)) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 50.0f);
            context = this.g;
            f = 16.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 20.0f);
            context = this.g;
            f = 34.0f;
        }
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(context, f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, f);
    }

    private void x() {
        ImageView imageView;
        int i;
        if (this.n) {
            imageView = this.m;
            i = 0;
        } else {
            imageView = this.m;
            i = 8;
        }
        imageView.setVisibility(i);
    }

    private void y() {
        com.opos.mobad.o.c.a aVar = this.q;
        if (aVar != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.a().getLayoutParams();
            if (this.s == 0) {
                if (!com.opos.cmn.an.h.f.a.d(this.g)) {
                    layoutParams.addRule(15);
                    layoutParams.removeRule(12);
                    layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 37.0f);
                    return;
                }
                layoutParams.removeRule(15);
                layoutParams.addRule(12);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 140.0f);
            } else if (!com.opos.cmn.an.h.f.a.d(this.g)) {
                layoutParams.addRule(15);
                layoutParams.removeRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 37.0f);
            } else {
                layoutParams.removeRule(15);
                layoutParams.addRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 140.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.C == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.g);
            this.C = aVar;
            aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.q.a.f.c.6
                @Override // com.opos.mobad.c.d.a.InterfaceC0508a
                public void a(boolean z) {
                    if (c.this.x == null) {
                        return;
                    }
                    if (!z) {
                        c.this.l();
                        return;
                    }
                    c.this.n();
                    c.this.k();
                }
            });
        }
        if (this.d.indexOfChild(this.C) < 0) {
            this.d.addView(this.C, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    protected void a(AdItemData adItemData) {
        if (adItemData == null || !adItemData.j()) {
            return;
        }
        Drawable b = b(adItemData);
        if (b != null) {
            com.opos.cmn.e.a.d.a.a(this.l, b);
        } else if (com.opos.cmn.an.c.a.a(adItemData.B())) {
        } else {
            this.l.setText(adItemData.B());
        }
    }

    public void a(MaterialData materialData) {
        if (materialData == null || materialData.ab() == null || materialData.ab().a() == null || TextUtils.isEmpty(materialData.ab().a().a())) {
            return;
        }
        com.opos.cmn.an.f.a.b("VideoTemplate", "add pendant");
        com.opos.mobad.o.c.a aVar = new com.opos.mobad.o.c.a(this.g, this.A);
        this.q = aVar;
        aVar.a(new a.b(materialData.ab().a().a(), 75, 75));
        View a2 = this.q.a();
        this.r = a2;
        a2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 75.0f), com.opos.cmn.an.h.f.a.a(this.g, 75.0f));
        if (materialData.ab().c() == 0) {
            this.s = 0;
            layoutParams.addRule(11);
            if (com.opos.cmn.an.h.f.a.d(this.g)) {
                layoutParams.addRule(12);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 37.0f);
            }
        } else {
            this.s = 1;
            layoutParams.addRule(9);
            if (com.opos.cmn.an.h.f.a.d(this.g)) {
                layoutParams.addRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 37.0f);
            }
        }
        this.d.addView(this.r, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        e b;
        if (hVar == null || (b = hVar.b()) == null) {
            return;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(b.f12942a.f12945a) && this.x == null) {
            this.v.a(b.f12942a.f12945a, false);
        }
        this.x = b;
        if (b.B == 1) {
            z = true;
        }
        b(z);
        this.e.a(b.s);
        c(b.C);
        a(b.r);
        this.f.a(b.l);
    }

    public void a(boolean z) {
        this.n = z;
        x();
    }

    protected Drawable b(AdItemData adItemData) {
        Drawable a2 = (adItemData == null || adItemData.l() == null || com.opos.cmn.an.c.a.a(adItemData.l().a())) ? null : g.a(this.g, adItemData.l().a());
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(a2 != null ? a2 : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("VideoTemplate", sb.toString());
        return a2;
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.d;
    }

    public void c(int i) {
        this.p = i;
        this.e.a(i, this.o);
    }

    @Override // com.opos.mobad.n.i.a
    public boolean f() {
        com.opos.mobad.c.c.a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        aVar.f();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean g() {
        com.opos.mobad.c.c.a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        aVar.g();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public void h() {
        this.d.removeAllViews();
        com.opos.mobad.o.c.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
        final com.opos.mobad.c.c.a aVar2 = this.v;
        if (aVar2 != null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.q.a.f.c.5
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.c.c.a aVar3 = aVar2;
                    if (aVar3 != null) {
                        aVar3.f();
                        aVar2.h();
                    }
                }
            });
        }
    }

    public void i() {
        this.h.setVisibility(0);
    }

    public void q() {
        this.o = true;
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        this.k.setVisibility(0);
        this.j.setVisibility(0);
        this.e.a(this.p, this.o);
        x();
        View view = this.r;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void r() {
        this.e.a();
    }

    public void s() {
        MaterialData materialData = this.u;
        if (materialData == null || materialData.T() != 1) {
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.i.setVisibility(8);
        View view = this.r;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void t() {
        w();
        a(this.k);
        y();
    }
}
