package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/h.class */
public abstract class h<T> implements Runnable {
    private static final String b = "BaseTask";

    /* renamed from: c  reason: collision with root package name */
    private static final int f9429c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static b j;

    /* renamed from: a  reason: collision with root package name */
    protected Future<T> f9430a;
    private String f;
    private long g;
    private long h;
    private long i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/h$a.class */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final h f9431a;
        final T b;

        a(h hVar, T t) {
            this.f9431a = hVar;
            this.b = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/h$b.class */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f9431a.a((h) aVar.b);
            } else if (i == 2) {
                aVar.f9431a.a((Throwable) aVar.b);
            } else if (i != 3) {
            } else {
                aVar.f9431a.j();
            }
        }
    }

    public h() {
        this.f = "default";
    }

    public h(String str) {
        this.f = str;
    }

    private static Handler k() {
        b bVar;
        synchronized (h.class) {
            try {
                if (j == null) {
                    j = new b(Looper.getMainLooper());
                }
                bVar = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public String a() {
        return this.f;
    }

    public void a(long j2) {
        this.g = j2;
    }

    protected void a(T t) {
    }

    protected void a(Throwable th) {
    }

    public void a(Future future) {
        this.f9430a = future;
    }

    public void a(boolean z) {
        Future<T> future = this.f9430a;
        if (future != null) {
            future.cancel(z);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.f9430a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f9430a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.h - this.g;
    }

    public long f() {
        return this.i - this.g;
    }

    public long g() {
        return this.i - this.h;
    }

    public h h() {
        try {
            this.h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    protected abstract T i();

    protected void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }
}
