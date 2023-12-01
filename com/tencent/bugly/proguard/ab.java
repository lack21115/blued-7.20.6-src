package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/ab.class */
public final class ab extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private boolean f35360a = false;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private List<aa> f35361c = new ArrayList();
    private List<ac> d = new ArrayList();
    private ArrayList<aa> e = new ArrayList<>();

    private void a(Handler handler, long j) {
        String name;
        if (handler == null) {
            x.e("addThread handler should not be null", new Object[0]);
            return;
        }
        name = handler.getLooper().getThread().getName();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.f35361c.size()) {
                    break;
                } else if (this.f35361c.get(i2).d().equals(handler.getLooper().getThread().getName())) {
                    x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                } else {
                    i = i2 + 1;
                }
            } catch (Exception e) {
                x.b(e);
            }
        }
        this.f35361c.add(new aa(handler, name, 5000L));
    }

    private int e() {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            try {
                if (i2 >= this.f35361c.size()) {
                    break;
                }
                i3 = Math.max(i, this.f35361c.get(i2).c());
                i2++;
            } catch (Exception e) {
                x.b(e);
            }
        }
        return i;
    }

    public final void a() {
        a(new Handler(Looper.getMainLooper()), 5000L);
    }

    public final void a(ac acVar) {
        if (this.d.contains(acVar)) {
            x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.d.add(acVar);
        }
    }

    public final void a(boolean z) {
        this.b = true;
    }

    public final void b() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.f35361c.size()) {
                    return;
                }
                if (this.f35361c.get(i2).d().equals(Looper.getMainLooper().getThread().getName())) {
                    x.c("remove handler::%s", this.f35361c.get(i2));
                    this.f35361c.remove(i2);
                }
                i = i2 + 1;
            } catch (Exception e) {
                x.b(e);
                return;
            }
        }
    }

    public final void b(ac acVar) {
        this.d.remove(acVar);
    }

    public final boolean c() {
        this.f35360a = true;
        if (isAlive()) {
            try {
                interrupt();
                return true;
            } catch (Exception e) {
                x.b(e);
                return true;
            }
        }
        return false;
    }

    public final boolean d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e) {
            x.b(e);
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f35360a) {
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= this.f35361c.size()) {
                        break;
                    }
                    this.f35361c.get(i2).a();
                    i = i2 + 1;
                } catch (Exception e) {
                    x.b(e);
                } catch (OutOfMemoryError e2) {
                    x.b(e2);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j = 2000; j > 0 && !isInterrupted(); j = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                sleep(j);
            }
            int e3 = e();
            if (e3 != 0 && e3 != 1) {
                this.e.clear();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.f35361c.size()) {
                        break;
                    }
                    aa aaVar = this.f35361c.get(i4);
                    if (aaVar.b()) {
                        this.e.add(aaVar);
                        aaVar.a(Long.MAX_VALUE);
                    }
                    i3 = i4 + 1;
                }
                int i5 = 0;
                while (true) {
                    if (this.b) {
                        break;
                    }
                    x.c("do not enable anr continue check", new Object[0]);
                    sleep(2000L);
                    int i6 = i5 + 1;
                    i5 = i6;
                    if (i6 == 15) {
                        this.e.clear();
                        break;
                    }
                }
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < this.e.size()) {
                        aa aaVar2 = this.e.get(i8);
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            if (i10 < this.d.size()) {
                                x.e("main thread blocked,now begin to upload anr stack", new Object[0]);
                                this.d.get(i10).a(aaVar2);
                                this.b = false;
                                i9 = i10 + 1;
                            }
                        }
                        i7 = i8 + 1;
                    }
                }
            }
        }
    }
}
