package com.qiniu.pili.droid.shortvideo.encode;

import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.f.i;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/f.class */
public abstract class f extends com.qiniu.pili.droid.shortvideo.encode.a {
    private static final boolean f = h.a().d();
    protected ByteBuffer e;
    private int i;
    private LinkedBlockingQueue g = new LinkedBlockingQueue();
    private LinkedBlockingQueue h = new LinkedBlockingQueue();
    private Object j = new Object();
    private i k = new i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/f$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f13971a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public long f13972c;

        public a(ByteBuffer byteBuffer, int i, long j) {
            this.f13971a = byteBuffer;
            this.b = i;
            this.f13972c = j;
        }
    }

    private void n() {
        a aVar;
        com.qiniu.pili.droid.shortvideo.f.e.h.b(j(), "wait for frames");
        try {
            aVar = (a) this.g.poll(1000L, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null || aVar.f13971a == null) {
            return;
        }
        com.qiniu.pili.droid.shortvideo.f.e.h.b(j(), "do encode frames, size = " + aVar.b + ", ts = " + aVar.f13972c);
        if (this.e == null) {
            this.e = ByteBuffer.allocateDirect(aVar.b);
        }
        this.e.rewind();
        a(this.e, aVar.f13971a.array(), aVar.b, aVar.f13972c);
        synchronized (this.j) {
            int intValue = ((Integer) this.h.poll()).intValue();
            if (intValue >= 0) {
                this.k.b(intValue);
                com.qiniu.pili.droid.shortvideo.f.e.h.b(j(), "buffer use done, return back " + intValue);
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "leave the tmp buffer to gc");
            }
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a, com.qiniu.pili.droid.shortvideo.f.k
    public boolean a() {
        com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "start +");
        if (!f) {
            com.qiniu.pili.droid.shortvideo.f.e.h.e(j(), "start failed !");
            return false;
        }
        this.i = 0;
        com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "start -");
        return super.a();
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a
    public boolean a(long j) {
        com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "unimplemented !");
        return false;
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a
    public boolean a(ByteBuffer byteBuffer, int i, long j) {
        int b;
        if (!f || m()) {
            com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "stop is marked, not accepting anymore frames.");
            return false;
        }
        long b2 = b(j);
        if (b2 < 0) {
            return false;
        }
        ByteBuffer byteBuffer2 = null;
        synchronized (this.j) {
            if (this.i != i) {
                com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "buffer size changed from " + this.i + " to " + i + ", reallocate now.");
                this.i = i;
                this.k.a();
                this.k.a(this.i, 6);
            }
            b = this.k.b();
            if (b >= 0) {
                byteBuffer2 = this.k.a(b);
                com.qiniu.pili.droid.shortvideo.f.e.h.b(j(), "found a buffer to reuse, index: " + b);
            }
        }
        ByteBuffer byteBuffer3 = byteBuffer2;
        if (byteBuffer2 == null) {
            byteBuffer3 = ByteBuffer.allocate(byteBuffer.capacity());
            com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "cannot find a buffer to reuse, allocate a tmp one.");
        }
        byteBuffer3.put(byteBuffer.array(), byteBuffer.arrayOffset(), i);
        com.qiniu.pili.droid.shortvideo.f.e.h.b(j(), "input frame, size =  " + i + ", ts = " + b2);
        this.h.add(Integer.valueOf(b));
        this.g.add(new a(byteBuffer3, i, b2));
        d();
        com.qiniu.pili.droid.shortvideo.f.e.h.b(j(), "input frame done, num = " + this.g.size());
        return true;
    }

    abstract boolean a(ByteBuffer byteBuffer, byte[] bArr, int i, long j);

    @Override // com.qiniu.pili.droid.shortvideo.encode.a, com.qiniu.pili.droid.shortvideo.f.k
    public boolean c() {
        com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "stop +");
        if (f) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "stop -");
            return super.c();
        }
        com.qiniu.pili.droid.shortvideo.f.e.h.e(j(), "encode thread not started !");
        return false;
    }

    abstract boolean g();

    abstract boolean h();

    abstract boolean i();

    abstract boolean k();

    @Override // java.lang.Runnable
    public void run() {
        com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "run +");
        if (!g() || !i()) {
            com.qiniu.pili.droid.shortvideo.f.e.h.e(j(), "start failed !");
            if (this.d != null) {
                this.d.a(false);
                return;
            }
            return;
        }
        if (this.d != null) {
            this.d.a(true);
        }
        while (true) {
            if (m() && !f()) {
                break;
            }
            n();
        }
        k();
        h();
        if (this.d != null) {
            this.d.b(false);
        }
        com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "run -");
    }
}
