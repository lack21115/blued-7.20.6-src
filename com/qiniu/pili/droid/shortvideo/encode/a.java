package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.f.k;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/a.class */
public abstract class a extends k {
    protected volatile int b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile int f13962c;
    protected InterfaceC0575a d;
    private volatile boolean e;
    private volatile long f;
    private volatile long g = -1;

    /* renamed from: a  reason: collision with root package name */
    protected double f13961a = 1.0d;
    private final Object h = new Object();

    /* renamed from: com.qiniu.pili.droid.shortvideo.encode.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/a$a.class */
    public interface InterfaceC0575a {
        void a(MediaFormat mediaFormat);

        void a(Surface surface);

        void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

        void a(boolean z);

        void b(boolean z);
    }

    public void a(double d) {
        this.f13961a = d;
    }

    public void a(InterfaceC0575a interfaceC0575a) {
        this.d = interfaceC0575a;
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public boolean a() {
        this.e = false;
        this.f = 0L;
        this.g = -1L;
        return super.a();
    }

    public abstract boolean a(long j);

    public abstract boolean a(ByteBuffer byteBuffer, int i, long j);

    public long b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(long j) {
        if (!this.e) {
            this.e = true;
            this.f = j;
        }
        long j2 = j - this.f;
        if (j2 <= this.g) {
            com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "timestamp fall back, ignore this frame.");
            return -1L;
        }
        this.g = j2;
        return j2;
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public boolean c() {
        boolean c2 = super.c();
        synchronized (this.h) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            String j = j();
            eVar.c(j, "stopping encoder, input frame count: " + this.b + " output frame count: " + this.f13962c + " flush remaining frames: " + (this.b - this.f13962c));
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        synchronized (this.h) {
            this.b++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        synchronized (this.h) {
            this.f13962c++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f() {
        boolean z;
        synchronized (this.h) {
            z = this.b > this.f13962c;
        }
        return z;
    }
}
