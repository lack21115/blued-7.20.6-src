package com.opos.mobad.o.b;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected Context f27049a;
    protected e b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f27050c;
    protected RelativeLayout d;

    public b(Context context, e eVar) {
        this.f27049a = context;
        this.b = eVar;
        d();
    }

    private void d() {
        this.f27050c = new RelativeLayout(this.f27049a);
        a();
        this.d = new RelativeLayout(this.f27049a);
        b();
        c();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f27050c.addView(this.d, layoutParams);
    }

    protected abstract void a();

    protected abstract void b();

    protected abstract void c();
}
