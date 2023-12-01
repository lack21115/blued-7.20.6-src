package com.tencent.bugly.idasc.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bg.class */
public final class bg extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public bf f21603a;
    private a g;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21604c = false;
    private boolean d = true;
    private boolean e = false;
    private int f = 1;
    public boolean b = true;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bg$a.class */
    public interface a {
    }

    private void a(bf bfVar) {
        synchronized (this) {
            if (this.d) {
                return;
            }
            if (this.e && !bfVar.a()) {
                al.c("Restart getting main stack trace.", new Object[0]);
                this.d = true;
                this.e = false;
            }
        }
    }

    public final boolean a() {
        this.f21604c = true;
        if (isAlive()) {
            try {
                interrupt();
            } catch (Exception e) {
                al.b(e);
            }
            al.d("MainHandlerChecker is reset to null.", new Object[0]);
            this.f21603a = null;
            return true;
        }
        return false;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.f21603a;
        if (bfVar != null) {
            bfVar.b = 5000L;
        } else {
            this.f21603a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e) {
            al.b(e);
            return false;
        }
    }

    public final void c() {
        synchronized (this) {
            this.d = false;
            al.c("Record stack trace is disabled.", new Object[0]);
        }
    }

    public final void d() {
        synchronized (this) {
            this.e = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.f21604c) {
            try {
            } catch (Exception | OutOfMemoryError e) {
                al.b(e);
            }
            if (this.f21603a == null) {
                al.c("Main handler checker is null. Stop thread monitor.", new Object[0]);
                return;
            }
            bf bfVar = this.f21603a;
            if (bfVar.f21602c) {
                bfVar.f21602c = false;
                bfVar.d = SystemClock.uptimeMillis();
                bfVar.f21601a.post(bfVar);
            }
            a(bfVar);
            boolean z = false;
            if (this.b) {
                if (this.d) {
                    long b = bfVar.b();
                    z = false;
                    if (b > 1510) {
                        if (b >= 199990) {
                            z = false;
                        } else if (b <= 5010) {
                            this.f = 1;
                            al.c("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                            z = true;
                        } else {
                            int i = this.f + 1;
                            this.f = i;
                            z = (i & (i - 1)) == 0;
                            if (z) {
                                al.c("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                            }
                        }
                    }
                } else {
                    z = false;
                }
            }
            if (z) {
                bfVar.d();
            }
            if (this.g != null && this.d) {
                bfVar.a();
                bfVar.b();
            }
            ap.b(500 - ((System.currentTimeMillis() - currentTimeMillis) % 500));
        }
    }
}
