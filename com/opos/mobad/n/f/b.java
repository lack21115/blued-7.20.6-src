package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/b.class */
public class b implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private int f12969a;
    private RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f12970c;
    private FrameLayout d;
    private d e;
    private a.InterfaceC0538a f;
    private int g;
    private Context h;
    private com.opos.mobad.n.d.d i;
    private a j;
    private volatile boolean k = false;
    private com.opos.mobad.c.a l;
    private int m;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f12985a;
        public final int b;

        public a(int i, int i2) {
            this.f12985a = i;
            this.b = i2;
        }
    }

    public b(Context context, int i, int i2, a aVar, int i3, com.opos.mobad.c.a aVar2) {
        this.h = context.getApplicationContext();
        this.g = i;
        this.j = aVar;
        this.f12969a = i3;
        this.l = aVar2;
        this.m = i2;
        a(i2);
    }

    public static final com.opos.mobad.n.a a(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 0, new a(258, 153), 1, aVar);
    }

    private void a(int i) {
        RelativeLayout relativeLayout = new RelativeLayout(this.h);
        this.b = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.b.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f != null) {
                    b.this.f.g(view, iArr);
                }
            }
        };
        this.b.setOnClickListener(gVar);
        this.b.setOnTouchListener(gVar);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.h);
        this.f12970c = relativeLayout2;
        relativeLayout2.setId(View.generateViewId());
        this.b.addView(this.f12970c, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.h, this.j.b)));
        this.d = new FrameLayout(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, this.f12970c.getId());
        this.b.addView(this.d, layoutParams);
        Context context = this.h;
        this.e = i == 1 ? d.a(context) : d.b(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.h, i == 1 ? 220.0f : 248.0f), -2);
        layoutParams2.gravity = 17;
        this.d.addView(this.e, layoutParams2);
        this.e.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.b.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f != null) {
                    b.this.f.f(view, iArr);
                }
            }
        });
    }

    public static void a(ViewGroup viewGroup, final a.InterfaceC0538a interfaceC0538a) {
        if (viewGroup == null || interfaceC0538a == null) {
            return;
        }
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(viewGroup.getContext());
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.f.b.8
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.b.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.InterfaceC0538a.this != null) {
                                a.InterfaceC0538a.this.b();
                            }
                        }
                    });
                    aVar.a((a.InterfaceC0508a) null);
                }
            }
        });
        viewGroup.addView(aVar, 0, 0);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        this.e.a(dVar.f, dVar.e, dVar.x, dVar.y, dVar.l);
        if (this.i != null) {
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.h, 60.0f);
        if (dVar.m == null || TextUtils.isEmpty(dVar.m.f12945a)) {
            this.e.b();
        } else {
            this.l.a(dVar.m.f12945a, dVar.m.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.b.3
                @Override // com.opos.mobad.c.a.InterfaceC0506a
                public void a(int i, final Bitmap bitmap) {
                    if (b.this.k) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (b.this.f != null) {
                            b.this.f.c(i);
                            return;
                        }
                        return;
                    }
                    if (i == 1 && b.this.f != null) {
                        b.this.f.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            b.this.e.a(bitmap);
                        }
                    });
                }
            });
        }
        this.e.a();
    }

    public static final com.opos.mobad.n.a b(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 0, new a(258, 179), 2, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        if (this.i != null) {
            return;
        }
        int i = this.f12969a;
        this.f12970c.addView((i == 1 || i == 2) ? e(dVar) : i == 3 ? c(dVar) : d(dVar), new RelativeLayout.LayoutParams(-1, -1));
    }

    private View c(com.opos.mobad.n.d.d dVar) {
        final com.opos.mobad.n.c.b bVar = new com.opos.mobad.n.c.b(this.h, 3);
        int a2 = com.opos.cmn.an.h.f.a.a(this.h, this.j.f12985a);
        int a3 = com.opos.cmn.an.h.f.a.a(this.h, this.j.b);
        if (dVar == null) {
            return bVar;
        }
        final ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(dVar.g.size(), 3)) {
                bVar.a(dVar.z);
                bVar.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.b.5
                    @Override // com.opos.mobad.n.c.g
                    public void a(View view, int[] iArr) {
                        if (b.this.f != null) {
                            b.this.f.g(view, iArr);
                        }
                    }
                });
                return bVar;
            }
            com.opos.mobad.n.d.g gVar = dVar.g.get(i2);
            if (gVar != null) {
                this.l.a(gVar.f12945a, gVar.b, a2, a3, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.b.4
                    @Override // com.opos.mobad.c.a.InterfaceC0506a
                    public void a(int i3, final Bitmap bitmap) {
                        if (b.this.k) {
                            return;
                        }
                        if (bitmap == null || bitmap.isRecycled()) {
                            com.opos.cmn.an.f.a.a("imageInter", "null bitmap");
                        } else if (i3 != 0 && i3 != 1) {
                            if (b.this.f != null) {
                                b.this.f.c(i3);
                            }
                        } else {
                            if (i3 == 1 && b.this.f != null) {
                                b.this.f.c(i3);
                            }
                            com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (b.this.k) {
                                        return;
                                    }
                                    arrayList.add(bitmap);
                                    bVar.a(arrayList);
                                }
                            });
                        }
                    }
                });
            }
            i = i2 + 1;
        }
    }

    public static final com.opos.mobad.n.a c(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 0, new a(258, 179), 3, aVar);
    }

    private View d(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.c.c b = this.m == 0 ? com.opos.mobad.n.c.c.b(this.h) : com.opos.mobad.n.c.c.a(this.h);
        if (dVar.m != null) {
            final com.opos.mobad.n.c.c cVar = b;
            this.l.a(dVar.m.f12945a, dVar.m.b, com.opos.cmn.an.h.f.a.a(this.h, b.b), com.opos.cmn.an.h.f.a.a(this.h, b.b), new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.b.6
                @Override // com.opos.mobad.c.a.InterfaceC0506a
                public void a(int i, final Bitmap bitmap) {
                    if (b.this.k) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (b.this.f != null) {
                            b.this.f.c(i);
                            return;
                        }
                        return;
                    }
                    if (i == 1 && b.this.f != null) {
                        b.this.f.c(i);
                    }
                    com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            cVar.a(bitmap, 28);
                        }
                    });
                }
            });
        }
        return b;
    }

    public static final com.opos.mobad.n.a d(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 0, new a(258, 179), 0, aVar);
    }

    private View e(com.opos.mobad.n.d.d dVar) {
        final ImageView imageView = new ImageView(this.h);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (dVar.g != null) {
            this.l.a(dVar.g.get(0).f12945a, dVar.g.get(0).b, com.opos.cmn.an.h.f.a.a(this.h, this.j.f12985a), com.opos.cmn.an.h.f.a.a(this.h, this.j.b), new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.b.7
                @Override // com.opos.mobad.c.a.InterfaceC0506a
                public void a(int i, final Bitmap bitmap) {
                    if (b.this.k) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (b.this.f != null) {
                            b.this.f.c(i);
                            return;
                        }
                        return;
                    }
                    if (i == 1 && b.this.f != null) {
                        b.this.f.c(i);
                    }
                    com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
        return imageView;
    }

    public static final com.opos.mobad.n.a e(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 1, new a(272, 145), 1, aVar);
    }

    public static final com.opos.mobad.n.a f(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 1, new a(272, 169), 2, aVar);
    }

    public static final com.opos.mobad.n.a g(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 1, new a(272, 169), 3, aVar);
    }

    public static final com.opos.mobad.n.a h(Context context, int i, com.opos.mobad.c.a aVar) {
        return new b(context, i, 1, new a(272, 169), 0, aVar);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.f = interfaceC0538a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0538a interfaceC0538a;
        a.InterfaceC0538a interfaceC0538a2;
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null) {
            com.opos.cmn.an.f.a.d("imageInter", "render with data null");
            interfaceC0538a2 = this.f;
            if (interfaceC0538a2 == null) {
                return;
            }
        } else if (this.f12969a == 0 && (a2.m == null || TextUtils.isEmpty(a2.m.f12945a))) {
            com.opos.cmn.an.f.a.d("", "render with iconUrl null");
            interfaceC0538a2 = this.f;
            if (interfaceC0538a2 == null) {
                return;
            }
        } else if (this.f12969a == 0 || (a2.g != null && a2.g.size() > 0)) {
            b(a2);
            a(a2);
            if (this.i == null && (interfaceC0538a = this.f) != null) {
                interfaceC0538a.e();
                a(this.b, this.f);
            }
            this.i = a2;
            return;
        } else {
            com.opos.cmn.an.f.a.d("", "render with imgList null");
            interfaceC0538a2 = this.f;
            if (interfaceC0538a2 == null) {
                return;
            }
        }
        interfaceC0538a2.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.b;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.k = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.g;
    }
}
