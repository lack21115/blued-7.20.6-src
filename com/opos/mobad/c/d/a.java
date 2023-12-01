package com.opos.mobad.c.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c/d/a.class */
public class a extends FrameLayout {
    private static Handler d;

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0508a f12124a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12125c;

    /* renamed from: com.opos.mobad.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c/d/a$a.class */
    public interface InterfaceC0508a {
        void a(boolean z);
    }

    public a(Context context) {
        super(context);
        this.f12124a = null;
        this.b = false;
        this.f12125c = false;
        d = new Handler(Looper.getMainLooper());
    }

    private void a(int i) {
        boolean z;
        if (i != 0) {
            z = false;
        } else if (getVisibility() != 0 || !isShown()) {
            return;
        } else {
            z = true;
        }
        a(z);
    }

    public void a(InterfaceC0508a interfaceC0508a) {
        this.f12124a = interfaceC0508a;
        if (!this.b || interfaceC0508a == null) {
            return;
        }
        d.post(new Runnable() { // from class: com.opos.mobad.c.d.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.b || a.this.f12124a == null) {
                    return;
                }
                a.this.f12124a.a(a.this.f12125c);
            }
        });
    }

    protected void a(final boolean z) {
        if (this.f12125c == (!z)) {
            this.f12125c = z;
            if (this.f12124a != null) {
                d.post(new Runnable() { // from class: com.opos.mobad.c.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f12124a != null) {
                            a.this.f12124a.a(z);
                        }
                    }
                });
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        a(i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        boolean z2;
        super.onWindowFocusChanged(z);
        com.opos.cmn.an.f.a.b("StatusMediaView", "onViewVisibile hasWindowFocus=" + z);
        if (!z) {
            z2 = false;
        } else if (getVisibility() != 0 || !isShown()) {
            return;
        } else {
            z2 = true;
        }
        a(z2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i);
    }
}
