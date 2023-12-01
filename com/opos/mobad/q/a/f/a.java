package com.opos.mobad.q.a.f;

import android.content.Context;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a.class */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0556a f13488a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f13489c;

    /* renamed from: com.opos.mobad.q.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a$a.class */
    public interface InterfaceC0556a {
        void a();

        void a(boolean z);

        void b();
    }

    public a(Context context) {
        super(context);
        this.b = false;
        this.f13489c = false;
    }

    public void a() {
        if (this.f13488a != null) {
            this.f13488a = null;
        }
    }

    public void a(InterfaceC0556a interfaceC0556a) {
        this.f13488a = interfaceC0556a;
        if (!this.b || interfaceC0556a == null) {
            return;
        }
        interfaceC0556a.b();
    }

    protected void a(boolean z) {
        if (this.f13489c == (!z)) {
            this.f13489c = z;
            InterfaceC0556a interfaceC0556a = this.f13488a;
            if (interfaceC0556a != null) {
                interfaceC0556a.a(z);
            }
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        InterfaceC0556a interfaceC0556a = this.f13488a;
        if (interfaceC0556a != null) {
            interfaceC0556a.b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        InterfaceC0556a interfaceC0556a = this.f13488a;
        if (interfaceC0556a != null) {
            interfaceC0556a.a();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i == 0);
    }
}
