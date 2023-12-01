package com.anythink.basead.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.a.a;
import com.anythink.basead.a.c;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;
import com.anythink.core.common.k.a.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseAdView.class */
public abstract class BaseAdView extends RelativeLayout {
    private com.anythink.basead.a.a a;
    String b;
    j c;
    i d;
    c e;
    com.anythink.basead.a.c f;
    volatile boolean g;
    boolean h;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    String q;
    List<View> r;
    View s;

    public BaseAdView(Context context) {
        super(context);
        this.b = "BaseAdView";
    }

    public BaseAdView(Context context, j jVar, i iVar) {
        this(context, jVar, iVar, "");
    }

    public BaseAdView(Context context, j jVar, i iVar, String str) {
        super(context);
        this.b = "BaseAdView";
        this.c = jVar;
        this.d = iVar;
        this.q = str;
        this.r = new ArrayList();
        if (!this.d.L() && this.c.m.F() != 1) {
            this.a = new com.anythink.basead.a.a(this, this.c, new a.InterfaceC0026a() { // from class: com.anythink.basead.ui.BaseAdView.1
                @Override // com.anythink.basead.a.a.InterfaceC0026a
                public final void a(int i) {
                    if (BaseAdView.this.s != null) {
                        BaseAdView baseAdView = BaseAdView.this;
                        baseAdView.a(baseAdView.s);
                    } else {
                        BaseAdView baseAdView2 = BaseAdView.this;
                        baseAdView2.a(baseAdView2);
                    }
                    BaseAdView.this.b(i);
                }
            });
        }
        d();
        a();
        setFocusable(true);
        setClickable(true);
    }

    private void b() {
        if (this.g) {
            return;
        }
        this.g = true;
        i iVar = this.d;
        if (iVar instanceof s) {
            com.anythink.basead.f.a.b.a(getContext()).a((s) this.d);
        } else if (iVar instanceof aa) {
            com.anythink.basead.d.c.c.a().a(getContext(), com.anythink.basead.d.c.c.a(this.c.b, this.c.c), this.d, this.c.m);
        }
        if ((this.d instanceof aa) && this.c.f == 67) {
            if (((aa) this.d).a(true, true)) {
                com.anythink.core.common.d.c.a(getContext()).a(this.d.p(), 0, 1);
            }
            if (((aa) this.d).a(false, true)) {
                com.anythink.core.common.d.b.a(getContext()).a(this.d.q(), 0, 1);
            }
        }
        e();
        o();
    }

    private void b(View view) {
        this.s = view;
    }

    private static int c(int i) {
        Random random = new Random();
        if (i > 0) {
            double d = i;
            int i2 = (int) (0.1d * d);
            return random.nextInt((((int) (d * 0.9d)) - i2) + 1) + i2;
        }
        return 0;
    }

    private void c() {
        if ((this.d instanceof aa) && this.c.f == 67) {
            if (((aa) this.d).a(true, false)) {
                com.anythink.core.common.d.c.a(getContext()).a(this.d.p(), 1, 0);
            }
            if (((aa) this.d).a(false, false)) {
                com.anythink.core.common.d.b.a(getContext()).a(this.d.q(), 1, 0);
            }
        }
    }

    private void o() {
        com.anythink.basead.a.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float a(a aVar, int i) {
        float f = 1.0f;
        float f2 = 1.0f;
        if (aVar != null) {
            if (i == 2) {
                f = 1.5f;
            } else if (i == 3) {
                f = 0.75f;
            } else if (i == 4) {
                f = 0.5f;
            }
            aVar.setClickAreaScaleFactor(f);
            f2 = f;
        }
        return f2;
    }

    protected abstract void a();

    protected abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final int i, final Runnable runnable) {
        if (i > 0) {
            getContext();
            this.e = new c(i);
        } else {
            getContext();
            this.e = new c();
        }
        this.e.a(this, new com.anythink.core.common.k.a.a() { // from class: com.anythink.basead.ui.BaseAdView.3
            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final int getImpressionMinTimeViewed() {
                int i2 = i;
                if (i2 > 0) {
                    return i2;
                }
                return 50;
            }

            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final void recordImpression(View view) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int c = c(width);
        int c2 = c(height);
        int i3 = i + c;
        this.i = i3;
        this.j = i2 + c2;
        this.m = c;
        this.n = c2;
        this.k = i3 + ((int) (Math.random() * 15.0d));
        int random = c + i2 + ((int) (Math.random() * 15.0d));
        this.l = random;
        this.o = this.k - i;
        this.p = random - i2;
    }

    protected abstract void a(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final int i) {
        b();
        k();
        if (this.f == null) {
            this.f = new com.anythink.basead.a.c(getContext(), this.c, this.d);
        }
        if (this.f.a()) {
            return;
        }
        this.f.a(new c.b() { // from class: com.anythink.basead.ui.BaseAdView.2
            @Override // com.anythink.basead.a.c.b
            public final void a() {
                BaseAdView.this.a(i);
                BaseAdView.this.f();
                BaseAdView baseAdView = BaseAdView.this;
                if ((baseAdView.d instanceof aa) && baseAdView.c.f == 67) {
                    if (((aa) baseAdView.d).a(true, false)) {
                        com.anythink.core.common.d.c.a(baseAdView.getContext()).a(baseAdView.d.p(), 1, 0);
                    }
                    if (((aa) baseAdView.d).a(false, false)) {
                        com.anythink.core.common.d.b.a(baseAdView.getContext()).a(baseAdView.d.q(), 1, 0);
                    }
                }
            }

            @Override // com.anythink.basead.a.c.b
            public final void a(boolean z) {
                BaseAdView.this.a(z);
            }

            @Override // com.anythink.basead.a.c.b
            public final void b() {
                BaseAdView.this.g();
            }
        });
        com.anythink.basead.c.i i2 = i();
        i2.g = j();
        this.f.a(i2);
    }

    protected void d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destroy() {
        k();
        com.anythink.basead.a.c cVar = this.f;
        if (cVar != null) {
            cVar.d();
        }
        com.anythink.core.common.k.a.c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.i = (int) motionEvent.getRawX();
            this.j = (int) motionEvent.getRawY();
            this.m = (int) motionEvent.getX();
            this.n = (int) motionEvent.getY();
        } else if (action == 1 || action == 3) {
            this.k = (int) motionEvent.getRawX();
            this.l = (int) motionEvent.getRawY();
            this.o = (int) motionEvent.getX();
            this.p = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected abstract void e();

    protected void f() {
    }

    protected void g() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        synchronized (this) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.anythink.basead.c.i i() {
        com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.c.d, "");
        iVar.e = getWidth();
        iVar.f = getHeight();
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.anythink.basead.c.a j() {
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        aVar.a = this.i;
        aVar.b = this.j;
        aVar.c = this.k;
        aVar.d = this.l;
        aVar.e = this.m;
        aVar.f = this.n;
        aVar.g = this.o;
        aVar.h = this.p;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        com.anythink.basead.a.a aVar = this.a;
        if (aVar != null) {
            aVar.b();
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        com.anythink.basead.a.a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        j jVar;
        return com.anythink.expressad.shake.a.a().b() && (jVar = this.c) != null && jVar.m != null && this.c.m.M() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n() {
        i iVar = this.d;
        return iVar != null && iVar.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }
}
