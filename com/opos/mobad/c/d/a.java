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
    private InterfaceC0678a f25812a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25813c;

    /* renamed from: com.opos.mobad.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c/d/a$a.class */
    public interface InterfaceC0678a {
        void a(boolean z);
    }

    public a(Context context) {
        super(context);
        this.f25812a = null;
        this.b = false;
        this.f25813c = false;
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

    public void a(InterfaceC0678a interfaceC0678a) {
        this.f25812a = interfaceC0678a;
        if (!this.b || interfaceC0678a == null) {
            return;
        }
        d.post(new Runnable() { // from class: com.opos.mobad.c.d.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.b || a.this.f25812a == null) {
                    return;
                }
                a.this.f25812a.a(a.this.f25813c);
            }
        });
    }

    protected void a(final boolean z) {
        if (this.f25813c == (!z)) {
            this.f25813c = z;
            if (this.f25812a != null) {
                d.post(new Runnable() { // from class: com.opos.mobad.c.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f25812a != null) {
                            a.this.f25812a.a(z);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
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
