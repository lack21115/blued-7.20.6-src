package com.opos.cmn.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/j/b.class */
public class b extends FrameLayout {
    private static Handler d;

    /* renamed from: a  reason: collision with root package name */
    private a f11295a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11296c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/j/b$a.class */
    public interface a {
        void a(boolean z);
    }

    public b(Context context) {
        super(context);
        this.f11295a = null;
        this.b = false;
        this.f11296c = false;
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

    public void a(a aVar) {
        this.f11295a = aVar;
        if (!this.b || aVar == null) {
            return;
        }
        d.post(new Runnable() { // from class: com.opos.cmn.j.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.b || b.this.f11295a == null) {
                    return;
                }
                b.this.f11295a.a(b.this.f11296c);
            }
        });
    }

    protected void a(final boolean z) {
        if (this.f11296c == (!z)) {
            this.f11296c = z;
            if (this.f11295a != null) {
                d.post(new Runnable() { // from class: com.opos.cmn.j.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f11295a != null) {
                            b.this.f11295a.a(z);
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
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i);
    }
}
