package com.opos.exoplayer.core.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.opos.exoplayer.core.i.u;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/r.class */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f11784a;
    private e<? extends b> b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f11785c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/r$a.class */
    public interface a<T extends b> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/r$b.class */
    public interface b {
        void a();

        boolean b();

        void c();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/r$c.class */
    public interface c {
        void g();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/r$d.class */
    public static final class d extends IOException {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/r$e.class */
    final class e<T extends b> extends Handler implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f11786a;

        /* renamed from: c  reason: collision with root package name */
        private final T f11787c;
        private final a<T> d;
        private final long e;
        private IOException f;
        private int g;
        private volatile Thread h;
        private volatile boolean i;

        public e(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.f11787c = t;
            this.d = aVar;
            this.f11786a = i;
            this.e = j;
        }

        private void a() {
            this.f = null;
            r.this.f11784a.execute(r.this.b);
        }

        private void b() {
            r.this.b = null;
        }

        private long c() {
            return Math.min((this.g - 1) * 1000, 5000);
        }

        public void a(int i) {
            IOException iOException = this.f;
            if (iOException != null && this.g > i) {
                throw iOException;
            }
        }

        public void a(long j) {
            com.opos.exoplayer.core.i.a.b(r.this.b == null);
            r.this.b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                a();
            }
        }

        public void a(boolean z) {
            this.i = z;
            this.f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f11787c.a();
                if (this.h != null) {
                    this.h.interrupt();
                }
            }
            if (z) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.d.a((a<T>) this.f11787c, elapsedRealtime, elapsedRealtime - this.e, true);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.i) {
                return;
            }
            if (message.what == 0) {
                a();
            } else if (message.what == 4) {
                throw ((Error) message.obj);
            } else {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.e;
                if (!this.f11787c.b()) {
                    int i = message.what;
                    int i2 = 1;
                    if (i != 1) {
                        if (i == 2) {
                            try {
                                this.d.a(this.f11787c, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception handling load completed", e);
                                r.this.f11785c = new d(e);
                                return;
                            }
                        } else if (i != 3) {
                            return;
                        } else {
                            IOException iOException = (IOException) message.obj;
                            this.f = iOException;
                            int a2 = this.d.a((a<T>) this.f11787c, elapsedRealtime, j, iOException);
                            if (a2 == 3) {
                                r.this.f11785c = this.f;
                                return;
                            } else if (a2 != 2) {
                                if (a2 != 1) {
                                    i2 = 1 + this.g;
                                }
                                this.g = i2;
                                a(c());
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                }
                this.d.a((a<T>) this.f11787c, elapsedRealtime, j, false);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IOException e;
            try {
                this.h = Thread.currentThread();
                if (!this.f11787c.b()) {
                    com.opos.exoplayer.core.i.t.a("load:" + this.f11787c.getClass().getSimpleName());
                    try {
                        this.f11787c.c();
                        com.opos.exoplayer.core.i.t.a();
                    } catch (Throwable th) {
                        com.opos.exoplayer.core.i.t.a();
                        throw th;
                    }
                }
                if (this.i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e2) {
                e = e2;
                if (this.i) {
                    return;
                }
                obtainMessage(3, e).sendToTarget();
            } catch (Error e3) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected error loading stream", e3);
                if (!this.i) {
                    obtainMessage(4, e3).sendToTarget();
                }
                throw e3;
            } catch (InterruptedException e4) {
                com.opos.exoplayer.core.i.a.b(this.f11787c.b());
                if (this.i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e5) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception loading stream", e5);
                if (this.i) {
                    return;
                }
                e = new d(e5);
                obtainMessage(3, e).sendToTarget();
            } catch (OutOfMemoryError e6) {
                com.opos.cmn.an.f.a.d("LoadTask", "OutOfMemory error loading stream", e6);
                if (this.i) {
                    return;
                }
                e = new d(e6);
                obtainMessage(3, e).sendToTarget();
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/r$f.class */
    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final c f11788a;

        public f(c cVar) {
            this.f11788a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11788a.g();
        }
    }

    public r(String str) {
        this.f11784a = u.a(str);
    }

    public <T extends b> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.opos.exoplayer.core.i.a.b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new e(myLooper, t, aVar, i, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    public void a(int i) {
        IOException iOException = this.f11785c;
        if (iOException != null) {
            throw iOException;
        }
        e<? extends b> eVar = this.b;
        if (eVar != null) {
            int i2 = i;
            if (i == Integer.MIN_VALUE) {
                i2 = eVar.f11786a;
            }
            eVar.a(i2);
        }
    }

    public void a(c cVar) {
        e<? extends b> eVar = this.b;
        if (eVar != null) {
            eVar.a(true);
        }
        if (cVar != null) {
            this.f11784a.execute(new f(cVar));
        }
        this.f11784a.shutdown();
    }

    public boolean a() {
        return this.b != null;
    }

    public void b() {
        this.b.a(false);
    }
}
