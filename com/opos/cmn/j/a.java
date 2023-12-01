package com.opos.cmn.j;

import android.content.Context;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/j/a.class */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0476a f11294a;
    private boolean b;

    /* renamed from: com.opos.cmn.j.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/j/a$a.class */
    public interface InterfaceC0476a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context);
        this.b = false;
    }

    public void a(InterfaceC0476a interfaceC0476a) {
        this.f11294a = interfaceC0476a;
        if (!this.b || interfaceC0476a == null) {
            return;
        }
        interfaceC0476a.b();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        InterfaceC0476a interfaceC0476a = this.f11294a;
        if (interfaceC0476a != null) {
            interfaceC0476a.b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        InterfaceC0476a interfaceC0476a = this.f11294a;
        if (interfaceC0476a != null) {
            interfaceC0476a.a();
        }
    }
}
