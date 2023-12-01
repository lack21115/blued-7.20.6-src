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
    private a f24983a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24984c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/j/b$a.class */
    public interface a {
        void a(boolean z);
    }

    public b(Context context) {
        super(context);
        this.f24983a = null;
        this.b = false;
        this.f24984c = false;
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
        this.f24983a = aVar;
        if (!this.b || aVar == null) {
            return;
        }
        d.post(new Runnable() { // from class: com.opos.cmn.j.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.b || b.this.f24983a == null) {
                    return;
                }
                b.this.f24983a.a(b.this.f24984c);
            }
        });
    }

    protected void a(final boolean z) {
        if (this.f24984c == (!z)) {
            this.f24984c = z;
            if (this.f24983a != null) {
                d.post(new Runnable() { // from class: com.opos.cmn.j.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f24983a != null) {
                            b.this.f24983a.a(z);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i);
    }
}
