package com.qiniu.pili.droid.shortvideo.gl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Object f27700a;
    private Surface b;

    /* renamed from: c  reason: collision with root package name */
    private int f27701c;
    private int d;
    private f e;
    private g f = new g();
    private a g;
    private volatile boolean h;
    private PLDisplayMode i;
    private volatile boolean j;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/c$a.class */
    static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<c> f27702a;

        public a(c cVar) {
            this.f27702a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            b bVar = (b) message.obj;
            c cVar = this.f27702a.get();
            if (cVar != null) {
                cVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/c$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f27703a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f27704c;
        public long d;
        public CountDownLatch e = new CountDownLatch(1);

        public b(int i, int i2, int i3, long j) {
            this.f27703a = i;
            this.b = i2;
            this.f27704c = i3;
            this.d = j;
        }
    }

    public c(Object obj, Surface surface, int i, int i2, PLDisplayMode pLDisplayMode) {
        this.f27700a = obj;
        this.b = surface;
        this.f27701c = i;
        this.d = i2;
        this.i = pLDisplayMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (!this.f.k() && bVar.b != 0 && bVar.f27704c != 0) {
            this.f.a(this.f27701c, this.d);
            this.f.a(bVar.b, bVar.f27704c, this.i);
        }
        synchronized (com.qiniu.pili.droid.shortvideo.f.d.f27670a) {
            if (this.f != null) {
                this.f.b(bVar.f27703a);
            }
        }
        this.e.a(bVar.d);
        this.e.c();
        bVar.e.countDown();
    }

    public void a() {
        synchronized (this) {
            if (this.h) {
                e.h.d("SurfaceRenderer", "already started !!!");
                return;
            }
            new Thread(this, "SurfaceRenderer").start();
            while (!this.j && !this.h) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(float f, float f2) {
        this.f.c(f, f2);
    }

    public void a(int i) {
        this.f.b(i);
    }

    public void a(int i, int i2, int i3, long j) {
        if (this.g != null) {
            b bVar = new b(i, i2, i3, j);
            a aVar = this.g;
            aVar.sendMessage(aVar.obtainMessage(0, bVar));
            try {
                bVar.e.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (!this.h) {
                e.h.d("SurfaceRenderer", "not started yet !!!");
                return;
            }
            if (this.g != null) {
                this.g.getLooper().quit();
            }
            while (this.h) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void c() {
        synchronized (this) {
            this.j = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            if (this.j) {
                e.h.d("SurfaceRenderer", "shared context is going to be invalid, interrupt now.");
                notify();
                return;
            }
            try {
                com.qiniu.pili.droid.shortvideo.gl.a.d dVar = new com.qiniu.pili.droid.shortvideo.gl.a.d(this.f27700a, 1);
                f fVar = new f(dVar, this.b, false);
                this.e = fVar;
                fVar.b();
                Looper.prepare();
                this.g = new a(this);
                synchronized (this) {
                    this.h = true;
                    notify();
                }
                Looper.loop();
                this.e.d();
                dVar.a();
                synchronized (this) {
                    this.h = false;
                    notify();
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                e eVar = e.h;
                eVar.e("SurfaceRenderer", "Prepares EGL display and context failed: " + e.getMessage());
            }
        }
    }
}
