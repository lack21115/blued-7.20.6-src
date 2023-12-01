package com.blued.android.statistics.grpc.connect;

import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.util.LoopQueue;
import com.blued.android.statistics.util.Utils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/BaseManager.class */
public abstract class BaseManager<Request> {

    /* renamed from: a  reason: collision with root package name */
    private final LoopQueue f18713a = new LoopQueue(300);
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f18714c = 0;
    private long d = 0;
    private Runnable e = new Runnable() { // from class: com.blued.android.statistics.grpc.connect.BaseManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (BaseManager.this.c() && ConnectManager.b()) {
                synchronized (BaseManager.this.f18713a) {
                    int i = 3;
                    while (BaseManager.this.f18713a.b() > 0 && i > 0) {
                        int i2 = i - 1;
                        Object[] a2 = BaseManager.this.f18713a.a(30);
                        i = i2;
                        if (a2 != null) {
                            i = i2;
                            if (a2.length > 0) {
                                BaseManager.this.a(a2);
                                i = i2;
                            }
                        }
                    }
                }
            }
        }
    };

    private void a() {
        Utils.a(this.e);
        this.b = this.d + b();
        this.f18714c = this.d;
    }

    private void d() {
        Utils.a(this.e, this.b - this.d);
        this.f18714c = this.b;
    }

    public void a(Request request) {
        if (c()) {
            synchronized (this.f18713a) {
                Utils.b(this.e);
                this.f18713a.a(request);
                long currentTimeMillis = System.currentTimeMillis();
                this.d = currentTimeMillis;
                if (0 == this.f18714c) {
                    this.f18714c = currentTimeMillis;
                    this.b = currentTimeMillis + b();
                }
                if (this.f18713a.b() >= 30) {
                    a();
                } else if (this.d < this.b) {
                    d();
                } else if (this.d >= this.f18714c + b()) {
                    a();
                } else {
                    this.b += b();
                    d();
                }
            }
        }
    }

    protected abstract void a(Object[] objArr);

    protected abstract long b();

    protected boolean c() {
        return true;
    }
}
