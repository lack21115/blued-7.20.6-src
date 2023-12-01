package com.anythink.expressad.exoplayer.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t.class */
public final class t implements u {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4768a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4769c = 2;
    public static final int d = 3;
    private final ExecutorService e;
    private b<? extends c> f;
    private IOException g;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t$a.class */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t$b.class */
    public final class b<T extends c> extends Handler implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private static final String f4770c = "LoadTask";
        private static final int d = 0;
        private static final int e = 1;
        private static final int f = 2;
        private static final int g = 3;
        private static final int h = 4;

        /* renamed from: a  reason: collision with root package name */
        public final int f4771a;
        private final T i;
        private final long j;
        private a<T> k;
        private IOException l;
        private int m;
        private volatile Thread n;
        private volatile boolean o;
        private volatile boolean p;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.i = t;
            this.k = aVar;
            this.f4771a = i;
            this.j = j;
        }

        private void a() {
            this.l = null;
            t.this.e.execute(t.this.f);
        }

        private void b() {
            t.this.f = null;
        }

        private long c() {
            return Math.min((this.m - 1) * 1000, 5000);
        }

        public final void a(int i) {
            IOException iOException = this.l;
            if (iOException != null && this.m > i) {
                throw iOException;
            }
        }

        public final void a(long j) {
            com.anythink.expressad.exoplayer.k.a.b(t.this.f == null);
            t.this.f = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                a();
            }
        }

        public final void a(boolean z) {
            this.p = z;
            this.l = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.o = true;
                this.i.a();
                if (this.n != null) {
                    this.n.interrupt();
                }
            }
            if (z) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.k.a((a<T>) this.i, elapsedRealtime, elapsedRealtime - this.j, true);
                this.k = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.p) {
                return;
            }
            if (message.what == 0) {
                a();
            } else if (message.what == 4) {
                throw ((Error) message.obj);
            } else {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.j;
                if (this.o) {
                    this.k.a((a<T>) this.i, elapsedRealtime, j, false);
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    this.k.a((a<T>) this.i, elapsedRealtime, j, false);
                } else if (i == 2) {
                    try {
                        this.k.a(this.i, elapsedRealtime, j);
                    } catch (RuntimeException e2) {
                        Log.e(f4770c, "Unexpected exception handling load completed", e2);
                        t.this.g = new g(e2);
                    }
                } else if (i != 3) {
                } else {
                    IOException iOException = (IOException) message.obj;
                    this.l = iOException;
                    int a2 = this.k.a((a<T>) this.i, elapsedRealtime, j, iOException);
                    if (a2 == 3) {
                        t.this.g = this.l;
                    } else if (a2 != 2) {
                        int i2 = a2 == 1 ? 1 : this.m + 1;
                        this.m = i2;
                        a(Math.min((i2 - 1) * 1000, 5000));
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.n = Thread.currentThread();
                if (!this.o) {
                    ad.a("load:" + this.i.getClass().getSimpleName());
                    try {
                        this.i.b();
                        ad.a();
                    } catch (Throwable th) {
                        ad.a();
                        throw th;
                    }
                }
                if (this.p) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e2) {
                if (this.p) {
                    return;
                }
                obtainMessage(3, e2).sendToTarget();
            } catch (InterruptedException e3) {
                com.anythink.expressad.exoplayer.k.a.b(this.o);
                if (this.p) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e4) {
                Log.e(f4770c, "Unexpected exception loading stream", e4);
                if (this.p) {
                    return;
                }
                obtainMessage(3, new g(e4)).sendToTarget();
            } catch (OutOfMemoryError e5) {
                Log.e(f4770c, "OutOfMemory error loading stream", e5);
                if (this.p) {
                    return;
                }
                obtainMessage(3, new g(e5)).sendToTarget();
            } catch (Error e6) {
                Log.e(f4770c, "Unexpected error loading stream", e6);
                if (!this.p) {
                    obtainMessage(4, e6).sendToTarget();
                }
                throw e6;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t$c.class */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t$d.class */
    public interface d {
        void g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t$e.class */
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final d f4772a;

        public e(d dVar) {
            this.f4772a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4772a.g();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t$f.class */
    public @interface f {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/t$g.class */
    public static final class g extends IOException {
        public g(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public t(String str) {
        this.e = af.a(str);
    }

    private void d() {
        a((d) null);
    }

    public final <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.anythink.expressad.exoplayer.k.a.b(myLooper != null);
        this.g = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    @Override // com.anythink.expressad.exoplayer.j.u
    public final void a(int i) {
        IOException iOException = this.g;
        if (iOException != null) {
            throw iOException;
        }
        b<? extends c> bVar = this.f;
        if (bVar != null) {
            int i2 = i;
            if (i == Integer.MIN_VALUE) {
                i2 = bVar.f4771a;
            }
            bVar.a(i2);
        }
    }

    public final void a(d dVar) {
        b<? extends c> bVar = this.f;
        if (bVar != null) {
            bVar.a(true);
        }
        if (dVar != null) {
            this.e.execute(new e(dVar));
        }
        this.e.shutdown();
    }

    public final boolean a() {
        return this.f != null;
    }

    public final void b() {
        this.f.a(false);
    }

    @Override // com.anythink.expressad.exoplayer.j.u
    public final void c() {
        a(Integer.MIN_VALUE);
    }
}
