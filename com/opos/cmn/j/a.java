package com.opos.cmn.j;

import android.content.Context;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/j/a.class */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0646a f24982a;
    private boolean b;

    /* renamed from: com.opos.cmn.j.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/j/a$a.class */
    public interface InterfaceC0646a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context);
        this.b = false;
    }

    public void a(InterfaceC0646a interfaceC0646a) {
        this.f24982a = interfaceC0646a;
        if (!this.b || interfaceC0646a == null) {
            return;
        }
        interfaceC0646a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        InterfaceC0646a interfaceC0646a = this.f24982a;
        if (interfaceC0646a != null) {
            interfaceC0646a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        InterfaceC0646a interfaceC0646a = this.f24982a;
        if (interfaceC0646a != null) {
            interfaceC0646a.a();
        }
    }
}
