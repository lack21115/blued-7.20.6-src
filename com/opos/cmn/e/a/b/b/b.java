package com.opos.cmn.e.a.b.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/b/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected Context f24760a;
    protected com.opos.cmn.e.a.b.a.a b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f24761c;
    protected ImageView d;

    public b(Context context) {
        this.f24760a = context;
        f();
        b();
        g();
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f24760a);
        this.f24761c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        a();
    }

    private void g() {
        this.b = new com.opos.cmn.e.a.b.a.b(this.d);
    }

    protected abstract void a();

    protected abstract void b();

    public View c() {
        return this.f24761c;
    }

    public void d() {
        this.b.a();
    }

    public void e() {
        this.b.b();
    }
}
