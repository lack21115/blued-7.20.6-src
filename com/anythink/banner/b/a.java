package com.anythink.banner.b;

import android.text.TextUtils;
import com.anythink.banner.a.d;
import com.anythink.core.c.e;
import com.anythink.core.common.b.n;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/b/a.class */
public class a {
    String a;
    WeakReference<d> b;
    Timer c;
    private boolean d = false;

    /* renamed from: com.anythink.banner.b.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/b/a$1.class */
    final class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a.a(a.this);
        }
    }

    public a(d dVar) {
        this.b = new WeakReference<>(dVar);
    }

    static /* synthetic */ void a(a aVar) {
        WeakReference<d> weakReference = aVar.b;
        d dVar = weakReference != null ? weakReference.get() : null;
        if (dVar != null) {
            dVar.timeUpRefreshView();
        } else {
            aVar.d();
        }
    }

    private TimerTask e() {
        return new AnonymousClass1();
    }

    private void f() {
        WeakReference<d> weakReference = this.b;
        d dVar = weakReference != null ? weakReference.get() : null;
        if (dVar != null) {
            dVar.timeUpRefreshView();
        } else {
            d();
        }
    }

    public final void a(String str) {
        this.a = str;
    }

    public final boolean a() {
        return this.d;
    }

    public final void b() {
        synchronized (this) {
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            com.anythink.core.c.d a = e.a(n.a().g()).a(this.a);
            if (this.c != null) {
                this.c.cancel();
            }
            if (a != null && a.V() == 1) {
                this.d = true;
                this.c = new Timer();
                long j = 5000;
                if (a.W() > 5000) {
                    j = a.W();
                }
                this.c.schedule(new AnonymousClass1(), j, j);
            }
        }
    }

    public final boolean c() {
        return this.c == null;
    }

    public final void d() {
        synchronized (this) {
            if (this.c != null) {
                this.c.cancel();
            }
            this.c = null;
        }
    }
}
