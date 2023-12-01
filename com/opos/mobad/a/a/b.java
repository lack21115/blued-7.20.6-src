package com.opos.mobad.a.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/a/a/b.class */
public class b implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f25608a;
    private com.opos.mobad.n.a b;

    public b(Context context) {
        this.f25608a = new FrameLayout(context);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.mobad.n.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.a(interfaceC0708a);
    }

    public void a(com.opos.mobad.n.a aVar) {
        this.b = aVar;
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.a(hVar);
        View c2 = this.b.c();
        if (c2 == null || this.f25608a.indexOfChild(c2) >= 0) {
            return;
        }
        this.f25608a.removeAllViews();
        this.f25608a.addView(c2, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f25608a;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.mobad.n.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.d();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.b;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }
}
