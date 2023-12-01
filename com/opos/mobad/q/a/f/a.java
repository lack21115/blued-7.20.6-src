package com.opos.mobad.q.a.f;

import android.content.Context;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a.class */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0726a f27176a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f27177c;

    /* renamed from: com.opos.mobad.q.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a$a.class */
    public interface InterfaceC0726a {
        void a();

        void a(boolean z);

        void b();
    }

    public a(Context context) {
        super(context);
        this.b = false;
        this.f27177c = false;
    }

    public void a() {
        if (this.f27176a != null) {
            this.f27176a = null;
        }
    }

    public void a(InterfaceC0726a interfaceC0726a) {
        this.f27176a = interfaceC0726a;
        if (!this.b || interfaceC0726a == null) {
            return;
        }
        interfaceC0726a.b();
    }

    protected void a(boolean z) {
        if (this.f27177c == (!z)) {
            this.f27177c = z;
            InterfaceC0726a interfaceC0726a = this.f27176a;
            if (interfaceC0726a != null) {
                interfaceC0726a.a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        InterfaceC0726a interfaceC0726a = this.f27176a;
        if (interfaceC0726a != null) {
            interfaceC0726a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        InterfaceC0726a interfaceC0726a = this.f27176a;
        if (interfaceC0726a != null) {
            interfaceC0726a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i == 0);
    }
}
